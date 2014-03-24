///**
// * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
// * filename: Composite.java
// * created:  Nov 20, 2009, 11:42:55 AM
// *
// * Copyright 2013 KU Leuven Research and Development - iMinds - DistriNet
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *
// * See the License for the specific language governing permissions and
// * limitations under the License.
// *
// * Administrative Contact: dnet-project-office@cs.kuleuven.be
// * Technical Contact: steven@opdebeeck.org
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
