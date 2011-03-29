/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBPointcut.java
 * created:  Mar 21, 2011, 2:32:24 PM
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

import mview.model.composition.AOComposition;
import mview.model.composition.Pointcut;
import mview.model.module.Service;
import mview.output.jboss.JBPointcutElement.PointcutKind;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBPointcutElement {
	
	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public enum PointcutKind {
		EXECUTION, CALL;
	}
	
	/**
	 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
	 *
	 */
	public enum ActorType {
		INTERFACE, COMPONENT, INSTANCE, APPLICATION, HOST;
	}

	private List<Service> _joinPoints;
	private PointcutKind _kind;

	/**
	 * @param sourceElement
	 */
	protected JBPointcutElement(Pointcut sourceElement) {
	}

	/**
	 * @param joinpoints
	 */
	public void addServices(List<Service> joinpoints) {
		_joinPoints = joinpoints;
	}

	/**
	 * @param pcKi
	 */
	public void addKind(PointcutKind pcKind) {
		_kind = pcKind;
	}

}
