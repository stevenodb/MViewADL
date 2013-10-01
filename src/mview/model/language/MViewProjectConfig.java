package mview.model.language;

import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.jnome.input.EagerJavaFileInputSourceFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaProjectConfiguration;

public class MViewProjectConfig extends JavaProjectConfiguration {

	public MViewProjectConfig(View view) {
		super(view, new EagerJavaFileInputSourceFactory());
	}

}
