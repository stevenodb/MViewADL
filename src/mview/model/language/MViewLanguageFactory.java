package mview.model.language;

import mview.parser.MViewModelFactory;
import chameleon.core.factory.Factory;
import chameleon.input.ModelFactory;
import chameleon.oo.plugin.ObjectOrientedFactory;
import chameleon.workspace.ProjectConfigurator;

public class MViewLanguageFactory {
	
	public MView create() {
		MView result = new MView();
		ModelFactory factory = new MViewModelFactory(result);
//		factory.setLanguage(result, ModelFactory.class);
		
		// We need two objects because for now, every plugin 
		// can be registered with only a single key.
		result.setPlugin(Factory.class, new MViewFactory());
		result.setPlugin(ObjectOrientedFactory.class, new MViewFactory());
		result.setPlugin(ProjectConfigurator.class, new MViewConfigLoader());
		return result;
	}
}
