package ButtonDecorate;

import javax.swing.JButton;

public abstract class ButtonComponent extends JButton{
	protected JButton button = null;
	public abstract void decorate();
	ButtonComponent(String text){
		super(text);
	}
	public ButtonComponent() {super();}
	public JButton getButton() {
		return button;
	}
}
