package at.jku.bise.ecore.json.grammar.wizard

import static extension org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextExtensions.*
import static extension org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil.*
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EAttribute

class Ecore2XtextJsonGrammarExtesions {
	
	def static assignmentKeyword(EStructuralFeature it) {
		name 
	}
	
	def static assignedRuleCall(EAttribute it) {
		getEType.uniqueName();
	}
}
