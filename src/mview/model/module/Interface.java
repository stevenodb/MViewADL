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
package mview.model.module;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;
import chameleon.oo.type.RegularType;

public class Interface extends RegularType {
	// MViewDeclaration<Interface, Element> {

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

	/**
	 * @param service
	 */
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

	@Override
	protected Interface cloneThis() {
		return new Interface(this.signature());
	}

	@Override
	public Interface clone() {
		final Interface clone = (Interface) super.clone();

		for (Service service : services()) {
			Service localClone = service.clone();

			clone.addService(localClone);
		}

		return clone;
	}

	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();

		if (!(services() != null)) {
			result = result.and(new BasicProblem(this, 
					this.signature().name() + ": Services is null."));
		}

		return result;
	}

	@Override
	public List<Element> children() {
		final List<Element> result = super.children();

		result.addAll(services());

		return result;

	}
}
