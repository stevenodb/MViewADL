/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: HostName.java
 * created:  Oct 25, 2010, 1:23:53 PM
 *
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
package mview.model.deployment;

import mview.model.namespace.MViewDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class HostName extends MViewDeclaration {
	
	/**
	 * default 
	 */
	public HostName() {
		super();
	}

	/**
	 * @param signature
	 */
	public HostName(SimpleNameSignature signature) {
		super(signature);
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected HostName cloneSelf() {
		return new HostName();
	}

}
