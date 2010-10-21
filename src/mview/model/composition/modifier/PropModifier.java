/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: PropModifier.java
 * created:  Oct 19, 2010, 5:15:04 PM
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
package mview.model.composition.modifier;

import java.util.Set;

import mview.model.composition.Actor;
import mview.model.language.MView;
import mview.model.namespace.MViewDeclaration;

import org.rejuse.property.Property;
import org.rejuse.property.PropertySet;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.modifier.ModifierImpl;
import chameleon.core.property.ChameleonProperty;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.VerificationResult;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 */
public class PropModifier extends ModifierImpl<PropModifier,Element> {
	
	private final Class<Declaration> _targetDeclarationClass;
	
	/**
	 * @param declarationClass
	 */
	protected PropModifier(Class<Declaration> declarationClass) {
		this._targetDeclarationClass = declarationClass;
	}
	
	/**
	 * @return
	 */
	public Class<Declaration> targetDeclarationClass() {
		return _targetDeclarationClass;
	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.modifier.Modifier#impliedProperties()
	 */
	@Override
	public PropertySet impliedProperties() {
		PropertySet<Element, ChameleonProperty> result = createSet();
	
		Set<ChameleonProperty> propSet = 
			((MView)language()).actorProperties(_targetDeclarationClass);
		result.addAll(propSet);

		return result;
	}

//	/* (non-Javadoc)
//	 * @see chameleon.core.modifier.ModifierImpl#verifySelf()
//	 */
//	@Override
//	public VerificationResult verifySelf() {
//		VerificationResult result = super.verifySelf();
//		
//		if ( ! (  ) )
//		
//		result.and(new BasicProblem(this, ""));
//	}
	
	/* (non-Javadoc)
	 * @see chameleon.core.modifier.ModifierImpl#clone()
	 */
	@Override
	public PropModifier clone() {
		PropModifier clone = new PropModifier(_targetDeclarationClass);
		return clone;
	}

}
