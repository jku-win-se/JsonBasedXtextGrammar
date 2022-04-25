package at.jku.bise.ecore.json.grammar.handlers;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.converter.util.ConverterUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.wizards.IWizardDescriptor;

import at.jku.bise.ecore.json.grammar.wizard.NewXtextProjectFromEcoreJsonGrammarWizard;
import jsongrammar.DetailedGrammar;
import jsongrammar.JsonGrammar;

public class CreateLanguageHandler extends AbstractHandler{

	public final static String JSCHEMA_EXTENSION = "jschema";
	public final static String JSON_GRAMMAR_EXTENSION = "jsongrammar";
	public final static String ECORE_SUFFIX= "Opt";
	public final static String ECORE_EXTENSION = "ecore";
	public final static String GENMODEL_EXTENSION = "genmodel";
	public final static String ROOT_EXTENDS_INTERFACE_SUFFIX = "Root";
	public final static String MODEL_FOLDER = "model";
	public final static String WIZARD_ID ="at.jku.bise.ecore.json.grammar.NewXtextProjectFromEcoreJsonGrammar";

	public final static String GEN_MODEL_XML_ENCODING = "UTF-8";
	public final static String GEN_MODEL_DIR = "src-gen";
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
//		ResourceSet resourceSet = new ResourceSetImpl();
		ResourceSet resourceSet = ConverterUtil.createResourceSet();
		
		TreeSelection treeSelection  = (TreeSelection)HandlerUtil.getCurrentSelectionChecked(event);
		IFile selectedFile = (IFile) treeSelection.getFirstElement();
		IPath fullPath = selectedFile.getFullPath(); 
		if(!JSCHEMA_EXTENSION.equals(fullPath.getFileExtension())) { 
			throw new ExecutionException("selected file extension must be "+JSCHEMA_EXTENSION);
		}
		String[] pathSegments = fullPath.segments();
		String selectedFileNameWithExtension = fullPath.lastSegment();
		/**
		 * name of the file without path and extension
		 */
		String filename = selectedFileNameWithExtension.substring(0, selectedFileNameWithExtension.lastIndexOf("."));
		IPath rootProjectPath = fullPath.removeLastSegments(1);
		IPath modelPath = rootProjectPath.append(MODEL_FOLDER);
		
		/**
		 * discover jsongrammar file
		 */
		String jsonGrammarFileName = filename+"."+JSON_GRAMMAR_EXTENSION;
		IPath jsonGrammarFilePath = modelPath.append(jsonGrammarFileName);
		IWorkspace workspace= ResourcesPlugin.getWorkspace();    
		IFile jsonGrammarFile = workspace.getRoot().getFile(jsonGrammarFilePath);
		
		GenModel genModel =generateGenmodelFile( workspace,  filename,  modelPath, rootProjectPath, resourceSet );
		generateSources(genModel);
		URI genModelURI = genModel.eResource().getURI();
		
		//genModel.getEcoreGenPackage();//genModel.getEcoreGenPackage().eContents()
		/**
		 * https://stackoverflow.com/questions/27766267/eclipse-plugin-how-to-open-a-wizard-page-in-a-command-handler
		 */
		Shell activeShell = HandlerUtil.getActiveShell(event);
		NewXtextProjectFromEcoreJsonGrammarWizard wizard = createNewXtextProjectFromEcoreJsonGrammarWizard();
		
		WizardDialog dialog = new WizardDialog(activeShell, wizard);
		wizard.setJsonGrammarFile(jsonGrammarFile);
		wizard.setGenModelSelection(genModelURI);
		wizard.addMainPage();
		/**
		 * set project name
		 */
		String dotSepatatedPath = fullPath.toString().replace("/", ".");
		String projectName = dotSepatatedPath.substring(1, dotSepatatedPath.lastIndexOf("."));
		wizard.setInitialProjectName(projectName);
		
		/**
		 * Set Language Name
		 */
		String languageName = projectName+"."+toCamelCase(filename);
		wizard.setInitialLanguageNameField(languageName);
		/**
		 * Set Language extension
		 */
		wizard.setInitialExtensionsField(filename);
		
		
		
		 
		
		/**
		 * call the createPageControls
		 */
		dialog.create();
		
		/**
		 * Set Root Class
		 * we need first the create control to initialize the combo viewer of the root EClass
		 */
		JsonGrammar jsonGrammar = loadJsonGrammar( jsonGrammarFile,  resourceSet);
		DetailedGrammar detailedJsonGrammar = jsonGrammar.getDetailedGrammar();
		EClass rootEClass = detailedJsonGrammar.getRootEClass();
		wizard.setSetRootClass(rootEClass);
		
		

		dialog.open();
		
		

		return null;
	}
	
	/**
	 * TODO refactor using Google guice
	 * https://resheim.net/2010/07/invoking-eclipse-wizard.html
	 * @return
	 */
	private NewXtextProjectFromEcoreJsonGrammarWizard createNewXtextProjectFromEcoreJsonGrammarWizard() {
		// First see if this is a "new wizard".
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(WIZARD_ID);
		// If not check if it is an "import wizard".
		if  (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(WIZARD_ID);
		}
		// Or maybe an export wizard
		if  (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(WIZARD_ID);
		}
		if  (descriptor != null) {
			
			try {
				NewXtextProjectFromEcoreJsonGrammarWizard wizard;
				wizard = (NewXtextProjectFromEcoreJsonGrammarWizard) descriptor.createWizard();
				return wizard;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("Wizard "+WIZARD_ID+ " not found" );

	}
	
	private GenModel generateGenmodelFile(IWorkspace workspace, String filename, IPath modelPath, IPath rootProjectPath , ResourceSet resourceSet) {
		String ecoreFileName = filename+ECORE_SUFFIX;
//		String genmodelFileName = ecoreFileName+"."+GENMODEL_EXTENSION;
		IPath ecoreFilePath = modelPath.append(ecoreFileName+"."+ECORE_EXTENSION);
		IPath genmodelFilePath = modelPath.append(ecoreFileName+"."+GENMODEL_EXTENSION);
//		IFile ecoreFile = workspace.getRoot().getFile(ecoreFilePath);
		/**
		 * https://spectrum.chat/emfcloud/general/get-epackage-of-ecore-file~97f19ba1-91a2-4a7d-ad33-ef06dfb7e52a
		 */
//		URI uri = URI.createURI(ecoreFilePath.toString());
		URI uri = URI.createPlatformResourceURI(ecoreFilePath.toString(),true);
		Resource ecorePackageResource = resourceSet.getResource(uri, true);
		EPackage ecorePackage = (EPackage)ecorePackageResource.getContents().get(0); 
		/**
		 * https://www.eclipse.org/forums/index.php?t=msg&th=513278&goto=1096737&#msg_1096737
		 * https://www.javatips.net/api/org.eclipse.emf.codegen.ecore.genmodel.genmodel
		 */
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setComplianceLevel(GenJDKLevel.JDK110_LITERAL);
		genModel.setModelDirectory(rootProjectPath.append(GEN_MODEL_DIR).toString());
		genModel.setModelPluginID(rootProjectPath.lastSegment());
		genModel.getForeignModel().add(ecoreFileName+"."+ECORE_EXTENSION);
		genModel.setModelName(toCamelCase(ecoreFileName));
		genModel.setOperationReflection(true);
		genModel.setImportOrganizing(true);
		genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
		genModel.setImporterID("org.eclipse.emf.importer.ecore");
		
		
//		URI jsonMetaschemaMMGenmodelURI = URI.createURI(jsonMetaschemaMM.Activator.getDefault().getBundle().getResource("model/jsonMetaschemaMM.genmodel").toString());
//		URI jsonMetaschemaMMGenmodelURI = URI.createPlatformPluginURI(jsonMetaschemaMM.Activator.getDefault().getBundle().getResource("model/jsonMetaschemaMM.genmodel").toString(),true);
//		URI jsonMetaschemaMMGenmodelURI  = URI.createURI("http://at.jku.bise/jsonMetaschemaMM");
		/**
		 * https://www.eclipse.org/forums/index.php/t/201509/
		 */
		//URI jsonMetaschemaMMGenmodelURI  = URI.createURI("http://at.jku.bise/jsonMetaschemaMM=platform:/resource/jsonmetaschemaMM/model/jsonMetaschemaMM.genmodel");
//		URI jsonMetaschemaMMGenmodelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap(true).get("http://at.jku.bise/jsonMetaschemaMM");//.get(jsonMetaschemaMMGenmodelURI);
//		URI jsonMetaschemaMMGenmodelURI =URI.createPlatformPluginURI("/jsonmetaschemaMM/model/jsonMetaschemaMM.genmodel",true);//resourceSet.getResource(URI.createPlatformPluginURI("/jsonmetaschemaMM/model/jsonMetaschemaMM.genmodel",true), true)
//		resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(true));
//		resourceSet.getResource(URI.createURI(JsonMetaschemaMMPackage.eINSTANCE.getNsURI()), true);
//		URI jsonMetaschemaMMGenmodelURI =URI.createURI("http://at.jku.bise/jsonMetaschemaMM/model/jsonMetaschemaMM.genmodel");
		URI jsonMetaschemaMMGenmodelURI =URI.createPlatformResourceURI("/jsonmetaschemaMM/model/jsonMetaschemaMM.genmodel",true);
		Resource jsonMetaschemaMMGenmodelResource = resourceSet.getResource(jsonMetaschemaMMGenmodelURI, true);
		
		GenModel jsonMetaschemaMMGenmodel = (GenModel)EcoreUtil.getObjectByType(jsonMetaschemaMMGenmodelResource.getContents(), GenModelPackage.Literals.GEN_MODEL);
		List<GenPackage> jsonMetaschemaMMGenPackages =jsonMetaschemaMMGenmodel.getGenPackages();
//		List<GenPackage> jsonMetaschemaMMGenPackages = ((GenModel) jsonMetaschemaMMGenmodelResource.getContents().get(0)).getGenPackages();
		genModel.getUsedGenPackages().addAll(jsonMetaschemaMMGenPackages);
		

		String packageName = ecorePackage.getName();
//		String rootExtendsInterface = packageName.substring(0, 1).toUpperCase() + packageName.substring(1)+ROOT_EXTENDS_INTERFACE_SUFFIX;
//		String rootExtendsInterface = toCamelCase(packageName)+ROOT_EXTENDS_INTERFACE_SUFFIX;
//		genModel.setRootExtendsInterface(rootExtendsInterface);
		genModel.initialize(Collections.singleton(ecorePackage));
		GenPackage genPackage = (GenPackage)genModel.getGenPackages().get(0);
		genPackage.setPrefix(packageName);
		
		genModel.setContainmentProxies(true);
		
		try {
//			URI genModelURI = URI.createFileURI(genmodelFilePath.toString());
			URI genModelURI = URI.createPlatformResourceURI(genmodelFilePath.toString(),true);
			final XMIResourceImpl genModelResource = new XMIResourceImpl(genModelURI);
			genModelResource.getDefaultSaveOptions().put(XMLResource.OPTION_ENCODING, GEN_MODEL_XML_ENCODING);
			genModelResource.getContents().add(genModel);
            genModelResource.save(Collections.EMPTY_MAP);
	            
		} catch (IOException e) {
			String msg = null;
            if (e instanceof FileNotFoundException) {
                msg = "Unable to open output file " + genmodelFilePath;
            } else {
                msg = "Unexpected IO Exception writing " + genmodelFilePath;
            }
           throw new RuntimeException(msg, e);     
		}
		
//		generate(genModel);
		return genModel;
	}
	/**
	 * https://github.com/antoniogarmendia/emfsplitter/blob/5c5bc2d78addff87021d8eeccbb0bfc6b3bc0ad0/org.emfsplitter.project/bundles/org.mondo.emf.splitter.library/src/splitterLibrary/impl/GenModelEMFImpl.java
	 * From Line 383
	 * @param genModel
	 */
	private void generateSources(GenModel genModel) {
		genModel.setCanGenerate(true);//genModel.get
		Generator generator = new Generator(); // GenBase
//		genModel.getModelBundleName()
		generator.setInput(genModel);
		generator.generate(genModel,GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor.Printing(System.err));
		generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,  new BasicMonitor.Printing(System.err));
		generator.generate(genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, new BasicMonitor.Printing(System.err));
//		genModel.getEd
//		FileWriter fw = new FileWriter(fileName, true);
//	    BufferedWriter bw = new BufferedWriter(fw);
		 
	}
	
	/**
	 * Copied from Ecore2XtextJSONGrammarCreator.xtend
	 * TODO move in a class Utils.
	 * @param jsonGrammarFile
	 * @param reset
	 * @return
	 */
	private JsonGrammar loadJsonGrammar(IFile jsonGrammarFile, ResourceSet resourceSet) {
		Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(jsonGrammarFile.getFullPath().toString(), true), true);
		if (resource.getContents().get(0) instanceof JsonGrammar) {
			return (JsonGrammar) resource.getContents().get(0);
		} else {
			throw new IllegalArgumentException("Expecting JsonGrammar type of object");
		}
			
	}
	
	/**
	 * TODO update the Manifest of model, edit and editor with  
	 * Bundle-RequiredExecutionEnvironment: JavaSE-11
	 */
	private void updateManifest() {
		
	}
	
	private String toCamelCase (String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
