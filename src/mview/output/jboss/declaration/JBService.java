/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBService.java
 * created:  Apr 1, 2011, 9:08:52 AM
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

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class JBService extends JBDeclarationImpl {

	/**
	 * @param sourceElement
	 */
	public JBService(Declaration sourceElement, JBDeclaration parentDeclaration) {
		super(sourceElement, parentDeclaration);
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
