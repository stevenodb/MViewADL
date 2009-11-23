package mstage.model;

import java.util.List;

import org.rejuse.association.OrderedMultiAssociation;

import chameleon.core.reference.SimpleReference;
import chameleon.core.validation.VerificationResult;

public class Connector extends Module<Connector> {
	
	private OrderedMultiAssociation<Connector, SimpleReference<Composition>> _compositions = 
		new OrderedMultiAssociation<Connector, SimpleReference<Composition>>(this); 
	// FIXME:this ok?
 
	
	public void removeComposition(SimpleReference<Composition> relation) {
		_compositions.remove(relation.parentLink());
	}

	public List<SimpleReference<Composition>> compositions() {
		return _compositions.getOtherEnds();
	}
	
	public void addComposition(SimpleReference<Composition> relation) {
		_compositions.add(relation.parentLink());
	}

	@Override
	public Connector clone() {
		// TODO Auto-generated method stub
	}

	@Override
	public VerificationResult verifySelf() {
		// TODO Auto-generated method stub
	}

}
