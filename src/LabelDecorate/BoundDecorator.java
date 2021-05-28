package LabelDecorate;

import javax.swing.JLabel;

public class BoundDecorator extends LabelDecorator{
	protected int x,y,w,h;
	
	public BoundDecorator(LabelDecorator label,int x, int y, int w, int h) {
		this.label = label.getLabel();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	public BoundDecorator(JLabel label,int x, int y, int w, int h) {
		super(label);
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	@Override
	public void decorate() {
		//super.decorate();
		label.setBounds(x,y,w,h);
	}
}
