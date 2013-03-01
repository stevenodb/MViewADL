package mview.model.language;

import java.io.File;
import java.net.URL;

import jnome.input.LazyJavaFileInputSourceFactory;
import jnome.workspace.JavaProjectConfig;
import chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;
import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.View;
import chameleon.workspace.Workspace;

public class MViewProjectConfig extends JavaProjectConfig {

	public MViewProjectConfig(String projectName, File root, View view, Workspace workspace, BaseLibraryConfiguration baseLibraryConfiguration) {
		super(projectName, root, view, workspace, new LazyJavaFileInputSourceFactory(), baseJarPath(), baseLibraryConfiguration);
	}

	private static String baseJarPath() {
		URL objectLocation = Object.class.getResource("/java/lang/Object.class");
		String fileName = objectLocation.getFile();
		String jarName = fileName.substring(5,fileName.indexOf('!'));
		return jarName;
	}

}