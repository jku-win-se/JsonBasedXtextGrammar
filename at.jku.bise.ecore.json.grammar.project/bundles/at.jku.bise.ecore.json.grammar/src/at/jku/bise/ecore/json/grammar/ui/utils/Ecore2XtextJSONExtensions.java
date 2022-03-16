package at.jku.bise.ecore.json.grammar.ui.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil;
import static org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextExtensions.*;

public class Ecore2XtextJSONExtensions {
	
	public static String assignedJSONRuleCall(EAttribute it) {
			return UniqueNameUtil.uniqueName(it.getEType());		
	} 
}
