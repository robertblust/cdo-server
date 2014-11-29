/**
 */
package ch.flatland.cdo.model.test;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ch.flatland.cdo.model.test.TestPackage
 * @generated
 */
public interface TestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestFactory eINSTANCE = ch.flatland.cdo.model.test.impl.TestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simple Data Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Data Types</em>'.
	 * @generated
	 */
	SimpleDataTypes createSimpleDataTypes();

	/**
	 * Returns a new object of class '<em>Simple Data Types As Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Data Types As Array</em>'.
	 * @generated
	 */
	SimpleDataTypesAsArray createSimpleDataTypesAsArray();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestPackage getTestPackage();

} //TestFactory
