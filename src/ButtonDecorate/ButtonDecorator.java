package ButtonDecorate;

import javax.swing.JButton;

public class ButtonDecorator extends ButtonComponent  {

	protected JButton button = null;
	protected String text;
	public ButtonDecorator(JButton button) {
		this.button = button;
	}
	public ButtonDecorator(String text) {
		super(text);
	}
	public ButtonDecorator() {}
	@Override
	public void decorate() {
		
		
	}
	public JButton getButton() {
		return button;
	}
}
