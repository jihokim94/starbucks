package LabelDecorate;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HorizonDecorator extends LabelDecorator{

	public HorizonDecorator(LabelDecorator label) {
		this.label = label.getLabel();
		decorate();
	}
	public HorizonDecorator(JLabel label) {
		super(label);
		decorate();
	}
	public void decorate() {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
}
