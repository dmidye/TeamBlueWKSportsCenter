package Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
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

public class ForgotPasswordPanel extends JPanel {
	private JTextField UsernameField;
	private JTextField EmailField;
	private JFrame owningFrame;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public ForgotPasswordPanel(JFrame owningFrame) throws IOException {
		
		this.owningFrame = owningFrame;
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		
		JLabel lblAccountRecovery = new JLabel("Account Recovery");
		lblAccountRecovery.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
		
		JButton btnSendRecoveryEmail = new JButton("Send Recovery Email");
		btnSendRecoveryEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("");
		
		JLabel lblPleaseProvideEither = new JLabel("Please Provide Either Your");
		lblPleaseProvideEither.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		TextPrompt EmailPrompt = new TextPrompt("Email Address", EmailField);
		
		EmailField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				EmailField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
			}

			@Override
			public void focusLost(FocusEvent e) {
				EmailField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
				
			}
		});
		
		UsernameField = new JTextField();
		UsernameField.setToolTipText("");
		UsernameField.setColumns(10);
		UsernameField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		TextPrompt usernamePrompt = new TextPrompt("Username", UsernameField);
		
		UsernameField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				UsernameField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
			}

			@Override
			public void focusLost(FocusEvent e) {
				UsernameField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
				
			}
		});
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblOr = new JLabel("Or");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel backButton = new JLabel("");
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
		
		Image loginImg = ImageIO.read(getClass().getResource("/Assets/back.png"));
		loginImg = loginImg.getScaledInstance(50, 50, 0);
		backButton.setIcon(new ImageIcon(loginImg));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(537, Short.MAX_VALUE)
					.addComponent(label_3)
					.addGap(35))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(backButton)
					.addGap(464))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOr)
						.addComponent(lblPleaseProvideEither))
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(179)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(EmailField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblAccountRecovery)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblEmailAddress)
								.addComponent(btnSendRecoveryEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblUsername)))
					.addGap(185))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(69)
					.addComponent(lblAccountRecovery)
					.addGap(38)
					.addComponent(lblPleaseProvideEither)
					.addGap(46)
					.addComponent(lblUsername)
					.addGap(18)
					.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblOr)
					.addGap(9)
					.addComponent(lblEmailAddress)
					.addGap(18)
					.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(label_3)
					.addGap(27)
					.addComponent(btnSendRecoveryEmail, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(backButton)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(334, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)
					.addGap(318))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void changePanel(JPanel nextPanel) throws IOException {
		owningFrame.getContentPane().add(nextPanel);
		owningFrame.getContentPane().remove(this);
		owningFrame.revalidate();
	}
}
