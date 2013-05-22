package mview.editor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.exception.ModelException;
import be.kuleuven.cs.distrinet.chameleon.plugin.ViewPluginImpl;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.BuildException;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.BuildProgressHelper;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.Builder;
import mview.output.jboss.JBossWriter;
import be.kuleuven.cs.distrinet.chameleon.core.document.Document;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;

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
