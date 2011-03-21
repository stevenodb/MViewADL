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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.rejuse.java.collections.RobustVisitor;

import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.composition.Advice;
import mview.model.composition.Pointcut;
import mview.model.deployment.Deployment;
import mview.model.module.Component;
import mview.model.module.Connector;
import mview.model.module.Interface;
import mview.model.module.Module.RequiredInterfaceDependency;
import mview.model.namespace.MViewDeclaration;
import mview.output.WriterArguments;
import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.core.reference.SimpleReference;
import chameleon.exception.ModelException;

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
	private final List<JBDeclaration>	_transformedDecls	=
																					new ArrayList<JBDeclaration>();


	/**
	 * @param decl
	 */
	protected void addTransformedDecl(JBDeclaration decl) {
		_transformedDecls.add(decl);
	}

	/*
	 * WriterArguments
	 */
	private final WriterArguments	_wArguments;


	/**
	 * @return the wArguments
	 */
	public WriterArguments writerArguments() {
		return _wArguments.clone();
	}

	/*
	 * Preamble
	 */
	Map<Class<? extends Element>, StringBuffer>	_preambles	=
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
		List<JBDeclaration> declaration = transform(element);
		
		for (JBDeclaration jbDeclaration : declaration) {
			System.out.println("Writing "+jbDeclaration);
		}
		
//		MViewDeclaration declaration = args.declarations().get(0);
//		String fileName = declaration.signature().name() + ".java";
//
//		String packageFQN =
//				declaration.getNamespace().getFullyQualifiedName();
//
//		if (packageFQN.equals("")) {
//			packageFQN = args.defaultNamespace();
//		}
//
//		String relDirName = packageFQN.replace('.', File.separatorChar);
//		File out =
//				new File(args.outputDir().getAbsolutePath()
//						+ File.separatorChar + relDirName
//						+ File.separatorChar + fileName);
//
//		System.out.println("Writing: " + out.getAbsolutePath());
//
//		File parent = out.getParentFile();
//		parent.mkdirs();
//		out.createNewFile();
//		FileWriter fw = new FileWriter(out);
//
//		// preamble
//		fw.write(preamble(element.getClass()).toString());
//
//		// body
//		fw.write(code);
//
//		fw.close();
	}


	// /**
	// * @param element
	// * @param writerArguments
	// */
	// private void writeCode(Element element, WriterArguments writerArguments)
	// {
	// // TODO Auto-generated method stub
	// }

	public List<JBDeclaration> transform(Element src)
			throws ModelException {

		List<JBDeclaration> result = null;

		if (isCompilationUnit(src)) {
			result = transformCompilationUnit((CompilationUnit) src);
		} else if (isNamespacePart(src)) {
			result = transformNamespacePart((NamespacePart) src);
		}
		if (isInstance(src)) {
			result = transformInstance((Instance) src);
		} else if (isComponent(src)) {
			result = transformComponent((Component) src);
		} else if (isConnector(src)) {
			result = transformConnector((Connector) src);
		} else if (isAOComposition(src)) {
			result = transformAOComposition((AOComposition) src);
		} else if (isDeployment(src)) {
			result = transformDeployment((Deployment) src);
		}

		else if (src == null) {
		} else {
			throw new IllegalArgumentException(
					"The given element is not know by MView syntax: "
							+ src.getClass().getName());
		}

		return result;
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
	private List<JBDeclaration> transformAOComposition(AOComposition src)
			throws ModelException {

		JBAOComposition jbAOC = new JBAOComposition(src);

		// pointcut
		List<Pointcut> pointcuts = src.members(Pointcut.class);

		// advice
		List<Advice> advices = src.members(Advice.class);

		if ((pointcuts.size() != 1) || (advices.size() != 1)) {
			throw new ModelException("AOComposition is allowed one pointcut " +
					"and one advice, something went horribly wrong.");

		} else {
			Pointcut pc = pointcuts.get(0);
			Advice adv = advices.get(0);

			JBPointcut jbPC = new JBPointcut(src, pc);
			JBAdvice jbAdv = new JBAdvice(src, adv);
		}

		List<JBDeclaration> result = new ArrayList<JBDeclaration>();
		result.add(jbAOC);

		return result;
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
	private List<JBDeclaration> transformInstance(Instance element)
			throws ModelException {

		return transform(element.type().getElement());
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
	private List<JBDeclaration> transformComponent(Component src) {
		List<JBDeclaration> result = new ArrayList<JBDeclaration>();

		// JBComponent jbc = new JBComponent();

		// src.

		return result;
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
	private List<JBDeclaration> transformNamespacePart(
			NamespacePart src) throws ModelException {

		List<JBDeclaration> result = new ArrayList<JBDeclaration>();

		List<Declaration> decls = src.declarations();
		Iterator iter = decls.iterator();
		while (iter.hasNext()) {
			result.addAll(transform((Element) iter.next()));
		}

		return result;
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
	private List<JBDeclaration> transformDeployment(Deployment src)
			throws ModelException {

		final List<JBDeclaration> result = new ArrayList<JBDeclaration>();

		List<Instance> instances = src.members(Instance.class);
		final ArrayList<JBModule> jbModules = new ArrayList<JBModule>();

		try {
			new RobustVisitor<Instance>() {
				public Object visit(Instance element) throws ModelException {
					jbModules
							.addAll((Collection<? extends JBModule>) transformInstance(element));
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

		JBDeployment jbd = new JBDeployment(src);

		for (JBModule jbModule : jbModules) {
			jbd.addModule(jbModule);
		}

		return result;
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
	private List<JBDeclaration> transformConnector(Connector element)
			throws ModelException {

		final List<JBDeclaration> result = new ArrayList<JBDeclaration>();

		// 1. connector's name.

		final JBConnector jbc = new JBConnector(element);

		result.add(jbc);

		// 2. required interfaces (injections)

		final List<RequiredInterfaceDependency> deps =
				element.members(RequiredInterfaceDependency.class);

		final List<SimpleReference<Interface>> required = null;

		for (RequiredInterfaceDependency ifaceDep : deps) {
			required.addAll(ifaceDep.dependencies());
		}

		jbc.addRequiredInterfaces(required);

		// 3. ao-compositions; pass on, process results

		final List<JBAOComposition> jbAOC = new ArrayList<JBAOComposition>();
		final List<AOComposition> compositions =
				element.members(AOComposition.class);

		try {
			new RobustVisitor<AOComposition>() {

				@Override
				public Object visit(AOComposition element) throws ModelException {
					jbAOC.addAll((Collection<? extends JBAOComposition>) transformAOComposition(element));
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

		for (JBAOComposition jbaoc : jbAOC) {
			jbc.addPointcut(jbaoc.pointcut());
			jbc.addAdvice(jbaoc.advice());
		}

		return result;
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
	protected List<JBDeclaration> transformCompilationUnit(
			CompilationUnit element) throws ModelException {

		List<JBDeclaration> result = new ArrayList<JBDeclaration>();

		for (NamespacePart part : element.namespaceParts()) {
			result.addAll(transform(part));
		}

		return result;
	}

}
