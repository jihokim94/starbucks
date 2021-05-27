package decorate_jy;

import java.awt.Font;

import javax.swing.JComponent;

public class FontDecorator extends Decorator {
	private Component decoratedComponent;
	protected String  font;
	protected int     fontsize;
	
	public FontDecorator(Component component, String font_, int fontsize_) {
		super(component);
		font     = font_;
		fontsize = fontsize_;
	}

	@Override
	public void decorate() {
		super.decorate();
		decoratedComponent.setFont(new Font(font, Font.BOLD, fontsize));
		
	}
		
}
