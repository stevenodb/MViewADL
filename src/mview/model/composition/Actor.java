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

import java.util.List;

import mview.exception.MergeNotSupportedException;
import mview.model.refinement.MViewMember;
import mview.model.refinement.RefinementContext;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Valid;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.rejuse.property.Property;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class Actor extends ElementImpl implements MViewMember {

	/*
	 * Props
	 */
	private Multi<ActorProp> _props =	new Multi<ActorProp>(this);

	/**
	 * @param actorProp
	 */
	public void addProp(ActorProp actorProp) {
		add(_props,actorProp);
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
		remove(_props,actorProp);
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
	public <D extends Declaration> ActorProp prop(Property property) throws ModelException {
		ActorProp result = null;

		for (ActorProp actorProp : props()) {
			if (actorProp.actorProperty().equals(property)) {
				result = actorProp;
			}
		}
		return result;
	}

	@Override
	public boolean sharesContext(MViewMember other) throws LookupException {
		return (new RefinementContext().verify(this, other)); 
	}
	
	@Override
	public boolean overrides(MViewMember other) throws ModelException {
		return false;
	}

	@Override
	public boolean mergesWith(MViewMember other) throws ModelException {
		return sameMemberAs(other) && sharesContext(other) && !overrides(other);
	}
		
	@Override
	public Actor merge(MViewMember other) throws MergeNotSupportedException, ModelException {
		Actor merged;
		
		if (mergesWith(other)) {
			merged = new Actor();
			merged.setUniParent(parent());
	
			Actor child = clone(this);
			Actor parent = (Actor) other.clone();
			child.setUniParent(parent());
			parent.setUniParent(other.parent());
	
			List<ActorProp> childProps = child.props();
			
			// for all props
			for (ActorProp childProp : childProps) {
	
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
				} else {
					merged.addProp(childProp);
				}
			}
	
			// add remaining parent props that haven't been refined here
			merged.addAllProps(parent.props());
		} else {
			merged = this;
		}

		return merged;
	}

	@Override
	protected Actor cloneSelf() {
		return new Actor();
	}

	@Override
	public Verification verifySelf() {
		Verification result = Valid.create();

		if (!(props() != null)) {
			result.and(new BasicProblem(this, "Actor: actor props is null"));
		}

		return result;
	}

	@Override
	public boolean sameMemberAs(MViewMember other) {
		return (other != null) && (other instanceof Actor);
	}

}
