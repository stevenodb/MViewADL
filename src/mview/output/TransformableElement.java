/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: TransformableElement.java
 * created:  May 23, 2011, 5:17:29 PM
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
package mview.output;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public interface TransformableElement {
	
//	public void transform(Element src, JBDeclaration parentTarget,
//			final List<JBDeclaration> result) throws ModelException;
	public Element sourceElement();
	public void writeCode(WriterArguments arg);
}
