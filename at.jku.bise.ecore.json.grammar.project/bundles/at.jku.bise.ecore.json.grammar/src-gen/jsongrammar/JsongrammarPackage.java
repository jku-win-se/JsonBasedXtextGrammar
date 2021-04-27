/**
 */
package jsongrammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see jsongrammar.JsongrammarFactory
 * @model kind="package"
 * @generated
 */
public interface JsongrammarPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jsongrammar";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://at.jku.bise/jsongrammar/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jsongrammar";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JsongrammarPackage eINSTANCE = jsongrammar.impl.JsongrammarPackageImpl.init();

	/**
	 * The meta object id for the '{@link jsongrammar.impl.DetailedGrammarImpl <em>Detailed Grammar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsongrammar.impl.DetailedGrammarImpl
	 * @see jsongrammar.impl.JsongrammarPackageImpl#getDetailedGrammar()
	 * @generated
	 */
	int DETAILED_GRAMMAR = 0;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__KEYWORDS = 0;

	/**
	 * The feature id for the '<em><b>Curly Braces References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Brackets References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__BRACKETS_REFERENCES = 2;

	/**
	 * The feature id for the '<em><b>Key Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__KEY_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Curly Braces EClass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__CURLY_BRACES_ECLASS = 4;

	/**
	 * The feature id for the '<em><b>Brackets EClass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR__BRACKETS_ECLASS = 5;

	/**
	 * The number of structural features of the '<em>Detailed Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Detailed Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILED_GRAMMAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jsongrammar.impl.JsonGrammarImpl <em>Json Grammar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsongrammar.impl.JsonGrammarImpl
	 * @see jsongrammar.impl.JsongrammarPackageImpl#getJsonGrammar()
	 * @generated
	 */
	int JSON_GRAMMAR = 1;

	/**
	 * The feature id for the '<em><b>Detailed Grammar</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_GRAMMAR__DETAILED_GRAMMAR = 0;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_GRAMMAR__NS_URI = 1;

	/**
	 * The number of structural features of the '<em>Json Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_GRAMMAR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Json Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSON_GRAMMAR_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link jsongrammar.DetailedGrammar <em>Detailed Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detailed Grammar</em>'.
	 * @see jsongrammar.DetailedGrammar
	 * @generated
	 */
	EClass getDetailedGrammar();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Keywords</em>'.
	 * @see jsongrammar.DetailedGrammar#getKeywords()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_Keywords();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getCurlyBracesReferences <em>Curly Braces References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Curly Braces References</em>'.
	 * @see jsongrammar.DetailedGrammar#getCurlyBracesReferences()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_CurlyBracesReferences();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getBracketsReferences <em>Brackets References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Brackets References</em>'.
	 * @see jsongrammar.DetailedGrammar#getBracketsReferences()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_BracketsReferences();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getKeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Key Value</em>'.
	 * @see jsongrammar.DetailedGrammar#getKeyValue()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_KeyValue();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getCurlyBracesEClass <em>Curly Braces EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Curly Braces EClass</em>'.
	 * @see jsongrammar.DetailedGrammar#getCurlyBracesEClass()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_CurlyBracesEClass();

	/**
	 * Returns the meta object for the reference list '{@link jsongrammar.DetailedGrammar#getBracketsEClass <em>Brackets EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Brackets EClass</em>'.
	 * @see jsongrammar.DetailedGrammar#getBracketsEClass()
	 * @see #getDetailedGrammar()
	 * @generated
	 */
	EReference getDetailedGrammar_BracketsEClass();

	/**
	 * Returns the meta object for class '{@link jsongrammar.JsonGrammar <em>Json Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Json Grammar</em>'.
	 * @see jsongrammar.JsonGrammar
	 * @generated
	 */
	EClass getJsonGrammar();

	/**
	 * Returns the meta object for the containment reference '{@link jsongrammar.JsonGrammar#getDetailedGrammar <em>Detailed Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Detailed Grammar</em>'.
	 * @see jsongrammar.JsonGrammar#getDetailedGrammar()
	 * @see #getJsonGrammar()
	 * @generated
	 */
	EReference getJsonGrammar_DetailedGrammar();

	/**
	 * Returns the meta object for the attribute '{@link jsongrammar.JsonGrammar#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see jsongrammar.JsonGrammar#getNsURI()
	 * @see #getJsonGrammar()
	 * @generated
	 */
	EAttribute getJsonGrammar_NsURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JsongrammarFactory getJsongrammarFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link jsongrammar.impl.DetailedGrammarImpl <em>Detailed Grammar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsongrammar.impl.DetailedGrammarImpl
		 * @see jsongrammar.impl.JsongrammarPackageImpl#getDetailedGrammar()
		 * @generated
		 */
		EClass DETAILED_GRAMMAR = eINSTANCE.getDetailedGrammar();

		/**
		 * The meta object literal for the '<em><b>Keywords</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__KEYWORDS = eINSTANCE.getDetailedGrammar_Keywords();

		/**
		 * The meta object literal for the '<em><b>Curly Braces References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES = eINSTANCE.getDetailedGrammar_CurlyBracesReferences();

		/**
		 * The meta object literal for the '<em><b>Brackets References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__BRACKETS_REFERENCES = eINSTANCE.getDetailedGrammar_BracketsReferences();

		/**
		 * The meta object literal for the '<em><b>Key Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__KEY_VALUE = eINSTANCE.getDetailedGrammar_KeyValue();

		/**
		 * The meta object literal for the '<em><b>Curly Braces EClass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__CURLY_BRACES_ECLASS = eINSTANCE.getDetailedGrammar_CurlyBracesEClass();

		/**
		 * The meta object literal for the '<em><b>Brackets EClass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAILED_GRAMMAR__BRACKETS_ECLASS = eINSTANCE.getDetailedGrammar_BracketsEClass();

		/**
		 * The meta object literal for the '{@link jsongrammar.impl.JsonGrammarImpl <em>Json Grammar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsongrammar.impl.JsonGrammarImpl
		 * @see jsongrammar.impl.JsongrammarPackageImpl#getJsonGrammar()
		 * @generated
		 */
		EClass JSON_GRAMMAR = eINSTANCE.getJsonGrammar();

		/**
		 * The meta object literal for the '<em><b>Detailed Grammar</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JSON_GRAMMAR__DETAILED_GRAMMAR = eINSTANCE.getJsonGrammar_DetailedGrammar();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSON_GRAMMAR__NS_URI = eINSTANCE.getJsonGrammar_NsURI();

	}

} //JsongrammarPackage
