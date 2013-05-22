/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PropModifier.java
 * created:  Oct 19, 2010, 5:15:04 PM
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
import mview.model.property.ActorProperty;
import be.kuleuven.cs.distrinet.rejuse.property.PropertySet;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ModifierImpl;
import be.kuleuven.cs.distrinet.chameleon.core.property.ChameleonProperty;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * @author Marko van Dooren
 */
public class PropModifier	extends ModifierImpl {
	
	private final Class<? extends Declaration> _targetDeclarationType;
	
	/**
	 * @param declarationType
	 */
	public PropModifier(Class<? extends Declaration> declarationType) {
		this._targetDeclarationType = declarationType;
	}
	
	/**
	 * @return the targetDeclarationClass
	 */
	public Class<? extends Declaration> targetDeclarationType() {
		return _targetDeclarationType;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.modifier.Modifier#impliedProperties()
	 */
	@Override
	public PropertySet impliedProperties() {
		PropertySet<Element, ChameleonProperty> result = createSet();
		for (ActorProperty property : language(MView.class).ACTOR_PROPERTIES) {
			if (property.hasDeclarationType(_targetDeclarationType)) {
				result.add(property);
			}
		}		
		return result;
	}

	@Override
	public PropModifier clone() {
		return new PropModifier(targetDeclarationType());
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#uniSameAs(chameleon.core.element.Element)
	 */
	@Override
	public boolean uniSameAs(Element other) throws LookupException {
		return (other instanceof PropModifier) 
			&& ((PropModifier) other).targetDeclarationType() == this.targetDeclarationType();
	}
}
