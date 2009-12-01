/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
package mstage.model.module;

import java.util.List;

import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;

public class Interface extends MStageDeclaration<Interface, Element> {
	
	
	/* 
	 * Association to Services 
	 */
	private OrderedMultiAssociation<Interface, Service> _services = 
		new OrderedMultiAssociation<Interface, Service>(this);
	
	public void removeService(Service relation) {
		_services.remove(relation.parentLink());
	}

	public List<Service> services() {
		return _services.getOtherEnds();
	}
	
	public void addService(Service relation) {
		_services.add(relation.parentLink());
	}

	
	
	@Override
	public Interface clone() {
		// TODO Auto-generated method stub
	}

	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}
