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
import exception.MergeNotSupportedException;


/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface MViewMember<M extends MViewMember<M,P>, P extends Element> extends Element<M, P> {
	
	/**
	 * Check whether this member overrides the given member
	 * @param other the member to check
	 * @return
	 */
	public boolean overrides(M other);
	
	/**
	 * Merge this member with given member. This method does not check
	 * if merging is allowed according to the specific context.
	 * @param other the member to merge with
	 * @return A merged member
	 * @throws MergeNotSupportedException 
	 */
	public M merge(M other) throws MergeNotSupportedException;

}
