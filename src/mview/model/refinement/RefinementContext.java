/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: RefinementContext.java
 * created:  Nov 11, 2010, 12:38:50 PM
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

import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class RefinementContext {
	
	/**
	 * @param <M>
	 * @param child
	 * @param parent
	 * @return
	 * @throws LookupException 
	 */
	public boolean verify(MViewMember child, MViewMember parent) throws LookupException {
		RefinableDeclaration childD, parentD;
		
		childD = (RefinableDeclaration) child.nearestAncestor(RefinableDeclaration.class);
		parentD = (RefinableDeclaration) parent.nearestAncestor(RefinableDeclaration.class);

		return (childD == parentD) || (childD.isRefinementOf(parentD)); 
		// TODO: ASK MARKO: multiple refinement paths?
	}
	
}
