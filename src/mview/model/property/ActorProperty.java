/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: ActorProperty.java
 * created:  Dec 6, 2010, 4:30:16 PM
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
