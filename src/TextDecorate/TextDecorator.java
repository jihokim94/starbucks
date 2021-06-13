package TextDecorate;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextDecorator extends TextComponent{
	protected String text;
	protected JTextField textField = null;
	
	public TextDecorator(JTextField textField) {
		this.textField = textField;
	}
	public TextDecorator(String text) {
		super(text);
	}
	public TextDecorator() {super();}

	@Override
	public void decorate() {
	}
	public JTextField getTextField() {
		return textField;
	}

}
