/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBDeployment.java
 * created:  Mar 20, 2011, 12:28:31 PM
 * license:
 * The code contained in this file is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * The code contained in this file is distributed in the hope that it 
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License. 
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.output.jboss;

import java.util.List;

import mview.model.deployment.Deployment;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBDeployment extends JBDeclarationImpl<JBDeployment,Deployment> {


	private List<JBModule>	_modules;

	/**
	 * @param sourceElement
	 */
	protected JBDeployment(Deployment sourceElement) {
		super(sourceElement);
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

}
