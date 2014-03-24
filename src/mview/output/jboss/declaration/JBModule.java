/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBModule.java
 * created:  Mar 21, 2011, 2:06:00 PM
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
package mview.output.jboss.declaration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import mview.model.module.Module;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class JBModule<D extends JBModule, E extends Module>
		extends JBDeclarationImpl<D,E> {

	private List<JBInterface> _requiredInterfaces = 
		new ArrayList<JBInterface>();
	
	private List<JBInterface> _providedInterfaces = 
		new ArrayList<JBInterface>();
	
	/**
	 * @param sourceElement
	 */
	protected JBModule(E sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement, parentDeclaration);
	}
	
	/**
	 * @param required
	 */
	public void addRequiredInterface(JBInterface required) {
		_requiredInterfaces.add(required);
	}

	/**
	 * @param provided
	 */
	public void addProvidedInterface(JBInterface provided) {
		_providedInterfaces.add(provided);
	}
	
	/**
	 * @return
	 */
	public List<JBInterface> requiredInterfaces() {
		return new ArrayList<JBInterface>(_requiredInterfaces);
	}
	
	/**
	 * @return
	 */
	public List<JBInterface> providedInterfaces() {
		return new ArrayList<JBInterface>(_providedInterfaces);
	}
	
	@Override
	protected String toCode(JBDeclaration parent) {
		final StringBuffer sb = startLine();
		
		List<JBInterface> reqList = requiredInterfaces();
		Iterator<JBInterface> reqIter = reqList.iterator();
		
		while (reqIter.hasNext()) {
			JBInterface reqItem = reqIter.next();
			String iName = reqItem.getName();
			
			String appendix = "";
			int n = Collections.frequency(reqList, reqItem);
			if (n > 1) {
				appendix = "" + n;
			}

			startNewLine(sb, "@EJB");
			startNewLine(sb, "private "+iName)
				.append(" ")
				.append(typeToInstanceName(iName) + appendix)
				.append(';');
			
			reqIter.remove();
			
			if (reqIter.hasNext()) {
				newLine(sb);
			}
		}

		return sb.toString();
	}
}
