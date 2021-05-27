package decorate_jy;

import javax.swing.ImageIcon;

public class IconDecorator extends Decorator{
	protected String  imageText;
	
	public IconDecorator(LabelComponent component,String imageText) {
		super(component);
		this.imageText = imageText;
	}
	@Override
	public void decorate() {
		super.decorate();
		decoratedComponent.setIcon(new ImageIcon(imageText));
		
	}
}
