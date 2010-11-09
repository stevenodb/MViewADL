/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewMemberDeclarationImpl.java
 * created:  Nov 5, 2010, 5:32:07 PM
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

import mview.model.namespace.MViewDeclaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import exception.MergeNotSupportedException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class MViewMemberDeclarationImpl<M extends MViewMemberDeclarationImpl<M, P>, P extends Element>
		extends MViewDeclaration<M, P> implements MViewMember<M, P> {

	/**
	 * default constructor
	 */
	protected MViewMemberDeclarationImpl() {
		super();
	}

	/**
	 * @param signature
	 */
	protected MViewMemberDeclarationImpl(SimpleNameSignature signature) {
		super(signature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mview.model.refinement.MViewMember#overrides(mview.model.refinement.
	 * MViewMember)
	 */
	@Override
	public boolean overrides(M other) {
		boolean equal = this.equals(other);
		boolean inARelationship =
				this.nearestAncestor(RefinableDeclaration.class).hasParent(
						other.nearestAncestor(RefinableDeclaration.class));
		return equal && inARelationship;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mview.model.refinement.MViewMember#merge(mview.model.refinement.MViewMember
	 * )
	 */
	@Override
	public M merge(M other) throws MergeNotSupportedException {
		throw new MergeNotSupportedException(this + " doesn't support merge.");
	}

}
