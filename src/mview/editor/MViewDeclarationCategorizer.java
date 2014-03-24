/**
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
package mview.editor;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.eclipse.presentation.treeview.DeclarationCategorizer;

public class MViewDeclarationCategorizer implements DeclarationCategorizer {

	public int category(Declaration declaration)  {
		Element element = declaration;
		int result = 1;
//		if(element instanceof Member){
//			if(element instanceof Method){
//				if(element instanceof RegularMethod) {
//					result = 3;
//				}
//				if(element instanceof Operator) {
//					result = 4;
//				}
//				else {
//					result = 10;
//				}
//			} else if(element instanceof Type) {
//				result = 5;
//			} else if(element instanceof MemberVariable) {
//				result = 1;
//			}	else {
//				result = 20;
//			}
//		} else {
//			result = 30;
//		}
		return result;
	}

}
