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
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import mview.model.application.Instance;
import mview.model.composition.AOComposition;
import mview.model.deployment.Deployment;
import mview.model.module.Component;
import mview.model.module.Connector;
import mview.model.namespace.MViewDeclaration;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
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
	protected void addPreamble(Class<? extends Element> key, StringBuffer preamble) {
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
		return '\n'+startLine().toString()+text;
	}
	
	/**
	 * @param args
	 * @param declaration
	 * @param code
	 * @throws IOException
	 */
	protected void writeCode(WriterArguments args,
			MViewDeclaration declaration, String code) throws IOException {

		if (args.allowedOutput(declaration)) {
			String fileName = declaration.signature().name() + ".java";
			String packageFQN =
					declaration.getNamespace().getFullyQualifiedName();
			String relDirName = packageFQN.replace('.', File.separatorChar);
			File out =
					new File(args.outputDir() + File.separatorChar + relDirName
							+ File.separatorChar + fileName);

			System.out.println("Writing: " + out.getAbsolutePath());

			File parent = out.getParentFile();
			parent.mkdirs();
			out.createNewFile();
			FileWriter fw = new FileWriter(out);

			//preamble
			fw.write(preamble(declaration.getClass()).toString());
			//body
			fw.write(code);
			
			fw.close();
		}
	}

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
			result = toCodeAOComposition((AOComposition)element);
			
		} else if(element == null) {
		      result = "";
	    }
	    else {
	      throw new IllegalArgumentException(
	    		  "The given element is not know by MView syntax: "
	    		  +element.getClass().getName());
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
	protected abstract String toCodeInstance(Instance element) throws ModelException;

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
	 */
	protected abstract String toCodeAOComposition(AOComposition element);

	/**
	 * @param args
	 * @param element
	 * @param code
	 * @throws IOException
	 */
	protected void writeCode(WriterArguments args,
			Element element, String code) throws IOException {
		System.out.println("Skipping: " + element.getClass());
	}

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
