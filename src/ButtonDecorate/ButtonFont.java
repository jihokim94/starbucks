package ButtonDecorate;

import java.awt.Font;

import javax.swing.JButton;

public class ButtonFont extends ButtonDecorator {
	public String  font;
	public int     fontsize,fontStyle;
	
	public ButtonFont(ButtonDecorator button, String font_,int fontStyle_, int fontsize_) {
		this.button = button.getButton();
		font     = font_;
		fontsize = fontsize_;
		fontStyle = fontStyle_;
		decorate();
	}
	public ButtonFont(JButton button, String font_,int fontStyle_, int fontsize_) {
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
