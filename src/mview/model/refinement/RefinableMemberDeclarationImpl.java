/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinableMemberDeclarationImpl.java
 * created:  Nov 9, 2010, 3:39:56 PM
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
 * You should have received a copy of the GNU General Public License. 
 * If not, see <http://www.gnu.org/licenses/>.
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
