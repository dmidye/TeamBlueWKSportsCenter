package Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class ForgotPasswordPanel extends JPanel {
	private JFrame owningFrame;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public ForgotPasswordPanel(JFrame owningFrame) throws IOException {
		
		this.owningFrame = owningFrame;
		
		Image loginImg = ImageIO.read(getClass().getResource("/Assets/back.png"));
		loginImg = loginImg.getScaledInstance(50, 50, 0);
		
		JLabel backButton = new JLabel("");
		backButton.setBounds(592, 530, 50, 50);
		backButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					try {
						changePanel(new LoginPanel(owningFrame));
					} catch (FontFormatException e1) {
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Image loginImg;
				try {
					loginImg = ImageIO.read(getClass().getResource("/Assets/backHovered.png"));
					loginImg = loginImg.getScaledInstance(50, 50, 0);
					backButton.setIcon(new ImageIcon(loginImg));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Image loginImg;
				try {
					loginImg = ImageIO.read(getClass().getResource("/Assets/back.png"));
					loginImg = loginImg.getScaledInstance(50, 50, 0);
					backButton.setIcon(new ImageIcon(loginImg));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		backButton.setIcon(new ImageIcon(loginImg));
		
		JLabel lblAccountRecovery = new JLabel("Account Recovery");
		lblAccountRecovery.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountRecovery.setBounds(381, 216, 458, 57);
		lblAccountRecovery.setFont(new Font("Arial", Font.PLAIN, 40));
		setLayout(null);
		add(backButton);
		add(lblAccountRecovery);
		
		JLabel lblPleaseStandBy = new JLabel("Please stand by,");
		lblPleaseStandBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseStandBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseStandBy.setBounds(381, 310, 458, 29);
		add(lblPleaseStandBy);
		
		JLabel lblThankYouFor = new JLabel("Thank you for your patience!");
		lblThankYouFor.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setBounds(381, 455, 458, 39);
		add(lblThankYouFor);
		
		JLabel lblNewLabel = new JLabel("an employee is on their way");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(381, 357, 458, 29);
		add(lblNewLabel);
		
		JLabel lblToResetYour = new JLabel("to reset your account.");
		lblToResetYour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblToResetYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblToResetYour.setBounds(381, 400, 458, 22);
		add(lblToResetYour);
		
		JLabel WhiteContainer = new JLabel("");
		WhiteContainer.setBounds(381, 134, 472, 507);
		WhiteContainer.setIcon(new ImageIcon(ForgotPasswordPanel.class.getResource("/Assets/LoginPanel.png")));
		add(WhiteContainer);

	}
	
	/////////////////////////////////////////////////////////////////////////
	//Draw with gradient background
		@Override
	    protected void paintComponent(Graphics g) {
			Color ulColor = new Color(247, 0, 225);
			Color lrColor = new Color(171, 0, 255);
			
			super.paintComponent(g);
			int x = getWidth();
			int y = getHeight();
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(new GradientPaint(new Point(0, 0), ulColor,
					new Point(x/2, y/2), lrColor, false));
			g2.fillRect(0, 0, x, y);
	    }
	
	public void changePanel(JPanel nextPanel) throws IOException {
		owningFrame.getContentPane().add(nextPanel);
		owningFrame.getContentPane().remove(this);
		owningFrame.revalidate();
	}
}

