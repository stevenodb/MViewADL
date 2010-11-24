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

import mview.model.refinement.RefinableMemberDeclarationImpl;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * Class representing the Module concept.
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>
 */
public abstract class Module<E extends Module<E>>
			extends RefinableMemberDeclarationImpl<E, Element> {
	
	/**
	 * Default constructor
	 */
	protected Module() {
	}

	/**
	 * @param signature
	 */
	protected Module(SimpleNameSignature signature) {
		super(signature);
	}
	

	/*
	 * Provided Interfaces association
	 */
	private final OrderedMultiAssociation<Module<E>, SimpleReference<Interface>> _providedInterfaces = 
		new OrderedMultiAssociation<Module<E>, SimpleReference<Interface>>(this);

	/**
	 * @return
	 */
	public List<SimpleReference<Interface>> providedInterfaces() {
		return _providedInterfaces.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addProvidedInterface(SimpleReference<Interface> relation) {
		if (relation != null)
			_providedInterfaces.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeProvidedInterface(SimpleReference<Interface> relation) {
		if (relation != null)
			_providedInterfaces.remove(relation.parentLink());
	}

	
	
	/*
	 * Required Interfaces association
	 */
	private final OrderedMultiAssociation<Module<E>, SimpleReference<Interface>> 
		_requiredInterfaces = 
		new OrderedMultiAssociation<Module<E>, SimpleReference<Interface>>(this);
	
	/**
	 * @return
	 */
	public List<SimpleReference<Interface>> requiredInterfaces() {
		return _requiredInterfaces.getOtherEnds();
	}
	
	/**
	 * @param relation
	 */
	public void addRequiredInterface(SimpleReference<Interface> relation) {
		if (relation != null)
			_requiredInterfaces.add(relation.parentLink());
	}
	
	/**
	 * @param relation
	 */
	public void removeRequiredInterface(SimpleReference<Interface> relation) {
		if (relation != null)
			_requiredInterfaces.remove(relation.parentLink());
	}

		
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		final E clone = super.clone();
		
		//moved to MViewDeclaration
		//clone.setSignature(signature().clone());		
		
		for (SimpleReference<Interface> simpleReference : this.providedInterfaces()) {
			SimpleReference<Interface> localClone = simpleReference.clone();
			
			clone.addProvidedInterface(localClone);
		}
		for (SimpleReference<Interface> simpleReference : this.requiredInterfaces()) {
			SimpleReference<Interface> localClone = simpleReference.clone();
			
			clone.addRequiredInterface(localClone);
		}
		
		return clone;
	}


	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = super.verifySelf();
		
		if ( ! (signature() != null) ) {
			result = result.and(new BasicProblem(this, "No valid signature"));
		}
		
		
		{ // check provided and required interface overlap
			boolean containsAny = false;
			
			try {
				
				for (SimpleReference<Interface> provided : this.providedInterfaces()) {
					for (SimpleReference<Interface> required : this.requiredInterfaces()) {
							if(provided.getElement().sameAs(required.getElement())) {
								containsAny = true;
							}
						if (containsAny) break;
					}
					if (containsAny) break;
				}
				
			} catch (LookupException e) {
				e.printStackTrace();
			}
	
			
			if (containsAny) {
				result = result.and(new BasicProblem(this, "Provided and required " +
						"interfaces should not overlap."));
			}
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.namespace.MViewDeclaration#children()
	 */
	@Override
	public List<Element> children() {
		final List<Element> result = super.children();
		
		result.addAll(providedInterfaces());
		result.addAll(requiredInterfaces());
		
		return result;
	}
}
