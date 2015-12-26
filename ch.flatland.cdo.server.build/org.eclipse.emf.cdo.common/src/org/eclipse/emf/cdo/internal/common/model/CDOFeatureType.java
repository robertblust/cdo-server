/*
 * Copyright (c) 2004-2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.internal.common.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Eike Stepper
 * @since 4.4
 */
public enum CDOFeatureType
{
  NONE
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      return false;
    }
  },

  ALL
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      return true;
    }
  },

  ATTRIBUTE
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      return feature instanceof EAttribute;
    }
  },

  REFERENCE
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      return feature instanceof EReference;
    }
  },

  CONTAINER
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      if (feature instanceof EReference)
      {
        EReference reference = (EReference)feature;
        return reference.isContainer();
      }

      return false;
    }
  },

  CONTAINMENT
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      if (feature instanceof EReference)
      {
        EReference reference = (EReference)feature;
        return reference.isContainment();
      }

      return false;
    }
  },

  XREF
  {
    @Override
    public boolean matches(EStructuralFeature feature)
    {
      if (feature instanceof EReference)
      {
        EReference reference = (EReference)feature;
        return !reference.isContainer() && !reference.isContainment();
      }

      return false;
    }
  };

  public abstract boolean matches(EStructuralFeature feature);

  public static boolean matchesCombination(EStructuralFeature feature, Collection<CDOFeatureType> featureTypes)
  {
    if (featureTypes != null)
    {
      for (CDOFeatureType featureType : featureTypes)
      {
        if (featureType.matches(feature))
        {
          return true;
        }
      }
    }

    return false;
  }

  public static CDOFeatureType read(String str)
  {
    if (str != null)
    {
      str = str.trim().toUpperCase();

      try
      {
        return valueOf(str);
      }
      catch (Exception ex)
      {
        //$FALL-THROUGH$
      }
    }

    return NONE;
  }

  public static Set<CDOFeatureType> readCombination(String str)
  {
    if (str != null)
    {
      str = str.replace(' ', '|').replace(',', '|').replace(';', '|');

      Set<CDOFeatureType> result = new HashSet<CDOFeatureType>();

      for (String token : str.split("\\|"))
      {
        CDOFeatureType featureType = read(token);
        if (featureType != NONE)
        {
          result.add(featureType);
        }
      }

      return result;
    }

    return Collections.emptySet();
  }

  public static String writeCombination(Collection<CDOFeatureType> featureTypes)
  {
    if (featureTypes != null)
    {
      if (!(featureTypes instanceof Set))
      {
        featureTypes = new HashSet<CDOFeatureType>(featureTypes);
      }

      if (featureTypes.contains(ALL))
      {
        return ALL.toString();
      }

      if (featureTypes.contains(REFERENCE))
      {
        featureTypes.remove(CONTAINER);
        featureTypes.remove(CONTAINMENT);
        featureTypes.remove(XREF);
      }

      featureTypes.remove(NONE);

      List<CDOFeatureType> list = new ArrayList<CDOFeatureType>(featureTypes);
      Collections.sort(list);

      StringBuilder result = new StringBuilder();
      for (CDOFeatureType featureType : list)
      {
        if (result.length() != 0)
        {
          result.append("|");
        }

        result.append(featureType);
      }

      return result.toString();
    }

    return "";
  }
}
