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

import mview.exception.MergeNotSupportedException;
import mview.model.namespace.MViewDeclaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.exception.ModelException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class MViewMemberDeclarationImpl
		extends MViewDeclaration
		implements MViewMemberDeclaration {

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

	public boolean sharesContext(MViewMember other) {
		return (new RefinementContext()).verify(this, other);
	}

	public boolean overrides(MViewMember other) throws ModelException {
		return sameMemberAs(other) && sharesContext(other);
	}

	public boolean mergesWith(MViewMember other) throws ModelException {
		return false;
	}

	public MViewMember merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		throw new MergeNotSupportedException(this + " doesn't support merge.");
	}

	public boolean sameMemberAs(MViewMember other) {
		return (other != null)
			&& this.getClass() == other.getClass()
			&& this.signature().equals(((MViewMemberDeclarationImpl)other).signature());
	}

}
