package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.DbManager;




public class StrengthAndFlexForm  extends JFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	JTextField pushups;
	JTextField oneMinuteSitUps;
	JTextField sitAndReach;
	
	JLabel name;
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	JButton calculate;
	JButton save;
	JButton cancel;

	public StrengthAndFlexForm(String username, String userID) {
		
		this.userID = userID;
		setTitle("Strength and Flex Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StrengthAndFlexForm.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(StrengthAndFlexForm.class.getResource("/StaffViewAssets/strengthAndFlexForm.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		
		name = new JLabel (username);
		name.setBounds(880, 50, 200, 25);
		name.setFont(font1);
		form.add(name);
		
		pushups = new JTextField(10);
		pushups.setBounds(225, 195, 80, 25);
		pushups.setOpaque(false);
		pushups.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pushups.setFont(font1);
		pushups.setEditable(true);
		form.add(pushups);
		
		oneMinuteSitUps = new JTextField(10);
		oneMinuteSitUps.setBounds(225, 230, 80, 25);
		oneMinuteSitUps.setOpaque(false);
		oneMinuteSitUps.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		oneMinuteSitUps.setFont(font1);
		oneMinuteSitUps.setEditable(true);
		form.add(oneMinuteSitUps);
				
		sitAndReach = new JTextField(10);
		sitAndReach.setBounds(225, 397, 80, 25);
		sitAndReach.setOpaque(false);
		sitAndReach.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		sitAndReach.setFont(font1);
		sitAndReach.setEditable(true);
		form.add(sitAndReach);
		
		
		
		//save and cancel
		
		save = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/SaveButton.png")));
		save.setBounds(600, 500, 156, 59);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.addActionListener(new saveButton(username));
		form.add(save);
		
		cancel = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CancelAssessment.png")));
		cancel.setBounds(800, 500, 156, 59);
		cancel.setOpaque(false);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.setFocusPainted(false);
		cancel.addActionListener(new cancelButton());
		form.add(cancel);
		
		background.add(form);
		
		setVisible(true);
	}
	
	//method of closing the frame
	private void closeFrame() {
		dispose();
	}
	
	
	
	//cancel button action listener than calls the closeFrame() method
	//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
		}
	}
	
	private class saveButton implements ActionListener{
		private String username;
		public saveButton(String username) {
			this.username = username;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				DbManager db = new DbManager();
				Integer pu = Integer.parseInt(pushups.getText());
				Integer omsu = Integer.parseInt(oneMinuteSitUps.getText());
				Integer sar = Integer.parseInt(sitAndReach.getText());
				
				//call method to create the form
				if(db.createNewMemberSFForm(username, pu, omsu, sar)) {
					JOptionPane.showMessageDialog(null, "Form added.");
					closeFrame();
				}

			} catch (SQLException e1) {
				System.out.println("Error connecting to database.");
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}
		
		

}
