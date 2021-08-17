package LabelDecorate;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelFont extends LabelDecorator {
	public String  font;
	public int     fontsize, fontStyle;
	
	public LabelFont(LabelDecorator label, String font_,int fontStyle_, int fontsize_) {
		this.label = label.getLabel();
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	public LabelFont(JLabel label, String font_,int fontStyle_, int fontsize_) {
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
