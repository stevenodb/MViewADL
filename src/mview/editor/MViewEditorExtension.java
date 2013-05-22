package mview.editor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mview.model.composition.modifier.After;
import mview.model.composition.modifier.Around;
import mview.model.composition.modifier.Before;
import mview.model.composition.modifier.Call;
import mview.model.composition.modifier.Execution;
import mview.model.composition.modifier.Negate;
import mview.model.refinement.modifier.Extendable;
import mview.model.refinement.modifier.Overridable;
import be.kuleuven.cs.distrinet.chameleon.core.modifier.Modifier;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseEditorExtension;
import be.kuleuven.cs.distrinet.chameleon.plugin.build.Builder;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;

/**
 * @author Marko van Dooren
 * @author Steven Op de beeck is also responsible for this piece of ...
 */
public class MViewEditorExtension extends EclipseEditorExtension {

	public MViewEditorExtension clone() {
		return new MViewEditorExtension();
	}

	@Override
	public List<Modifier> getFilterModifiers() {
		List<Modifier> result = new ArrayList<Modifier>();
		result.add(new Before());
		result.add(new After());
		result.add(new Around());
		result.add(new Call());
		result.add(new Execution());
		result.add(new Overridable());
		result.add(new Extendable());
		result.add(new Negate());
		return result;
	}

	@Override
	public File buildDirectory(File projectRoot) {
		return new File(projectRoot.getAbsolutePath()+File.separator+"java");
	}

	/**
	 * Add the MView builder to the view.
	 */
	@Override
	public void initialize(View view) {
		view.setPlugin(Builder.class, new MViewBuilder());
	}
}
