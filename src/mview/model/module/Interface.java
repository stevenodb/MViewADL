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
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

public class Interface extends MViewDeclaration<Interface, Element> 
	/*implements 
		TargetDeclaration<Interface, Element, Signature, Interface>,
		DeclarationContainer<Interface, Element>*/{
	
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

	
	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#cloneThis()
	 */
	@Override
	protected Interface cloneThis() {
		return new Interface();
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#clone()
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
	 * @see mview.model.namespace.MViewDeclaration#verifySelf()
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
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(services());
		
		return result;
		
	}

//	/* (non-Javadoc)
//	 * @see chameleon.core.declaration.DeclarationContainer#declarations()
//	 */
//	@Override
//	public List<? extends Declaration> declarations() throws LookupException {
//		return locallyDeclaredDeclarations();
//	}
//
//	/* (non-Javadoc)
//	 * @see chameleon.core.declaration.DeclarationContainer#locallyDeclaredDeclarations()
//	 */
//	@Override
//	public List<? extends Declaration> locallyDeclaredDeclarations()
//			throws LookupException {
//		
//		return services();
//	}
//
//	/* (non-Javadoc)
//	 * @see chameleon.core.declaration.DeclarationContainer#declarations(chameleon.core.lookup.DeclarationSelector)
//	 */
//	@Override
//	public <D extends Declaration> List<D> declarations(
//			DeclarationSelector<D> selector) throws LookupException {
//		return selector.selection(declarations());
//	}
//
//	/* (non-Javadoc)
//	 * @see chameleon.core.declaration.TargetDeclaration#targetContext()
//	 */
//	@Override
//	public LookupStrategy targetContext() {
//		return language().lookupFactory().createTargetLookupStrategy(this);
//	}
//
//	/* (non-Javadoc)
//	 * @see chameleon.core.element.ElementImpl#lexicalLookupStrategy(chameleon.core.element.Element)
//	 */
//	@Override
//	public LookupStrategy lexicalLookupStrategy(Element child)
//			throws LookupException {
//		return lexicalMembersLookupStrategy();
//	}
//	
//	private LookupStrategy lexicalMembersLookupStrategy() {
//		if(_lus == null) {
//			_lus = language().lookupFactory().createLexicalLookupStrategy(
//					targetContext(), this);
//		}
//		return _lus;
//	}
//	
//	private LookupStrategy _lus;

}
