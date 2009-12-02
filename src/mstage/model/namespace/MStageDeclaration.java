/**
 * author:     Marko Van Dooren
 * author:     Steven Op de beeck <steven /at/ opdebeeck /./ org>
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
package mstage.model.namespace;

import java.util.ArrayList;
import java.util.List;

import org.rejuse.association.SingleAssociation;

import chameleon.core.MetamodelException;
import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.Signature;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.scope.Scope;
import chameleon.core.scope.UniversalScope;
import chameleon.util.Util;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 *
 * @param <E>	Element
 * @param <P>	Parent Element
 */
public abstract class MStageDeclaration<E extends MStageDeclaration<E,P>, P extends Element> 
	extends NamespaceElementImpl<E,P> implements Declaration<E,P,SimpleNameSignature,E> {

	public E actualDeclaration() throws LookupException {
		return (E) this;
	}

	public Scope scope() throws MetamodelException {
		return new UniversalScope();
	}

	public Declaration<?, ?, SimpleNameSignature, E> selectionDeclaration() throws LookupException {
		return this;
	}

	public SimpleNameSignature signature() {
		return _signature.getOtherEnd();
	}
	
	private SingleAssociation<MStageDeclaration<E,P>, SimpleNameSignature> _signature = new SingleAssociation<MStageDeclaration<E,P>, SimpleNameSignature>(this); 

	public List<Element> children() {
		List<Element> result = new ArrayList<Element>();
		Util.addNonNull(signature(), result);
		return result;
	}
	
	public void setSignature(SimpleNameSignature signature) {
		if(signature != null) {
			_signature.connectTo(signature.parentLink());
		} else {
			_signature.connectTo(null);
		}
	}


}
