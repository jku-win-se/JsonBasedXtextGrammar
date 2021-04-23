/**
 */
package jsongrammar.impl;

import java.util.Collection;

import jsongrammar.DetailedGrammar;
import jsongrammar.JsongrammarPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Detailed Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getCurlyBracesReferences <em>Curly Braces References</em>}</li>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getBracketsReferences <em>Brackets References</em>}</li>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getKeyValue <em>Key Value</em>}</li>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getCurlyBracesEClass <em>Curly Braces EClass</em>}</li>
 *   <li>{@link jsongrammar.impl.DetailedGrammarImpl#getBracketsEClass <em>Brackets EClass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DetailedGrammarImpl extends MinimalEObjectImpl.Container implements DetailedGrammar {
	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> keys;

	/**
	 * The cached value of the '{@link #getCurlyBracesReferences() <em>Curly Braces References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurlyBracesReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> curlyBracesReferences;

	/**
	 * The cached value of the '{@link #getBracketsReferences() <em>Brackets References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBracketsReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> bracketsReferences;

	/**
	 * The cached value of the '{@link #getKeyValue() <em>Key Value</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValue()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttribute> keyValue;

	/**
	 * The cached value of the '{@link #getCurlyBracesEClass() <em>Curly Braces EClass</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurlyBracesEClass()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> curlyBracesEClass;

	/**
	 * The cached value of the '{@link #getBracketsEClass() <em>Brackets EClass</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBracketsEClass()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> bracketsEClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DetailedGrammarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsongrammarPackage.Literals.DETAILED_GRAMMAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getKeys() {
		if (keys == null) {
			keys = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, JsongrammarPackage.DETAILED_GRAMMAR__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getCurlyBracesReferences() {
		if (curlyBracesReferences == null) {
			curlyBracesReferences = new EObjectResolvingEList<EReference>(EReference.class, this, JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES);
		}
		return curlyBracesReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getBracketsReferences() {
		if (bracketsReferences == null) {
			bracketsReferences = new EObjectResolvingEList<EReference>(EReference.class, this, JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_REFERENCES);
		}
		return bracketsReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttribute> getKeyValue() {
		if (keyValue == null) {
			keyValue = new EObjectResolvingEList<EAttribute>(EAttribute.class, this, JsongrammarPackage.DETAILED_GRAMMAR__KEY_VALUE);
		}
		return keyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getCurlyBracesEClass() {
		if (curlyBracesEClass == null) {
			curlyBracesEClass = new EObjectResolvingEList<EClass>(EClass.class, this, JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_ECLASS);
		}
		return curlyBracesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getBracketsEClass() {
		if (bracketsEClass == null) {
			bracketsEClass = new EObjectResolvingEList<EClass>(EClass.class, this, JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_ECLASS);
		}
		return bracketsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JsongrammarPackage.DETAILED_GRAMMAR__KEYS:
				return getKeys();
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES:
				return getCurlyBracesReferences();
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_REFERENCES:
				return getBracketsReferences();
			case JsongrammarPackage.DETAILED_GRAMMAR__KEY_VALUE:
				return getKeyValue();
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_ECLASS:
				return getCurlyBracesEClass();
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_ECLASS:
				return getBracketsEClass();
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
			case JsongrammarPackage.DETAILED_GRAMMAR__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES:
				getCurlyBracesReferences().clear();
				getCurlyBracesReferences().addAll((Collection<? extends EReference>)newValue);
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_REFERENCES:
				getBracketsReferences().clear();
				getBracketsReferences().addAll((Collection<? extends EReference>)newValue);
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__KEY_VALUE:
				getKeyValue().clear();
				getKeyValue().addAll((Collection<? extends EAttribute>)newValue);
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_ECLASS:
				getCurlyBracesEClass().clear();
				getCurlyBracesEClass().addAll((Collection<? extends EClass>)newValue);
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_ECLASS:
				getBracketsEClass().clear();
				getBracketsEClass().addAll((Collection<? extends EClass>)newValue);
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
			case JsongrammarPackage.DETAILED_GRAMMAR__KEYS:
				getKeys().clear();
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES:
				getCurlyBracesReferences().clear();
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_REFERENCES:
				getBracketsReferences().clear();
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__KEY_VALUE:
				getKeyValue().clear();
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_ECLASS:
				getCurlyBracesEClass().clear();
				return;
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_ECLASS:
				getBracketsEClass().clear();
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
			case JsongrammarPackage.DETAILED_GRAMMAR__KEYS:
				return keys != null && !keys.isEmpty();
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_REFERENCES:
				return curlyBracesReferences != null && !curlyBracesReferences.isEmpty();
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_REFERENCES:
				return bracketsReferences != null && !bracketsReferences.isEmpty();
			case JsongrammarPackage.DETAILED_GRAMMAR__KEY_VALUE:
				return keyValue != null && !keyValue.isEmpty();
			case JsongrammarPackage.DETAILED_GRAMMAR__CURLY_BRACES_ECLASS:
				return curlyBracesEClass != null && !curlyBracesEClass.isEmpty();
			case JsongrammarPackage.DETAILED_GRAMMAR__BRACKETS_ECLASS:
				return bracketsEClass != null && !bracketsEClass.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DetailedGrammarImpl