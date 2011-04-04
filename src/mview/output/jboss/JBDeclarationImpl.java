/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBDeclarationImpl.java
 * created:  Mar 21, 2011, 2:29:30 PM
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
package mview.output.jboss;

import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.LookupException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class JBDeclarationImpl<D extends JBDeclarationImpl, E extends Declaration>
		implements JBDeclaration<D> {

	private final E	_sourceElement;

	protected JBDeclarationImpl(E sourceElement) {
		_sourceElement = sourceElement;
	}

	@Override
	public E sourceElement() {
		return _sourceElement;
	}

	public String getName() {
		return sourceElement().signature().name(); 
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object other) {
		try {
			return (other != null) 
				&& (other instanceof JBDeclaration) 
				&& (this.sourceElement().sameAs(((JBDeclaration)other).sourceElement()));
		} catch (LookupException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.sourceElement().hashCode();
	}
}
