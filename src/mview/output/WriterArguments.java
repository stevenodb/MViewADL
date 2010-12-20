/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: WriterArguments.java
 * created:  Dec 20, 2010, 10:57:11 AM
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
package mview.output;

import java.util.ArrayList;
import java.util.List;

import chameleon.core.element.Element;

import mview.model.namespace.MViewDeclaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class WriterArguments {

	private final String _defaultNamespace, _outputDir;
	private final List<Element> _elementsAllowedOutput =
		new ArrayList<Element>();

	/**
	 * @param defaultNameSpace
	 * @param outputDir
	 * @param declAllowedOutput
	 */
	public WriterArguments(String defaultNameSpace, String outputDir,
			List<MViewDeclaration> elementsAllowedOutput) {
		_defaultNamespace = defaultNameSpace;
		_outputDir = outputDir;
		_elementsAllowedOutput.addAll(elementsAllowedOutput);
	}

	public String defaultNamespace() {
		return _defaultNamespace;
	}

	public String outputDir() {
		return _outputDir;
	}
	
	public boolean allowedOutput(Element declaration) {
		return _elementsAllowedOutput.contains(declaration);
	}
}
