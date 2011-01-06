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

import java.util.HashSet;
import java.util.Set;

import mview.model.language.MView;
import mview.model.property.ActorProperty;

import org.rejuse.property.PropertySet;


import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.modifier.ModifierImpl;
import chameleon.core.property.ChameleonProperty;
import chameleon.core.property.StaticChameleonProperty;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class PropModifier<D extends Declaration> 
					extends ModifierImpl<PropModifier,D> {
	
	private final Class<D> _targetDeclarationType;
	
	/**
	 * @param declarationType
	 */
	public PropModifier(Class<D> declarationType) {
		this._targetDeclarationType = declarationType;
	}
	
	/**
	 * @return the targetDeclarationClass
	 */
	public Class<D> targetDeclarationType() {
		return _targetDeclarationType;
	}

	/* (non-Javadoc)
	 * @see chameleon.core.modifier.Modifier#impliedProperties()
	 */
	@Override
	public PropertySet impliedProperties() {
		PropertySet<Element, ChameleonProperty> result = createSet();
	
//		Set<ChameleonProperty> propSet = 
//			(language(MView.class)).actorProperties(
//				targetDeclarationType());

		for (ActorProperty property : language(MView.class).ACTOR_PROPERTIES) {
			if (property.targetDeclarationType().equals(_targetDeclarationType)) {
				result.add(property);
			}
		}
		
		return result;
	}

//	/* (non-Javadoc)
//	 * @see chameleon.core.modifier.ModifierImpl#verifySelf()
//	 */
//	@Override
//	public VerificationResult verifySelf() {
//		VerificationResult result = super.verifySelf();
//		
//		if ( ! (  ) )
//		
//		result.and(new BasicProblem(this, ""));
//	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.modifier.ModifierImpl#clone()
	 */
	@Override
	public PropModifier<D> clone() {
		return new PropModifier<D>(targetDeclarationType());
	}

	/* (non-Javadoc)
	 * @see chameleon.core.element.ElementImpl#uniSameAs(chameleon.core.element.Element)
	 */
	@Override
	public boolean uniSameAs(Element other) throws LookupException {
		return (other instanceof PropModifier) 
			&& ((PropModifier) other).targetDeclarationType() 
				== this.targetDeclarationType();
	}
}
