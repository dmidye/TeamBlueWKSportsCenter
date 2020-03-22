package OtherPanels;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class LookupForm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	JTextField fName;
	JTextField lName;
	JTextField userName;
	
	JButton lookUpUser;
	JButton Cancel;
	
	public LookupForm() {
		
		
			
			setTitle("Look-Up User");
			setSize(500, 675);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			
			setLayout(new BorderLayout());
			JLabel background = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/NewUserFormBackground.png")));
			add(background);
			background.setLayout(null);
			
			JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/Look-UpForm.png")));
			form.setBounds(22, 32, 472, 597);
			form.setLayout(null);
			fName = new JTextField(20);
			fName.setBounds(133, 185, 278, 25);
			fName.setOpaque(false);
			fName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			fName.setFont(font1);
			fName.setEditable(true);
			form.add(fName);
			
			lName = new JTextField(20);
			lName.setBounds(133, 225, 278, 25);
			lName.setOpaque(false);
			lName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			lName.setFont(font1);
			lName.setEditable(true);
			form.add(lName);
						
			userName = new JTextField(20);
			userName.setBounds(133, 265, 250, 25);
			userName.setOpaque(false);
			userName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			userName.setFont(font1);
			userName.setEditable(true);
			form.add(userName);
			
						
			lookUpUser = new JButton(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/Look-UpButton.png")));
			lookUpUser.setBounds(50, 468,142, 59);
			lookUpUser.setOpaque(false);
			lookUpUser.setContentAreaFilled(false);
			lookUpUser.setBorderPainted(false);
			lookUpUser.setFocusPainted(false);
			lookUpUser.addActionListener(new lookUpUserButton());
			form.add(lookUpUser);
			
			Cancel = new JButton(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/Cancel.png")));
			Cancel.setBounds(250, 468,142, 59);
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
		
		//cancel button action listener than calls the closeFrame() method
		//to close the frame.
		private class cancelButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				closeFrame();			
			}
		}
		
		private class lookUpUserButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				new EditUserForm();			
			}
		}
	}

