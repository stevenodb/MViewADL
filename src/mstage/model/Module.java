package mstage.model;
import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.reference.SimpleReference;


public abstract class Module<E extends Module<E>> extends MstageDeclaration<E, Element> {

	// provided interfaces
	private OrderedMultiAssociation<Module, SimpleReference<Interface>> _providedInterfaces = 
		new OrderedMultiAssociation<Module, SimpleReference<Interface>>(this); // FIXME:this ok?

	// required interfaces
	private OrderedMultiAssociation<Module, SimpleReference<Interface>> _requiredInterfaces = 
		new OrderedMultiAssociation<Module, SimpleReference<Interface>>(this); // FIXME:this ok?

	
	public void removeProvidedInterface(SimpleReference<Interface> relation) {
		_providedInterfaces.remove(relation.parentLink());
	}

	public List<SimpleReference<Interface>> providedInterfaces() {
		return _providedInterfaces.getOtherEnds();
	}
	
	public void addProvidedInterface(SimpleReference<Interface> relation) {
		_providedInterfaces.add(relation.parentLink());
	}

	
	public void removeRequiredInterface(SimpleReference<Interface> relation) {
		_requiredInterfaces.remove(relation.parentLink());
	}

	public List<SimpleReference<Interface>> requiredInterfaces() {
		return _requiredInterfaces.getOtherEnds();
	}
	
	public void addRequiredInterface(SimpleReference<Interface> relation) {
		_requiredInterfaces.add(relation.parentLink());
	}

	
	
}
