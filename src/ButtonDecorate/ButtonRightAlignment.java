package ButtonDecorate;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonRightAlignment extends ButtonDecorator{
	
	public ButtonRightAlignment(ButtonDecorator button) {
		this.button = button.getButton();
		decorate();
	}
	public ButtonRightAlignment(JButton button) {
		super(button);
		decorate();
	}
	@Override
	public void decorate() {
		super.decorate();
		button.setAlignmentX(this.RIGHT_ALIGNMENT);
	}
}
