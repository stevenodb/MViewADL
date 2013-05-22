package mview.editor;

import mview.model.language.MViewLanguageFactory;
import be.kuleuven.cs.distrinet.chameleon.core.language.Language;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseBootstrapper;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseEditorExtension;

public class MViewEclipseBootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID = "mview.eclipse";
	
	public Language createLanguage() {
		Language result = new MViewLanguageFactory().create();
		result.setPlugin(EclipseEditorExtension.class, new MViewEditorExtension());
		return result;
	}
	
}
