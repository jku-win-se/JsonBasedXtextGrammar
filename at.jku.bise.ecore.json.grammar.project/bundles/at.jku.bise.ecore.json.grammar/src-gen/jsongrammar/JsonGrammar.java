/**
 */
package jsongrammar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsongrammar.JsonGrammar#getDetaileGrammars <em>Detaile Grammars</em>}</li>
 *   <li>{@link jsongrammar.JsonGrammar#getNsURI <em>Ns URI</em>}</li>
 * </ul>
 *
 * @see jsongrammar.JsongrammarPackage#getJsonGrammar()
 * @model
 * @generated
 */
public interface JsonGrammar extends EObject {
	/**
	 * Returns the value of the '<em><b>Detaile Grammars</b></em>' containment reference list.
	 * The list contents are of type {@link jsongrammar.DetailedGrammar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detaile Grammars</em>' containment reference list.
	 * @see jsongrammar.JsongrammarPackage#getJsonGrammar_DetaileGrammars()
	 * @model containment="true"
	 * @generated
	 */
	EList<DetailedGrammar> getDetaileGrammars();

	/**
	 * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns URI</em>' attribute.
	 * @see #setNsURI(String)
	 * @see jsongrammar.JsongrammarPackage#getJsonGrammar_NsURI()
	 * @model
	 * @generated
	 */
	String getNsURI();

	/**
	 * Sets the value of the '{@link jsongrammar.JsonGrammar#getNsURI <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns URI</em>' attribute.
	 * @see #getNsURI()
	 * @generated
	 */
	void setNsURI(String value);

} // JsonGrammar
