package at.jku.bise.ecore.json.grammar.wizard;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageChooser;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Messages;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.WizardSelectImportedEPackagePage;
import org.eclipse.xtext.xtext.ui.wizard.project.NewXtextProjectWizard;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;

import com.google.common.collect.Lists;
import com.google.inject.Inject;


public class NewXtextProjectFromEcoreJsonGrammarWizard extends NewXtextProjectWizard {
	
	public static final String JSON_GRAMMAR_CREATION_PAGE_NAME ="Selection Custom JSON Grammar Specification";
	public static final String E_PACKAGE_CREATION_PAGE_NAME = "ePackageSelectionPage";
	
	
//	private WizardSelectImportedEPackagePage ePackageSelectionPage  = null;
	private WizardJsonGrammarSelectImportedEPackagePage ePackageSelectionPage  = null;
	


	private final IJdtHelper jdtHelper;
	private WizardNewJSonGrammarCreationPage grammarSelectionPage = null;

	
	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectFromEcoreJsonGrammarWizard(XtextProjectCreator creator, IJdtHelper jdtHelper) {
		super(creator);
		this.jdtHelper = jdtHelper;
		setWindowTitle(Messages.NewXtextProjectFromEcoreWizard_WindowTitle);
	}

	@Override
	public void addPages() {
//		ePackageSelectionPage = new WizardSelectImportedEPackagePage("ePackageSelectionPage", selection, jdtHelper);
//		grammarSelectionPage = new WizardNewJSonGrammarCreationPage(JSON_GRAMMAR_CREATION_PAGE_NAME, selection, jdtHelper);
//		addPage(grammarSelectionPage);
		addGrammarSelectionPage();
//		addPage(ePackageSelectionPage); //$NON-NLS-1$	
		addEPackageSelectionPage();
		super.addPages();
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		XtextJsonGrammarProjectInfo projectInfo = (XtextJsonGrammarProjectInfo) super.getProjectInfo();
		projectInfo.setJsonGrammarFile(this.grammarSelectionPage.getJsonGrammarFile());
		RuntimeProjectDescriptor runtimeProjectDescriptor = projectInfo.getRuntimeProject();
		runtimeProjectDescriptor.setWithPluginXml(false);
		Ecore2XtextConfiguration ecore2Xtext = projectInfo.getEcore2Xtext();
		ecore2Xtext.getEPackageInfos().addAll(ePackageSelectionPage.getEPackageInfos());
		ecore2Xtext.setRootElementClass(ePackageSelectionPage.getRootElementClass());
		ecore2Xtext.setDefaultEPackageInfo(ePackageSelectionPage.getDefaultEPackageInfo());
		return projectInfo;
	}
	
	@Override
	protected XtextProjectInfo createProjectInfo() {
		return new XtextJsonGrammarProjectInfo();
	}
	
	public void addGrammarSelectionPage() {
		if(grammarSelectionPage==null) {
			grammarSelectionPage = new WizardNewJSonGrammarCreationPage(JSON_GRAMMAR_CREATION_PAGE_NAME, selection, jdtHelper);
			addPage(grammarSelectionPage);
		}
	}
	
	public void addEPackageSelectionPage() {
		if(ePackageSelectionPage==null) {
//			ePackageSelectionPage = new WizardSelectImportedEPackagePage(E_PACKAGE_CREATION_PAGE_NAME, selection, jdtHelper);  
			ePackageSelectionPage = new WizardJsonGrammarSelectImportedEPackagePage(E_PACKAGE_CREATION_PAGE_NAME, selection, jdtHelper);  
			addPage(ePackageSelectionPage);
		}
	}
	

	public WizardNewJSonGrammarCreationPage getGrammarSelectionPage() {
		return grammarSelectionPage;
	}
	
//	public WizardSelectImportedEPackagePage getePackageSelectionPage() {
	public WizardJsonGrammarSelectImportedEPackagePage getePackageSelectionPage() {
		return ePackageSelectionPage;
	}
	
	public void setJsonGrammarFile(IFile jsonGrammarFile) {
		addGrammarSelectionPage();
		grammarSelectionPage.setJsonGrammarFile(jsonGrammarFile);
	}
	
	public void setGenModelSelection(URI genModelURI) {
//		List<EPackageInfo> ePackageInfos = Lists.newArrayList();
		addEPackageSelectionPage();
		Collection<EPackageInfo> ePackageInfos = ePackageSelectionPage.getEPackageInfos();
		EPackageChooserExtended ePackageChooser = new EPackageChooserExtended(getShell(), jdtHelper);
		ePackageInfos.addAll(ePackageChooser.createEPackageInfosFromGenModel(genModelURI));
	}
	
	public void setSetRootClass(EClass rootEClass) {
//		ISelection selection = new StructuredSelection(rootEClass);//selection instanceof IStructuredSelection
//		ComboViewer rootElementComboViewer = (ComboViewer) ePackageSelectionPage.getRootElementComboViewer();
//		rootElementComboViewer.setSelection(selection); //rootElementComboViewer.getSelection()
//		/**
//		 * it forces the updateUI()
//		 */
//		ePackageSelectionPage.setRootElementComboViewer( rootElementComboViewer);
		ePackageSelectionPage.setSetRootClass( rootEClass);
	}

}
