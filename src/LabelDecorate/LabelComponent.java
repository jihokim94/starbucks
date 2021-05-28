package LabelDecorate;

import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class LabelComponent extends JLabel {
	public abstract void decorate();
	public LabelComponent(String text){
		super(text);
	}
	public LabelComponent() {
		super();
	}
}
