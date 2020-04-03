package OtherPanels;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.DbManager;



public class notesForm extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String memberUserName;
	String trainerID;

	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	JTextField userName;
	
	JTextArea notes;
	JButton save;
	JButton Cancel;
	JButton remove;
	
	public notesForm(String userID) {
		
		this.trainerID = userID;
		//TODO: set each JTextField to display the information corresponding the user
		
		setTitle("Edit User");
		setSize(500, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(notesForm.class.getResource("/StaffViewAssets/NewUserFormBackground.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(notesForm.class.getResource("/StaffViewAssets/notesForm.png")));
		form.setBounds(22, 32, 472, 597);
		form.setLayout(null);
		userName = new JTextField(20);
		userName.setBounds(227, 43, 200, 25);
		userName.setOpaque(false);
		userName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userName.setFont(font1);
		userName.setEditable(true);
		form.add(userName);
		
		notes = new JTextArea(50,50);
		notes.setBounds(45, 180, 350, 250);
		notes.setLineWrap(true);
		notes.setWrapStyleWord(true);
		notes.setOpaque(false);
		notes.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		notes.setFont(font1);
		notes.setEditable(true);
		form.add(notes);		
		
		save = new JButton(new ImageIcon(notesForm.class.getResource("/StaffViewAssets/Look-upSaveButton.png")));
		save.setBounds(20, 468,142, 59);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.addActionListener(new saveButton());
		form.add(save);
		
		
		
		Cancel = new JButton(new ImageIcon(notesForm.class.getResource("/StaffViewAssets/CancelLookUpButton.png")));
		Cancel.setBounds(280, 468,142, 59);
		Cancel.setOpaque(false);
		Cancel.setContentAreaFilled(false);
		Cancel.setBorderPainted(false);
		Cancel.setFocusPainted(false);
		Cancel.addActionListener(new cancelButton());
		form.add(Cancel);
		
		background.add(form);
		
		setVisible(true);
		
		
	}
	//close frame method
	private void closeFrame() {
		this.dispose();
	}
	//method to add a new user to the database

	
	//cancel button action listener than calls the closeFrame() method
	//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
		}
	}
	
	private class saveButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO:
			try {
				DbManager db = new DbManager();
				if(db.newTrainerNotes(userName.getText(), trainerID, notes.getText())) {
					JOptionPane.showMessageDialog(null, "Success! New note has been added for " + userName.getText());
					closeFrame();
				} else {
					JOptionPane.showMessageDialog(null, "Unable to add values. Please make sure valid IDs are being entered.");
				}			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
	
