///**
// * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
// * filename: Composite.java
// * created:  Nov 20, 2009, 11:42:55 AM
// * license:
// * The code contained in this file is free software: you can redistribute 
// * it and/or modify it under the terms of the GNU General Public License
// * as published by the Free Software Foundation, either version 3 of the 
// * License, or (at your option) any later version.
// *
// * The code contained in this file is distributed in the hope that it 
// * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
// * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
// * See the GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License
// *
// * If not, see <http://www.gnu.org/licenses/>.
// */
//package mview.model.module;
//
//import java.util.List;
//
//import org.rejuse.association.OrderedMultiAssociation;
//
//import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
//import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
//import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
//import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
//import be.kuleuven.cs.distrinet.chameleon.core.validation.VerificationResult;
//
///**
// * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
// * @param <E>
// *
// */
//public class Composite<E extends Composite<E>> extends Component<E> implements ModuleContainer {
//	
//	
//	/**
//	 * Default constructor
//	 */
//	protected Composite() {
//		//what are you staring at?
//	}
//	
//	/**
//	 * @param submodules
//	 */
//	public Composite(SimpleNameSignature signature) {
//		super(signature);	
//	}
//
//	/*
//	 * Association to composite's modules 
//	 */
//	private OrderedMultiAssociation<Composite<E>, SimpleReference<Module<?>>> _modules =
//		new OrderedMultiAssociation<Composite<E>, SimpleReference<Module<?>>>(this);
//
//	
//	/* (non-Javadoc)
//	 * @see mview.model.module.ModuleContainer#modules()
//	 */
//	public List<Module> modules() {
//		return _modules.getOtherEnds();
//	}
//
//	/* (non-Javadoc)
//	 * @see mview.model.module.ModuleContainer#addModule(chameleon.core.reference.SimpleReference)
//	 */
//	public void addModule(Module relation) {
//		_modules.add(relation.parentLink());
//	}
//	
//	
//	/* (non-Javadoc)
//	 * @see mview.model.module.ModuleContainer#removeModule(chameleon.core.reference.SimpleReference)
//	 */
//	public void removeModule(Module relation) {
//		_modules.remove(relation.parentLink());
//	}
//	
//
//
//	/* (non-Javadoc)
//	 * @see mview.model.module.Component#cloneThis()
//	 */
//	@Override
//	protected E cloneThis() {
//		return (E) new Composite();
//	}
//
//	/* (non-Javadoc)
//	 * @see mview.model.module.Module#clone()
//	 */
//	@Override
//	public E clone() {
//		final E clone = super.clone();
//		
//		for (SimpleReference<Module<?>> simpleReference : this.modules()) {
//			SimpleReference<Module<?>> localClone = simpleReference.clone();
//
//			clone.addModule(localClone);
//		}
//		
//		return clone;
//	}
//
//	/* (non-Javadoc)
//	 * @see mview.model.Component#verifySelf()
//	 */
//	@Override
//	public VerificationResult verifySelf() {
//		VerificationResult result = super.verifySelf();
//		
//		if ( ! (modules().size() > 0) ) {
//			result = result.and(new BasicProblem(this, "No submodules in Composite"));
//		}
//		
//		return result;
//	}
//	
//	/* (non-Javadoc)
//	 * @see mview.model.namespace.MViewDeclaration#children()
//	 */
//	@Override
//	public List<Element> children() {
//		final List<Element> result = super.children();
//		
//		result.addAll(modules());
//
//		return result;
//	}
//
//}
