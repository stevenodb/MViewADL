/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBConnector.java
 * created:  Mar 15, 2011, 4:42:59 PM
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

import java.util.ArrayList;
import java.util.List;

import mview.model.module.Connector;
import mview.model.module.Interface;
import chameleon.core.reference.SimpleReference;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBConnector extends JBModule<JBConnector,Connector> {

	private List<SimpleReference<Interface>> _requiredInterfaces = 
		new ArrayList<SimpleReference<Interface>>();

	/**
	 * @param name
	 */
	public JBConnector(Connector sourceElement) {
		super(sourceElement);
	}

	/**
	 * @param required
	 */
	public void addRequiredInterfaces(List<SimpleReference<Interface>> required) {
		_requiredInterfaces.addAll(required);
	}

	/**
	 * @param pointcut
	 */
	public void addPointcut(JBPointcut pointcut) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param advice
	 */
	public void addAdvice(Object advice) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @return
	 */
	public String name() {
		return sourceElement().signature().name();
	}

}
