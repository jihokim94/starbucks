package TextDecorate;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TextForeGroud extends TextDecorator{
	protected int fr,fg,fb;
	
	public TextForeGroud(TextDecorator textField,int fr, int fg, int fb) {
		this.textField = textField.getTextField();
		this.fr = fr; this.fg = fg; this.fb = fb; 
		decorate();
		
	} 
	public TextForeGroud(JTextField textField,int fr, int fg, int fb) {
		super(textField);
		this.fr = fr; this.fg = fg; this.fb = fb; 
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		textField.setForeground(new Color(fr,fg,fb));
	}
}
