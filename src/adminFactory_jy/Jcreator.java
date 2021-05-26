package adminFactory_jy;

import javax.swing.JComponent;

public abstract class Jcreator {
	public abstract JComponent create(String text,String font, int x, int y, int w, int h);
	public abstract JComponent createWithIcon(String text, String iconText,int x, int y, int w, int h);
	public abstract JComponent createWithHorizontal(String text, String font, int x, int y, int w, int h,int fontsize);
	public abstract JComponent createWithAlignment(String text);
}
