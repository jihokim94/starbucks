package decorate_jy;

import javax.swing.JLabel;

public class BoundDecorator extends Decorator{
	protected int x,y,w,h;
	
	public BoundDecorator(LabelComponent component,int x, int y, int w, int h) {
		super(component);
		this.x = x; this.y = y; this.w = w; this.h = h;
		
	} 
	@Override
	public void decorate() {
		super.decorate();
		decoratedComponent.setBounds(x,y,w,h);
	}
}
