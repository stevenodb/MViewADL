package mview.model.language;

import be.kuleuven.cs.distrinet.chameleon.input.ModelFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import mview.parser.MViewModelFactory;
import be.kuleuven.cs.distrinet.chameleon.core.factory.Factory;
import be.kuleuven.cs.distrinet.chameleon.oo.plugin.ObjectOrientedFactory;

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
