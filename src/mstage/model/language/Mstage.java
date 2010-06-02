/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Mstage.java
 * created:  Jan 22, 2010, 1:56:34 PM
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
package mstage.model.language;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.language.Language;
import chameleon.core.namespace.RootNamespace;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Mstage extends Language {

	/**
	 * @param name
	 */
	public Mstage() {
		super("Mstage",new MstageLookupFactory());
		new RootNamespace(new SimpleNameSignature(""), this);
	}

	@Override
	protected void initializePropertyRules() {
	}

	@Override
	protected void initializeValidityRules() {
	}

	@Override
	public boolean isValidIdentifierCharacter(char character) {
		return Character.isJavaIdentifierPart(character);
	}

	/* (non-Javadoc)
	 * @see chameleon.core.language.Language#cloneThis()
	 */
	@Override
	protected Language cloneThis() {
		throw new RuntimeException("unimplemented");
	}

}
