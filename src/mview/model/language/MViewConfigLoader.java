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

import java.util.jar.JarFile;

import be.kuleuven.cs.distrinet.chameleon.workspace.ConfigException;
import be.kuleuven.cs.distrinet.chameleon.workspace.ExtensionPredicate;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfiguration;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.jnome.core.language.Java;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaProjectConfigurator;
import be.kuleuven.cs.distrinet.rejuse.action.Nothing;
import be.kuleuven.cs.distrinet.rejuse.predicate.False;
import be.kuleuven.cs.distrinet.rejuse.predicate.Predicate;
import be.kuleuven.cs.distrinet.rejuse.predicate.SafePredicate;

public class MViewConfigLoader extends JavaProjectConfigurator implements ProjectConfigurator {

	public MViewConfigLoader(Java java, JarFile javaBaseJarPath) {
		super(javaBaseJarPath);
		_java = java;
	}
	
	private Java _java;

	@Override
	protected ProjectConfiguration createProjectConfig(View view) throws ConfigException {
		return new MViewProjectConfig(view);
	}
	
	@Override
	protected Java java() {
		return _java;
	}

	@Override
	public MViewConfigLoader clone() {
		return new MViewConfigLoader(_java, baseJarPath());
	}

	@Override
	public SafePredicate<? super String> sourceFileFilter() {
		return new ExtensionPredicate("mview");
	}

	@Override
	public Predicate<? super String,Nothing> binaryFileFilter() {
		return new False();
	}

}
