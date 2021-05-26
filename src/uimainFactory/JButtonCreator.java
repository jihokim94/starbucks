package uimainFactory;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class JButtonCreator extends Jcreator{

	@Override
	public JComponent create(String text, String font, int x, int y, int width, int height) {
		JButton button = new JButton(text);
	    button.setFont(new Font(font, Font.BOLD, 13));
	    button.setForeground(new Color(0, 0, 0));
	    button.setBackground(new Color(0, 102, 51));
	    button.setBounds(x,y,width,height);
		return button;
	}

	@Override
	public JComponent createWithIcon(String text, String iconText, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setIcon(new ImageIcon(iconText));
		button.setBounds(x,y,width,height);
		return button;
	}

	@Override
	public JComponent createWithFont(String text, String font,int PlainBold, int x, int y, int width, int height,int fontsize) {
		JButton button = new JButton(text);
	    button.setFont(new Font(font, PlainBold, fontsize));
	    button.setForeground(new Color(0, 0, 0));
	    button.setBackground(new Color(0, 102, 51));
	    button.setBounds(x,y,width,height);
		return button;
	}

	@Override
	public JComponent createWithAlignment(String text,String font, int x, int y, int width, int height,int Alignment) {
		JButton button = new JButton(text);
		button.setAlignmentX(Alignment);
		button.setFont(new Font(font, Font.BOLD, 15));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0,121,51));
		button.setBounds(x,y,width,height);
		return button;
	}

	

}
