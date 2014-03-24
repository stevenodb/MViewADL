/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Overridable.java
 * created:  Nov 10, 2010, 1:26:31 PM
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
package mview.model.refinement.modifier;

import mview.model.language.MView;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ModifierImpl;
import be.kuleuven.cs.distrinet.chameleon.core.property.ChameleonProperty;
import be.kuleuven.cs.distrinet.rejuse.property.PropertySet;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Extendable extends ModifierImpl {

	@Override
	public PropertySet<Element, ChameleonProperty> impliedProperties() {
		return createSet(language(MView.class).EXTENDABLE);
	}

	@Override
	protected Extendable cloneSelf() {
		return new Extendable();
	}

}
