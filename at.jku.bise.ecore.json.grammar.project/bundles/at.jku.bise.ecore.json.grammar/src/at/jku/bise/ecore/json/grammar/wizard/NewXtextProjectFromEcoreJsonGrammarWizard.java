package at.jku.bise.ecore.json.grammar.wizard;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.ui.Activator;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageChooser;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Messages;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.WizardSelectImportedEPackagePage;
import org.eclipse.xtext.xtext.ui.wizard.project.AdvancedNewProjectPage;
import org.eclipse.xtext.xtext.ui.wizard.project.NewXtextProjectWizard;
import org.eclipse.xtext.xtext.ui.wizard.project.WizardNewXtextProjectCreationPage;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;
import org.eclipse.xtext.xtext.wizard.BuildSystem;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.ProjectLayout;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TestedProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;


//public class NewXtextProjectFromEcoreJsonGrammarWizard extends NewXtextProjectWizard {
public class NewXtextProjectFromEcoreJsonGrammarWizard extends XtextNewProjectWizard {
		
	public static final String JSON_GRAMMAR_CREATION_PAGE_NAME ="Selection Custom JSON Grammar Specification";
	public static final String E_PACKAGE_CREATION_PAGE_NAME = "ePackageSelectionPage";
	public static final String MAIN_PAGE ="mainPage";
	public static final String ADVANCED_PAGE = "advancedPage";
	
	private final IJdtHelper jdtHelper;
	
//	private WizardSelectImportedEPackagePage ePackageSelectionPage  = null;
	private WizardJsonGrammarSelectImportedEPackagePage ePackageSelectionPage  = null;
	


	
	private WizardNewJSonGrammarCreationPage grammarSelectionPage = null;
	private WizardJsonGrammarNewXtextProjectCreationPage mainPage = null;
	private AdvancedJsonGrammarNewProjectPage advancedPage = null;

	
	/**
	 * Constructs a new wizard
	 */
	@Inject
	public NewXtextProjectFromEcoreJsonGrammarWizard(XtextProjectCreator creator, IJdtHelper jdtHelper) {
		super(creator);
		this.jdtHelper = jdtHelper;
		setWindowTitle(Messages.NewXtextProjectFromEcoreWizard_WindowTitle);
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/wizban/newxprj_wiz.gif")); //$NON-NLS-1$
	}

	@Override
	public void addPages() {
//		ePackageSelectionPage = new WizardSelectImportedEPackagePage("ePackageSelectionPage", selection, jdtHelper);
//		grammarSelectionPage = new WizardNewJSonGrammarCreationPage(JSON_GRAMMAR_CREATION_PAGE_NAME, selection, jdtHelper);
//		addPage(grammarSelectionPage);
		addGrammarSelectionPage();
//		addPage(ePackageSelectionPage); //$NON-NLS-1$	
		addEPackageSelectionPage();
//		super.addPages();
		addMainPage();
		addAdvancedPage();
	}

	@Override
	protected IProjectInfo getProjectInfo() {
//		XtextJsonGrammarProjectInfo projectInfo = (XtextJsonGrammarProjectInfo) super.getProjectInfo();
		XtextJsonGrammarProjectInfo projectInfo = (XtextJsonGrammarProjectInfo) createXtextJsonGrammarProjectInfo();
		projectInfo.setJsonGrammarFile(this.grammarSelectionPage.getJsonGrammarFile());
		RuntimeProjectDescriptor runtimeProjectDescriptor = projectInfo.getRuntimeProject();
		runtimeProjectDescriptor.setWithPluginXml(false);
		Ecore2XtextConfiguration ecore2Xtext = projectInfo.getEcore2Xtext();
		ecore2Xtext.getEPackageInfos().addAll(ePackageSelectionPage.getEPackageInfos());
		ecore2Xtext.setRootElementClass(ePackageSelectionPage.getRootElementClass());
		ecore2Xtext.setDefaultEPackageInfo(ePackageSelectionPage.getDefaultEPackageInfo());
		return projectInfo;
	}
	
	private IProjectInfo createXtextJsonGrammarProjectInfo() {
//		XtextProjectInfo projectInfo = createProjectInfo();
		XtextJsonGrammarProjectInfo projectInfo = new XtextJsonGrammarProjectInfo();
		LanguageDescriptor language = projectInfo.getLanguage();
		language.setFileExtensions(FileExtensions.fromString(mainPage.getFileExtensions()));
		language.setName(mainPage.getLanguageName());
		projectInfo.setBaseName(mainPage.getProjectName());
		projectInfo.setWorkingSets(Arrays.asList(mainPage.getSelectedWorkingSets()));
		projectInfo.setRootLocation(mainPage.getLocationPath().toString());
		Charset encoding = null;
		try {
			encoding = Charset.forName(ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset());
		}
		catch (final CoreException e) {
			encoding = Charset.defaultCharset();
		}
		projectInfo.setEncoding(encoding);
		String lineDelimiter = InstanceScope.INSTANCE.getNode("org.eclipse.core.runtime").get("line.separator", Strings.newLine());
		projectInfo.setLineDelimiter(lineDelimiter);
		projectInfo.setWorkbench(getWorkbench());
		JavaVersion selectedBree = mainPage.getJavaVersion();
		// Use old default for wizard as fall back, when something goes wrong
		if (selectedBree != null) {
			projectInfo.setJavaVersion(selectedBree);
		}

		BuildSystem buildSystem = advancedPage.getPreferredBuildSystem();
		projectInfo.setPreferredBuildSystem(buildSystem);
		projectInfo.setSourceLayout(advancedPage.getSourceLayout());
		
		projectInfo.getUiProject().setEnabled(advancedPage.isCreateUiProject());
		if (buildSystem != BuildSystem.NONE) {
			projectInfo.setProjectLayout(ProjectLayout.HIERARCHICAL);
		}
		projectInfo.getIdeProject().setEnabled(advancedPage.isCreateIdeProject());
		projectInfo.getWebProject().setEnabled(advancedPage.isCreateWebProject());
		projectInfo.getSdkProject().setEnabled(advancedPage.isCreateSdkProject());
		projectInfo.getP2Project().setEnabled(advancedPage.isCreateP2Project());
		projectInfo.setLanguageServer(advancedPage.getLanguageServer());
		projectInfo.setJunitVersion(advancedPage.getSelectedJUnitVersion());
		
		if (advancedPage.isCreateTestProject()) {
			for (ProjectDescriptor project : projectInfo.getEnabledProjects()) {
				if (project instanceof TestedProjectDescriptor) {
					((TestedProjectDescriptor) project).getTestProject().setEnabled(true);
				}
			}
		}
		return projectInfo;
	}
	
//	@Override
//	protected XtextProjectInfo createProjectInfo() {
//		return new XtextJsonGrammarProjectInfo();
//	}
//	
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
	
	public void addMainPage() {
//		WizardNewXtextProjectCreationPage mainPage = getMainPage();
		WizardJsonGrammarNewXtextProjectCreationPage mainPage = getMainPage();
		if(mainPage==null) {
//			mainPage = new WizardNewXtextProjectCreationPage(MAIN_PAGE, this.selection); //$NON-NLS-1$
			this.mainPage = new WizardJsonGrammarNewXtextProjectCreationPage(MAIN_PAGE, this.selection); //$NON-NLS-1$
			addPage(this.mainPage);
		}
	}
	
	public void addAdvancedPage() {
		AdvancedJsonGrammarNewProjectPage advancedPage = getAdvancedPage();
		if(advancedPage==null) {
			this.advancedPage = new AdvancedJsonGrammarNewProjectPage(ADVANCED_PAGE);
			addPage(this.advancedPage);
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
		ePackageSelectionPage.setSetRootClass( rootEClass);
	}
	
//	public WizardNewXtextProjectCreationPage getMainPage() {
//		return (WizardNewXtextProjectCreationPage) getPage(MAIN_PAGE);
//	}
	
	public WizardJsonGrammarNewXtextProjectCreationPage getMainPage() {
//		return (WizardJsonGrammarNewXtextProjectCreationPage) getPage(MAIN_PAGE);
		return this.mainPage;
	}
	
//	WizardJsonGrammarNewXtextProjectCreationPage
	public AdvancedJsonGrammarNewProjectPage getAdvancedPage() {
//		return (AdvancedJsonGrammarNewProjectPage) getPage(ADVANCED_PAGE);
		return this.advancedPage;
	}
	
	public void setInitialProjectName(String name) {
		getMainPage().setInitialProjectName(name);
	}
	
	public void setInitialLanguageNameField(String initialLanguageNameField) {
		getMainPage().setInitialLanguageNameField(initialLanguageNameField);
	}
	
	public void setInitialExtensionsField(String initialExtensionsField) {
		getMainPage().setInitialExtensionsField(initialExtensionsField);
	}
	
	 

}
