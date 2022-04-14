package at.jku.bise.ecore.json.grammar.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class CreateLanguageHandler extends AbstractHandler{

	private String extension;
	
	
	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
//		org.eclipse.ui.menus.MenuUtil.
//		ActiveContextInfoHandler
//		File file:
//				((TreeSelection)HandlerUtil.getCurrentSelectionChecked(event)).getPaths();
//		(org.eclipse.jface.viewers.TreeSelection) 
		TreeSelection treeSelection  = (TreeSelection)HandlerUtil.getCurrentSelectionChecked(event);
		IFile selectedFile = (IFile) treeSelection.getFirstElement();
		selectedFile.getFullPath().getFileExtension();
		return null;
	}

}
