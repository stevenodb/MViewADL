/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Abstract.java
 * created:  Jan 6, 2011, 11:56:32 AM
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
import be.kuleuven.cs.distrinet.chameleon.core.modifier.ModifierImpl;
import be.kuleuven.cs.distrinet.rejuse.property.PropertySet;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * The abstract modifier
 */
public class Abstract extends ModifierImpl {

	@Override
	public PropertySet impliedProperties() {
		return createSet(language(MView.class).ABSTRACT);
	}

	@Override
	protected Abstract cloneSelf() {
		return new Abstract();
	}

}
