/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableMemberDeclarationImpl.java
 * created:  Nov 9, 2010, 3:39:56 PM
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
package mview.model.refinement;

import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import mview.exception.MergeNotSupportedException;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableMemberDeclarationImpl
		extends RefinableDeclarationImpl implements MViewMemberDeclaration {

	/**
	 * default
	 */
	protected RefinableMemberDeclarationImpl() {
		super();
	}
	
	/**
	 * @param signature
	 */
	protected RefinableMemberDeclarationImpl(SimpleNameSignature signature) {
		super(signature);
	}

	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext()).verify(this, other);
	}

	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		boolean result = false;
		
		result = sameMemberAs(other)
			&& this.sharesContext(other);
		
		return result;
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return false;
	}

	@Override
	public RefinableMemberDeclarationImpl merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		throw new MergeNotSupportedException(this + " doesn't support merge.");
	}

	@Override
	public boolean sameMemberAs(MViewMember other) {
		return (other != null)
			&& other instanceof RefinableMemberDeclarationImpl
			&& this.signature().equals(((RefinableMemberDeclarationImpl)other).signature());
	}

}
