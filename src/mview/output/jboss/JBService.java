/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBService.java
 * created:  Apr 1, 2011, 9:08:52 AM
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
package mview.output.jboss;

import chameleon.core.declaration.Declaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBService extends JBDeclarationImpl {

	/**
	 * @param sourceElement
	 */
	protected JBService(Declaration sourceElement) {
		super(sourceElement);
	}

	private String _returnType;
	private String _signature;
	private String _paramSignature;
	private String _paramType;


	@Override
	protected String toCode(JBDeclaration parent) {
		final StringBuffer sb = new StringBuffer();
		
		startNewLine(sb, "");
		appendTerm(sb, returnType());
		appendTerm(sb, signature());
		appendTermStrict(sb, "(");
		appendTerm(sb, paramType());
		appendTermStrict(sb, paramSignature());
		appendTermStrict(sb, ");");
		
		return sb.toString();
	}

	/**
	 * @return the returnType
	 */
	public String returnType() {
		return this._returnType;
	}

	/**
	 * @return the signature
	 */
	public String signature() {
		return this._signature;
	}

	/**
	 * @return the paramSignature
	 */
	public String paramSignature() {
		return this._paramSignature;
	}

	/**
	 * @return the paramType
	 */
	public String paramType() {
		return this._paramType;
	}
	/**
	 * @param signature
	 */
	public void addReturnType(String signature) {
		_returnType = signature;
	}

	/**
	 * @param string
	 */
	public void addSignature(String signature) {
		_signature = signature;
	}

	/**
	 * @param signature
	 * @param type
	 */
	public void addFormalParameter(String signature, String type) {
		_paramSignature = signature;
		_paramType = type;
	}

	
}
