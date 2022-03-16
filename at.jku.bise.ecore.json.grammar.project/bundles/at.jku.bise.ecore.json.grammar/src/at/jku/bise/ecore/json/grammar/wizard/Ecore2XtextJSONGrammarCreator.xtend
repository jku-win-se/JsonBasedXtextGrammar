package at.jku.bise.ecore.json.grammar.wizard

import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.eclipse.emf.ecore.EClassifier
import static extension org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextExtensions.*
import static extension org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil.*
import static extension at.jku.bise.ecore.json.grammar.ui.utils.Ecore2XtextJSONExtensions.*;
import org.eclipse.emf.ecore.EClass
import java.util.List
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EDataType
import jsongrammar.DetailedGrammar
import jsongrammar.JsonGrammar
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.BaseInternalContentAssistParser.IFollowElementFactory

class Ecore2XtextJSONGrammarCreator {
	
	DetailedGrammar detailedJsonGrammar = null;
	
	def grammar(WizardConfiguration config) {
		val it = config.ecore2Xtext
		val XtextJsonGrammarProjectInfo xtextJsonGrammarProject = config as XtextJsonGrammarProjectInfo;
		this.detailedJsonGrammar = loadJsonGrammar(xtextJsonGrammarProject.jsonGrammarFile,
				config.ecore2Xtext.rootElementClass.eResource.resourceSet
		).detailedGrammar;
		defaultEPackageInfo.clearUniqueNames
		'''
			// automatically generated by Xtext JSON
			grammar «config.language.name» with org.eclipse.xtext.common.Terminals
			
			«FOR it: allReferencedEPackages»
				import "«nsURI»" «IF uniqueName !== null && uniqueName != ""»as «uniqueName»«ENDIF»
			«ENDFOR»
			
			«rootElementClass.rules»
			«FOR it:allDispatcherRuleClasses.but(rootElementClass)»
				
				«subClassDispatcherRule»
			«ENDFOR»
			«FOR it:allConcreteRuleClassifiers.but(rootElementClass)»
				
				«rule(it)»
			«ENDFOR»
			
		'''
	}
	
	def <T extends EClassifier> List<T> but(Iterable<T> classes, EClassifier it) {
		val retVal = classes.toList
		retVal.remove(it)
		return retVal
	}
	 
	def subClassDispatcherRule(EClass it) {
		'''
			«IF needsDispatcherRule»
				«uniqueName» returns «fqn»:
					«subClassAlternatives»;
			«ENDIF»
		'''
	}
	
	def subClassAlternatives(EClass eClazz) {
		var list = newArrayList(eClazz)+subClasses(eClazz)
		list=list.filter([c|needsConcreteRule(c)])
		list.map([concreteRuleName]).join(" | ")
	}
	
	def assigment(EStructuralFeature it) {
		'''	
			«assignmentKeywordJSON(it)»«IF it instanceof EReference»«it.openParenthesis»«ENDIF»«IF(!required)»(«ENDIF»«IF many»«IF containment»«ELSE»'(' «ENDIF»«ENDIF»«name.quoteIfNeccesary»«assignmentOperator»«assignedTerminal»«IF many» ( "," «name.quoteIfNeccesary»«assignmentOperator»«assignedTerminal»)* «IF containment»«ELSE»')' «ENDIF»«ENDIF»«IF (!required)»)?«ENDIF»«IF it instanceof EReference»«it.closeParenthesis»«ENDIF»
			«IF it instanceof EAttribute»
				«IF it.isKeyValue»
					«"'"»:«"'"»
				«ENDIF»
			«ENDIF»
		'''
	}
	
	def assignedTerminal(EStructuralFeature it) {
		switch(it) {
			EAttribute:
				it.assignedJSONRuleCall
			EReference:
				if(containment)
					it.EReferenceType.uniqueName
				else
					'''[«it.EReferenceType.fqn»|EString]'''
			default:
				''''''
		}
	}

	def assignmentOperator(EStructuralFeature it) {
		'''«IF many»+=«ELSEIF isBoolean(EType)&&prefixBooleanFeature»?=«ELSE»=«ENDIF»'''
	}

	def rules(EClassifier it) {
		if (it !== null && it.needsConcreteRule) {
			rule(it)
		}
	}
	
	def rule(EClassifier it) {
		switch(it) {
			EClass :
				'''
				//EClass «it.name»
				«it.concreteRuleName» returns «fqn»:
					«IF (it.onlyOptionalFeatures)»
						{«fqn»}
					«ENDIF»
					«FOR strF: it.prefixFeatures»
						«strF.assigment»
					«ENDFOR»
					«openParenthesis»
					«idAssignmentJSON(it)»«IF (!it.inlinedFeatures.empty)»
						«FOR attr: it.allAttributes»
								«attr.assigment»
							«ENDFOR»
							«FOR ref: it.allCrossReferences»
								«ref.assigment»
							«ENDFOR»
							«FOR conti: it.allContainmentReferences»
								«conti.assigment»
							«ENDFOR»
					«closeParenthesis»«ENDIF»;
			'''
			EEnum:
				'''enum «name.quoteIfNeccesary» returns «fqn»:
				«it.ELiterals.map([name+" = '"+name+"'"]).join(' | ')»;'''
			EDataType:
				if (it.serializable) {
				'''
						«uniqueName» returns «fqn»:
							«it.dataTypeRuleBody»;
					'''
				}
			
			default:	
				throw new IllegalStateException("No rule template for "+it)
		}
	}	
	
	def jsonSeparator(EStructuralFeature it) {
		'''«"'"»:«"'"»'''		
	}
	
	def isKeyword(EStructuralFeature it) {
		this.detailedJsonGrammar.keywords.contains(it) === true;
	}
	
	def isKeyValue(EAttribute it) {
		this.detailedJsonGrammar.keyValue.contains(it) === true;
	}
	
	def assignmentKeywordJSON(EStructuralFeature it) {
		if (isPrefixBooleanFeature(it))
			""
		else if (it.isKeyword) {
			''' 
				//Keywords
				'"«it.name»"' «jsonSeparator»
			'''
		} else if (it instanceof EReference) {
			'''
				//EReference is not a keyword
			'''
		} else if (it instanceof EAttribute) {
			if (it.isKeyValue)
				'''
				//KeyValue
				'''
		} else
			"'" + name + "' "
	}
	
	//Original implementation idAssigment
	def idAssignmentJSON(EClass it) {
		println(it.toString);
		val idAttr = idAttribute
		if(idAttr!==null) {
			'''
				//Keyword´s Name
				«assigment(idAttr)»
			'''
		}
	}	
	
	def closeParenthesis(EClass it) {
		if (needBraces) {
			'''«"'"»}«"'"»'''
		}
		else if (needBrackets)
			'''«"'"»]«"'"»'''	
			
	}
	
	def openParenthesis(EClass it) {
		if (needBraces) {
			'''«"'"»{«"'"»'''
		}
		else if (needBrackets)
			'''«"'"»[«"'"»'''			
	}
	
	def needBrackets(EClass it) {
		this.detailedJsonGrammar.bracketsEClass.contains(it) === true;
	}
	
	def boolean needBraces(EClass it) {		
		this.detailedJsonGrammar.curlyBracesEClass.contains(it) === true;
	}
	
	def openParenthesis(EReference it) {
		if (needBrackets) {
			'''«"'"»[«"'"»'''
		}
		else if (needCurlyBraces)
			'''«"'"»{«"'"»'''			
	}	
	
	def closeParenthesis(EReference it) {
		if (needBrackets) {
			'''«"'"»]«"'"»'''
		}
		else if (needCurlyBraces)
			'''«"'"»}«"'"»'''			
	}
	
	def needBrackets(EReference it) {
		this.detailedJsonGrammar.bracketsReferences.contains(it) === true;
	}
	
	def needCurlyBraces(EReference it) {
		this.detailedJsonGrammar.curlyBracesReferences.contains(it) === true;
	}
	
	def JsonGrammar loadJsonGrammar(IFile jsonGrammarFile, ResourceSet reset) {
		val Resource resource = reset.getResource(URI.createPlatformResourceURI(jsonGrammarFile.getFullPath().toString(), true), true);
		if (resource.getContents().get(0) instanceof JsonGrammar) {
			return resource.getContents().get(0) as JsonGrammar;
		} else
			throw new IllegalArgumentException("Expecting JsonGrammar type of object");
	 }
}