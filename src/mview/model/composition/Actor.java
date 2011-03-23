/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: Actor.java
 * created:  Nov 9, 2010, 2:35:42 PM
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
package mview.model.composition;

import java.util.ArrayList;
import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;

import org.rejuse.association.OrderedMultiAssociation;
import org.rejuse.property.Property;

import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.Signature;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespace.NamespaceElementImpl;
import chameleon.core.validation.BasicProblem;
import chameleon.core.validation.Valid;
import chameleon.core.validation.VerificationResult;
import chameleon.exception.ModelException;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class Actor extends NamespaceElementImpl<Actor, Element> implements
		MViewMember<Actor, Element> {

	/*
	 * Props
	 */
	private OrderedMultiAssociation<Actor, ActorProp> _props =
			new OrderedMultiAssociation<Actor, ActorProp>(this);

	/**
	 * @param actorProp
	 */
	public void addProp(ActorProp actorProp) {
//		if (!props().contains(actorProp)) {
			_props.add(actorProp.parentLink());
//		} else {
//			throw new IllegalArgumentException("ActorProp for " + actorProp
//					+ " already exists.");
//		}
	}

	/**
	 * @param actorProps
	 */
	public void addAllProps(List<ActorProp> actorProps) {
		for (ActorProp actorProp : actorProps) {
			this.addProp(actorProp);
		}
	}

	/**
	 * Remove actorProp from props
	 * 
	 * @param actorProp
	 */
	public void removeProp(ActorProp actorProp) {
		_props.remove(actorProp.parentLink());
	}

	/**
	 * @return the list of props
	 */
	public List<ActorProp> props() {
		return _props.getOtherEnds();
	}

	/**
	 * @param <D>
	 * @param declarationType
	 * @return
	 * @throws LookupException 
	 */
	public <D extends Declaration> ActorProp<D> prop(Property property) throws ModelException {
		ActorProp<D> result = null;

		for (ActorProp<D> actorProp : props()) {
			if (actorProp.actorProperty().equals(property)) {
				result = actorProp;
			}
		}
		return result;
	}

	@Override
	public boolean sharesContext(MViewMember other) {
		return (new RefinementContext().verify(this, other)); 
	}
	
	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return false;
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return (other != null) && (this.getClass().equals(other.getClass())) && sharesContext(other) && !overrides(other);
	}
		
	@Override
	public Actor merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		Actor merged;
		
		if (mergesWith(other)) {
			merged = new Actor();
			merged.setUniParent(parent());
	
			Actor child = this.clone();
			Actor parent = (Actor) other.clone();
			child.setUniParent(parent());
			parent.setUniParent(other.parent());
	
			// for all props
			for (ActorProp childProp : child.props()) {
	
				// get the respective prop of the parent, if it has one
				// in which case, this one's a refinement (merge/overidde) of
				// the parent's
				ActorProp parentProp =
						parent.prop(childProp.actorProperty());
	
				if (parentProp != null) {
	
					ActorProp mergedProp = childProp.merge(parentProp);
					mergedProp.setUniParent(null);
					merged.addProp(mergedProp);
	
					// remove callerprop from the parent, we are done with it
					parent.removeProp(parentProp);
				}
			}
	
			// add remaining parent props that haven't been refined here
			merged.addAllProps(parent.props());
		} else {
			merged = this;
		}

		return merged;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.Element#children()
	 */
	@Override
	public List<Element> children() {
		List<Element> result = new ArrayList<Element>();

		result.addAll(props());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#clone()
	 */
	@Override
	public Actor clone() {
		final Actor clone = new Actor();

		for (ActorProp<?> actor : props()) {
			clone.addProp(actor.clone());
		}

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.core.element.ElementImpl#verifySelf()
	 */
	@Override
	public VerificationResult verifySelf() {
		VerificationResult result = Valid.create();

		if (!(props() != null)) {
			result.and(new BasicProblem(this, "Actor: actor props is null"));
		}

		return result;
	}

}
