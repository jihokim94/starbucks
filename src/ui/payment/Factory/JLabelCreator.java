package ui.payment.Factory;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelCreator extends Jcreator {

	@Override
	public JComponent create(String text, String font, int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		if(font != null) label.setFont(new Font(font, Font.BOLD, 12));
	    label.setBounds(x,y,w,h);
	    return label;
	}

	@Override
	public JComponent createWithIcon(String text, String iconText,int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		label.setIcon(new ImageIcon(iconText));
		if(x != -1)	label.setBounds(x,y,w,h);
		return label;
	}

	@Override
	public JComponent createWithHorizontal(String text, String font, int x, int y, int w, int h,int fontsize) {
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if(font != null) label.setFont(new Font(text, Font.BOLD, fontsize));
		if(x != -1) label.setBounds(x, y, w,h);
		return label;
	}

	@Override
	public JComponent createWithAlignment(String text) {
		// TODO Auto-generated method stub
		return null;
	}


}