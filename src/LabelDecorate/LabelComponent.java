package LabelDecorate;

import javax.swing.JLabel;

public abstract class LabelComponent extends JLabel {


	protected String text;
	protected JLabel label =null;
	public abstract void decorate();
	public LabelComponent(String text){
		super(text);
	}
	public LabelComponent() {
		super();
	}
}
