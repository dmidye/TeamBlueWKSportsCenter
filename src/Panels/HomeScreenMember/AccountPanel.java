package Panels.HomeScreenMember;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Database.databaseConnector;
import Panels.HomeScreen;
import Panels.LoginPanel;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AccountPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private String username;
	private databaseConnector databaseConnector;
	JLabel PhotoHolder;
	private boolean updating = false;
	public HomeScreen homeScreen;
	
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
			
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(43, 103, 59, 25);
			panel.add(lblName);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblNameTestLabel = new JLabel("");
			lblNameTestLabel.setBounds(127, 103, 189, 25);
			panel.add(lblNameTestLabel);
			lblNameTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNameTestLabel.setText(rs.getString(1) + " " + rs.getString(2));
			
			JLabel lblUsername = new JLabel("Username:");
			lblUsername.setBounds(43, 198, 100, 25);
			panel.add(lblUsername);
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblUsernameTestLabel = new JLabel("");
			lblUsernameTestLabel.setBounds(153, 194, 189, 32);
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
			
			JLabel lblThereIsAn = new JLabel("There is an error in your format");
			lblThereIsAn.setForeground(Color.RED);
			lblThereIsAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblThereIsAn.setBounds(408, 219, 234, 14);
			panel_1.add(lblThereIsAn);
			
			JTextField lblPhonenumber = new JTextField(rs.getString(5));
			lblPhonenumber.setEditable(false);
			lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhonenumber.setBounds(183, 209, 158, 32);
			panel_1.add(lblPhonenumber);
			
			JLabel lblBirthday = new JLabel("Birthday:");
			lblBirthday.setBounds(408, 123, 83, 25);
			panel_1.add(lblBirthday);
			lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JTextField lblBirthdayTestLabel = new JTextField("");
			lblBirthdayTestLabel.setEditable(false);
			lblBirthdayTestLabel.setBounds(499, 120, 189, 32);
			panel_1.add(lblBirthdayTestLabel);
			lblBirthdayTestLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblBirthdayTestLabel.setText(rs.getString(5));
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(36, 123, 59, 25);
			panel_1.add(lblEmail);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JTextField lblEmailTestLabel = new JTextField("");
			lblEmailTestLabel.setEditable(false);
			lblEmailTestLabel.setBounds(105, 120, 266, 32);
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
			
			JLabel lblPhoneNumber = new JLabel("Phone Number:");
			lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhoneNumber.setBounds(35, 206, 138, 32);
			panel_1.add(lblPhoneNumber);
			
			JLabel label_1 = new JLabel("");
			label_1.setBounds(-4, 0, 812, 327);
			panel_1.add(label_1);
			label_1.setIcon(new ImageIcon(AccountPanel.class.getResource("/Assets/ContactPanel.png")));
			
			PhotoHolder = new JLabel("");
			PhotoHolder.setIcon(null);
			PhotoHolder.setBounds(99, 29, 327, 327);
			add(PhotoHolder);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setBounds(989, 491, 89, 23);
			add(btnUpdate);
			
			JButton deleteButton = new JButton("Delete Account");
			deleteButton.setBounds(973, 525, 120, 23);
			add(deleteButton);
			SetAccountProfilePic();
			
			lblThereIsAn.setVisible(false);
			
			btnUpdate.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!updating) {
						updating = true;
						btnUpdate.setText("Finish");
						lblEmailTestLabel.setEditable(true);
						lblPhonenumber.setEditable(true);
						lblBirthdayTestLabel.setEditable(true);
					}
					else {
						try {
							lblThereIsAn.setVisible(false);
							String number = lblPhonenumber.getText();
							String[] parts = number.split("-");
							String date = lblPhonenumber.getText();
							String[] dateParts = lblBirthdayTestLabel.getText().split("-");
							System.out.println(dateParts[2]);
							databaseConnector.sendUpdate("UPDATE `user` SET `memberEmail` = \"" + lblEmailTestLabel.getText() + "\", `areaCode` = \"" + parts[0] + "\", `phone` = \"" + parts[1] + parts[2] + "\", `memberBday` = \"" + lblBirthdayTestLabel.getText() + "\" WHERE username = \"" + username + "\"");
							updating = false;
							btnUpdate.setText("Update");
							lblEmailTestLabel.setEditable(false);
							lblPhonenumber.setEditable(false);
							lblBirthdayTestLabel.setEditable(false);
						}
						catch(Exception j) {
							j.printStackTrace();
							lblThereIsAn.setVisible(true);
						}
					}
					
				}
				
			});
			
			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					databaseConnector.sendUpdate("DELETE FROM `user` WHERE `username` = \"" + username + "\"");
					homeScreen.logOut();	
				}
			
			});
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void SetAccountProfilePic() {
		try {
		PhotoHolder.setIcon(new ImageIcon(AccountPanel.class.getResource("/Photos/" + username + ".png")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
