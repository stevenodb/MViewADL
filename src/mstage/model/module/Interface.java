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
 *
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.module;

import java.util.List;

import mstage.model.namespace.MStageDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

public class Interface extends MStageDeclaration<Interface, Element> {
	
	/**
	 * Default constructor 
	 */
	protected Interface() {
	}

	/**
	 * @param signature
	 */
	public Interface(SimpleNameSignature signature) {
		super(signature);
	}

	/* 
	 * Association to Services 
	 */
	private OrderedMultiAssociation<Interface, Service> _services = 
		new OrderedMultiAssociation<Interface, Service>(this);
	
	public void removeService(Service service) {
		if (service != null) {
			_services.remove(service.parentLink());
		}
	}

	/**
	 * @return
	 */
	public List<Service> services() {
		return _services.getOtherEnds();
	}
	
	/**
	 * @param service
	 */
	public void addService(Service service) {
		if (service != null) {
			_services.add(service.parentLink());
		}
	}

	
	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#cloneThis()
	 */
	@Override
	protected Interface cloneThis() {
		return new Interface();
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#clone()
	 */
	@Override
	public Interface clone() {
		final Interface clone = super.clone();
			
		for (Service service : services()) {
			Service localClone = service.clone();
			
			clone.addService(localClone);
		}
		
		return clone;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (services() != null) ) {
			result = result.and(new BasicProblem(this, "Services is null"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mstage.model.namespace.MStageDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(services());
		
		return result;
		
	}

}
