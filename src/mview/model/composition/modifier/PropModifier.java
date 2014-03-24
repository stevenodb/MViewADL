/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PropModifier.java
 * created:  Oct 19, 2010, 5:15:04 PM
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
	protected PropModifier cloneSelf() {
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
