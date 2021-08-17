package PanelDecorate;

import javax.swing.JPanel;
public abstract class PanelComponent extends JPanel{
	public abstract void decorate();
	public PanelComponent() {
		super();
	}
}
