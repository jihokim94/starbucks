package TextDecorate;

import javax.swing.JTextField;

public abstract class TextComponent extends JTextField{
	public abstract void decorate();
	TextComponent(String text){
		super(text);
	}
	public TextComponent() {
		super();
	}
}
