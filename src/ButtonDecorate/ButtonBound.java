package ButtonDecorate;

import javax.swing.JButton;

import LabelDecorate.LabelDecorator;

public class ButtonBound extends ButtonDecorator{
	protected int x,y,w,h;
	public ButtonBound(ButtonDecorator button, int x, int y, int w, int h) {
		this.button = button.getButton();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
	}
	public ButtonBound(JButton button, int x, int y, int w, int h) {
		super(button);
		this.x = x; this.y=y; this.w=w; this.h=h;
		decorate();
	}

	@Override
	public void decorate() {
		//super.decorate();
		button.setBounds(x,y,w,h);
	}
}