package LabelDecorate;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class FontDecorator extends LabelDecorator {
	public String  font;
	public int     fontsize;
	
	public FontDecorator(LabelDecorator label, String font_, int fontsize_) {
		this.label = label.getLabel();
		font     = font_;
		fontsize = fontsize_;
		decorate();
	}
	public FontDecorator(JLabel label, String font_, int fontsize_) {
		super(label);
		font     = font_;
		fontsize = fontsize_;
		decorate();
	}
	@Override
	public void decorate() {
		label.setFont(new Font(font, Font.BOLD, fontsize));
	}
	
		
}
