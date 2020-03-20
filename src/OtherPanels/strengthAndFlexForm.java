package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class strengthAndFlexForm  extends JFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField pushups;
	JTextField oneMinuteSitUps;
	JTextField sitAndReach;
	
	JLabel name;
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	JButton calculate;
	JButton save;
	JButton cancel;

	public strengthAndFlexForm(String fName, String lName, String bDay) {
		setTitle("Strength and Flex Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(strengthAndFlexForm.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(strengthAndFlexForm.class.getResource("StaffViewAssets/strengthAndFlexForm.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		
		name = new JLabel (fName + " " + lName);
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
		this.dispose();
	}
	
	
	
	//cancel button action listener than calls the closeFrame() method
		//to close the frame.
		private class cancelButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				closeFrame();			
			}
		}
		
		

}
