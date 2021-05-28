package LabelDecorate;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelHorizon extends LabelDecorator{

	public LabelHorizon(LabelDecorator label) {
		this.label = label.getLabel();
		decorate();
	}
	public LabelHorizon(JLabel label) {
		super(label);
		decorate();
	}
	public void decorate() {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
}
