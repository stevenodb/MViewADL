package mview.editor;

import java.io.File;
import java.util.List;

import mview.output.jboss.JBossWriter;
import be.kuleuven.cs.distrinet.chameleon.core.document.Document;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.plugin.ViewPluginImpl;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.BuildException;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.BuildProgressHelper;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.Builder;

public class MViewBuilder extends ViewPluginImpl implements Builder {
	
	public MViewBuilder() {
	}

	public void build(List<Document> compilationUnits, File outputDir, BuildProgressHelper buildProgressHelper) throws BuildException {
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
