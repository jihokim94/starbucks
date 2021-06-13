package PanelDecorate;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDecorator extends PanelComponent {
	protected JPanel panel = null;
	
	public PanelDecorator(JPanel panel) {
		this.panel = panel;
		}
	public PanelDecorator() {super();}

	@Override
	public void decorate() {
		// TODO Auto-generated method stub
		
	}
	public JPanel getPanel() {
		return panel;
	}
}
