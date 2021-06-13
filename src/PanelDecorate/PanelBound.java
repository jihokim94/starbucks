package PanelDecorate;

import javax.swing.JPanel;

public class PanelBound extends PanelDecorator{
	protected int x,y,w,h;
	
	public PanelBound(PanelDecorator panel,int x, int y, int w, int h) {
		this.panel = panel.getPanel();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	public PanelBound(JPanel panel,int x, int y, int w, int h) {
		super(panel);
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		panel.setBounds(x,y,w,h);
	}

}
