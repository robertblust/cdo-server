/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.base.BasePackage
 * @generated
 */
public interface BaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseFactory eINSTANCE = ch.flatland.cdo.model.base.impl.BaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FL Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Package</em>'.
	 * @generated
	 */
	FLPackage createFLPackage();

	/**
	 * Returns a new object of class '<em>FL Hyper Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Hyper Link</em>'.
	 * @generated
	 */
	FLHyperLink createFLHyperLink();

	/**
	 * Returns a new object of class '<em>FL Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Comment</em>'.
	 * @generated
	 */
	FLComment createFLComment();

	/**
	 * Returns a new object of class '<em>FL Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Data Provider</em>'.
	 * @generated
	 */
	FLDataProvider createFLDataProvider();

	/**
	 * Returns a new object of class '<em>FL Rating</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Rating</em>'.
	 * @generated
	 */
	FLRating createFLRating();

	/**
	 * Returns a new object of class '<em>FL Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Trace</em>'.
	 * @generated
	 */
	FLTrace createFLTrace();

	/**
	 * Returns a new object of class '<em>FL Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FL Property</em>'.
	 * @generated
	 */
	FLProperty createFLProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BasePackage getBasePackage();

} //BaseFactory
