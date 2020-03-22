package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterMemberInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font1 = new Font("Agency FB", Font.PLAIN, 20);

	JLabel userName;
	JTextField uName;

	public EnterMemberInfo() {
		
		setLayout(new GridLayout(0, 2));
		
		userName = new JLabel("Username");
		userName.setFont(font1);
		add(userName);
		
		uName = new JTextField(10);
		uName.setFont(font1);
		add(uName);
	}
}
