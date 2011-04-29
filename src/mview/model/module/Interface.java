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

import mview.model.namespace.MViewDeclaration;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.DeclarationContainer;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.declaration.TargetDeclaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LocalLookupStrategy;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

public class Interface extends MViewDeclaration<Interface> implements
		TargetDeclaration<Interface, Signature, Interface>,
		DeclarationContainer<Interface> {

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
		return new Interface((SimpleNameSignature) this.signature());
	}


	@Override
	public Interface clone() {
		final Interface clone = (Interface) super.clone();

		for (Service service : services()) {
			clone.addService(service.clone());
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


	@Override
	public LocalLookupStrategy<?> targetContext() throws LookupException {
		return language().lookupFactory().createTargetLookupStrategy(this);
	}


	@Override
	public List<? extends Declaration> declarations() throws LookupException {
		return services();
	}


	@Override
	public List<? extends Declaration> locallyDeclaredDeclarations()
			throws LookupException {
		return declarations();
	}


	@Override
	public <D extends Declaration> List<D> declarations(DeclarationSelector<D> selector)
			throws LookupException {
		return selector.selection(declarations());
	}
}
