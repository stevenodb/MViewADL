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

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import exception.MergeNotSupportedException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class RefinableMemberDeclarationImpl<
			D extends RefinableMemberDeclarationImpl<D, P>, P extends Element>
		extends RefinableDeclarationImpl<D, P> implements MViewMember<D, P> {

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

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#sharesContext(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean sharesContext(D other) {
		return new RefinementContext(this, other).verify();
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean overrides(D other) {
		boolean result = false;
		
		try {
			result = this.sameAs(other) && this.sharesContext(other);
		} catch (LookupException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#mergesWith(mview.model.refinement.MViewMember)
	 */
	@Override
	public boolean mergesWith(D other) {
		return false;
	}

	/* (non-Javadoc)
	 * @see mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember)
	 */
	@Override
	public D merge(D other) throws MergeNotSupportedException {
		throw new MergeNotSupportedException(this + " doesn't support merge.");
	}

}
