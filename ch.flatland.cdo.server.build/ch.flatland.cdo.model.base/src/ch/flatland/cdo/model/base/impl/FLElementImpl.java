/**
 */
package ch.flatland.cdo.model.base.impl;

import ch.flatland.cdo.model.base.BasePackage;
import ch.flatland.cdo.model.base.FLElement;
import ch.flatland.cdo.model.base.FLProperty;
import ch.flatland.cdo.model.base.FLTrace;
import ch.flatland.cdo.model.base.FLTraceType;
import com.google.common.base.Objects;
import java.lang.Iterable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
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
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToffect <em>Trace Toffect</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToSatisfy <em>Trace To Satisfy</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToVerify <em>Trace To Verify</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToRefine <em>Trace To Refine</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.impl.FLElementImpl#getTraceToTrack <em>Trace To Track</em>}</li>
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
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.OWN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToUse() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.USE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRealize() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.REALIZE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSpecify() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.SPECIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToImplement() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.IMPLEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToElaborate() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.ELABORATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToDerive() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.DERIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToValidate() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.VALIDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTest() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.TEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRelate() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.RELATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToffect() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.AFFECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToSatisfy() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.SATISFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToVerify() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.VERIFY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToRefine() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.REFINE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FLElement> getTraceToTrack() {
		EList<FLTrace> _traces = this.getTraces();
		return this.toFilterByType(_traces, FLTraceType.TRACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FLElement> toFilterByType(final EList<FLTrace> traces, final FLTraceType traceType) {
		final BasicEList<FLElement> targets = new BasicEList<FLElement>();
		final Function1<FLTrace, Boolean> _function = new Function1<FLTrace, Boolean>() {
			public Boolean apply(final FLTrace it) {
				FLTraceType _traceType = it.getTraceType();
				return Boolean.valueOf(Objects.equal(_traceType, traceType));
			}
		};
		Iterable<FLTrace> _filter = IterableExtensions.<FLTrace>filter(traces, _function);
		final Procedure1<FLTrace> _function_1 = new Procedure1<FLTrace>() {
			public void apply(final FLTrace it) {
				FLElement _target = it.getTarget();
				targets.add(_target);
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
			case BasePackage.FL_ELEMENT__TRACE_TOFFECT:
				return getTraceToffect();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return getTraceToSatisfy();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return getTraceToVerify();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return getTraceToRefine();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return getTraceToTrack();
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
			case BasePackage.FL_ELEMENT__TRACE_TOFFECT:
				return !getTraceToffect().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_SATISFY:
				return !getTraceToSatisfy().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_VERIFY:
				return !getTraceToVerify().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_REFINE:
				return !getTraceToRefine().isEmpty();
			case BasePackage.FL_ELEMENT__TRACE_TO_TRACK:
				return !getTraceToTrack().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasePackage.FL_ELEMENT___TO_FILTER_BY_TYPE__ELIST_FLTRACETYPE:
				return toFilterByType((EList<FLTrace>)arguments.get(0), (FLTraceType)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //FLElementImpl
