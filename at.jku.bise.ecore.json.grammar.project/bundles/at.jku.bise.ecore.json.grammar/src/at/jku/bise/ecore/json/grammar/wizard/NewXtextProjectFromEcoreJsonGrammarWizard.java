package at.jku.bise.ecore.json.grammar.wizard;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Messages;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.WizardSelectImportedEPackagePage;
import org.eclipse.xtext.xtext.ui.wizard.project.NewXtextProjectWizard;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;
import org.eclipse.xtext.xtext.wizard.RuntimeProjectDescriptor;

import com.google.inject.Inject;


public class NewXtextProjectFromEcoreJsonGrammarWizard extends NewXtextProjectWizard {
	
	private WizardSelectImportedEPackagePage ePackageSelectionPage;
	private final IJdtHelper jdtHelper;
	private WizardNewJSonGrammarCreationPage grammarSelectionPage;

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
		ePackageSelectionPage = new WizardSelectImportedEPackagePage("ePackageSelectionPage", selection, jdtHelper);
		grammarSelectionPage = new WizardNewJSonGrammarCreationPage("Selection Custom JSON Grammar Specification", selection, jdtHelper);
		addPage(grammarSelectionPage);
		addPage(ePackageSelectionPage); //$NON-NLS-1$		
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
	
}
