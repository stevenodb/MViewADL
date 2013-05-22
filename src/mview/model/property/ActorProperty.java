/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ActorProperty.java
 * created:  Dec 6, 2010, 4:30:16 PM
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
package mview.model.property;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.property.ChameleonProperty;
import be.kuleuven.cs.distrinet.chameleon.core.property.StaticChameleonProperty;
import be.kuleuven.cs.distrinet.rejuse.property.PropertyMutex;
import be.kuleuven.cs.distrinet.rejuse.property.PropertyUniverse;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class ActorProperty extends StaticChameleonProperty {

	private Class<? extends Declaration> _targetDeclarationType;

	/**
	 * @param name
	 * @param universe
	 * @param mutex
	 * @param validElementType
	 */
	public ActorProperty(
			Class<? extends Declaration> targetDeclarationType,
			PropertyUniverse<ChameleonProperty> universe,
			PropertyMutex<ChameleonProperty> mutex,
			Class<? extends Element> validElementType) {
		
		super(targetDeclarationType.getName(), universe, mutex, validElementType);
		
		_targetDeclarationType = targetDeclarationType;
	}

//	/**
//	 * @return the targetDeclarationType
//	 */
//	private Class<? extends Declaration> targetDeclarationType() {
//		return _targetDeclarationType;
//	}
	
	/**
	 * @param declationType
	 * @return
	 */
	public boolean hasDeclarationType(Class<? extends Declaration> declationType) {
		return (declationType != null) 
				&& _targetDeclarationType.equals(declationType);
	}

}
