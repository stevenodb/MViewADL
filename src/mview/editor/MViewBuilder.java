package mview.editor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import mview.output.jboss.JBossWriter;
import chameleon.core.document.Document;
import chameleon.core.element.Element;
import chameleon.exception.ModelException;
import chameleon.plugin.ViewPluginImpl;
import chameleon.plugin.build.BuildException;
import chameleon.plugin.build.BuildProgressHelper;
import chameleon.plugin.build.Builder;

public class MViewBuilder extends ViewPluginImpl implements Builder {
	
	public MViewBuilder() {
	}

	public void build(List<Document> compilationUnits, 
			File outputDir, BuildProgressHelper buildProgressHelper) throws BuildException {

//		Language lang = compilationUnit.language();
//		List<PointcutSignature> pointcuts = lang.defaultNamespace().descendants(PointcutSignature.class);
//		for(PointcutSignature pc: pointcuts) {
//			pc.parentLink().lock();
//		}
		
//		List<Class<? extends Element>> elemsAllowedOutput = new ArrayList<Class<? extends Element>>();
//		elemsAllowedOutput.add(Connector.class);
		for(Element compilationUnit:compilationUnits) {
			try {
				JBossWriter.writeElement((Element)compilationUnit, "", outputDir);
			} catch (Exception e) {
				throw new BuildException(e);
			}
			buildProgressHelper.addWorked(1);
		}
	}

	@Override
	public MViewBuilder clone() {
		return new MViewBuilder();
	}

	@Override
	public int totalAmountOfWork(List<Document> compilationUnits, List<Document> allProjectCompilationUnits) {
		return compilationUnits.size();
	}
}
