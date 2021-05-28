package LabelDecorate;

import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class LabelComponent extends JLabel {
	protected JLabel label =null;
	public abstract void decorate();
	LabelComponent(String text){
		super(text);
	}
	public LabelComponent() {
		super();
	}
	public JLabel getLabel() {
		return label;
	}
}
