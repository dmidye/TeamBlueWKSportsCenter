package Panels;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Assets.fonts;
import Data.AccountCreationTempStorage;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Database.DbManager;
import Database.databaseConnector;

import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

public class LoginPanel extends JPanel {
	private JTextField UsernameField;
	private JTextField PasswordField;
	private JFrame owningFrame;
	private databaseConnector databaseConnector;
	private AccountCreationTempStorage tempAccountStorage = new AccountCreationTempStorage();
	private fonts fontCatalog = new fonts();
	
	private JTextField newUsername;
	private JTextField newPassword;
	private JTextField newEmail;
	private JTextField newFirstName;
	private JTextField newLastName;
	private StaffView staffView;
	private JPanel MainPanel;

	/**
	 * This class encompasses the login screen, password recovery screen, and new account screens.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public LoginPanel(JFrame owningFrame) throws IOException, FontFormatException {
		this.owningFrame = owningFrame;
		databaseConnector = new databaseConnector();
		
		setBorder(null);
		setBackground(new Color(255, 255, 255));		
		
		MainPanel = new JPanel();
		MainPanel.setBounds(409, 159, 407, 450);
		MainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel LoginPanel = new JPanel();
		MainPanel.add(LoginPanel, "name_253020715779000");
		MainPanel.setBackground(new Color(232,232,232));
		LoginPanel.setToolTipText("");
		LoginPanel.setBackground(null);
		LoginPanel.setBorder(null);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(62, 193, 280, 37);
		UsernameField.setToolTipText("");
		UsernameField.setColumns(10);
		UsernameField.setBorder(null);
		TextPrompt usernamePrompt = new TextPrompt("Username", UsernameField);
		
		UsernameField.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				UsernameField.setBorder(null);
			}
		});
		
		PasswordField = new JTextField();
		PasswordField.setBounds(63, 260, 280, 37);
		PasswordField.setColumns(10);
		PasswordField.setBorder(null);
		TextPrompt passwordPrompt = new TextPrompt("Password", PasswordField);
		
		PasswordField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				PasswordField.setBorder(null);
			}
		});
		
		JLabel lblEitherYourUsername = new JLabel("Either your username or password is incorrect. Please try again.");
		lblEitherYourUsername.setBounds(19, 345, 368, 16);
		lblEitherYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEitherYourUsername.setForeground(Color.RED);
		lblEitherYourUsername.setVisible(false);
		
		JLabel LoginLabel = new JLabel("Log In");
		LoginLabel.setBounds(115, 63, 176, 47);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setFont(new Font("Arial", Font.BOLD, 40));
		
		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblForgotPassword.setBounds(256, 313, 97, 14);
		lblForgotPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblForgotPassword.setForeground(new Color(34, 139, 34));
		
		LoginPanel.setLayout(null);
		LoginPanel.add(LoginLabel);
		LoginPanel.add(lblEitherYourUsername);
		LoginPanel.add(lblForgotPassword);
		LoginPanel.add(PasswordField);
		LoginPanel.add(UsernameField);
		
		JPanel NewAccountPanel = new JPanel();
		NewAccountPanel.setBackground(new Color(232,232,232));
		MainPanel.add(NewAccountPanel, "name_253368529604700");
		NewAccountPanel.setLayout(null);
		
		JLabel lblCreateANew = new JLabel("New Account Creation");
		lblCreateANew.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCreateANew.setBounds(75, 62, 256, 32);
		NewAccountPanel.add(lblCreateANew);
		
		newUsername = new JTextField();
		newUsername.setBounds(183, 213, 148, 32);
		NewAccountPanel.add(newUsername);
		newUsername.setColumns(10);
		
		JLabel lblRequired = new JLabel("Required:");
		lblRequired.setHorizontalAlignment(SwingConstants.CENTER);
		lblRequired.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRequired.setBounds(160, 141, 86, 32);
		NewAccountPanel.add(lblRequired);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(75, 219, 86, 17);
		NewAccountPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(75, 262, 73, 20);
		NewAccountPanel.add(lblPassword);
		
		newPassword = new JTextField();
		newPassword.setBounds(183, 258, 148, 32);
		NewAccountPanel.add(newPassword);
		newPassword.setColumns(10);
		
		JLabel lblOptional = new JLabel("Optional:");
		lblOptional.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptional.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOptional.setBounds(167, 301, 89, 23);
		NewAccountPanel.add(lblOptional);
		
		JLabel lblUsedForAccount = new JLabel("Used for account recovery");
		lblUsedForAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsedForAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsedForAccount.setBounds(128, 335, 158, 17);
		NewAccountPanel.add(lblUsedForAccount);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(128, 363, 73, 20);
		NewAccountPanel.add(lblEmail);
		
		newEmail = new JTextField();
		newEmail.setBounds(211, 363, 148, 32);
		NewAccountPanel.add(newEmail);
		newEmail.setColumns(10);
		
		JButton btnContinueNewAccount = new JButton("Continue");
		btnContinueNewAccount.setBounds(265, 416, 89, 23);
		NewAccountPanel.add(btnContinueNewAccount);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(43, 416, 89, 23);
		NewAccountPanel.add(btnReturn);
		
		JLabel MissingUPError = new JLabel("Please fill out the required fields.");
		MissingUPError.setForeground(Color.RED);
		MissingUPError.setHorizontalAlignment(SwingConstants.CENTER);
		MissingUPError.setBounds(99, 116, 208, 14);
		NewAccountPanel.add(MissingUPError);
		MissingUPError.setVisible(false);
		
		JPanel FurtherInfoPanel = new JPanel();
		FurtherInfoPanel.setBackground(new Color(232,232,232));
		MainPanel.add(FurtherInfoPanel, "name_1256495724900");
		FurtherInfoPanel.setLayout(null);
		
		JLabel lblAddFutherInformation = new JLabel("Add Futher Information");
		lblAddFutherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFutherInformation.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddFutherInformation.setBounds(126, 58, 309, 37);
		FurtherInfoPanel.add(lblAddFutherInformation);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(126, 241, 89, 20);
		FurtherInfoPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(126, 297, 86, 20);
		FurtherInfoPanel.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(126, 343, 102, 26);
		FurtherInfoPanel.add(lblDateOfBirth);
		
		newFirstName = new JTextField();
		newFirstName.setBounds(238, 237, 197, 32);
		FurtherInfoPanel.add(newFirstName);
		newFirstName.setColumns(10);
		
		newLastName = new JTextField();
		newLastName.setBounds(238, 294, 197, 31);
		FurtherInfoPanel.add(newLastName);
		newLastName.setColumns(10);
		
		JButton btnReturn_1 = new JButton("Return");
		btnReturn_1.setBounds(48, 516, 89, 23);
		FurtherInfoPanel.add(btnReturn_1);
		
		JSpinner newBirthday = new JSpinner();
		newBirthday.setModel(new SpinnerDateModel(new Date(1576908000000L), null, null, Calendar.WEEK_OF_MONTH));
		newBirthday.setBounds(293, 343, 86, 31);
		newBirthday.setEditor(new JSpinner.DateEditor(newBirthday, "MM/dd/yyyy"));
		FurtherInfoPanel.add(newBirthday);
		
		JLabel missingFurtherInfo = new JLabel("Please fill out the required fields.");
		missingFurtherInfo.setForeground(Color.RED);
		missingFurtherInfo.setHorizontalAlignment(SwingConstants.CENTER);
		missingFurtherInfo.setBounds(174, 121, 212, 14);
		FurtherInfoPanel.add(missingFurtherInfo);
		missingFurtherInfo.setVisible(false);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(417, 516, 89, 23);
		FurtherInfoPanel.add(btnFinish);
		
		Image loginImg = ImageIO.read(getClass().getResource("/Assets/enter.png"));
		loginImg = loginImg.getScaledInstance(50, 50, 0);
		Image sepImg = ImageIO.read(getClass().getResource("/Assets/Line.png"));
		sepImg = sepImg.getScaledInstance(500, 50, 0);
		setLayout(null);
		add(MainPanel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		MainPanel.add(lblNewLabel_1, "name_104904377110100");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/signUpButton.png")));
		
		JLabel lblSignUp = new JLabel("New label");
		lblSignUp.setBounds(54, 372, 157, 57);
		LoginPanel.add(lblSignUp);
		lblSignUp.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/Group 27.png")));
		
		JLabel loginButton = new JLabel("");
		loginButton.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/SignInButton.png")));
		loginButton.setBounds(221, 372, 157, 57);
		LoginPanel.add(loginButton);
		
		JLabel label = new JLabel("");
		label.setBounds(50, 183, 317, 67);
		LoginPanel.add(label);
		label.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/PasswordBar.png")));
		
		JLabel LoginPanelBackground = new JLabel("");
		LoginPanelBackground.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/LoginPanel.png")));
		LoginPanelBackground.setBounds(381, 134, 472, 507);
		add(LoginPanelBackground);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(51, 250, 317, 67);
		LoginPanel.add(label_1);
		label_1.setIcon(new ImageIcon(LoginPanel.class.getResource("/Assets/PasswordBar.png")));
		
		
		///////Start of Button Functionality Addition  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		btnContinueNewAccount.addActionListener(new ActionListener() {   //New Account Button
			@Override
			public void actionPerformed(ActionEvent e) {
				if(newPassword.getText().equals("") || newUsername.getText().equals("")) {
					MissingUPError.setVisible(true);
				}
				else {
					tempAccountStorage.password = newPassword.getText();
					tempAccountStorage.username = newUsername.getText();
					if(!newEmail.getText().equals("")) {
						tempAccountStorage.email = newEmail.getText();
					}
					System.out.println(tempAccountStorage.password + " " + tempAccountStorage.username + " ");
					MissingUPError.setVisible(false);
					changeCurrentCard(FurtherInfoPanel);
				}
			}
		});
		
		lblSignUp.addMouseListener(new MouseListener() {     //Sign up Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				changeCurrentCard(NewAccountPanel);
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSignUp.setForeground(new Color(0,0,20));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		lblForgotPassword.addMouseListener(new MouseListener() {  //Forgot Password Button 
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					changePanel(new ForgotPasswordPanel(owningFrame));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					changePanel(new ForgotPasswordPanel(owningFrame));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		loginButton.addMouseListener(new MouseListener() {      //Login Button
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ResultSet rs;
				String username = UsernameField.getText();
				String password = PasswordField.getText();
				rs = databaseConnector.sendStatement("SELECT * FROM `user` WHERE `memberPswd` = \"" + password + "\" AND username = \"" + username + "\"");
				try {
					rs.next();
					String memberType = rs.getString("Status");
					String staffID = rs.getString("username");
					System.out.println(memberType);
					switch (memberType) { //Sign in based on member type
						case ("Admin"):
							new StaffView(staffID);
							break;
						case ("Member"):
							changePanel(new HomeScreen(owningFrame, username));
							break;
						case("FrontDesk"):
							new StaffView(staffID);
							break;
						case("Trainer"):
							new StaffView(staffID);
							break;
					}
					
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
					lblEitherYourUsername.setVisible(true);
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		btnReturn.addActionListener(new ActionListener() {   //Return from Account Creation Button Layer 1
			public void actionPerformed(ActionEvent e) {
				changeCurrentCard(LoginPanel);
			}
		});
		
		btnReturn_1.addActionListener(new ActionListener() {   // Return from Account Creation Button Layer 2
			public void actionPerformed(ActionEvent e) {
				changeCurrentCard(NewAccountPanel);
			}
		});
		
		btnFinish.addActionListener(new ActionListener() {    //Finish Account Creation Button
			public void actionPerformed(ActionEvent e) {
				if(newFirstName.getText().equals("") || newLastName.getText().equals("")) {
					missingFurtherInfo.setVisible(true);
				}
				else {
					missingFurtherInfo.setVisible(false);
					tempAccountStorage.firstName = newFirstName.getText();
					tempAccountStorage.lastName = newLastName.getText();
					String[] dateParts = newBirthday.getNextValue().toString().split(" ", 6);
					tempAccountStorage.birthday = dateParts[1] + "/" + dateParts[2] + "/" + dateParts[5];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/d/yyyy", Locale.ENGLISH);
					LocalDate date = LocalDate.parse(tempAccountStorage.birthday, formatter);
					System.out.println(date); // 2010-01-02
					int result = databaseConnector.sendUpdate("INSERT INTO `user` (`Username`, `memberFirst`, `memberLast`, `memberEmail`, `memberPswd`)"
							+ " VALUES (\"" + tempAccountStorage.username + "\", \"" + tempAccountStorage.firstName + "\", \"" + tempAccountStorage.lastName + "\", \"" + tempAccountStorage.email + "\", \"" + tempAccountStorage.password + "\")");
					newUsername.setText("");
					newFirstName.setText("");
					newLastName.setText("");
					newEmail.setText("");
					newPassword.setText("");
					changeCurrentCard(LoginPanel);
				}
			}
		});

	}
	
	///Start of Functions/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	//This function changes the visible panel to the one passed in and removes this panel from the view.
	public void changePanel(JPanel newPanel) throws IOException {
		owningFrame.getContentPane().add(newPanel);
		owningFrame.getContentPane().remove(this);
		owningFrame.revalidate();
	}
	
	//Changes the card shown to the one passed in
	public void changeCurrentCard(JPanel nextPanel) {
		MainPanel.removeAll();
		MainPanel.add(nextPanel);
		MainPanel.repaint();
		MainPanel.revalidate();
	}
}
