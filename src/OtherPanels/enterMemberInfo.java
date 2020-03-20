package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class enterMemberInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 20);

	JLabel firstName;
	JTextField fName;
	JLabel lastName;
	JTextField lName;
	JLabel birthday;
	JTextField bday;
	public enterMemberInfo() {
		
		setLayout(new GridLayout(0, 2));
		
		firstName = new JLabel("First Name");
		firstName.setFont(font1);
		add(firstName);
		
		fName = new JTextField(10);
		fName.setFont(font1);
		add(fName);
		
		lastName = new JLabel("Last Name");
		lastName.setFont(font1);
		add(lastName);
		
		lName = new JTextField(10);
		lName.setFont(font1);
		add(lName);
		
		birthday = new JLabel("Birthday");
		birthday.setFont(font1);
		add(birthday);
		
		bday = new JTextField(10);
		bday.setFont(font1);
		add(bday);
		
		
	}

}
