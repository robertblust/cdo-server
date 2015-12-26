/*
 * Copyright (c) 2008-2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Simon McDuff  - initial API and implementation
 *    Eike Stepper  - maintenance
 *    Cyril Jaquier - Bug 310574 (with the help of Pascal Lehmann)
 */
package org.eclipse.emf.cdo.internal.common.revision.delta;

import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOMoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOSetFeatureDelta;
import org.eclipse.emf.cdo.spi.common.revision.CDOReferenceAdjuster;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDOFeatureDelta;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.collection.Pair;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Simon McDuff
 */
public class CDOListFeatureDeltaImpl extends CDOFeatureDeltaImpl implements CDOListFeatureDelta
{
  private final int originSize;

  private final List<CDOFeatureDelta> listChanges = new ArrayList<CDOFeatureDelta>();

  private transient int[] cachedIndices;

  private transient ListTargetAdding[] cachedSources;

  private transient List<CDOFeatureDelta> unprocessedFeatureDeltas;

  public CDOListFeatureDeltaImpl(EStructuralFeature feature, int originSize)
  {
    super(feature);
    this.originSize = originSize;
  }

  public CDOListFeatureDeltaImpl(CDODataInput in, EClass eClass) throws IOException
  {
    super(in, eClass);
    originSize = in.readInt();
    int size = in.readInt();
    for (int i = 0; i < size; i++)
    {
      listChanges.add(in.readCDOFeatureDelta(eClass));
    }
  }

  public CDOListFeatureDelta copy()
  {
    CDOListFeatureDeltaImpl result = new CDOListFeatureDeltaImpl(getFeature(), getOriginSize());

    Map<CDOFeatureDelta, CDOFeatureDelta> map = null;
    if (cachedSources != null || unprocessedFeatureDeltas != null)
    {
      map = new HashMap<CDOFeatureDelta, CDOFeatureDelta>();
    }

    for (CDOFeatureDelta delta : listChanges)
    {
      CDOFeatureDelta newDelta = delta.copy();
      result.listChanges.add(newDelta);
      if (map != null)
      {
        map.put(delta, newDelta);
      }
    }

    if (cachedIndices != null)
    {
      result.cachedIndices = copyOf(cachedIndices, cachedIndices.length);
    }

    if (cachedSources != null)
    {
      int length = cachedSources.length;
      result.cachedSources = new ListTargetAdding[length];
      for (int i = 0; i < length; i++)
      {
        ListTargetAdding oldElement = cachedSources[i];
        CDOFeatureDelta newElement = map.get(oldElement);
        if (newElement instanceof ListTargetAdding)
        {
          result.cachedSources[i] = (ListTargetAdding)newElement;
        }
      }
    }

    if (unprocessedFeatureDeltas != null)
    {
      int size = unprocessedFeatureDeltas.size();
      result.unprocessedFeatureDeltas = new ArrayList<CDOFeatureDelta>(size);
      for (CDOFeatureDelta oldDelta : unprocessedFeatureDeltas)
      {
        CDOFeatureDelta newDelta = map.get(oldDelta);
        if (newDelta != null)
        {
          result.unprocessedFeatureDeltas.add(newDelta);
        }
      }
    }

    return result;
  }

  @Override
  public void write(CDODataOutput out, EClass eClass) throws IOException
  {
    super.write(out, eClass);
    out.writeInt(originSize);
    out.writeInt(listChanges.size());
    for (CDOFeatureDelta featureDelta : listChanges)
    {
      out.writeCDOFeatureDelta(eClass, featureDelta);
    }
  }

  public Type getType()
  {
    return Type.LIST;
  }

  public int getOriginSize()
  {
    return originSize;
  }

  public List<CDOFeatureDelta> getListChanges()
  {
    return listChanges;
  }

  /**
   * Returns the number of indices as the first element of the array.
   *
   * @return never <code>null</code>.
   */
  public Pair<ListTargetAdding[], int[]> reconstructAddedIndices()
  {
    reconstructAddedIndicesWithNoCopy();
    return Pair.create(copyOf(cachedSources, cachedSources.length, cachedSources.getClass()),
        copyOf(cachedIndices, cachedIndices.length));
  }

  private void reconstructAddedIndicesWithNoCopy()
  {
    // Note that cachedIndices and cachedSources are always either both null or
    // both non-null, and in the latter case, are always of the same length.
    // Furthermore, there can only be unprocessedFeatureDeltas if cachesIndices
    // and cachedSources are non-null.

    if (cachedIndices == null || unprocessedFeatureDeltas != null)
    {
      if (cachedIndices == null)
      {
        int initialCapacity = listChanges.size() + 1;
        cachedIndices = new int[initialCapacity];
        cachedSources = new ListTargetAdding[initialCapacity];
      }
      else
        // i.e. unprocessedFeatureDeltas != null
      {
        int requiredCapacity = 1 + cachedIndices[0] + unprocessedFeatureDeltas.size();
        if (cachedIndices.length < requiredCapacity)
        {
          int newCapacity = Math.max(requiredCapacity, cachedIndices.length * 2);

          int[] newIndices = new int[newCapacity];
          System.arraycopy(cachedIndices, 0, newIndices, 0, cachedIndices.length);
          cachedIndices = newIndices;

          ListTargetAdding[] newSources = new ListTargetAdding[newCapacity];
          System.arraycopy(cachedSources, 0, newSources, 0, cachedSources.length);
          cachedSources = newSources;
        }
      }

      List<CDOFeatureDelta> featureDeltasToBeProcessed = unprocessedFeatureDeltas == null ? listChanges
          : unprocessedFeatureDeltas;
      for (CDOFeatureDelta featureDelta : featureDeltasToBeProcessed)
      {
        if (featureDelta instanceof ListIndexAffecting)
        {
          ListIndexAffecting affecting = (ListIndexAffecting)featureDelta;
          affecting.affectIndices(cachedSources, cachedIndices);
        }

        if (featureDelta instanceof ListTargetAdding)
        {
          cachedIndices[++cachedIndices[0]] = ((ListTargetAdding)featureDelta).getIndex();
          cachedSources[cachedIndices[0]] = (ListTargetAdding)featureDelta;
        }
      }

      unprocessedFeatureDeltas = null;
    }
  }

  private boolean cleanupWithNewDelta(CDOFeatureDelta featureDelta)
  {
    EStructuralFeature feature = getFeature();
    switch (featureDelta.getType())
    {
    case REMOVE:
    {
      if (feature instanceof EReference || FeatureMapUtil.isFeatureMap(feature))
      {
        Boolean result = cleanupWithNewRemoveDelta((CDORemoveFeatureDelta)featureDelta);
        if (result != null)
        {
          return result;
        }
      }

      break;
    }
    case SET:
    {
      Boolean result = cleanupWithNewSetDelta((CDOSetFeatureDelta)featureDelta);
      if (result != null)
      {
        return result;
      }

      break;
    }
    }

    if (cachedIndices != null)
    {
      if (unprocessedFeatureDeltas == null)
      {
        unprocessedFeatureDeltas = new ArrayList<CDOFeatureDelta>();
      }

      unprocessedFeatureDeltas.add(featureDelta);
    }

    return true;
  }

  private Boolean cleanupWithNewRemoveDelta(CDORemoveFeatureDelta removeFeatureDelta)
  {
    int indexToRemove = removeFeatureDelta.getIndex();
    reconstructAddedIndicesWithNoCopy();

    for (int i = 1; i <= cachedIndices[0]; i++)
    {
      int index = cachedIndices[i];
      if (indexToRemove == index)
      {
        // The previous implementation set the value of the feature delta to CDOID.NULL. Databinding and probably
        // others don't really like it. We now remove the ADD (or SET which seems to appear in CDOListFeatureDelta
        // during opposite adjustment!? Why???) and patch the other feature deltas.
        // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=310574

        ListTargetAdding delta = cachedSources[i];

        // We use a "floating" index which is the index (in the list) of the item to remove at the time when the
        // object was still in the list. This index evolves with the feature deltas.
        int floatingIndex = delta.getIndex();

        // First updates cachedSources and cachedIndices using CDORemoveFeatureDelta.
        ListIndexAffecting affecting = (ListIndexAffecting)removeFeatureDelta;
        affecting.affectIndices(cachedSources, cachedIndices);

        // Then adjusts the remaining feature deltas.
        boolean skip = true;
        ListIterator<CDOFeatureDelta> iterator = listChanges.listIterator();

        while (iterator.hasNext())
        {
          CDOFeatureDelta fd = iterator.next();

          // We only need to process feature deltas that come after the ADD (or SET) to be removed.
          if (skip)
          {
            if (fd == delta)
            {
              // Found the ADD (or SET) feature delta that we need to remove. So remove it from the list and start
              // processing the next feature deltas.
              skip = false;
              iterator.remove();

              // SET
              if (fd instanceof CDOSetFeatureDelta)
              {
                // If the removed delta is SET we add the REMOVE to the feature deltas. We do not need to adjust the
                // other feature deltas because SET do not modify the list.
                return true;
              }
            }

            continue;
          }

          // ADD
          if (fd instanceof CDOAddFeatureDelta)
          {
            // Increases the floating index if the ADD came in front of the item.
            if (((CDOAddFeatureDelta)fd).getIndex() <= floatingIndex)
            {
              ++floatingIndex;
            }

            // Adjusts the feature delta too.
            ((WithIndex)fd).adjustAfterRemoval(floatingIndex);
          }

          // REMOVE
          else if (fd instanceof CDORemoveFeatureDelta)
          {
            int idx = floatingIndex;
            // Decreases the floating index if the REMOVE came in front of the item.
            if (((CDORemoveFeatureDelta)fd).getIndex() <= floatingIndex)
            {
              --floatingIndex;
            }

            // Adjusts the feature delta too.
            ((WithIndex)fd).adjustAfterRemoval(idx);
          }

          // MOVE
          else if (fd instanceof CDOMoveFeatureDelta)
          {
            // Remembers the positions before we patch them.
            int from = ((CDOMoveFeatureDelta)fd).getOldPosition();
            int to = ((CDOMoveFeatureDelta)fd).getNewPosition();

            if (floatingIndex == from)
            {
              // We are moving the "to be deleted" item. So we update our floating index and remove the MOVE. It has
              // no effect on the list.
              floatingIndex = to;
              iterator.remove();
            }
            else
            {
              // In the other cases, we need to patch the positions.

              // If the old position is greater or equal to the current position of the item to be removed (remember,
              // that's our floating index), decrease the position.
              int patchedFrom = floatingIndex <= from ? from - 1 : from;

              // The new position requires more care. We need to know the direction of the move (left-to-right or
              // right-to-left).
              int patchedTo;
              if (from > to)
              {
                // left-to-right. Only decreases the position if it is strictly greater than the current item
                // position.
                patchedTo = floatingIndex < to ? to - 1 : to;
              }
              else
              {
                // right-to-left. Decreases the position if it is greater or equal than the current item position.
                patchedTo = floatingIndex <= to ? to - 1 : to;
              }

              // We can now update our floating index. We use the original positions because the floating index
              // represents the item "to be deleted" before it was actually removed.
              if (from < floatingIndex && floatingIndex <= to)
              {
                --floatingIndex;
              }
              else if (to <= floatingIndex && floatingIndex < from)
              {
                ++floatingIndex;
              }

              // And finally adjust the feature delta.
              if (patchedFrom == patchedTo)
              {
                // Source and destination are the same so just remove the feature delta.
                iterator.remove();
              }
              else
              {
                ((CDOMoveFeatureDeltaImpl)fd).setOldPosition(patchedFrom);
                ((CDOMoveFeatureDeltaImpl)fd).setNewPosition(patchedTo);
              }
            }
          }

          // SET
          else if (fd instanceof CDOSetFeatureDelta)
          {
            // Adjusts the feature delta too.
            ((WithIndex)fd).adjustAfterRemoval(floatingIndex);
          }
        }

        // If the removed delta was ADD so we do not add the REMOVE to the feature deltas.
        return false;
      }
    }

    return null;
  }

  /**
   * A new SET feature delta can interfere with former ADD or SET deltas.
   */
  private Boolean cleanupWithNewSetDelta(CDOSetFeatureDelta featureDelta)
  {
    final class DeltaProxy implements InternalCDOFeatureDelta.WithIndex
    {
      private final int indexIntoListChanges;

      private int index;

      public DeltaProxy(int indexIntoListChanges, int index)
      {
        this.indexIntoListChanges = indexIntoListChanges;
        this.index = index;
      }

      public int getIndexIntoListChanges()
      {
        return indexIntoListChanges;
      }

      public int getIndex()
      {
        return index;
      }

      public void adjustAfterAddition(int index)
      {
        if (index <= this.index)
        {
          ++this.index;
        }
      }

      public void adjustAfterRemoval(int index)
      {
        if (index < this.index && this.index > 0)
        {
          --this.index;
        }
      }
    }

    int size = listChanges.size();
    List<DeltaProxy> proxies = new ArrayList<DeltaProxy>();

    for (int i = 0; i < size; i++)
    {
      CDOFeatureDelta fd = listChanges.get(i);
      switch (fd.getType())
      {
      case MOVE:
      {
        int oldPosition = ((CDOMoveFeatureDelta)fd).getOldPosition();
        int newPosition = ((CDOMoveFeatureDelta)fd).getNewPosition();
        for (DeltaProxy proxy : proxies)
        {
          proxy.adjustAfterRemoval(oldPosition);
          proxy.adjustAfterAddition(newPosition);
        }

        break;
      }

      case REMOVE:
      {
        int index = ((CDORemoveFeatureDelta)fd).getIndex();
        for (DeltaProxy proxy : proxies)
        {
          proxy.adjustAfterRemoval(index);
        }

        break;
      }

      case ADD:
      {
        int index = ((CDOAddFeatureDelta)fd).getIndex();
        for (DeltaProxy proxy : proxies)
        {
          proxy.adjustAfterAddition(index);
        }

        proxies.add(new DeltaProxy(i, index));
        break;
      }

      case SET:
      {
        int index = ((CDOSetFeatureDelta)fd).getIndex();
        proxies.add(new DeltaProxy(i, index));
        break;
      }
      }
    }

    int index = featureDelta.getIndex();
    for (DeltaProxy proxy : proxies)
    {
      if (proxy.getIndex() == index)
      {
        int indexIntoListChanges = proxy.getIndexIntoListChanges();
        CDOFeatureDelta featureDeltaToModify = listChanges.get(indexIntoListChanges);
        if (featureDeltaToModify.getType() == CDOFeatureDelta.Type.ADD)
        {
          ((CDOAddFeatureDeltaImpl)featureDeltaToModify).setValue(featureDelta.getValue());
          return false;
        }

        // Here featureDeltaToModify is a SET delta
        listChanges.remove(indexIntoListChanges); // Replace the SET delta that existed for this index
        break;
      }
    }

    return null;
  }

  public void add(CDOFeatureDelta featureDelta)
  {
    // Only adds the feature delta to the list if required.
    if (cleanupWithNewDelta(featureDelta))
    {
      listChanges.add(featureDelta);
    }
  }

  public Object applyTo(CDORevision revision)
  {
    for (CDOFeatureDelta featureDelta : listChanges)
    {
      ((CDOFeatureDeltaImpl)featureDelta).applyTo(revision);
    }

    return null;
  }

  @Override
  public boolean adjustReferences(CDOReferenceAdjuster adjuster)
  {
    boolean changed = false;
    for (CDOFeatureDelta featureDelta : listChanges)
    {
      changed |= ((CDOFeatureDeltaImpl)featureDelta).adjustReferences(adjuster);
    }

    return changed;
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  @Override
  public boolean isStructurallyEqual(Object obj)
  {
    if (!super.isStructurallyEqual(obj))
    {
      return false;
    }

    CDOListFeatureDelta that = (CDOListFeatureDelta)obj;
    return ObjectUtil.equals(listChanges, that.getListChanges());
  }

  @Override
  protected String toStringAdditional()
  {
    return "originSize=" + originSize + ", list=" + listChanges; //$NON-NLS-1$
  }

  /**
   * Copied from JAVA 1.6 {@link Arrays Arrays.copyOf}.
   */
  private static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType)
  {
    @SuppressWarnings("unchecked")
    T[] copy = (Object)newType == (Object)Object[].class ? (T[])new Object[newLength]
        : (T[])Array.newInstance(newType.getComponentType(), newLength);
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
    return copy;
  }

  /**
   * Copied from JAVA 1.6 {@link Arrays Arrays.copyOf}.
   */
  private static int[] copyOf(int[] original, int newLength)
  {
    int[] copy = new int[newLength];
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
    return copy;
  }
}
