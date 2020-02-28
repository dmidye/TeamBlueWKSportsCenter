package Panels;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class welcomeBanner extends JPanel {
	//This class is background of the navigation bar.
	//
	

	//Deal with gradient background
	private static final Color ulColor = new Color(247,0, 255);
	private static final Color lrColor = new Color(171,0,255);
	
	public welcomeBanner() {

	}
	
	@Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       int x = getWidth();
       int y = getHeight();
       Graphics2D g2 = (Graphics2D) g;
       g2.setPaint(new GradientPaint(new Point(0, 0), ulColor,
                new Point(x/2, y/2), lrColor, false));
       g2.fillRect(0, 0, x, y);
    }

}
