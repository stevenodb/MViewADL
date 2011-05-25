/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBElementImpl.java
 * created:  May 23, 2011, 5:22:55 PM
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
package mview.output.jboss.element;

import chameleon.core.element.Element;
import mview.output.TransformableElement;
import mview.output.WriterArguments;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public abstract class JBElementImpl implements TransformableElement {
	
	private Element sourceElement;

	/**
	 * 
	 */
	public JBElementImpl(Element sourceElement) {
		this.sourceElement = sourceElement;		
	}

	@Override
	public Element sourceElement() {
		return sourceElement;
	}

}
