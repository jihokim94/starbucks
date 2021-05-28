package ButtonDecorate;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;

public class FontDecorator extends ButtonDecorator {
	public String  font;
	public int     fontsize,fontStyle;
	
	public FontDecorator(ButtonDecorator button, String font_, int fontsize_,int fontStyle_) {
		this.button = button.getButton();
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	public FontDecorator(JButton button, String font_, int fontsize_,int fontStyle_) {
		super(button);
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	@Override
	public void decorate() {
		button.setFont(new Font(font, fontStyle, fontsize));
	}
	
		
}
