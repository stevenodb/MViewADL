/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBDeployment.java
 * created:  Mar 20, 2011, 12:28:31 PM
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

import java.util.ArrayList;
import java.util.List;

import mview.model.application.Application;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBApplication extends JBDeclarationImpl<JBApplication,Application> {


	private List<JBModule>	_modules = new ArrayList<JBModule>();
	private List<JBHost> _hosts = new ArrayList<JBHost>();

	/**
	 * @param sourceElement
	 */
	public JBApplication(Application sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement,parentDeclaration);
	}
	
	/**
	 * @param jbHost
	 */
	public void addHost(JBHost jbHost) {
		_hosts.add(jbHost);
	}
	
	/**
	 * @return
	 */
	public List<JBHost> hosts() {
		return _hosts;
	}
	
	/**
	 * @param name
	 * @return
	 */
	public JBHost hostWithName(String name) {
		JBHost result = null;
		
		for (JBHost host : hosts()) {
			
			if (name.equals(host.getName())) {
				result = host;
				break;
			}
		}
		
		return result;
	}
	

	/**
	 * @param jbModule
	 */
	public void addModule(JBModule jbModule) {
		_modules.add(jbModule);
	}
	
	public List<JBModule> modules() {
		return _modules;
	}

	@Override
	protected String toCode(JBDeclaration parent) {
		return "";
	}

//	@Override
//	public void transform(Element src, JBDeclaration parentTarget,
//			List<JBDeclaration> result) throws ModelException {
//		List<Instance> instances = src.members(Instance.class);
//
//		try {
//			new RobustVisitor<Instance>() {
//				public Object visit(Instance element) throws ModelException {
//
//					transform(element, parentTarget, result);
//					return null;
//				}
//
//				public void unvisit(Instance element, Object unvisitData) {
//				}
//			}.applyTo(instances);
//
//		} catch (ModelException e) {
//			throw e;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
