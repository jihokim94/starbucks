package ui.payment.util;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/*
 * 디스플레이 설정화면
 */
public class Display {
	private static final int SCREEN_HEIGHT;
	private static final int WINDOWS_TITLEBAR_HEIGHT;

	public static final int WINDOWS_WIDTH, WINDOWS_HEIGHT;
	public static final int WINDOWS_HALF_WIDTH;
	public static final int WINDOWS_AVALIABLE_HEIGHT;

	static {
	    Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
	    SCREEN_HEIGHT = (int) dimen.getHeight();
	
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Rectangle rec = ge.getMaximumWindowBounds();
	    WINDOWS_WIDTH = (int) rec.getWidth();
	    WINDOWS_HEIGHT = (int) rec.getHeight();
	    
	    WINDOWS_HALF_WIDTH = WINDOWS_WIDTH / 2;
	    WINDOWS_TITLEBAR_HEIGHT = SCREEN_HEIGHT - WINDOWS_HEIGHT;
	    WINDOWS_AVALIABLE_HEIGHT = WINDOWS_HEIGHT - WINDOWS_TITLEBAR_HEIGHT;
	}
	
	private Display() {
		throw new AssertionError();
	}
}
