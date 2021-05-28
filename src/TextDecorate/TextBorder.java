package TextDecorate;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TextBorder extends TextDecorator{
	protected int lr,lg,lb;
	
	public TextBorder(TextDecorator textField,int lr, int lg, int lb) {
		this.textField = textField.getTextField();
		this.lr = lr; this.lg = lg; this.lb = lb; 
		decorate();
		
	} 
	public TextBorder(JTextField textField,int lr, int lg, int lb) {
		super(textField);
		this.lr = lr; this.lg = lg; this.lb = lb; 
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		textField.setBorder(new LineBorder(new Color(lb,lg,lb)));
	}
}
