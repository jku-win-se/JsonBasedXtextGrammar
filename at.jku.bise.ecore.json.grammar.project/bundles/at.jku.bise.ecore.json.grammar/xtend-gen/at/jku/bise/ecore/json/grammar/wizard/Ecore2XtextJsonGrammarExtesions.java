package at.jku.bise.ecore.json.grammar.wizard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil;

@SuppressWarnings("all")
public class Ecore2XtextJsonGrammarExtesions {
  public static String assignmentKeyword(final EStructuralFeature it) {
    return it.getName();
  }
  
  public static String assignedRuleCall(final EAttribute it) {
    return UniqueNameUtil.uniqueName(it.getEType());
  }
}
