package mstage.model;
import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.core.type.inheritance.InheritanceRelation;


public abstract class Module<E extends Module<E>> extends NamespaceElementImpl<E, Element> {

	// provided interface
	private OrderedMultiAssociation<Module, SimpleReference<Interface>> _providedInterfaces = 
		new OrderedMultiAssociation<Module, Service>(this);

	private OrderedMultiAssociation<Module, SimpleReference<Interface>> _requiredInterfaces = 
		new OrderedMultiAssociation<Module, Service>(this);

	
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
