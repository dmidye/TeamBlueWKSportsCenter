package OtherPanels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.DbManager;

public class AdminView extends JFrame {
	JButton calculationControls;
	JButton memberComments;
	JButton back;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminView() {
		setTitle("Admin View");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		
		
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		//new user button
		memberComments = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/memberCommentsButton.png")));
		memberComments.setBounds(340, 250, 228, 202);
		memberComments.setOpaque(false);
		memberComments.setContentAreaFilled(false);
		memberComments.setBorderPainted(false);
		memberComments.setFocusPainted(false);
		memberComments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberComments();
				
			}	
		});
		background.add(memberComments);
		
		//memberLookUp
		calculationControls = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/calculationsControlsButton.png")));
		calculationControls.setBounds(630, 250, 228, 202);
		calculationControls.setOpaque(false);
		calculationControls.setContentAreaFilled(false);
		calculationControls.setBorderPainted(false);
		calculationControls.setFocusPainted(false);
		calculationControls.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CalculationControls();				
			}
		});
		background.add(calculationControls);
		
		
		
		//LogOut
		back = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/BackButton.png")));
		back.setBounds(50, 50, 173, 56);
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
	
	
	

};
