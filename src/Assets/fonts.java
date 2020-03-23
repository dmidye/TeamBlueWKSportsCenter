package Assets;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class fonts {
	public static Font lobster;
	public static Font lobster20;
	public static Font lobster30;
	
	public fonts() {
		//lobster = null;
//		try {
//			lobster = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("Lobster-Regular.ttf"));
//		}
//		catch(IOException|FontFormatException e) {
//			e.printStackTrace();
//		}
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		lobster20 = lobster.deriveFont(Font.PLAIN,20);
//		lobster30 = lobster.deriveFont(Font.PLAIN,30);
//		ge.registerFont(lobster30);
//		ge.registerFont(lobster20);
	}
}
