/**
 * author:   Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * filename: MViewWriter.java
 * created:  Dec 9, 2010, 11:55:55 AM
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
package mview.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mview.model.application.Application;
import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.deployment.Deployment;
import mview.model.module.Component;
import mview.model.module.Connector;
import mview.model.namespace.MViewDeclaration;
import chameleon.core.compilationunit.CompilationUnit;
import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.namespacepart.NamespacePart;
import chameleon.exception.ModelException;
import chameleon.output.Syntax;

//import chameleon.tool.Connector;

/**
 * @author Steven Op de beeck <steven /at/ opdebeeck /./ org>
 * 
 */
public abstract class MViewWriter extends Syntax {

	/**
	 * @param wArguments
	 */
	protected MViewWriter(WriterArguments wArguments) {
		initPreambles();
		_wArguments = wArguments;
	}

	/*
	 * WriterArguments
	 */
	private final WriterArguments _wArguments;

	/**
	 * @return the wArguments
	 */
	public WriterArguments writerArguments() {
		return _wArguments;
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
	 * Initialize the preambles
	 */
	protected abstract void initPreambles();

	/*
	 * indent
	 */
	private int _indent;
	private final int _tabSize = 4;

	/**
	 * @return the indent
	 */
	public int getIndent() {
		return _indent;
	}

	protected void indent() {
		_indent += _tabSize;
	}

	protected void undent() {
		_indent -= _tabSize;
	}

	/**
	 * @return
	 */
	protected StringBuffer startLine() {
		StringBuffer result = new StringBuffer();
		int indent = getIndent();
		for (int i = 0; i < indent; i++) {
			result.append(' ');
		}
		return result;
	}

	/**
	 * @param text
	 * @return start text on a new line
	 */
	public String startNewLine(String text) {
		return '\n' + startLine().toString() + text;
	}

	/**
	 * @param args
	 * @param element
	 * @param code
	 * @throws IOException
	 */
	protected void writeCode(WriterArguments args,
			Element element, String code) throws IOException {

		if (args.allowedOutput(element.getClass())) {
			MViewDeclaration declaration = (MViewDeclaration) element;
			String fileName = declaration.signature().name() + ".java";
			String packageFQN =
				declaration.getNamespace().getFullyQualifiedName();
			String relDirName = packageFQN.replace('.', File.separatorChar);
			File out =
					new File(args.outputDir().getAbsolutePath()
							+ File.separatorChar + relDirName
							+ File.separatorChar + fileName);

			System.out.println("Writing: " + out.getAbsolutePath());

			File parent = out.getParentFile();
			parent.mkdirs();
			out.createNewFile();
			FileWriter fw = new FileWriter(out);

			// preamble
			fw.write(preamble(element.getClass()).toString());
			// body
			fw.write(code);

			fw.close();
		} else {
			System.out.println("Skipping: " + element.getClass());
		}
	}

//	/**
//	 * @param args
//	 * @param element
//	 * @param code
//	 * @throws IOException
//	 */
//	protected void writeCode(WriterArguments args,
//			Element element, String code) throws IOException {
//		System.out.println("Skipping: " + element.getClass());
//	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see chameleon.output.Syntax#toCode(chameleon.core.element.Element)
	 */
	@Override
	public String toCode(Element element) throws ModelException {
		String result = null;
		if (isConnector(element)) {
			result = toCodeConnector((Connector) element);
		} else if (isComponent(element)) {
			result = toCodeComponent((Component) element);
		} else if (isDeployment(element)) {
			result = toCodeDeployment((Deployment) element);
		} else if (isInstance(element)) {
			result = toCodeInstance((Instance) element);
		} else if (isAOComposition(element)) {
			result = toCodeAOComposition((AOComposition) element);
		} else if (isCompilationUnit(element)) {
			result = toCodeCompilationUnit((CompilationUnit) element);
		} else if(isNamespacePart(element)) {
			result = toCodeNamespacePart((NamespacePart) element);
		} else if(isApplication(element)) {
		}

		else if (element == null) {
			result = "";
		} else {
			throw new IllegalArgumentException(
					"The given element is not know by MView syntax: "
							+ element.getClass().getName());
		}

		try {
			writeCode(writerArguments(), element, result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * @param element
	 * @return
	 */
	private boolean isApplication(Element element) {
		return element instanceof Application;
	}

	/**
	 * @param element
	 * @return
	 */
	protected boolean isNamespacePart(Element element) {
		return element instanceof NamespacePart;
	}

	/**
	 * @param part
	 * @return
	 * @throws ModelException 
	 */
	protected String toCodeNamespacePart(NamespacePart part)
			throws ModelException {
		StringBuffer result = new StringBuffer();
		result.append("package " + part.namespace().getFullyQualifiedName()
				+ ";\n\n");

//		for (Import imp : part.imports()) {
//			if (imp instanceof TypeImport) {
//				result.append("import "
//						+ toCode(((TypeImport) imp).getTypeReference()) + ";\n");
//			} else if (imp instanceof DemandImport) {
//				result.append("import "
//						+ toCode(((DemandImport) imp).namespaceReference())
//						+ ".*;\n");
//			}
//		}

		result.append("\n");
		List<Declaration> decls = part.declarations();
		Iterator iter = decls.iterator();
		while (iter.hasNext()) {
			result.append(toCode((Element) iter.next()));
			if (iter.hasNext()) {
				result.append("\n\n");
			}
		}
		return result.toString();
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
	 * @return
	 * @throws ModelException 
	 */
	protected String toCodeCompilationUnit(CompilationUnit element) throws ModelException {
		StringBuffer result = new StringBuffer();
		for (NamespacePart part : element.namespaceParts()) {
			result.append(toCodeNamespacePart(part));
		}
		return result.toString();
	}

	/**
	 * @param element
	 * @return
	 */
	protected boolean isComponent(Element element) {
		return (element instanceof Component);
	}

	/**
	 * @param element
	 * @return
	 */
	protected abstract String toCodeComponent(Component element);

	/**
	 * @param element
	 * @return
	 */
	protected boolean isInstance(Element element) {
		return (element instanceof Instance);
	}

	/**
	 * @param element
	 * @return
	 * @throws ModelException
	 */
	protected abstract String toCodeInstance(Instance element)
			throws ModelException;

	/**
	 * @param element
	 * @return
	 */
	protected boolean isAOComposition(Element element) {
		return (element instanceof AOComposition);
	}

	/**
	 * @param element
	 * @return
	 * @throws ModelException
	 */
	protected abstract String toCodeAOComposition(AOComposition element)
			throws ModelException;

	/**
	 * @param element
	 * @return
	 */
	protected boolean isDeployment(Element element) {
		return (element instanceof Deployment);
	}

	/**
	 * @param element
	 * @throws ModelException
	 */
	protected abstract String toCodeDeployment(Deployment element)
			throws ModelException;

	/**
	 * @param element
	 * @return
	 */
	protected boolean isConnector(Element element) {
		return (element instanceof mview.model.module.Connector);
	}

	/**
	 * @param element
	 * @throws ModelException
	 * @throws IOException
	 */
	protected abstract String toCodeConnector(Connector element)
			throws ModelException;

}
