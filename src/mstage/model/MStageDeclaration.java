package mstage.model;

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

public abstract class MStageDeclaration<E extends MStageDeclaration<E,P>, P extends Element> 
	extends NamespaceElementImpl<E,P> 
	implements Declaration<E,P,SimpleNameSignature,E> {

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
