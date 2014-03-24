/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewMember.java
 * created:  Nov 3, 2010, 4:46:45 PM
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
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface MViewMember extends Element {

	/**
	 * Checks whether this member and other share the same context
	 * @param other the member to check
	 * @return
	 * @throws LookupException 
	 */
	public boolean sharesContext(MViewMember other) throws LookupException;
	
	/**
	 * Checks whether this member overrides the given member
	 * @param other the member to check with
	 * @return
	 * @throws ModelException
	 */
	public boolean overrides(MViewMember other) throws ModelException;

	/**
	 * Checks whether this member can be merged with the given member
	 * @return	other the member to check with
	 * @throws ModelException
	 */
	public boolean mergesWith(MViewMember other) throws ModelException;
	
	/**
	 * If {@link #mergesWith(MViewMember)} is true, returns merged result of 
	 * a merge with this and the other member. 
	 * Otherwise, if {@link #mergesWith(MViewMember)} is false, returns a clone
	 * of this.
	 * 
	 * Throws {@link MergeNotSupportedException} exception if this member
	 * does not support the merge operation.
	 * 
	 * @param other the member to merge with
	 * @return the merged member
	 * @throws MergeNotSupportedException when merge is not supported 
	 * @throws ModelException 
	 */
	public MViewMember merge(MViewMember other) throws MergeNotSupportedException, ModelException;
	
	/**
	 * Checks whether this member is the same type of member as other.
	 * @param other	the member to check against
	 * @return	true if both members are of the same type; false otherwise
	 * @throws ModelException
	 */
	public boolean sameMemberAs(MViewMember other) throws ModelException;
	
	/*
	 * Override vs. Merge
	 * 
	 * Member A overrides Member B when 
	 * (
	 * 	(1) they share the same declaration signature
	 * 	 OR
	 *  (1') they are marked to be overridden
	 * )
	 * (2) AND are of the same declaration type 
	 * (3) AND A is a member of a refinable declaration that refines 
	 * another refinable declaration of which B is a member.
	 * 
	 * 
	 * Member C merges with Member D when
	 * 
	 * (1) C and D are of type Element (not Declaration)
	 * (2) C and D are of the same Element type
	 * (3) Do not override each other
	 * 
	 */
}
