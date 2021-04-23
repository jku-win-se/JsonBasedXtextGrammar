/**
 */
package jsongrammar.impl;

import java.util.Collection;

import jsongrammar.DetailedGrammar;
import jsongrammar.JsonGrammar;
import jsongrammar.JsongrammarPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link jsongrammar.impl.JsonGrammarImpl#getDetaileGrammars <em>Detaile Grammars</em>}</li>
 *   <li>{@link jsongrammar.impl.JsonGrammarImpl#getNsURI <em>Ns URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JsonGrammarImpl extends MinimalEObjectImpl.Container implements JsonGrammar {
	/**
	 * The cached value of the '{@link #getDetaileGrammars() <em>Detaile Grammars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetaileGrammars()
	 * @generated
	 * @ordered
	 */
	protected EList<DetailedGrammar> detaileGrammars;

	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JsonGrammarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsongrammarPackage.Literals.JSON_GRAMMAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DetailedGrammar> getDetaileGrammars() {
		if (detaileGrammars == null) {
			detaileGrammars = new EObjectContainmentEList<DetailedGrammar>(DetailedGrammar.class, this, JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS);
		}
		return detaileGrammars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsongrammarPackage.JSON_GRAMMAR__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS:
				return ((InternalEList<?>)getDetaileGrammars()).basicRemove(otherEnd, msgs);
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
			case JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS:
				return getDetaileGrammars();
			case JsongrammarPackage.JSON_GRAMMAR__NS_URI:
				return getNsURI();
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
			case JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS:
				getDetaileGrammars().clear();
				getDetaileGrammars().addAll((Collection<? extends DetailedGrammar>)newValue);
				return;
			case JsongrammarPackage.JSON_GRAMMAR__NS_URI:
				setNsURI((String)newValue);
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
			case JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS:
				getDetaileGrammars().clear();
				return;
			case JsongrammarPackage.JSON_GRAMMAR__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
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
			case JsongrammarPackage.JSON_GRAMMAR__DETAILE_GRAMMARS:
				return detaileGrammars != null && !detaileGrammars.isEmpty();
			case JsongrammarPackage.JSON_GRAMMAR__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (nsURI: ");
		result.append(nsURI);
		result.append(')');
		return result.toString();
	}

} //JsonGrammarImpl
