package mview.model.language;

import mview.parser.MViewModelFactory;
import chameleon.eclipse.connector.EclipseEditorExtension;
import chameleon.input.ModelFactory;
import chameleon.workspace.ProjectConfigurator;

public class MViewLanguageFactory {
	
	public MView create() {
		MView result = new MView();
		ModelFactory factory = new MViewModelFactory(result);
		factory.setLanguage(result, ModelFactory.class);
		result.setPlugin(ProjectConfigurator.class, new MViewConfigLoader());
		return result;
	}
}
