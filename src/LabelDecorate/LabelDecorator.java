package LabelDecorate;

import javax.swing.JLabel;

public class LabelDecorator extends LabelComponent {



	public LabelDecorator(JLabel label) {
		this.label = label;
	}
	public LabelDecorator(String text) {
		super(text);
	}
	public LabelDecorator() {}

	@Override
	public void decorate() {
	}

	public JLabel getLabel() {
		return label;
	}
}
