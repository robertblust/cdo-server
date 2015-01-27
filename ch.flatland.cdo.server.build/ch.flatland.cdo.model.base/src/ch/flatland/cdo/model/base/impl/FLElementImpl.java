/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.BasePackage.Literals;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLProperty;
import ch.flatland.cdo.model.base.FLTrace;
import ch.flatland.cdo.model.base.FLTraceType;
import com.google.common.base.Objects;
import java.lang.Iterable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToOwn <em>Trace To Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToUse <em>Trace To Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRealize <em>Trace To Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToSpecify <em>Trace To Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToImplement <em>Trace To Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToElaborate <em>Trace To Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToDerive <em>Trace To Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToValidate <em>Trace To Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToTest <em>Trace To Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRelate <em>Trace To Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToAffect <em>Trace To Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToSatisfy <em>Trace To Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToVerify <em>Trace To Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRefine <em>Trace To Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToTrack <em>Trace To Track</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromOwn <em>Trace From Own</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromUse <em>Trace From Use</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRealize <em>Trace From Realize</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromSpecify <em>Trace From Specify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromImplement <em>Trace From Implement</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromElaborate <em>Trace From Elaborate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromDerive <em>Trace From Derive</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromValidate <em>Trace From Validate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromTest <em>Trace From Test</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRelate <em>Trace From Relate</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromAffect <em>Trace From Affect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromSatisfy <em>Trace From Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromVerify <em>Trace From Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromRefine <em>Trace From Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceFromTrack <em>Trace From Track</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FLElementImpl extends CDOObjectImpl implements FLElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FLElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__NAME, BasePackage.Literals.FL_ELEMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(BasePackage.FL_ELEMENT__NAME, BasePackage.Literals.FL_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__UUID, BasePackage.Literals.FL_ELEMENT__UUID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUuid(String newUuid) {
		eDynamicSet(BasePackage.FL_ELEMENT__UUID, BasePackage.Literals.FL_ELEMENT__UUID, newUuid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(BasePackage.FL_ELEMENT__DESCRIPTION, BasePackage.Literals.FL_ELEMENT__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(BasePackage.FL_ELEMENT__DESCRIPTION, BasePackage.Literals.FL_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLTrace> getTraces() {
		return (EList<FLTrace>)eDynamicGet(BasePackage.FL_ELEMENT__TRACES, BasePackage.Literals.FL_ELEMENT__TRACES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FLProperty> getProperties() {
		return (EList<FLProperty>)eDynamicGet(BasePackage.FL_ELEMENT__PROPERTIES, BasePackage.Literals.FL_ELEMENT__PROPERTIES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToOwn() {
		return this.toFilterByType(FLTraceType.OWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToUse() {
		return this.toFilterByType(FLTraceType.USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRealize() {
		return this.toFilterByType(FLTraceType.REALIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSpecify() {
		return this.toFilterByType(FLTraceType.SPECIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToImplement() {
		return this.toFilterByType(FLTraceType.IMPLEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToElaborate() {
		return this.toFilterByType(FLTraceType.ELABORATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToDerive() {
		return this.toFilterByType(FLTraceType.DERIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToValidate() {
		return this.toFilterByType(FLTraceType.VALIDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTest() {
		return this.toFilterByType(FLTraceType.TEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRelate() {
		return this.toFilterByType(FLTraceType.RELATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToAffect() {
		return this.toFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToffect() {
		return this.toFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSatisfy() {
		return this.toFilterByType(FLTraceType.SATISFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToVerify() {
		return this.toFilterByType(FLTraceType.VERIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRefine() {
		return this.toFilterByType(FLTraceType.REFINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTrack() {
		return this.toFilterByType(FLTraceType.TRACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromOwn() {
		return this.fromFilterByType(FLTraceType.OWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromUse() {
		return this.fromFilterByType(FLTraceType.USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRealize() {
		return this.fromFilterByType(FLTraceType.REALIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromSpecify() {
		return this.fromFilterByType(FLTraceType.SPECIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromImplement() {
		return this.fromFilterByType(FLTraceType.IMPLEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromElaborate() {
		return this.fromFilterByType(FLTraceType.ELABORATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromDerive() {
		return this.fromFilterByType(FLTraceType.DERIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromValidate() {
		return this.fromFilterByType(FLTraceType.VALIDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromTest() {
		return this.fromFilterByType(FLTraceType.TEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRelate() {
		return this.fromFilterByType(FLTraceType.RELATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromAffect() {
		return this.fromFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromffect() {
		return this.fromFilterByType(FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromSatisfy() {
		return this.fromFilterByType(FLTraceType.SATISFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromVerify() {
		return this.fromFilterByType(FLTraceType.VERIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromRefine() {
		return this.fromFilterByType(FLTraceType.REFINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceFromTrack() {
		return this.fromFilterByType(FLTraceType.TRACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FLElement> toFilterByType(final FLTraceType traceType) {
		final BasicEList<FLElement> targets = new BasicEList<FLElement>();
		EList<FLTrace> _traces = this.getTraces();
		final Function1<FLTrace, Boolean> _function = new Function1<FLTrace, Boolean>() {
			public Boolean apply(final FLTrace it) {
				FLTraceType _traceType = it.getTraceType();
				return Boolean.valueOf(Objects.equal(_traceType, traceType));
			}
		};
		Iterable<FLTrace> _filter = IterableExtensions.<FLTrace>filter(_traces, _function);
		final Procedure1<FLTrace> _function_1 = new Procedure1<FLTrace>() {
			public void apply(final FLTrace it) {
				FLElement _target = it.getTarget();
				boolean _notEquals = (!Objects.equal(_target, null));
				if (_notEquals) {
					FLElement _target_1 = it.getTarget();
					targets.add(_target_1);
				}
			}
		};
		IterableExtensions.<FLTrace>forEach(_filter, _function_1);
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FLElement> fromFilterByType(final FLTraceType traceType) {
		final BasicEList<FLElement> sources = new BasicEList<FLElement>();
		boolean _and = false;
		CDOView _cdoView = this.cdoView();
		boolean _notEquals = (!Objects.equal(_cdoView, null));
		if (!_notEquals) {
			_and = false;
		} else {
			CDOView _cdoView_1 = this.cdoView();
			boolean _isClosed = _cdoView_1.isClosed();
			boolean _not = (!_isClosed);
			_and = _not;
		}
		if (_and) {
			CDOView _cdoView_2 = this.cdoView();
			ArrayList<EReference> _newArrayList = CollectionLiterals.<EReference>newArrayList(Literals.FL_TRACE__TARGET);
			final List<CDOObjectReference> xrefs = _cdoView_2.queryXRefs(this, ((EReference[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_newArrayList, EReference.class)));
			for (final CDOObjectReference x : xrefs) {
				{
					CDOObject _sourceObject = x.getSourceObject();
					final FLTrace trace = ((FLTrace) _sourceObject);
					FLTraceType _traceType = trace.getTraceType();
					boolean _equals = Objects.equal(_traceType, traceType);
					if (_equals) {
						EObject _eContainer = trace.eContainer();
						sources.add(((FLElement) _eContainer));
					}
				}
			}
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FL_ELEMENT__TRACES:
				return ((InternalEList<?>)getTraces()).basicRemove(otherEnd, msgs);
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.FL_ELEMENT__NAME:
				return getName();
			case BasePackage.FL_ELEMENT__UUID:
				return getUuid();
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				return getDescription();
			case BasePackage.FL_ELEMENT__TRACES:
				return getTraces();
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return getProperties();
			case BasePackage.FL_ELEMENT__TRACE_TO_OWN:
				return getTraceToOwn();
			case BasePackage.FL_ELEMENT__TRACE_TO_USE:
				return getTraceToUse();
			case BasePackage.FL_ELEMENT__TRACE_TO_REALIZE:
				return getTraceToRealize();
			case BasePackage.FL_ELEMENT__TRACE_TO_SPECIFY:
				return getTraceToSpecify();
			case BasePackage.FL_ELEMENT__TRACE_TO_IMPLEMENT:
				return getTraceToImplement();
			case BasePackage.FL_ELEMENT__TRACE_TO_ELABORATE:
				return getTraceToElaborate();
			case BasePackage.FL_ELEMENT__TRACE_TO_DERIVE:
				return getTraceToDerive();
			case BasePackage.FL_ELEMENT__TRACE_TO_VALIDATE:
				return getTraceToValidate();
			case BasePackage.FL_ELEMENT__TRACE_TO_TEST:
				return getTraceToTest();
			case BasePackage.FL_ELEMENT__TRACE_TO_RELATE:
				return getTraceToRelate();
			case BasePackage.FL_ELEMENT__TRACE_TO_AFFECT:
				return getTraceToAffect();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return getTraceToSatisfy();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return getTraceToVerify();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return getTraceToRefine();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return getTraceToTrack();
			case BasePackage.FL_ELEMENT__TRACE_FROM_OWN:
				return getTraceFromOwn();
			case BasePackage.FL_ELEMENT__TRACE_FROM_USE:
				return getTraceFromUse();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REALIZE:
				return getTraceFromRealize();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SPECIFY:
				return getTraceFromSpecify();
			case BasePackage.FL_ELEMENT__TRACE_FROM_IMPLEMENT:
				return getTraceFromImplement();
			case BasePackage.FL_ELEMENT__TRACE_FROM_ELABORATE:
				return getTraceFromElaborate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_DERIVE:
				return getTraceFromDerive();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VALIDATE:
				return getTraceFromValidate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TEST:
				return getTraceFromTest();
			case BasePackage.FL_ELEMENT__TRACE_FROM_RELATE:
				return getTraceFromRelate();
			case BasePackage.FL_ELEMENT__TRACE_FROM_AFFECT:
				return getTraceFromAffect();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SATISFY:
				return getTraceFromSatisfy();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VERIFY:
				return getTraceFromVerify();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REFINE:
				return getTraceFromRefine();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TRACK:
				return getTraceFromTrack();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.FL_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__UUID:
				setUuid((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BasePackage.FL_ELEMENT__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends FLTrace>)newValue);
				return;
			case BasePackage.FL_ELEMENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends FLProperty>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BasePackage.FL_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FL_ELEMENT__TRACES:
				getTraces().clear();
				return;
			case BasePackage.FL_ELEMENT__PROPERTIES:
				getProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BasePackage.FL_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case BasePackage.FL_ELEMENT__UUID:
				return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
			case BasePackage.FL_ELEMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case BasePackage.FL_ELEMENT__TRACES:
				return !getTraces().isEmpty();
			case BasePackage.FL_ELEMENT__PROPERTIES:
				return !getProperties().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_OWN:
				return !getTraceToOwn().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_USE:
				return !getTraceToUse().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_REALIZE:
				return !getTraceToRealize().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_SPECIFY:
				return !getTraceToSpecify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_IMPLEMENT:
				return !getTraceToImplement().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_ELABORATE:
				return !getTraceToElaborate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_DERIVE:
				return !getTraceToDerive().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_VALIDATE:
				return !getTraceToValidate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_TEST:
				return !getTraceToTest().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_RELATE:
				return !getTraceToRelate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_AFFECT:
				return !getTraceToAffect().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return !getTraceToSatisfy().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return !getTraceToVerify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return !getTraceToRefine().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return !getTraceToTrack().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_OWN:
				return !getTraceFromOwn().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_USE:
				return !getTraceFromUse().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REALIZE:
				return !getTraceFromRealize().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SPECIFY:
				return !getTraceFromSpecify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_IMPLEMENT:
				return !getTraceFromImplement().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_ELABORATE:
				return !getTraceFromElaborate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_DERIVE:
				return !getTraceFromDerive().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VALIDATE:
				return !getTraceFromValidate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TEST:
				return !getTraceFromTest().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_RELATE:
				return !getTraceFromRelate().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_AFFECT:
				return !getTraceFromAffect().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_SATISFY:
				return !getTraceFromSatisfy().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_VERIFY:
				return !getTraceFromVerify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_REFINE:
				return !getTraceFromRefine().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_FROM_TRACK:
				return !getTraceFromTrack().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasePackage.FL_ELEMENT___TO_FILTER_BY_TYPE__FLTRACETYPE:
				return toFilterByType((FLTraceType)arguments.get(0));
			case BasePackage.FL_ELEMENT___FROM_FILTER_BY_TYPE__FLTRACETYPE:
				return fromFilterByType((FLTraceType)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //FLElementImpl
