/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinementRelation.java
 * created:  Oct 29, 2010, 1:09:03 PM
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mview.exception.MergeNotSupportedException;

import org.rejuse.association.SingleAssociation;

import chameleon.core.element.ElementImpl;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class RefinementRelation
		extends ElementImpl<RefinementRelation, RefinableDeclaration> {//NameSpaceElementImpl

	/**
	 * default
	 */
	public RefinementRelation() {
		super();
	}

	/**
	 * @param parentRef
	 *            reference to parent declaration
	 */
	public RefinementRelation(SimpleReference<RefinableDeclaration> parentRef) {
		this();
		setParentDeclaration(parentRef);
	}

	/*
	 * Parent declaration
	 */
	private SingleAssociation<RefinementRelation, SimpleReference<RefinableDeclaration>> _parentDeclaration =
			new SingleAssociation<RefinementRelation,
			SimpleReference<RefinableDeclaration>>(this);

	/**
	 * @return the parent declaration
	 */
	public RefinableDeclaration parentDeclarationEnd() {
		try {
			return _parentDeclaration.getOtherEnd().getElement();
		} catch (LookupException e) {
			return null;
		}
	}

	/**
	 * @return a SimpleReference to the parent declaration
	 */
	public SimpleReference<RefinableDeclaration> parentDeclaration() {
		return _parentDeclaration.getOtherEnd();
	}

	/**
	 * @param relation
	 */
	public void setParentDeclaration(
			SimpleReference<RefinableDeclaration> relation) {
		_parentDeclaration.connectTo(relation.parentLink());
	}

	/**
	 * @param current
	 * @return
	 * @throws LookupException
	 */
	public <M extends MViewMember> void gatherParentMembers(Class<M> kind, 
			List<M> current) throws ModelException {
		
		List<M> toAdd = new ArrayList<M>();
		RefinableDeclaration pe = parentDeclarationEnd();
		
		if(pe != null) {
			List<M> potential = pe.members(kind);

			for (M parentM : potential) {
				M newM = parentM;
				boolean stop = false;
				
				for (Iterator<M> itCur = current.iterator(); itCur.hasNext() && !stop;) {

					M childM = itCur.next();

					if (childM.mergesWith(parentM)) {
						try {
							newM = (M) childM.merge(parentM);
							stop = true;
						} catch (MergeNotSupportedException e) {
							e.printStackTrace();
							throw new LookupException("Merge failed while it " +
									"should be allowed according to mergesWith()");
						}
					} 
					else 
						if (childM.sameAs(parentM)) {
							stop = true;
							newM = null;
						}
				}

				if (newM != null) {
					toAdd.add(parentM);
				}
			}

			current.addAll(toAdd);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	@Override
	public List<SimpleReference<RefinableDeclaration>> children() {
		
		List<SimpleReference<RefinableDeclaration>> result =
				new ArrayList<SimpleReference<RefinableDeclaration>>();

		Util.addNonNull(parentDeclaration(), result);
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public RefinementRelation clone() {
		RefinementRelation clone = new RefinementRelation();
		clone.setParentDeclaration(parentDeclaration().clone());
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

		if (!(parentDeclaration() != null)) {
			result.and(new BasicProblem(this,
					"Doesn't have a parent declaration"));
		}

		return result;
	}

}
