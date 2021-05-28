package TextDecorate;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class TextBound extends TextDecorator{
protected int x,y,w,h;
	
	public TextBound(TextDecorator textField,int x, int y, int w, int h) {
		this.textField = textField.getTextField();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	public TextBound(JTextField textField,int x, int y, int w, int h) {
		super(textField);
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		textField.setBounds(x,y,w,h);
	}
}
