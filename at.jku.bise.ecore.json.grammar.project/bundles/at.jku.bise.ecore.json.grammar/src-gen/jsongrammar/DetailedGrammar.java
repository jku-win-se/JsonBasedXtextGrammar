/**
 */
package jsongrammar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detailed Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jsongrammar.DetailedGrammar#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link jsongrammar.DetailedGrammar#getCurlyBracesReferences <em>Curly Braces References</em>}</li>
 *   <li>{@link jsongrammar.DetailedGrammar#getBracketsReferences <em>Brackets References</em>}</li>
 *   <li>{@link jsongrammar.DetailedGrammar#getKeyValue <em>Key Value</em>}</li>
 *   <li>{@link jsongrammar.DetailedGrammar#getCurlyBracesEClass <em>Curly Braces EClass</em>}</li>
 *   <li>{@link jsongrammar.DetailedGrammar#getBracketsEClass <em>Brackets EClass</em>}</li>
 * </ul>
 *
 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar()
 * @model
 * @generated
 */
public interface DetailedGrammar extends EObject {
	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keywords</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_Keywords()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getKeywords();

	/**
	 * Returns the value of the '<em><b>Curly Braces References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curly Braces References</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_CurlyBracesReferences()
	 * @model
	 * @generated
	 */
	EList<EReference> getCurlyBracesReferences();

	/**
	 * Returns the value of the '<em><b>Brackets References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brackets References</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_BracketsReferences()
	 * @model
	 * @generated
	 */
	EList<EReference> getBracketsReferences();

	/**
	 * Returns the value of the '<em><b>Key Value</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Value</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_KeyValue()
	 * @model
	 * @generated
	 */
	EList<EAttribute> getKeyValue();

	/**
	 * Returns the value of the '<em><b>Curly Braces EClass</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curly Braces EClass</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_CurlyBracesEClass()
	 * @model
	 * @generated
	 */
	EList<EClass> getCurlyBracesEClass();

	/**
	 * Returns the value of the '<em><b>Brackets EClass</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brackets EClass</em>' reference list.
	 * @see jsongrammar.JsongrammarPackage#getDetailedGrammar_BracketsEClass()
	 * @model
	 * @generated
	 */
	EList<EClass> getBracketsEClass();

} // DetailedGrammar
