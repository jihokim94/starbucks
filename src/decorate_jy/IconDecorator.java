package decorate_jy;

import javax.swing.ImageIcon;

public class IconDecorator extends Decorator{
	private Component decoratedComponent;
	protected String  imageText;
	
	public IconDecorator(Component component,String imageText) {
		super(component);
		this.imageText = imageText;
	}
	@Override
	public void decorate() {
		super.decorate();
		decoratedComponent.setIcon(new ImageIcon(iconText));
		decoratedComponent.setAli
	}
}
