/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewMember.java
 * created:  Nov 3, 2010, 4:46:45 PM
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

import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import exception.MergeNotSupportedException;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface MViewMember<M extends MViewMember<M,P>, P extends Element> extends Element<M, P> {

	/**
	 * Checks whether this member and other share the same context
	 * @param other the member to check
	 * @return
	 */
	public boolean sharesContext(MViewMember other);
	
	/**
	 * Check whether this member overrides the given member
	 * @param other the member to check with
	 * @return
	 * @throws LookupException 
	 */
	public boolean overrides(MViewMember other) throws LookupException;

	/**
	 * Check whether this member can be merged with the given member
	 * @return	other the member to check with
	 * @throws LookupException 
	 */
	public boolean mergesWith(MViewMember other) throws LookupException;
	
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
	 * @throws LookupException 
	 */
	public M merge(MViewMember other) throws MergeNotSupportedException, LookupException;
	
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
