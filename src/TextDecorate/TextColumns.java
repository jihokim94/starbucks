package TextDecorate;

import javax.swing.JTextField;

public class TextColumns extends TextDecorator{
	protected int c;
	public TextColumns(TextDecorator textField,int c) {
		this.textField = textField.getTextField();
		this.c =c;
		decorate();
		
	} 
	public TextColumns(JTextField textField,int c) {
		super(textField);
		this.c =c;
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		textField.setColumns(c);
	}
}
