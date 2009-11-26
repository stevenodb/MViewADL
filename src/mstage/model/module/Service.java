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
import org.rejuse.association.SingleAssociation;

import chameleon.core.element.Element;
import chameleon.core.method.MethodHeader;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;
import chameleon.support.member.simplename.SimpleNameMethodSignature;

@SuppressWarnings("unchecked")
public class Service extends MStageDeclaration<Service, Element> {
	

	
	// SingleAssociation<Service, MethodHeader<?, Service, SimpleNameMethodSignature>> _header =
	/*
	 * The service header.
	 */
	private SingleAssociation<Service, MethodHeader> _header =
		new SingleAssociation<Service, MethodHeader>(this);
	
	/**
	 * @return the service's header
	 */
	public MethodHeader header() {
		return _header.getOtherEnd();
	}
	
	/**
	 * @param header	the header to set
	 */
	public void setHeader(MethodHeader header) {
		if (header != null) {
			_header.connectTo(header.parentLink());
		}
	}


	
	/*
	 * The service's attached properties
	 */
	private OrderedMultiAssociation<Service, SimpleReference<Property>> _attachedProperties =
		new OrderedMultiAssociation<Service, SimpleReference<Property>>(this);
	
	/**
	 * @return	the attached properties
	 */
	public List<SimpleReference<Property>> _aggregatedServices() {
		return _attachedProperties.getOtherEnds();
	}
	
	/**
	 * @param relation	the property to attach
	 */
	public void addServices(SimpleReference<Property> relation) {
		_attachedProperties.add(relation.parentLink());
	}
	
	/**
	 * @param relation the service to remove from the aggregation
	 */
	public void removeServices(SimpleReference<Property> relation) {
		_attachedProperties.remove(relation.parentLink());
	}

	
	
	
	
	
	@Override
	public Service clone() {
		// TODO Auto-generated method stub
	}

	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}
