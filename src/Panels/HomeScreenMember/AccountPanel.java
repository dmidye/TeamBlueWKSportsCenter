package Panels.HomeScreenMember;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Database.databaseConnector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AccountPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private String username;
	private databaseConnector databaseConnector;
	
	public AccountPanel(String username) {
		this.username = username;
		
		setBackground(new Color(243,243,243));
		setLayout(null);
		
		
		ResultSet rs;
		databaseConnector = new databaseConnector();
		rs = databaseConnector.sendStatement("SELECT memberFirst, memberLast, Username, memberEmail, memberBday, phone, areaCode FROM `user` WHERE Username = \"" + username + "\"");
		try {
			rs.next();
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(243,243,243));
			panel.setBounds(477, 58, 721, 288);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblBasicInfo = new JLabel("Personal Information");
			lblBasicInfo.setBounds(25, 22, 278, 32);
			panel.add(lblBasicInfo);
			lblBasicInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(43, 203, 90, 25);
			panel.add(lblPassword);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(43, 103, 59, 25);
			panel.add(lblName);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblNameTestLabel = new JLabel("");
			lblNameTestLabel.setBounds(127, 103, 189, 25);
			panel.add(lblNameTestLabel);
			lblNameTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNameTestLabel.setText(rs.getString(1) + " " + rs.getString(2));
			
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setBounds(282, 203, 100, 25);
			panel.add(lblUsername);
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblUsernameTestLabel = new JLabel("");
			lblUsernameTestLabel.setBounds(392, 199, 189, 32);
			panel.add(lblUsernameTestLabel);
			lblUsernameTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUsernameTestLabel.setText(rs.getString(3));
			
			JLabel label = new JLabel("");
			label.setBounds(0, 0, 696, 294);
			panel.add(label);
			label.setIcon(new ImageIcon(AccountPanel.class.getResource("/Assets/PersonalPanel.png")));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(243,243,243));
			panel_1.setBounds(80, 349, 807, 316);
			add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblPhonenumber = new JLabel("(" + Integer.toString(rs.getInt("areaCode")) + ") " + Integer.toString(rs.getInt("phone")));
			lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhonenumber.setBounds(179, 213, 158, 19);
			panel_1.add(lblPhonenumber);
			
			JLabel lblBirthday = new JLabel("Birthday");
			lblBirthday.setBounds(408, 210, 83, 25);
			panel_1.add(lblBirthday);
			lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblBirthdayTestLabel = new JLabel("");
			lblBirthdayTestLabel.setBounds(501, 210, 189, 25);
			panel_1.add(lblBirthdayTestLabel);
			lblBirthdayTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblBirthdayTestLabel.setText(rs.getString(5));
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(36, 123, 59, 25);
			panel_1.add(lblEmail);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblEmailTestLabel = new JLabel("");
			lblEmailTestLabel.setBounds(179, 123, 189, 25);
			panel_1.add(lblEmailTestLabel);
			lblEmailTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblEmailTestLabel.setText(rs.getString(4));
			
			JLabel lblContactInformation = new JLabel("Contact Information");
			lblContactInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblContactInformation.setBounds(36, 25, 266, 32);
			panel_1.add(lblContactInformation);
			
			JLabel lblHealthInformation = new JLabel("Health Information");
			lblHealthInformation.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblHealthInformation.setBounds(408, 28, 251, 29);
			panel_1.add(lblHealthInformation);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhoneNumber.setBounds(35, 206, 138, 32);
			panel_1.add(lblPhoneNumber);
			
			JLabel lblHeight = new JLabel("Height");
			lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHeight.setBounds(408, 123, 59, 25);
			panel_1.add(lblHeight);
			
			JLabel label_1 = new JLabel("");
			label_1.setBounds(-4, 0, 812, 327);
			panel_1.add(label_1);
			label_1.setIcon(new ImageIcon(AccountPanel.class.getResource("/Assets/ContactPanel.png")));
			
			JPanel photoHolder = new JPanel();
			photoHolder.setBackground(Color.WHITE);
			photoHolder.setBounds(80, 26, 300, 300);
			add(photoHolder);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(888, 433, 288, 132);
			add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon(AccountPanel.class.getResource("/Assets/EditProfileButton.png")));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
