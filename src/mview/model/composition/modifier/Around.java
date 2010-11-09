/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Before.java
 * created:  Oct 25, 2010, 10:30:09 AM
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
package mview.model.composition.modifier;

import mview.model.language.MView;

import org.rejuse.property.PropertySet;

import chameleon.core.element.Element;
import chameleon.core.modifier.Modifier;
import chameleon.core.modifier.ModifierImpl;
import chameleon.core.property.ChameleonProperty;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Around extends ModifierImpl<Around,Element> {

	/* (non-Javadoc)
	 * @see chameleon.core.modifier.Modifier#impliedProperties()
	 */
	@Override
	public PropertySet<Element,ChameleonProperty> impliedProperties() {
		return createSet(language(MView.class).AROUND);
	}

	/* (non-Javadoc)
	 * @see chameleon.core.modifier.ModifierImpl#clone()
	 */
	@Override
	public Around clone() {
		return new Around();
	}

}