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
package mview.output.jboss.declaration;

import java.util.ArrayList;
import java.util.List;

import org.rejuse.java.collections.RobustVisitor;

import chameleon.core.element.Element;
import chameleon.exception.ModelException;

import mview.model.application.Instance;
import mview.model.deployment.Deployment;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBDeployment extends JBDeclarationImpl<JBDeployment,Deployment> {


	private List<JBModule>	_modules = new ArrayList<JBModule>();

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
