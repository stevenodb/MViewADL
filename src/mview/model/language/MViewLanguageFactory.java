package mview.model.language;

import mview.parser.MViewModelFactory;
import be.kuleuven.cs.distrinet.chameleon.core.factory.Factory;
import be.kuleuven.cs.distrinet.chameleon.input.ModelFactory;
import be.kuleuven.cs.distrinet.chameleon.oo.expression.ExpressionFactory;
import be.kuleuven.cs.distrinet.chameleon.oo.plugin.ObjectOrientedFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import be.kuleuven.cs.distrinet.jnome.core.language.Java;
import be.kuleuven.cs.distrinet.jnome.core.language.JavaLanguageFactory;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;

public class MViewLanguageFactory {
	
	public MView create() {
		Java java = new JavaLanguageFactory().create();
		MView result = new MView();
		ModelFactory factory = new MViewModelFactory(result);
//		factory.setLanguage(result, ModelFactory.class);
		
		// We need two objects because for now, every plugin 
		// can be registered with only a single key.
		result.setPlugin(Factory.class, new MViewFactory());
		result.setPlugin(ObjectOrientedFactory.class, new MViewFactory());
		result.setPlugin(ExpressionFactory.class, new JavaExpressionFactory());
		result.setPlugin(ProjectConfigurator.class, new MViewConfigLoader(java,JavaLanguageFactory.javaBaseJar()));
		return result;
	}
}
