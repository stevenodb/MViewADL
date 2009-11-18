package mstage.model;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.ChameleonProgrammerException;
import chameleon.core.element.Element;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.type.Type;
import chameleon.core.type.inheritance.InheritanceRelation;

public class Interface extends NamespaceElementImpl<Interface, Element> {
	
	private OrderedMultiAssociation<Interface, Service> _services = new OrderedMultiAssociation<Interface, Service>(this);

	public void removeInheritanceRelation(InheritanceRelation relation) {
		_services.remove(relation.parentLink());
	}

	public List<Service> services() {
		return _services.getOtherEnds();
	}
	
	public void addService(Service relation) {
		_services.add(relation.parentLink());
	}



}
