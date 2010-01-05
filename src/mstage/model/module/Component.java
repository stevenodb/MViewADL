/**
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename:   Component.java
 * created:    Nov 20, 2009, 11:23:49 AM
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
 * You should have received a copy of the GNU General Public License
 * along with Digital Publishing Demonstrator.  
 * If not, see <http://www.gnu.org/licenses/>.
 */
package mstage.model.module;

import chameleon.core.declaration.SimpleNameSignature;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class Component<E extends Component<E>> extends Module<E> {

	/**
	 * default
	 */
	public Component() {
	}
	
	/**
	 * @param signature
	 */
	protected Component(SimpleNameSignature signature) {
		super(signature);
	}
	
	

	/* (non-Javadoc)
	 * @see mstage.model.module.Module#cloneThis()
	 */
	@Override
	protected E cloneThis() {
		return (E) new Component();
	}

//	/* (non-Javadoc)
//	 * @see mstage.model.module.Module#clone()
//	 */
//	@Override
//	public E clone() {
//		// TODO Auto-generated method stub
//	}

	
//	/* (non-Javadoc)
//	 * @see chameleon.core.element.ElementImpl#verifySelf()
//	 */
//	@Override
//	public VerificationResult verifySelf() {
//		VerificationResult result = super.verifySelf();
//					
//		return result;
//	}

//	/* (non-Javadoc)
//	 * @see mstage.model.namespace.MStageDeclaration#children()
//	 */
//	@Override
//	public List<Element> children() {
//		List<Element> result = super.children();
//		return result;
//	}
	
}
