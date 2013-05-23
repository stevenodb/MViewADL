package mview.model.language;

import java.io.File;

import be.kuleuven.cs.distrinet.chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.workspace.Workspace;
import be.kuleuven.cs.distrinet.jnome.core.language.JavaLanguageFactory;
import be.kuleuven.cs.distrinet.jnome.input.EagerJavaFileInputSourceFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaProjectConfig;

public class MViewProjectConfig extends JavaProjectConfig {

	public MViewProjectConfig(String projectName, File root, View view, Workspace workspace, BaseLibraryConfiguration baseLibraryConfiguration) {
		super(projectName, root, view, workspace, new EagerJavaFileInputSourceFactory(), JavaLanguageFactory.javaBaseJar(), baseLibraryConfiguration);
	}

}
