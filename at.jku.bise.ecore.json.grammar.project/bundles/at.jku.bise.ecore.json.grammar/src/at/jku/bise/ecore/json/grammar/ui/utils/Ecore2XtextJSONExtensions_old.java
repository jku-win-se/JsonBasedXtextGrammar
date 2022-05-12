package at.jku.bise.ecore.json.grammar.ui.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextExtensions;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil;
import static org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextExtensions.*;

public class Ecore2XtextJSONExtensions_old extends Ecore2XtextExtensions {
	
	//Similar to Ecore2XtextExtensions.assignedRuleCall(EAttribute it)
	public static String assignedJSONRuleCall(EAttribute it) {
			return UniqueNameUtil.uniqueName(it.getEType());		
	} 
	
}
