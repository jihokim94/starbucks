package PanelDecorate;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import TextDecorate.TextDecorator;

public class PanelLayout extends PanelDecorator{
	protected int x=-1,y=-1;
	public PanelLayout(PanelDecorator panel) {
		this.panel = panel.getPanel();
		decorate();
		
	} 
	public PanelLayout(JPanel panel) {
		super(panel);
		decorate();
	} 
	public PanelLayout(PanelDecorator panel,int x, int y) {
		this.panel = panel.getPanel();
		this.x = x; this.y =y;
		decorate();
		
	} 
	public PanelLayout(JPanel panel,int x, int y) {
		super(panel);
		this.x = x; this.y =y;
		decorate();
	} 
	

	@Override
	public void decorate() {
		//super.decorate();
		if(x<0 || y<0) 		panel.setLayout(null);
		else panel.setLayout(new BorderLayout(x,y));
	}
}
