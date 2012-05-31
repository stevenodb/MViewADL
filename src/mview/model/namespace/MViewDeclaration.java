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
package mview.model.namespace;

import java.util.ArrayList;
import java.util.List;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.Signature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.modifier.ElementWithModifiersImpl;
import chameleon.core.scope.Scope;
import chameleon.core.scope.UniversalScope;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;
import chameleon.util.association.Single;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 * @param <E>
 *            Element
 * @param <P>
 *            Parent Element
 */
public abstract class MViewDeclaration extends ElementWithModifiersImpl implements Declaration {

	/**
	 * Default constructor
	 */
	protected MViewDeclaration() {
	}

	/**
	 * @param signature
	 */
	protected MViewDeclaration(Signature signature) {
		setSignature(signature);
	}

	public MViewDeclaration actualDeclaration() throws LookupException {
		return this;
	}

	public Scope scope() throws ModelException {
		return new UniversalScope();
	}

	public Declaration selectionDeclaration() throws LookupException {
		return this;
	}

	/*
	 * SIGNATURE
	 */

	private final Single<Signature> _signature = new Single<Signature>(this);

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.declaration.Declaration#signature()
	 */
	public Signature signature() {
		return _signature.getOtherEnd();
	}
	
	@Override
	public String name() {
		return signature().name();
	}

	/**
	 * @param signature
	 */
	public void setSignature(Signature signature) {
		set(_signature, signature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.declaration.Declaration#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		signature().setName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.declaration.Declaration#declarator()
	 */
	public Declaration declarator() {
		return this;
	}

	/**
	 * @return An incomplete clone with the correct sub-Type
	 */
	protected abstract MViewDeclaration cloneThis();

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public MViewDeclaration clone() {
		final MViewDeclaration clone = cloneThis();
		clone.setSignature(signature().clone());
		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();

		if (!(signature() != null)) {
			result = result.and(new BasicProblem(this, "No valid signature"));
		}
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" + signature().toString();
	}
	
	// extra verification step (eg. abstract)
	@Override
	public boolean complete() throws LookupException {
		return true;
	}

	@Override
	public LookupStrategy targetContext() throws LookupException {
		throw new LookupException("Error looking up target.");
	}
	
}
