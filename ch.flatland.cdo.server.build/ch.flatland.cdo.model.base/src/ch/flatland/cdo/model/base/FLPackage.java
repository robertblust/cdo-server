/**
 */
package ch.flatland.cdo.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FL Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getElements <em>Elements</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getSubPackages <em>Sub Packages</em>}</li>
 *   <li>{@link ch.flatland.cdo.model.base.FLPackage#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage()
 * @model
 * @generated
 */
public interface FLPackage extends FLElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<FLElement> getElements();

	/**
	 * Returns the value of the '<em><b>Sub Packages</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Packages</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_SubPackages()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLElement%>> _elements = this.getElements();\n<%java.lang.Iterable%><<%ch.flatland.cdo.model.base.FLPackage%>> _filter = <%com.google.common.collect.Iterables%>.<<%ch.flatland.cdo.model.base.FLPackage%>>filter(_elements, <%ch.flatland.cdo.model.base.FLPackage%>.class);\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%ch.flatland.cdo.model.base.FLPackage%>>asEList(((<%ch.flatland.cdo.model.base.FLPackage%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, <%ch.flatland.cdo.model.base.FLPackage%>.class)));'"
	 * @generated
	 */
	EList<FLPackage> getSubPackages();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' reference list.
	 * The list contents are of type {@link ch.flatland.cdo.model.base.FLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' reference list.
	 * @see ch.flatland.cdo.model.base.BasePackage#getFLPackage_Contents()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%ch.flatland.cdo.model.base.FLElement%>> _elements = this.getElements();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLElement%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.flatland.cdo.model.base.FLElement%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%ch.flatland.cdo.model.base.FLElement%> it)\n\t{\n\t\treturn <%java.lang.Boolean%>.valueOf((!(it instanceof <%ch.flatland.cdo.model.base.FLPackage%>)));\n\t}\n};\n<%java.lang.Iterable%><<%ch.flatland.cdo.model.base.FLElement%>> _filter = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%ch.flatland.cdo.model.base.FLElement%>>filter(_elements, _function);\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%ch.flatland.cdo.model.base.FLElement%>>asEList(((<%ch.flatland.cdo.model.base.FLElement%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_filter, <%ch.flatland.cdo.model.base.FLElement%>.class)));'"
	 * @generated
	 */
	EList<FLElement> getContents();

} // FLPackage
