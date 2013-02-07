package mview.model.language;

import java.io.File;

import org.rejuse.predicate.False;
import org.rejuse.predicate.SafePredicate;

import chameleon.core.namespace.LazyRootNamespace;
import chameleon.plugin.LanguagePluginImpl;
import chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;
import chameleon.workspace.ConfigException;
import chameleon.workspace.ExtensionPredicate;
import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfigurator;
import chameleon.workspace.ProjectInitialisationListener;
import chameleon.workspace.View;
import chameleon.workspace.Workspace;

public class MViewConfigLoader extends LanguagePluginImpl implements ProjectConfigurator {

	@Override
	public MViewProjectConfig createConfigElement(String projectName, File root, Workspace workspace, ProjectInitialisationListener listener, BaseLibraryConfiguration baseLibraryConfiguration) throws ConfigException {
		View view = new View(new LazyRootNamespace(), language());
		if(listener != null) {listener.viewAdded(view);}
		return new MViewProjectConfig(projectName, root, view, workspace, new FileInputSourceFactory(), baseLibraryConfiguration);
	}

	@Override
	public MViewConfigLoader clone() {
		return new MViewConfigLoader();
	}

	@Override
	public SafePredicate<? super String> sourceFileFilter() {
		return new ExtensionPredicate("mview");
	}

	@Override
	public SafePredicate<? super String> binaryFileFilter() {
		return new False<String>();
	}

}