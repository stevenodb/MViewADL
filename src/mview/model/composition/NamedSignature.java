/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: NamedJoinPoint.java
 * created:  Nov 27, 2009, 6:04:34 PM
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
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mview.model.composition;

import org.rejuse.association.SingleAssociation;

import chameleon.core.reference.SimpleReference;
import mview.model.module.Service;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class NamedSignature<E extends NamedSignature<E>> 
					extends SingleSignature<NamedSignature<E>,Service> {
	
	/**
	 * default
	 */
	public NamedSignature() {
		super();
	}

	/**
	 * @param joinPoint
	 */
	public NamedSignature(Service joinPoint) {
		super(joinPoint);
	}

	/* (non-Javadoc)
	 * @see mstage.model.composition.JoinPoint#cloneThis()
	 */
	@Override
	protected E cloneThis() {
		return (E) new NamedSignature();
	}
	
}
