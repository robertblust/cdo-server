/**
 */
package ch.flatland.cdo.model.base.util;

import ch.flatland.cdo.model.base.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.base.BasePackage
 * @generated
 */
public class BaseSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BasePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseSwitch() {
		if (modelPackage == null) {
			modelPackage = BasePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BasePackage.FLID: {
				FLID flid = (FLID)theEObject;
				T result = caseFLID(flid);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_ELEMENT: {
				FLElement flElement = (FLElement)theEObject;
				T result = caseFLElement(flElement);
				if (result == null) result = caseFLID(flElement);
				if (result == null) result = caseFLNameable(flElement);
				if (result == null) result = caseFLRateable(flElement);
				if (result == null) result = caseFLCommentable(flElement);
				if (result == null) result = caseFLHyperLinkable(flElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_PACKAGE: {
				FLPackage flPackage = (FLPackage)theEObject;
				T result = caseFLPackage(flPackage);
				if (result == null) result = caseFLElement(flPackage);
				if (result == null) result = caseFLID(flPackage);
				if (result == null) result = caseFLNameable(flPackage);
				if (result == null) result = caseFLRateable(flPackage);
				if (result == null) result = caseFLCommentable(flPackage);
				if (result == null) result = caseFLHyperLinkable(flPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_HYPER_LINK: {
				FLHyperLink flHyperLink = (FLHyperLink)theEObject;
				T result = caseFLHyperLink(flHyperLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_COMMENT: {
				FLComment flComment = (FLComment)theEObject;
				T result = caseFLComment(flComment);
				if (result == null) result = caseFLRateable(flComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_DATA_PROVIDER: {
				FLDataProvider flDataProvider = (FLDataProvider)theEObject;
				T result = caseFLDataProvider(flDataProvider);
				if (result == null) result = caseFLID(flDataProvider);
				if (result == null) result = caseFLNameable(flDataProvider);
				if (result == null) result = caseFLCommentable(flDataProvider);
				if (result == null) result = caseFLHyperLinkable(flDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_COMMENTABLE: {
				FLCommentable flCommentable = (FLCommentable)theEObject;
				T result = caseFLCommentable(flCommentable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_HYPER_LINKABLE: {
				FLHyperLinkable flHyperLinkable = (FLHyperLinkable)theEObject;
				T result = caseFLHyperLinkable(flHyperLinkable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_NAMEABLE: {
				FLNameable flNameable = (FLNameable)theEObject;
				T result = caseFLNameable(flNameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_RATEABLE: {
				FLRateable flRateable = (FLRateable)theEObject;
				T result = caseFLRateable(flRateable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_GLOBAL_SEARCH: {
				FLGlobalSearch flGlobalSearch = (FLGlobalSearch)theEObject;
				T result = caseFLGlobalSearch(flGlobalSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_RATING: {
				FLRating flRating = (FLRating)theEObject;
				T result = caseFLRating(flRating);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_TRACE: {
				FLTrace flTrace = (FLTrace)theEObject;
				T result = caseFLTrace(flTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BasePackage.FL_PROPERTY: {
				FLProperty flProperty = (FLProperty)theEObject;
				T result = caseFLProperty(flProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FLID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FLID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLID(FLID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLElement(FLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLPackage(FLPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Hyper Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Hyper Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLHyperLink(FLHyperLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLComment(FLComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLDataProvider(FLDataProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Commentable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Commentable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLCommentable(FLCommentable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Hyper Linkable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Hyper Linkable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLHyperLinkable(FLHyperLinkable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLNameable(FLNameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Rateable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Rateable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLRateable(FLRateable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Global Search</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Global Search</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLGlobalSearch(FLGlobalSearch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Rating</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Rating</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLRating(FLRating object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLTrace(FLTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FL Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FL Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFLProperty(FLProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BaseSwitch
