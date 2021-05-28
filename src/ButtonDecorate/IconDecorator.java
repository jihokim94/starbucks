package ButtonDecorate;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconDecorator extends ButtonDecorator{
	protected String  imageText;
	
	public IconDecorator(ButtonDecorator button,String imageText) {
		this.button = button.getButton();
		this.imageText = imageText;
	}
	public IconDecorator(JButton button,String imageText) {
		super(button);
		this.imageText = imageText;
	}
	@Override
	public void decorate() {
		super.decorate();
		button.setIcon(new ImageIcon(imageText));
		
	}
}
