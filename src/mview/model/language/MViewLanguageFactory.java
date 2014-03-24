/**
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
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
