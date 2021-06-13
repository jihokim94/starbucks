package PanelDecorate;

import java.awt.Color;

import javax.swing.JPanel;


public class PanelBackground extends PanelDecorator {
	protected int br,bg,bb;
	public PanelBackground(PanelDecorator panel,int br, int bg, int bb) {
		this.panel = panel.getPanel();
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	public PanelBackground(JPanel panel,int br, int bg, int bb) {
		super(panel);
		this.br= br; this.bb =bb; this.bg = bg;
		decorate();
	}
	@Override
	public void decorate(){
		panel.setBackground(new Color(br,bg,bb));
	}
}
