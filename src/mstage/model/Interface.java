package mstage.model;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.element.Element;
import chameleon.core.validation.VerificationResult;

public class Interface extends MStageDeclaration<Interface, Element> {
	
	
	private OrderedMultiAssociation<Interface, Service> _services = 
		new OrderedMultiAssociation<Interface, Service>(this);
	
	private OrderedMultiAssociation<Interface, Property> _properties = 
		new OrderedMultiAssociation<Interface, Property>(this);

	
	
	/* 
	 * _services accessors 
	 */
	
	public void removeService(Service relation) {
		_services.remove(relation.parentLink());
	}

	public List<Service> services() {
		return _services.getOtherEnds();
	}
	
	public void addService(Service relation) {
		_services.add(relation.parentLink());
	}

	
	
	/*
	 * _properties accessors
	 */
	
	public void removeService(Property relation) {
		_properties.remove(relation.parentLink());
	}

	public List<Property> properties() {
		return _properties.getOtherEnds();
	}
	
	public void addService(Property relation) {
		_properties.add(relation.parentLink());
	}
	
	
	
	
	@Override
	public Interface clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
		return null;
	}

}
