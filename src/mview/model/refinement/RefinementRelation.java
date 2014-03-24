/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinementRelation.java
 * created:  Oct 29, 2010, 1:09:03 PM
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
	protected RefinementRelation cloneSelf() {
		return new RefinementRelation();
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
