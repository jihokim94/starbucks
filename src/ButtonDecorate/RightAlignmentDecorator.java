package ButtonDecorate;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RightAlignmentDecorator extends ButtonDecorator{
	
	public RightAlignmentDecorator(ButtonDecorator button,String imageText) {
		this.button = button.getButton();
	}
	public RightAlignmentDecorator(JButton button,String imageText) {
		super(button);
	}
	@Override
	public void decorate() {
		super.decorate();
		button.setAlignmentX(this.RIGHT_ALIGNMENT);
	}
}
