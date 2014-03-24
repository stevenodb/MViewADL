/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBInterface.java
 * created:  Mar 15, 2011, 4:43:12 PM
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
import java.util.Iterator;
import java.util.List;

import mview.model.module.Interface;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBInterface extends JBDeclarationImpl<JBInterface, Interface> {

	List<JBService> _services = new ArrayList<JBService>();
	
	/**
	 * @param sourceElement
	 */
	public JBInterface(Interface sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement, parentDeclaration);
	}

	/**
	 * @return
	 */
	protected String getPreamble() {
		String preamble = 
			"import javax.ejb.Remote;"; 
		return preamble;
	}
	
	/**
	 * @return
	 */
	public List<JBService> services() {
		return _services;
	}
	
	/**
	 * @param jbSrv
	 */
	public void addService(JBService jbSrv) {
		_services.add(jbSrv);
	}

	@Override
	protected String toCode(JBDeclaration parent) {
		final StringBuffer sb = startLine();
		
		startNewLine(sb, getPreamble());
		newLine(sb);

		startNewLine(sb,"@Remote");
		startNewLine(sb,"public interface "+getName()+" {");
		
		indent();
		
		for(Iterator<JBService> it = services().iterator(); it.hasNext();) {
			JBService srv = it.next();
			identCode(sb, srv.toCode(parent)); 
		}
		
		undent();
		
		startNewLine(sb, "}");

		return sb.toString();
	}

	
}
