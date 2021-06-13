package LabelDecorate;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LabelBound extends LabelDecorator{
	protected int x,y,w,h;
	
	public LabelBound(LabelDecorator label,int x, int y, int w, int h) {
		this.label = label.getLabel();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	public LabelBound(JLabel label,int x, int y, int w, int h) {
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
