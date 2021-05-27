package decorate_jy;

public class BoundDecorator extends Decorator{
	private Component decoratedComponent;
	protected int x,y,w,h;
	
	public BoundDecorator(Component component,int x, int y, int w, int h) {
		super(component);
		this.x = x; this.y = y; this.w = w; this.h = h;
		
	} 
	@Override
	public void decorate() {
		super.decorate();
		decoratedComponent.setBounds(x,y,w,h);
	}
}
