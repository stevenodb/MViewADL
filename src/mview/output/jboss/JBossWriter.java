/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: JBossWriter.java
 * created:  Mar 17, 2011, 4:23:23 PM
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
package mview.output.jboss;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mview.model.application.Application;
import mview.model.application.Host;
import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.composition.Actor;
import mview.model.composition.ActorProp;
import mview.model.composition.Advice;
import mview.model.composition.PatternSignature;
import mview.model.composition.Pointcut;
import mview.model.composition.PointcutSignature;
import mview.model.composition.PropValue;
import mview.model.composition.ServiceSignature;
import mview.model.deployment.Deployment;
import mview.model.language.MView;
import mview.model.module.Component;
import mview.model.module.Connector;
import mview.model.module.Dependency;
import mview.model.module.Interface;
import mview.model.module.Module.ProvidedInterfaceDependency;
import mview.model.module.Module.RequiredInterfaceDependency;
import mview.model.module.Service;
import mview.model.property.ActorProperty;
import mview.output.WriterArguments;
import mview.output.jboss.declaration.JBAOComposition;
import mview.output.jboss.declaration.JBApplication;
import mview.output.jboss.declaration.JBComponent;
import mview.output.jboss.declaration.JBConnector;
import mview.output.jboss.declaration.JBDeclaration;
import mview.output.jboss.declaration.JBHost;
import mview.output.jboss.declaration.JBInterface;
import mview.output.jboss.declaration.JBModule;
import mview.output.jboss.declaration.JBService;
import mview.output.jboss.element.JBActorPropValue;
import mview.output.jboss.element.JBAdviceElement;
import mview.output.jboss.element.JBPointcutElement;
import mview.output.jboss.element.JBPointcutElement.ActorType;
import mview.output.jboss.element.JBPointcutElement.PointcutKind;

import org.rejuse.java.collections.RobustVisitor;
import org.rejuse.property.Property;

import chameleon.core.document.Document;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.namespacedeclaration.NamespaceDeclaration;
import chameleon.core.reference.SimpleReference;
import chameleon.exception.ModelException;
import chameleon.oo.type.BasicTypeReference;
import chameleon.oo.variable.FormalParameter;
import chameleon.util.Pair;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public class JBossWriter {

	/**
	 * @param wArguments
	 */
	private JBossWriter(WriterArguments wArguments) {
		_wArguments = wArguments;
	}

//	/*
//	 * List of transformed declarations
//	 */
//	private final List<JBDeclaration> _transformedDecls = new ArrayList<JBDeclaration>();
//
//
//	/**
//	 * @param decl
//	 */
//	protected void addTransformedDecl(JBDeclaration decl) {
//		_transformedDecls.add(decl);
//	}

	/*
	 * WriterArguments
	 */
	private final WriterArguments _wArguments;


	/**
	 * @return the wArguments
	 */
	public WriterArguments writerArguments() {
		return _wArguments.clone();
	}

	/*
	 * Preamble
	 */
	Map<Class<? extends Element>, StringBuffer> _preambles =
			new HashMap<Class<? extends Element>, StringBuffer>();


//	/**
//	 * @param key
//	 * @return
//	 */
//	protected StringBuffer preamble(Class<? extends Element> key) {
//		return _preambles.get(key);
//	}
//
//
//	/**
//	 * @param key
//	 * @param preamble
//	 */
//	protected void addPreamble(Class<? extends Element> key,
//			StringBuffer preamble) {
//		_preambles.put(key, preamble);
//	}
//
//
//	/**
//	 * @param key
//	 */
//	protected void removePreamble(Class<? extends Element> key) {
//		_preambles.remove(key);
//	}
//
//
//	protected void initPreambles() {
//		String connector = 
//			"import java.net.InetAddress;" +
//			"import java.net.UnknownHostException;" +
//			"import java.util.Arrays;" +
//			"import java.util.List;" +
//			"import javax.ejb.EJB;" +
//			"import org.jboss.aop.AdviceType;" +
//			"import org.jboss.aop.Aspect;" +
//			"import org.jboss.aop.Bind;" +
//			"import org.jboss.aop.DynamicCFlowDef;" +
//			"import org.jboss.aop.PointcutDef;" +
//			"import org.jboss.aop.advice.annotation.Args;" +
//			"import org.jboss.aop.joinpoint.Invocation;" +
//			"import org.jboss.aop.pointcut.DynamicCFlow;" +
//			"import org.jboss.aop.pointcut.Pointcut;"; 
//			
//		StringBuffer connPA = new StringBuffer(connector);
//		addPreamble(Connector.class, connPA);
//	}


	/**
	 * @param declarations
	 * @param defaultNamespace
	 * @param outputDir
	 * @throws IOException
	 * @throws ModelException
	 */
	public static void writeElement(Element decl,
			String defaultNamespace, File outputDir)
				throws IOException, ModelException {

		WriterArguments wArgs = new WriterArguments(defaultNamespace,
				outputDir);

		JBossWriter writer = new JBossWriter(wArgs);
		writer.writeCode(decl);
	}


	/**
	 * @param element
	 * @throws IOException
	 * @throws ModelException
	 */
	public void writeCode(Element element) throws IOException, ModelException {

		List<JBDeclaration> declarations = new ArrayList<JBDeclaration>();

		transform(element, null, declarations);
		
		Set<JBDeclaration> uniqDeclarations = new HashSet<JBDeclaration>(declarations);

		for (JBDeclaration jbDeclaration : uniqDeclarations) {
//			System.out.println("Writing " + jbDeclaration);
			jbDeclaration.writeCode(writerArguments());
		}

		System.out.println("done, "+uniqDeclarations.size()+" objects written.");
	}


	// /**
	// * @param element
	// * @param writerArguments
	// */
	// private void writeCode(Element element, WriterArguments writerArguments)
	// {
	// // TODO Auto-generated method stub
	// }

	public void transform(Element src, JBDeclaration parentTarget,
			final List<JBDeclaration> result)
			throws ModelException {

		if (isCompilationUnit(src)) {
			transformCompilationUnit((Document) src, parentTarget, result);

		} else if (isNamespacePart(src)) {
			transformNamespacePart((NamespaceDeclaration) src, parentTarget, result);

		} else if (isInstance(src)) {
			transformInstance((Instance) src, parentTarget, result);

		} else if (isComponent(src)) {
			transformComponent((Component) src, parentTarget, result);

		} else if (isConnector(src)) {
			transformConnector((Connector) src, parentTarget, result);

		} else if (isAOComposition(src)) {
			transformAOComposition((AOComposition) src, parentTarget, result);

		} else if (isPointcut(src)) {
			transformPointcut((Pointcut) src, parentTarget, result);

		} else if (isAdvice(src)) {
			tranformAdvice((Advice) src, parentTarget, result);

		} else if (isApplication(src)) {
			transformApplication((Application) src, parentTarget, result);
			// } else if (isDeployment(src)) {
			// transformDeployment((Deployment) src, parentTarget, result);

		} else if (isInterface(src)) {
			transformInterface((Interface) src, parentTarget, result);
			
		} else if (isHost(src)) {
			transformHost((Host) src, parentTarget, result);
		}

		else if (src == null) {

		} else {
			throw new IllegalArgumentException(
					"The given element is not know by MView syntax: "
							+ src.getClass().getName());
		}
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isHost(Element src) {
		return src instanceof Host;
	}


	/**
	 * @param src
	 * @param parentTarget
	 * @param result
	 */
	private void transformHost(Host src, JBDeclaration parentTarget,
			List<JBDeclaration> result) {

		if (parentTarget != null && parentTarget instanceof JBApplication) {
			JBHost host = new JBHost(src,parentTarget);
			((JBApplication) parentTarget).addHost(host);
		}
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isApplication(Element src) {
		return src instanceof Application;
	}


	/**
	 * @param src
	 * @param parentTarget
	 * @param result
	 */
	private void transformApplication(Application src, final JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		final JBApplication jbApp = new JBApplication(src,parentTarget);
		
		List<Host> hosts = src.members(Host.class);
		
		try {
			new RobustVisitor<Host>() {
				public Object visit(Host element) throws ModelException {

					transform(element, jbApp, result);
					return null;
				}

				public void unvisit(Host element, Object unvisitData) {
				}
			}.applyTo(hosts);

		} catch (ModelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Instance> instances = src.members(Instance.class);

		try {
			new RobustVisitor<Instance>() {
				public Object visit(Instance element) throws ModelException {

					transform(element, jbApp, result);
					return null;
				}

				public void unvisit(Instance element, Object unvisitData) {
				}
			}.applyTo(instances);

		} catch (ModelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isAdvice(Element element) {
		return (element instanceof Advice);
	}


	/**
	 * @param src
	 * @param parentTarget
	 * @param result
	 * @throws ModelException
	 */
	private void tranformAdvice(Advice src, JBDeclaration parentTarget,
			List<JBDeclaration> result) throws ModelException {

		JBAdviceElement adviceElement = new JBAdviceElement(src);

		// advice type
		MView mview = src.language(MView.class);
		Property adviceProperty = src.type();

		JBAdviceElement.AdviceType adviceType =
				adviceTypeForProperty(mview, adviceProperty);

		adviceElement.setType(adviceType);

		// service
		Service service = src.service().getElement();
		adviceElement.setServiceReturnType(service.returnType().signature().name());
		adviceElement.setServiceSignature(service.signature().name());
		adviceElement.setServiceInterface(((Declaration)service.parent()).signature().name());

		List<Pair<String, String>> parameters = new ArrayList<Pair<String, String>>();
		for (FormalParameter param : service.formalParameters()) {
			String name = param.signature().name();
			String type = "Type";/*
								 * param.getType().signature().name(); TODO: fix
								 * types
								 */

			parameters.add(new Pair<String, String>(name, type));
		}

		((JBAOComposition) parentTarget).addAdvice(adviceElement);
	}


	/**
	 * @param mview
	 * @param adviceProperty
	 * @return
	 */
	public JBAdviceElement.AdviceType adviceTypeForProperty(MView mview,
			Property adviceProperty) {
		JBAdviceElement.AdviceType adviceType = null;
		if (adviceProperty == mview.BEFORE) {
			adviceType = JBAdviceElement.AdviceType.BEFORE;

		} else if (adviceProperty == mview.AFTER) {
			adviceType = JBAdviceElement.AdviceType.AFTER;

		} else if (adviceProperty == mview.AROUND) {
			adviceType = JBAdviceElement.AdviceType.AROUND;
		}
		return adviceType;
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isPointcut(Element element) {
		return (element instanceof Pointcut);
	}


	/**
	 * @param src
	 * @param parentTarget
	 * @param result
	 * @throws ModelException
	 */
	private void transformPointcut(Pointcut src, JBDeclaration parentTarget,
			List<JBDeclaration> result) throws ModelException {

		JBPointcutElement pointcutElement = new JBPointcutElement(src);

		// signature
		List<Service> joinpoints = new ArrayList<Service>();

		PointcutSignature pcSig = src.signature();

		if (pcSig != null) {
			List<ServiceSignature> serviceSigs = pcSig.signatures();
	
			for (ServiceSignature serviceSignature : serviceSigs) {
				PatternSignature patternSig = (PatternSignature) serviceSignature;
				pointcutElement.addPatternSignature(patternSig.clone()); // TODO: clone?
			}
		}

		// pointcut kind
		MView mview = src.language(MView.class);
		Property pcProperty = src.kind();

		PointcutKind pcKind = pointcutKindForProperty(mview, pcProperty);

		pointcutElement.setKind(pcKind);

		// caller
		Map<ActorType, List<JBActorPropValue>> callerMap =
				new EnumMap<ActorType, List<JBActorPropValue>>(ActorType.class);

		if (src.caller() != null) {
			callerMap.putAll(transformActor(src.caller(),result));
		}

		pointcutElement.addCaller(callerMap);

		// callee

		Map<ActorType, List<JBActorPropValue>> calleeMap =
				new EnumMap<ActorType, List<JBActorPropValue>>(ActorType.class);

		if (src.callee() != null) {
			calleeMap.putAll(transformActor(src.callee(),result));
		}

		pointcutElement.addCallee(calleeMap);

		((JBAOComposition) parentTarget).addPointcut(pointcutElement);
	}


	/**
	 * @param src
	 * @param result
	 * @throws ModelException
	 */
	private Map<ActorType, List<JBActorPropValue>> transformActor(Actor src, 
			List<JBDeclaration> jbDcls)	throws ModelException {

		Map<ActorType, List<JBActorPropValue>> result =
				new EnumMap<ActorType, List<JBActorPropValue>>(ActorType.class);

		for (ActorProp actorProp : src.props()) {
			ActorProperty actorProperty = actorProp.actorProperty();

			ActorType acType =
					actorTypeForProperty(src.language(MView.class), actorProperty);

			List<PropValue<Declaration>> propValues = actorProp.propValues();

			List<JBActorPropValue> actorPropValues = new ArrayList<JBActorPropValue>();
			for (PropValue<Declaration> propValue : propValues) {
				JBActorPropValue jba = new JBActorPropValue();

				jba.setNegated(propValue.isNegated());
				jba.setValue(propValue.value().getElement().signature().name());
				transform(propValue.value().getElement(), null, jbDcls);

				actorPropValues.add(jba);
			}

			result.put(acType, actorPropValues);
		}

		return result;
	}


	/**
	 * @param mview
	 * @param pcProperty
	 * @return
	 */
	public PointcutKind pointcutKindForProperty(MView mview, Property pcProperty) {
		PointcutKind pcKind = null;
		if (pcProperty == mview.CALL) {
			pcKind = PointcutKind.CALL;
		} else if (pcProperty == mview.EXECUTION) {
			pcKind = PointcutKind.EXECUTION;
		}
		return pcKind;
	}


	/**
	 * @param mview
	 * @param actorProperty
	 */
	public ActorType actorTypeForProperty(MView mview, ActorProperty actorProperty) {
		ActorType acType = null;
		if (actorProperty == mview.APPLICATION) {
			acType = ActorType.APPLICATION;
		} else if (actorProperty == mview.COMPONENT) {
			acType = ActorType.COMPONENT;
		} else if (actorProperty == mview.HOST) {
			acType = ActorType.HOST;
		} else if (actorProperty == mview.INSTANCE) {
			acType = ActorType.INSTANCE;
		} else if (actorProperty == mview.INTERFACE) {
			acType = ActorType.INTERFACE;
		}
		return acType;
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isInterface(Element element) {
		return (element instanceof Interface);
	}


	/**
	 * @param src
	 * @param result
	 */
	private void transformInterface(Interface src, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		JBInterface iface = new JBInterface(src,parentTarget);
		result.add(iface);

//		if (parentTarget != null) {
//			((JBConnector) parentTarget).addRequiredInterface(iface);
//		}

		List<Service> services = src.services();

		for (Service service : services) {
			JBService jbSrv = new JBService(service,parentTarget);
			iface.addService(jbSrv);

			jbSrv.addReturnType(service.returnType().signature().name());
			jbSrv.addSignature(service.signature().toString());

			final List<FormalParameter> params = service.formalParameters();

			for (FormalParameter formalParameter : params) {
				String type =
						((BasicTypeReference) formalParameter.getTypeReference())
								.signature().name();
				String signature = formalParameter.signature().name();

				jbSrv.addFormalParameter(signature, type);
			}
		}
	}


	/**
	 * @param src
	 * @return
	 */
	private boolean isAOComposition(Element element) {
		return (element instanceof AOComposition);
	}


	/**
	 * @param src
	 * @return
	 */
	private void transformAOComposition(AOComposition src, JBDeclaration parentTarget,
			final List<JBDeclaration> result)
			throws ModelException {

		JBAOComposition jbAOC = new JBAOComposition(src,parentTarget);
		((JBConnector) parentTarget).addComposition(jbAOC);

		// pointcut
		List<Pointcut> pointcuts = src.members(Pointcut.class);

		// advice
		List<Advice> advices = src.members(Advice.class);

		if (pointcuts.size() > 1 || advices.size() > 1) {
			throw new ModelException("AOComposition is allowed one pointcut " +
					"and one advice, something went horribly wrong. " +
						"(" + src.signature().name() + ")");
		}

		if (pointcuts.size() == 1) {
			Pointcut pc = pointcuts.get(0);

			transform(pc, jbAOC, result);
		}

		if (advices.size() == 1) {
			Advice adv = advices.get(0);

			transform(adv, jbAOC, result);
		}
	}


	/**
	 * @param element
	 * @return
	 */
	private boolean isInstance(Element element) {
		return (element instanceof Instance);
	}


	/**
	 * @param src
	 * @return
	 */
	private void transformInstance(Instance src, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		transform(src.type().getElement(), parentTarget, result);
	}


	/**
	 * @param element
	 * @return
	 */
	protected boolean isComponent(Element element) {
		return (element instanceof Component);
	}


	/**
	 * @param src
	 * @return
	 * @throws ModelException
	 */
	private void transformComponent(Component src, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		JBComponent jbc = new JBComponent(src,parentTarget);
		result.add(jbc);

		//required interfaces (injections)

		{
		
			final List<JBInterface> jbReqs = transformModuleInterfaces(jbc, 
					src.members(RequiredInterfaceDependency.class));
			
			for (JBInterface jbInterface : jbReqs) {
				jbc.addRequiredInterface(jbInterface);
			}
			
			result.addAll(jbReqs);
		
		}
		
		//provided interfaces (implements)
		
		{
			
			final List<JBInterface> jbProvs = transformModuleInterfaces(jbc, 
					src.members(ProvidedInterfaceDependency.class));
	
			
			for (JBInterface jbInterface : jbProvs) {
				jbc.addProvidedInterface(jbInterface);
			}
			
			result.addAll(jbProvs);

		}		
	}


	/**
	 * @param jbc
	 * @param dependencies
	 * @return
	 * @throws ModelException
	 */
	private List<JBInterface> transformModuleInterfaces(JBModule jbc,
			final List<? extends Dependency> dependencies) throws ModelException {
		
		final List<JBInterface> result = new ArrayList<JBInterface>();
		final List<JBDeclaration> jbDeclarations = new ArrayList<JBDeclaration>();
		
		for (Dependency ifaceDep : dependencies) {

			List<SimpleReference<Interface>> ifaceRefs =
					(List<SimpleReference<Interface>>) ifaceDep.dependencies();

			//transform each Interface
			for (SimpleReference<Interface> ifaceRef : ifaceRefs) {
				transform(ifaceRef.getElement(), jbc, jbDeclarations);
			}

			//cast items to JBInterface
			for (JBDeclaration decl : jbDeclarations) {
				if (decl instanceof JBInterface) {
					result.add((JBInterface)decl);
				}
			}
		}
		return result;
	}


	/**
	 * @return
	 */
	private boolean isNamespacePart(Element element) {
		return (element instanceof NamespaceDeclaration);
	}


	/**
	 * @param src
	 * @return
	 * @throws ModelException
	 */
	private void transformNamespacePart(NamespaceDeclaration src, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		List<Declaration> decls = src.declarations();
		Iterator iter = decls.iterator();
		while (iter.hasNext()) {
			transform((Element) iter.next(), parentTarget, result);
		}
	}


	/**
	 * @param element
	 * @return
	 */
	private boolean isDeployment(Element element) {
		return (element instanceof Deployment);
	}


	/**
	 * @param src
	 * @return
	 * @throws ModelException
	 */
	private void transformDeployment(Deployment src, final JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		System.out.println("JBossWriter.transformDeployment()");

		// List<Instance> instances = src.members(Instance.class);
		// final List<JBDeclaration> jbDecl = new ArrayList<JBDeclaration>();
		//
		// try {
		// new RobustVisitor<Instance>() {
		// public Object visit(Instance element) throws ModelException {
		//
		// transform(element, parentTarget, jbDecl);
		// return null;
		// }
		//
		//
		// public void unvisit(Instance element, Object unvisitData) {
		// }
		// }.applyTo(instances);
		//
		// } catch (ModelException e) {
		// throw e;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// result.addAll(jbDecl);
	}


	/**
	 * @param element
	 * @return
	 */
	protected boolean isConnector(Element element) {
		return (element instanceof mview.model.module.Connector);
	}


	/**
	 * @param src
	 * @param wArgs
	 * @throws ModelException
	 */
	@SuppressWarnings("unchecked")
	private void transformConnector(Connector src, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		// 1. connector's name.

		final JBConnector jbc = new JBConnector(src,parentTarget);
		result.add(jbc);

		// 2. required interfaces (injections)
		
		final List<JBInterface> reqs = transformModuleInterfaces(jbc, 
				src.members(RequiredInterfaceDependency.class));

		for (JBInterface jbInterface : reqs) {
			jbc.addRequiredInterface(jbInterface);
		}
		
		// 3. ao-compositions; pass on, process results

//		final List<JBDeclaration> jbAOC = new ArrayList<JBDeclaration>();
		final List<AOComposition> compositions =
				src.members(AOComposition.class);

		try {
			new RobustVisitor<AOComposition>() {
				@Override
				public Object visit(AOComposition element) throws ModelException {
					if (!element.isAbstract()) { 
						transform(element, jbc, result);
					}
					return null;
				}


				@Override
				public void unvisit(AOComposition element, Object unvisitData) {
				}

			}.applyTo(compositions);

		} catch (ModelException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// for (JBDeclaration jbaoc : jbAOC) {
		// jbc.addPointcut(((JBAOComposition) jbaoc).pointcut());
		// jbc.addAdvice(((JBAOComposition) jbaoc).advice());
		// }
	}


	/**
	 * @param element
	 * @return
	 */
	protected boolean isCompilationUnit(Element element) {
		return (element instanceof Document);
	}


	/**
	 * @param src
	 * @param wArgs
	 * @return
	 * @throws ModelException
	 */
	protected void transformCompilationUnit(Document src,
			JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		for (NamespaceDeclaration part : src.namespaceDeclarations()) {
			transform(part, parentTarget, result);
		}
	}

}
