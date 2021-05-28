package ButtonDecorate;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonRightAlignment extends ButtonDecorator{
	
	public ButtonRightAlignment(ButtonDecorator button,String imageText) {
		this.button = button.getButton();
	}
	public ButtonRightAlignment(JButton button,String imageText) {
		super(button);
	}
	@Override
	public void decorate() {
		super.decorate();
		button.setAlignmentX(this.RIGHT_ALIGNMENT);
	}
}
