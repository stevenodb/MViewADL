/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBModule.java
 * created:  Mar 21, 2011, 2:06:00 PM
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
package mview.output.jboss.declaration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sun.codemodel.internal.JJavaName;

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
