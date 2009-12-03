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

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public abstract class Module<E extends Module<E>> extends MStageDeclaration<E, Element> {

	protected Module() {
	}

	/**
	 * @param signature
	 */
	protected Module(SimpleNameSignature signature) {
		setSignature(signature);
	}
	
//	/**
//	 * @param providedInterfaces
//	 * @param requiredInterfaces
//	 */
//	protected Module(
//			SimpleNameSignature signature,
//			List<SimpleReference<Interface>> providedInterfaces,
//			List<SimpleReference<Interface>> requiredInterfaces) {
//		
//		super();
//		
//		setSignature(signature);
//		
//		for (SimpleReference<Interface> simpleReference : requiredInterfaces) {
//			addRequiredInterface(simpleReference);
//		}
//		
//		for (SimpleReference<Interface> simpleReference : providedInterfaces) {
//			addProvidedInterface(simpleReference);
//		}
//
//	}

	// provided interfaces
	private OrderedMultiAssociation<Module<E>, SimpleReference<Interface>> _providedInterfaces = 
		new OrderedMultiAssociation<Module<E>, SimpleReference<Interface>>(this);

	// required interfaces
	private OrderedMultiAssociation<Module<E>, SimpleReference<Interface>> _requiredInterfaces = 
		new OrderedMultiAssociation<Module<E>, SimpleReference<Interface>>(this);

	
	
	/**
	 * @param relation
	 */
	public void removeProvidedInterface(SimpleReference<Interface> relation) {
		_providedInterfaces.remove(relation.parentLink());
	}

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
		_providedInterfaces.add(relation.parentLink());
	}

	
	/**
	 * @param relation
	 */
	public void removeRequiredInterface(SimpleReference<Interface> relation) {
		_requiredInterfaces.remove(relation.parentLink());
	}

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
		_requiredInterfaces.add(relation.parentLink());
	}


	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		
		Component clone = new Component(signature());		

		
		for (SimpleReference<Interface> simpleReference : this.providedInterfaces()) {
			clone.addProvidedInterface(simpleReference.clone());
		}
		for (SimpleReference<Interface> simpleReference : this.requiredInterfaces()) {
			clone.addRequiredInterface(simpleReference.clone());
		}
		
		return (Component) clone;
	}


	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
		if (signature() == null) {
			result = result.and(new BasicProblem(this, "No valid signature"));
		}
		
		return result;
	}


}
