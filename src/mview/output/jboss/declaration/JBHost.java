/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBHost.java
 * created:  Jun 9, 2011, 4:32:20 PM
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
package mview.output.jboss.declaration;

import mview.model.application.Host;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBHost extends JBDeclarationImpl<JBHost, Host> {

	/**
	 * @param sourceElement
	 */
	public JBHost(Host sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement, parentDeclaration);
	}
	
	/**
	 * @return
	 */
	public String getHostName() {
		String result = null;
		
		if (sourceElement().hostName() != null) {
			result = sourceElement().hostName().signature().toString();
		}		
		
		return result;
	}

	@Override
	protected String toCode(JBDeclaration parent) {
		return getHostName();
	}

}
