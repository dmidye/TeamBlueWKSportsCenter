package OtherPanels;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Database.DbManager;


public class AssessmentView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton bodyComp;
	JButton aerobicCapacity;
	JButton strengthAndFlex;
	JButton coronaryRisk;
	JButton addNote;
	JButton back;
	String staffID;
	
	public AssessmentView(String staffID) {
			this.staffID = staffID;
		
			setTitle("Assessment View");
			setSize(1200, 675);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
			
			setLayout(new BorderLayout());
			JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
			add(background);
			background.setLayout(null);
			
			//new user button
			bodyComp = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/BodyCompButton.png")));
			bodyComp.setBounds(320, 71, 273, 242);
			bodyComp.setOpaque(false);
			bodyComp.setContentAreaFilled(false);
			bodyComp.setBorderPainted(false);
			bodyComp.setFocusPainted(false);
			bodyComp.addActionListener(new bodyCompAssessment());
			background.add(bodyComp);
			
			//memberLookUp
			aerobicCapacity = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/AerobicCapcityButton.png")));
			aerobicCapacity.setBounds(620, 71, 273, 242);
			aerobicCapacity.setOpaque(false);
			aerobicCapacity.setContentAreaFilled(false);
			aerobicCapacity.setBorderPainted(false);
			aerobicCapacity.setFocusPainted(false);
			aerobicCapacity.addActionListener(new AerobicCapacityAssessment());
			
			background.add(aerobicCapacity);
			
			//strengthAndFlex
			//TODO: strength and flex form
			strengthAndFlex = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/StrengthandFlexButton.png")));
			strengthAndFlex.setBounds(320, 339, 273, 242);
			strengthAndFlex.setOpaque(false);
			strengthAndFlex.setContentAreaFilled(false);
			strengthAndFlex.setBorderPainted(false);
			strengthAndFlex.setFocusPainted(false);
			strengthAndFlex.addActionListener(new strengthAndFlexAssessment());
			background.add(strengthAndFlex);
		
			//Coronary Risk
			//TODO: coronary risk form
			coronaryRisk = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CoronaryRiskButton.png")));
			coronaryRisk.setBounds(620, 339, 273, 242);
			coronaryRisk.setOpaque(false);
			coronaryRisk.setContentAreaFilled(false);
			coronaryRisk.setBorderPainted(false);
			coronaryRisk.setFocusPainted(false);
			coronaryRisk.addActionListener(new coronaryRiskAssessment());
			background.add(coronaryRisk);
			
			//Add Note
			//TODO: add note form
			addNote = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/AddButton.png")));
			addNote.setBounds(1010, 490,128, 118);
			addNote.setOpaque(false);
			addNote.setContentAreaFilled(false);
			addNote.setBorderPainted(false);
			addNote.setFocusPainted(false);
			addNote.addActionListener(new notes());
			background.add(addNote);
			
			//back button
			back = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/BackButton.png")));
			back.setBounds(40, 40, 173, 56);
			back.setOpaque(false);
			back.setContentAreaFilled(false);
			back.setBorderPainted(false);
			back.setFocusPainted(false);
			back.addActionListener(new backButton());
			background.add(back);
			setVisible(true);
		
	}
	//method of closing the frame
	private void closeFrame() {
		this.dispose();
	}
	
	private class backButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();
		}
	}
	
	private class bodyCompAssessment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String userName;
			EnterMemberInfo member = new EnterMemberInfo();
			int result = JOptionPane.showConfirmDialog(null, member, "Enter Member Information", JOptionPane.OK_CANCEL_OPTION );
			if (result == JOptionPane.OK_OPTION) {
				userName = member.uName.getText();
				
				// check to make sure username exists
				try {
					DbManager db = new DbManager();
					if(db.lookupMember(userName) != null) {
						new BodyCompForm(userName, staffID);	
					} else {
						JOptionPane.showMessageDialog(null, "Username doesn't exist.");
					}
				} catch (SQLException | HeadlessException | ParseException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
	}
	
	private class AerobicCapacityAssessment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String userName;
			EnterMemberInfo member = new EnterMemberInfo();
			int result = JOptionPane.showConfirmDialog(null, member, "Enter Member Information", JOptionPane.OK_CANCEL_OPTION );
			if (result == JOptionPane.OK_OPTION) {
				userName = member.uName.getText();
				// check to make sure username exists
				try {
					DbManager db = new DbManager();
					if(db.lookupMember(userName) != null) {
						new AerobicCapacityForm(userName, staffID);	
					} else {
						JOptionPane.showMessageDialog(null, "Username doesn't exist.");
					}
				} catch (SQLException | HeadlessException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class strengthAndFlexAssessment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String userName;
			EnterMemberInfo member = new EnterMemberInfo();
			int result = JOptionPane.showConfirmDialog(null, member, "Enter Member Information", JOptionPane.OK_CANCEL_OPTION );
			if (result == JOptionPane.OK_OPTION) {
				userName = member.uName.getText();
				// check to make sure username exists
				try {
					DbManager db = new DbManager();
					if(db.lookupMember(userName) != null) {
						new StrengthAndFlexForm(userName, staffID);
					} else {
						JOptionPane.showMessageDialog(null, "Username doesn't exist.");
					}
				} catch (SQLException | HeadlessException | ParseException e1) {
					e1.printStackTrace();
				}
			
			}
		}
	}
	
	private class coronaryRiskAssessment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String userName;
			EnterMemberInfo member = new EnterMemberInfo();
			int result = JOptionPane.showConfirmDialog(null, member, "Enter Member Information", JOptionPane.OK_CANCEL_OPTION );
			if (result == JOptionPane.OK_OPTION) {
				userName = member.uName.getText();
				// check to make sure username exists
				try {
					DbManager db = new DbManager();
					if(db.lookupMember(userName) != null) {
						new CoronaryRiskForm(userName, staffID);	
					} else {
						JOptionPane.showMessageDialog(null, "Username doesn't exist.");
					}
				} catch (SQLException | HeadlessException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class notes implements ActionListener{		

		public void actionPerformed(ActionEvent e) {

			new NotesForm(staffID);
		}
	}


}
	
	

