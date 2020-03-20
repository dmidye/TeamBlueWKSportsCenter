package OtherPanels;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;



public class editUserForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	JTextField fName;
	JTextField lName;
	JTextField bday;
	JTextField email;
	JTextField areaCode;
	JTextField phone;
	JTextField userName;
	JTextField password;
	JTextField confirm;
    ButtonGroup group;
	JButton saveUser;
	JButton Cancel;
	JButton remove;
	public editUserForm() {
		
		//TODO: set each JTextField to display the information corresponding the user
		
		setTitle("Edit User");
		setSize(500, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(newUserForm.class.getResource("/StaffViewAssets/NewUserFormBackground.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(newUserForm.class.getResource("StaffViewAssets/NewUserForm.png")));
		form.setBounds(22, 32, 472, 597);
		form.setLayout(null);
		fName = new JTextField(20);
		fName.setBounds(120, 50, 278, 25);
		fName.setOpaque(false);
		fName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fName.setFont(font1);
		fName.setEditable(true);
		form.add(fName);
		
		lName = new JTextField(20);
		lName.setBounds(120, 90, 278, 25);
		lName.setOpaque(false);
		lName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lName.setFont(font1);
		lName.setEditable(true);
		form.add(lName);
		
		bday = new JTextField(20);
		bday.setBounds(120, 130, 278, 25);
		bday.setOpaque(false);
		bday.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bday.setFont(font1);
		bday.setEditable(true);
		form.add(bday);
		
		areaCode = new JTextField(3);
		areaCode.setBounds(120, 170, 44, 25);
		areaCode.setOpaque(false);
		areaCode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		areaCode.setFont(font1);
		areaCode.setEditable(true);
		form.add(areaCode);
		
		phone = new JTextField(20);
		phone.setBounds(170, 170, 250, 25);
		phone.setOpaque(false);
		phone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		phone.setFont(font1);
		phone.setEditable(true);
		form.add(phone);
		
		email = new JTextField(20);
		email.setBounds(120, 210, 250, 25);
		email.setOpaque(false);
		email.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		email.setFont(font1);
		email.setEditable(true);
		form.add(email);
		
		userName = new JTextField(20);
		userName.setBounds(120, 248, 250, 25);
		userName.setOpaque(false);
		userName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userName.setFont(font1);
		userName.setEditable(true);
		form.add(userName);
		
		password = new JTextField(20);
		password.setBounds(120, 285, 250, 25);
		password.setOpaque(false);
		password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		password.setFont(font1);
		password.setEditable(true);
		form.add(password);
		
		confirm = new JTextField(20);
		confirm.setBounds(120, 325, 250, 25);
		confirm.setOpaque(false);
		confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		confirm.setFont(font1);
		confirm.setEditable(true);
		form.add(confirm);
		
		group = new ButtonGroup();
		JRadioButton member = new JRadioButton();
		member.setBounds(89, 393, 25, 25);
		member.setOpaque(false);
		form.add(member);
		
		JRadioButton fStaff = new JRadioButton();
		fStaff.setBounds(205, 393, 25, 25);
		fStaff.setOpaque(false);
		form.add(fStaff);
		
		JRadioButton Trainer = new JRadioButton();
		Trainer.setBounds(300, 393, 25, 25);
		Trainer.setOpaque(false);
		form.add(Trainer);
		
		JRadioButton Admin = new JRadioButton();
		Admin.setBounds(390, 393, 25, 25);
		Admin.setOpaque(false);
		form.add(Admin);
		
		group.add(member);
		group.add(fStaff);
		group.add(Trainer);
		group.add(Admin);
		
		
		saveUser = new JButton(new ImageIcon(newUserForm.class.getResource("/StaffViewAssets/Look-upSaveButton.png")));
		saveUser.setBounds(20, 468,142, 59);
		saveUser.setOpaque(false);
		saveUser.setContentAreaFilled(false);
		saveUser.setBorderPainted(false);
		saveUser.setFocusPainted(false);
		saveUser.addActionListener(new saveButton());
		form.add(saveUser);
		
		remove = new JButton(new ImageIcon(newUserForm.class.getResource("/StaffViewAssets/RemoveButton.png")));
		remove.setBounds(150, 468,142, 59);
		remove.setOpaque(false);
		remove.setContentAreaFilled(false);
		remove.setBorderPainted(false);
		remove.setFocusPainted(false);
		//TODO: complete removeButton ActionListener
		//remove.addActionListener(new removeButton());
		form.add(remove);
		
		Cancel = new JButton(new ImageIcon(newUserForm.class.getResource("/StaffViewAssets/CancelLookUpButton.png")));
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
	private void editUser() {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(fName.getText());
		list.add(lName.getText());
		list.add(bday.getText());
		list.add(areaCode.getText());
		list.add(phone.getText());
		list.add(email.getText());
		list.add(password.getText());
		list.add(confirm.getText());
		
		//check for null entries
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i).trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "Please complete form");
				break;		
			}
		}
		
		//check for user type
		//check that a user type is selected
		String status = null;
		Enumeration<AbstractButton> buttons = group.getElements();
				
		while(buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                status = button.getText().replaceAll(" ", "");//trim spaces
            }
		}
		if(status == null) {//if no button is selected, initialize member to member status
			JOptionPane.showMessageDialog(null, "Please select a user type");
		}
		
		//check to see if areaCode is a number
		try {
		Integer areaCodeNum = Integer.parseInt(areaCode.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Area Code must be a number");
			areaCode.setText("");
		}
		if(areaCode.getText().length() > 3 ) {
			JOptionPane.showMessageDialog(null, "Area Code must be three digits long");
			areaCode.setText("");
		}
		
		//check to make sure password and confirmed password match
		if(!password.getText().equals(confirm.getText())) {
			JOptionPane.showMessageDialog(null, "Passwords do not match");			
		}
		
		
		
		String firstName = fName.getText();
		String lastName = lName.getText();
		String birthday = bday.getText();
		String areacode = areaCode.getText();
		String phoneNumber = phone.getText();
		String emailAddress = email.getText();
		String userPassword = password.getText();
		String confirmedPassword = confirm.getText();
		
		//TODO: add code to save updates to database here.
		
	}
	
	//cancel button action listener than calls the closeFrame() method
	//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
		}
	}
	
	private class saveButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			editUser();
		}
	}
	
	//TODO: create removeButton actionListener
	

}
