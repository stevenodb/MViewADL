package mview.model.language;

import be.kuleuven.cs.distrinet.jnome.input.JavaFactory;

public class MViewFactory extends JavaFactory {

	@Override
	public MViewFactory clone() {
		return new MViewFactory();
	}

}
