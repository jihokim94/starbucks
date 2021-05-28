package ButtonDecorate;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonForeGround extends ButtonDecorator{
	protected int br,bg,bb;
	public ButtonForeGround(ButtonDecorator button,int br, int bg, int bb) {
		this.button = button.getButton();
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	public ButtonForeGround(JButton button,int br, int bg, int bb) {
		super(button);
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	@Override
	public void decorate(){
		button.setForeground(new Color(br,bg,bb));
	}

}
