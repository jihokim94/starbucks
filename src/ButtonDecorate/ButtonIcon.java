package ButtonDecorate;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonIcon extends ButtonDecorator{
	protected String  imageText;
	
	public ButtonIcon(ButtonDecorator button,String imageText) {
		this.button = button.getButton();
		this.imageText = imageText;
		decorate();
	}
	public ButtonIcon(JButton button,String imageText) {
		super(button);
		this.imageText = imageText;
		decorate();
	}
	@Override
	public void decorate() {
		super.decorate();
		button.setIcon(new ImageIcon(imageText));
		
	}
}
