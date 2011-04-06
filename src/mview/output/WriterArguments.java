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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mview.model.namespace.MViewDeclaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class WriterArguments {

	private final String _defaultNamespace;
	private final File _outputDir;

//	private List<MViewDeclaration> _declarations;
//	private boolean _canOutput;

	/**
	 * @param defaultNameSpace
	 * @param outputDir
	 * @param declAllowedOutput
	 */
	public WriterArguments(String defaultNameSpace, File outputDir) {
		_defaultNamespace = defaultNameSpace;
		_outputDir = outputDir;
//		_canOutput = false;
	}

	public String defaultNamespace() {
		return _defaultNamespace;
	}

	public File outputDir() {
		return _outputDir;
	}

//	/**
//	 * @param declaration the declaration to set
//	 */
//	public void addDeclaration(MViewDeclaration declaration) {
//		this._declarations.add(declaration);
//	}
//
//	/**
//	 * @return the declarations
//	 */
//	public List<MViewDeclaration> declarations() {
//		return _declarations;
//	}
//
//	/**
//	 * @param decls
//	 */
//	protected void setDeclarations(List<MViewDeclaration> decls) {
//		_declarations = decls;
//	}
//	
//	/**
//	 * @param canOutput the canOutput to set
//	 */
//	public void setCanOutput(boolean canOutput) {
//		this._canOutput = canOutput;
//	}
//
//	/**
//	 * @return the canOutput
//	 */
//	public boolean canOutput() {
//		return _canOutput;
//	}

	/**
	 *
	 */
	public WriterArguments clone() {
		WriterArguments clone = 
			new WriterArguments(this.defaultNamespace(), this.outputDir());
		
//		clone.setCanOutput(this.canOutput());
//		clone.setDeclarations(new ArrayList<MViewDeclaration>(this.declarations()));
		
		return clone;
	}
}
