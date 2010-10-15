/**
 * author:     Marko van Dooren
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
package mstage.model.namespace;

import java.util.ArrayList;
import java.util.List;

import org.rejuse.association.SingleAssociation;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.scope.Scope;
import chameleon.core.scope.UniversalScope;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>	Element
 * @param <P>	Parent Element
 */
public abstract class MStageDeclaration<E extends MStageDeclaration<E,P>, P extends Element> 
	extends NamespaceElementImpl<E,P> implements Declaration<E,P,SimpleNameSignature,E> {
	
	/**
	 * Default constructor
	 */
	protected MStageDeclaration() {
	}
	
	/**
	 * @param signature
	 */
	protected MStageDeclaration(SimpleNameSignature signature) {
		setSignature(signature);
	}


	public E actualDeclaration() throws LookupException {
		return (E) this;
	}

	public Scope scope() throws ModelException {
		return new UniversalScope();
	}

	public Declaration<?, ?, SimpleNameSignature, E> selectionDeclaration() throws LookupException {
		return this;
	}

	
	private final SingleAssociation<MStageDeclaration<E,P>, SimpleNameSignature> _signature = 
		new SingleAssociation<MStageDeclaration<E,P>, SimpleNameSignature>(this); 

	
	/* (non-Javadoc)
	 * @see chameleon.core.declaration.Declaration#signature()
	 */
	public SimpleNameSignature signature() {
		return _signature.getOtherEnd();
	}

	/**
	 * @param signature
	 */
	public void setSignature(Signature signature) {
		if(signature != null) {
			_signature.connectTo(signature.parentLink());
		} else {
			_signature.connectTo(null);
		}
	}

		
	/* (non-Javadoc)
	 * @see chameleon.core.declaration.Declaration#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		signature().setName(name);
	}

	
	/* (non-Javadoc)
	 * @see chameleon.core.declaration.Declaration#declarator()
	 */
	public Declaration declarator() {
		return this;
	}
	
	
	/**
	 * @return An incomplete clone with the correct sub-Type 
	 */
	protected abstract E cloneThis();
	
	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public E clone() {
		final E clone = cloneThis();
		
		clone.setSignature(signature().clone());
		
		return clone;
	}

	/* Override in Subtypes
	 * (non-Javadoc)
	 * @see chameleon.core.element.Element#children()
	 */
	public List<Element> children() {
		final List<Element> result = new ArrayList<Element>();
		
		Util.addNonNull(signature(), result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();
		
		if ( ! (signature() != null) ) {
			result = result.and(new BasicProblem(this, "No valid signature"));
		}
		return result;
	}

}
