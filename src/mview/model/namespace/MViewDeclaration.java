/**
 * author:     Marko van Dooren
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Administrative Contact: dnet-project-office@cs.kuleuven.be
 * Technical Contact: steven@opdebeeck.org
 */
package mview.model.namespace;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Signature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupContext;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.SelectionResult;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ElementWithModifiersImpl;
import be.kuleuven.cs.distrinet.chameleon.core.scope.Scope;
import be.kuleuven.cs.distrinet.chameleon.core.scope.UniversalScope;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

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
		if (signature != null) {
			setSignature(signature);
		}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();

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
	public LookupContext targetContext() throws LookupException {
		throw new LookupException("Error looking up target.");
	}
	
	@Override
	public Declaration finalDeclaration() {
		return this;
	}

	@Override
	public SelectionResult updatedTo(Declaration declaration) {
		return declaration;
	}
	
	@Override
	public Declaration template() {
		return finalDeclaration();
	}

}
