/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Advice.java
 * created:  Nov 24, 2009, 6:27:38 PM
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
package mstage.model;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Advice extends MStageDeclaration<Advice, Element> {

	private SingleAssociation<Advice, SimpleReference<Service>> _service =
		new SingleAssociation<Advice, SimpleReference<Service>>(this);
	
	
	/**
	 * @return	the reference to the service
	 */
	public SimpleReference<Service> _service() {
		return _service.getOtherEnd();
	}
	
	/**
	 * @param reference	the reference to set
	 */
	public void setService(SimpleReference<Service> relation) {
		_service.connectTo(relation.parentLink());
	}

	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}
