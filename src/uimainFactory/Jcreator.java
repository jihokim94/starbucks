package uimainFactory;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class Jcreator {
	public abstract JComponent create(String text,String font, int x, int y, int width, int height);
	public abstract JComponent createWithIcon(String text, String iconText,int x, int y, int width, int height);
	public abstract JComponent createWithFont(String text, String font,int PlainBold, int x, int y, int width, int height,int fontsize);
	public abstract JComponent createWithAlignment(String text,String font, int x, int y, int w, int h,int Alignment);
}