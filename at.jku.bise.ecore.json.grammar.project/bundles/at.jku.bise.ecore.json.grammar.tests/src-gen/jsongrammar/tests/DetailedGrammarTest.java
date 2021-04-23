/**
 */
package jsongrammar.tests;

import jsongrammar.DetailedGrammar;
import jsongrammar.JsongrammarFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Detailed Grammar</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DetailedGrammarTest extends TestCase {

	/**
	 * The fixture for this Detailed Grammar test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DetailedGrammar fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DetailedGrammarTest.class);
	}

	/**
	 * Constructs a new Detailed Grammar test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailedGrammarTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Detailed Grammar test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DetailedGrammar fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Detailed Grammar test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DetailedGrammar getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(JsongrammarFactory.eINSTANCE.createDetailedGrammar());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //DetailedGrammarTest
