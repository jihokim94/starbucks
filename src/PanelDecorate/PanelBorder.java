package PanelDecorate;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import TextDecorate.TextDecorator;

public class PanelBorder extends PanelDecorator {
	protected int x,y,w,h;
	
	public PanelBorder(PanelDecorator panel, int x, int y, int w, int h) {
		this.panel = panel.getPanel();
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 
	public PanelBorder(JPanel panel, int x, int y, int w, int h) {
		super(panel);
		this.x = x; this.y = y; this.w = w; this.h = h;
		decorate();
		
	} 

	@Override
	public void decorate() {
		//super.decorate();
		panel.setBorder(new EmptyBorder(x,y,w,h));
	}

}
