package TextDecorate;

import javax.swing.JTextField;

public class NonTextEditable extends TextDecorator{
	public NonTextEditable(TextDecorator textField) {
		this.textField = textField.getTextField();
		decorate();
		
	} 
	public NonTextEditable(JTextField textField) {
		super(textField);
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		textField.setEditable(false);
	}
}
