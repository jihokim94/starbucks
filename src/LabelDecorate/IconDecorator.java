package LabelDecorate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconDecorator extends LabelDecorator{
	protected String  imageText;
	
	public IconDecorator(LabelDecorator label,String imageText) {
		this.label = label.getLabel();
		this.imageText = imageText;
	}
	public IconDecorator(JLabel label,String imageText) {
		super(label);
		this.imageText = imageText;
	}
	@Override
	public void decorate() {
		super.decorate();
		label.setIcon(new ImageIcon(imageText));
		
	}
}
