package ButtonDecorate;

import javax.swing.JButton;

public abstract class ButtonComponent extends JButton{
	
	public abstract void decorate();
	ButtonComponent(String text){
		super(text);
	}
	public ButtonComponent() {super();}


}
