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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.composition.Actor;
import mview.model.composition.ActorProp;
import mview.model.composition.Advice;
import mview.model.composition.Pointcut;
import mview.model.composition.PointcutSignature;
import mview.model.composition.ServiceSignature;
import mview.model.deployment.Deployment;
import mview.model.language.MView;
import mview.model.module.Component;
import mview.model.module.Connector;
import mview.model.module.Interface;
import mview.model.module.Module.RequiredInterfaceDependency;
import mview.model.module.Service;
import mview.model.property.ActorProperty;
import mview.output.WriterArguments;
import mview.output.jboss.JBPointcutElement.ActorType;
import mview.output.jboss.JBPointcutElement.PointcutKind;

import org.rejuse.java.collections.RobustVisitor;
import org.rejuse.property.Property;

import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.core.variable.FormalParameter;
import chameleon.exception.ModelException;
import chameleon.oo.type.BasicTypeReference;
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

	/*
	 * List of transformed declarations
	 */
	private final List<JBDeclaration> _transformedDecls = new ArrayList<JBDeclaration>();


	/**
	 * @param decl
	 */
	protected void addTransformedDecl(JBDeclaration decl) {
		_transformedDecls.add(decl);
	}

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


	/**
	 * @param key
	 * @return
	 */
	protected StringBuffer preamble(Class<? extends Element> key) {
		return _preambles.get(key);
	}


	/**
	 * @param key
	 * @param preamble
	 */
	protected void addPreamble(Class<? extends Element> key,
			StringBuffer preamble) {
		_preambles.put(key, preamble);
	}


	/**
	 * @param key
	 */
	protected void removePreamble(Class<? extends Element> key) {
		_preambles.remove(key);
	}


	/**
	 * 
	 */
	protected void initPreambles() {
		String imports = "import javax.ejb.EJB;\n" +
						"import org.jboss.aop.AdviceType;\n" +
						"import org.jboss.aop.Aspect;\n" +
						"import org.jboss.aop.Bind;\n" +
						"import org.jboss.aop.PointcutDef;\n" +
						"import org.jboss.aop.pointcut.Pointcut;\n";
		StringBuffer connPA = new StringBuffer(imports);
		addPreamble(Connector.class, connPA);
	}


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

		for (JBDeclaration jbDeclaration : declarations) {
			System.out.println("Writing " + jbDeclaration);
		}

		// MViewDeclaration declaration = args.declarations().get(0);
		// String fileName = declaration.signature().name() + ".java";
		//
		// String packageFQN =
		// declaration.getNamespace().getFullyQualifiedName();
		//
		// if (packageFQN.equals("")) {
		// packageFQN = args.defaultNamespace();
		// }
		//
		// String relDirName = packageFQN.replace('.', File.separatorChar);
		// File out =
		// new File(args.outputDir().getAbsolutePath()
		// + File.separatorChar + relDirName
		// + File.separatorChar + fileName);
		//
		// System.out.println("Writing: " + out.getAbsolutePath());
		//
		// File parent = out.getParentFile();
		// parent.mkdirs();
		// out.createNewFile();
		// FileWriter fw = new FileWriter(out);
		//
		// // preamble
		// fw.write(preamble(element.getClass()).toString());
		//
		// // body
		// fw.write(code);
		//
		// fw.close();
	}


	// /**
	// * @param element
	// * @param writerArguments
	// */
	// private void writeCode(Element element, WriterArguments writerArguments)
	// {
	// // TODO Auto-generated method stub
	// }

	public void transform(Element src, JBDeclaration parentTarget, final List<JBDeclaration> result)
			throws ModelException {

		if (isCompilationUnit(src)) {
			transformCompilationUnit((CompilationUnit) src, parentTarget, result);

		} else if (isNamespacePart(src)) {
			transformNamespacePart((NamespacePart) src, parentTarget, result);

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
			
		} else if (isDeployment(src)) {
			transformDeployment((Deployment) src, parentTarget, result);

		} else if (isInterface(src)) {
			transformInterface((Interface) src, parentTarget, result);
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
		
		JBAdviceElement.AdviceType adviceType = null; 
		if (adviceProperty == mview.BEFORE) {
			adviceType = JBAdviceElement.AdviceType.BEFORE;
			
		} else if (adviceProperty == mview.AFTER) {
			adviceType = JBAdviceElement.AdviceType.AFTER;
			
		} else if (adviceProperty == mview.AROUND) {
			adviceType = JBAdviceElement.AdviceType.AROUND;
		}
		
		adviceElement.setAdviceType(adviceType);
		
		
		// service
		try { // TODO: FIX! then remove try catch
			Service service = src.service().getElement();
			adviceElement.addSericeReturnType(service.returnType().signature().name());
			adviceElement.addServiceSignature(service.signature().name());
			
			List<Pair<String, String>> parameters = new ArrayList<Pair<String,String>>();
			for (FormalParameter param : service.formalParameters()) {
				String name = param.signature().name();
				String type = param.getType().signature().name();
				
				parameters.add(new Pair<String, String>(name, type));
			}
			
		} catch (LookupException e) {
			e.printStackTrace();
			System.err.println("FIX; REMOVE TRY CATCH");
		}
		
		((JBAOComposition) parentTarget).addAdvice(adviceElement);
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
	 * @throws LookupException 
	 */
	private void transformPointcut(Pointcut src, JBDeclaration parentTarget,
			List<JBDeclaration> result) throws LookupException {

		JBPointcutElement pointcutElement = new JBPointcutElement(src);
		
		// signature
		List<Service> joinpoints = new ArrayList<Service>();
				
		PointcutSignature pcSig = src.signature();
		
		List<ServiceSignature> serviceSigs = pcSig.signatures();
		
		for (ServiceSignature serviceSignature : serviceSigs) {
			try { // TODO: fix, then remove try catch
				joinpoints.addAll(serviceSignature.services());
			} catch (LookupException e) {
				System.err.println(e.getMessage());
				System.err.println("FIX; REMOVE TRY CATCH");
			}
		}
		
		pointcutElement.addServices(joinpoints);
		
		// pointcut kind
		MView mview = src.language(MView.class);
		Property pcProperty = src.kind();
		
		PointcutKind pcKind = null;
		if (pcProperty == mview.CALL) {
			pcKind = PointcutKind.CALL;
		} else if (pcProperty == mview.EXECUTION) {
			pcKind = PointcutKind.EXECUTION;
		}

		pointcutElement.addKind(pcKind);
		
		// caller
		
		 Actor caller = src.caller();
		 
//		 Map<ActorType,List<String>> actorMap = 
		 
//		 for (ActorProp actorProp : caller.props()) {
//			ActorProperty actorProperty = actorProp.actorProperty();
//			actorProperty.
//		 }
		
		// callee
		
		((JBAOComposition) parentTarget).addPointcut(pointcutElement);
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

		JBInterface iface = new JBInterface(src);
		if (parentTarget != null) {
			((JBConnector)parentTarget).addRequiredInterface(iface);
		}
		result.add(iface);

		List<Service> services = src.services();

		for (Service service : services) {
			iface.addReturnType(service.returnType().signature().name());
			iface.addSignature(service.signature().toString());

			final List<FormalParameter> params = service.formalParameters();

			for (FormalParameter formalParameter : params) {
				String type =
						((BasicTypeReference) formalParameter.getTypeReference())
								.signature().name();
				String signature = formalParameter.signature().name();

				iface.addFormalParameter(signature, type);
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

		JBAOComposition jbAOC = new JBAOComposition(src);

		// pointcut
		List<Pointcut> pointcuts = src.members(Pointcut.class);

		// advice
		List<Advice> advices = src.members(Advice.class);

		if ((pointcuts.size() == 1) && (advices.size() == 1)) {
			Pointcut pc = pointcuts.get(0);
			Advice adv = advices.get(0);

//			JBPointcutElement jbPC = new JBPointcutElement(pc);
//			JBAdviceElement jbAdv = new JBAdviceElement(adv);
			
			transform(pc, jbAOC, result);
			transform(adv, jbAOC, result);
			
//			jbAOC.addPointcut(jbPC);
//			jbAOC.addAdvice(jbAdv);

			((JBConnector)parentTarget).addComposition(jbAOC);
		}
//		else {
			// throw new ModelException("AOComposition is allowed one pointcut "
			// +
			// "and one advice, something went horribly wrong. " +
			// "(" + src.signature().name() + ")");
//		}

	}


	/**
	 * @param element
	 * @return
	 */
	private boolean isInstance(Element element) {
		return (element instanceof Instance);
	}


	/**
	 * @param element
	 * @return
	 */
	private void transformInstance(Instance element, JBDeclaration parentTarget,
			final List<JBDeclaration> result) throws ModelException {

		transform(element.type().getElement(), parentTarget, result);
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
	 */
	private void transformComponent(Component src, JBDeclaration parentTarget, 
			final List<JBDeclaration> result) {
		// JBComponent jbc = new JBComponent();
		// src.
	}


	/**
	 * @return
	 */
	private boolean isNamespacePart(Element element) {
		return (element instanceof NamespacePart);
	}


	/**
	 * @param src
	 * @return
	 * @throws ModelException
	 */
	private void transformNamespacePart(NamespacePart src, JBDeclaration parentTarget,
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

		List<Instance> instances = src.members(Instance.class);
		final List<JBDeclaration> jbDecl = new ArrayList<JBDeclaration>();

		try {
			new RobustVisitor<Instance>() {
				public Object visit(Instance element) throws ModelException {

					transform(element, parentTarget, jbDecl);
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

		result.addAll(jbDecl);

//		JBDeployment jbd = new JBDeployment(src);
//		result.add(jbd);
//
//		for (JBDeclaration jbModule : jbDecl) {
//			jbd.addModule((JBModule) jbModule);
//		}
	}


	/**
	 * @param element
	 * @return
	 */
	protected boolean isConnector(Element element) {
		return (element instanceof mview.model.module.Connector);
	}


	/**
	 * @param element
	 * @param wArgs
	 * @throws ModelException
	 */
	@SuppressWarnings("unchecked")
	private void transformConnector(Connector element, JBDeclaration parentTarget, 
			final List<JBDeclaration> result) throws ModelException {

		// 1. connector's name.

		final JBConnector jbc = new JBConnector(element);
		result.add(jbc);

		// 2. required interfaces (injections)

		final List<RequiredInterfaceDependency> deps =
				element.members(RequiredInterfaceDependency.class);

		for (RequiredInterfaceDependency ifaceDep : deps) {

			List<SimpleReference<Interface>> ifaceRefs =
					(List<SimpleReference<Interface>>) ifaceDep.dependencies();

			List<JBDeclaration> ifLst = new ArrayList<JBDeclaration>();

			for (SimpleReference<Interface> ifaceRef : ifaceRefs) {
				transform(ifaceRef.getElement(), jbc, ifLst);
				result.addAll(ifLst);
			}
		}

		// jbc.addRequiredInterfaces(required);

		// 3. ao-compositions; pass on, process results

		final List<JBDeclaration> jbAOC = new ArrayList<JBDeclaration>();
		final List<AOComposition> compositions =
				element.members(AOComposition.class);

		try {
			new RobustVisitor<AOComposition>() {
				@Override
				public Object visit(AOComposition element) throws ModelException {
					transform(element, jbc, jbAOC);
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

//		for (JBDeclaration jbaoc : jbAOC) {
//			jbc.addPointcut(((JBAOComposition) jbaoc).pointcut());
//			jbc.addAdvice(((JBAOComposition) jbaoc).advice());
//		}
	}


	/**
	 * @param element
	 * @return
	 */
	protected boolean isCompilationUnit(Element element) {
		return (element instanceof CompilationUnit);
	}


	/**
	 * @param element
	 * @param wArgs
	 * @return
	 * @throws ModelException
	 */
	protected void transformCompilationUnit(CompilationUnit element,
			JBDeclaration parentTarget, 
			final List<JBDeclaration> result) throws ModelException {

		for (NamespacePart part : element.namespaceParts()) {
			transform(part, parentTarget, result);
		}
	}

}
