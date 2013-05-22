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
