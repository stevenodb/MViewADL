package mview.editor;

import mview.model.language.MViewLanguageFactory;
import chameleon.core.language.Language;
import chameleon.eclipse.connector.EclipseBootstrapper;
import chameleon.eclipse.connector.EclipseEditorExtension;

public class MViewEclipseBootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID = "mview.eclipse";
	
	public MViewEclipseBootstrapper() {
		super("MView","1.0",PLUGIN_ID);
	}
	
	public Language createLanguage() {
		Language result = new MViewLanguageFactory().create();
		result.setPlugin(EclipseEditorExtension.class, new MViewEditorExtension("MView"));
		return result;
	}
	
}