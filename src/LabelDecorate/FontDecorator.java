package LabelDecorate;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class FontDecorator extends LabelDecorator {
	public String  font;
	public int     fontsize, fontStyle;
	
	public FontDecorator(LabelDecorator label, String font_, int fontsize_,int fontStyle_) {
		this.label = label.getLabel();
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	public FontDecorator(JLabel label, String font_, int fontsize_,int fontStyle_) {
		super(label);
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	@Override
	public void decorate() {
		label.setFont(new Font(font, fontStyle, fontsize));
	}
	
		
}
