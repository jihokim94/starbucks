package LabelDecorate;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HorizonDecorator extends LabelDecorator{

	public HorizonDecorator(LabelDecorator label) {
		this.label = label.getLabel();
		
	}
	public HorizonDecorator(JLabel label) {
		super(label);
		
	}
	public void decorate() {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
}
