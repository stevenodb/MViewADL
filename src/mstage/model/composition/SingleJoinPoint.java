/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: SingleJoinPoint.java
 * created:  Dec 1, 2009, 1:38:25 PM
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
 * You should have received a copy of the GNU General Public License
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.composition;

import mstage.model.module.JoinPointElement;
import mstage.model.module.Service;

import org.rejuse.association.SingleAssociation;

import chameleon.core.reference.SimpleReference;

/**
 * @author  Steven Op de beeck <steven /at/ opdebeeck /./ org>
 */
public abstract class SingleJoinPoint<E extends SingleJoinPoint<E,JP>,JP extends JoinPointElement> 
					extends JoinPoint<SingleJoinPoint<E,JP>> {

	/*
	 * Accessors for joinPoint  
	 */
	private SingleAssociation<NamedJoinPoint, SimpleReference<JP>> _joinPoint;

	/**
	 * @return the joinPoint
	 */
	public SimpleReference<JP> getJoinPoint() {
		return _joinPoint.getOtherEnd();
	}

	/**
	 * @param joinPoint the joinPoint to set
	 */
	public void setJoinPoint(
			SimpleReference<JP> relation) {_joinPoint.connectTo(relation.parentLink());
	}
}