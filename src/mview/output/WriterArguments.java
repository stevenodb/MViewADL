/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: WriterArguments.java
 * created:  Dec 20, 2010, 10:57:11 AM
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

import java.io.File;

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
