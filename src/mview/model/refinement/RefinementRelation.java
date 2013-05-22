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

import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class RefinementRelation extends ElementImpl {

	/**
	 * default
	 */
	public RefinementRelation() {
		super();
	}


	/**
	 * @param parentRef
	 *           reference to parent declaration
	 */
	public RefinementRelation(SimpleReference<RefinableDeclaration> parentRef) {
		this();
		setParentDeclaration(parentRef);
	}

	/*
	 * Parent declaration
	 */
	private Single<SimpleReference<RefinableDeclaration>> _parentDeclaration = new Single<SimpleReference<RefinableDeclaration>>(this);


	/**
	 * @return the parent declaration
	 * @throws LookupException 
	 */
	public RefinableDeclaration parentDeclarationEnd() throws LookupException {
			return _parentDeclaration.getOtherEnd().getElement();
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
	public void setParentDeclaration(SimpleReference<RefinableDeclaration> relation) {
		set(_parentDeclaration,relation);
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
//		System.out.println(pe.signature().name());

		if (pe != null) {
			List<M> potential = pe.members(kind);

			for (M parentM : potential) {
				
				boolean stop = false;
				M newM = parentM;
				
				for (Iterator<M> itCur = current.iterator(); itCur.hasNext() && !stop;) {

					M childM = itCur.next();
					
//					System.out.print(childM + " -- " + parentM + ": ");

					if (childM.mergesWith(parentM)) {
						newM = (M) childM.merge(parentM);
						itCur.remove();
						stop = true;
//						System.out.println("Merged. "+newM);
					} else if (childM.overrides(parentM)) {
						stop = true;
						newM = null;
//						System.out.println("Override.");
  					} 

					/*THIS WAS A TEST FOR AVOIDING DOUBLES FROM LATER ON IN REFINEMT PATH
					else if (childM.sameMemberAs(parentM)) {
						stop = true;
						newM = null;
					} */
					
					else {
//						newM = parentM;
//						System.out.println("New.");
					}
				} // for-loop

				if (newM != null) {
					toAdd.add(newM);
				}
			}

			current.addAll(toAdd);
		}
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
	public Verification verifySelf() {
		Verification result = Valid.create();

		if (!(parentDeclaration() != null)) {
			result.and(new BasicProblem(this,
					"Doesn't have a parent declaration"));
		}

		return result;
	}

}
