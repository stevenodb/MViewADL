/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBElementImpl.java
 * created:  May 23, 2011, 5:22:55 PM
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
package mview.output.jboss.element;

import mview.output.TransformableElement;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public abstract class JBElementImpl implements TransformableElement {
	
	private Element sourceElement;

	/**
	 * 
	 */
	public JBElementImpl(Element sourceElement) {
		this.sourceElement = sourceElement;		
	}

	@Override
	public Element sourceElement() {
		return sourceElement;
	}

}
