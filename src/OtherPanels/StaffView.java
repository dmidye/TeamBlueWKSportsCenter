package OtherPanels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StaffView extends JFrame {
	JButton newMember;
	JButton memberLookUp;
	JButton assessment;
	JButton adminControls;
	JButton logout;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StaffView(String userID) {
		setTitle("Staff View");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		
		
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		//new user button
		newMember = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/NewUserButton.png")));
		newMember.setBounds(360, 45, 483, 85);
		newMember.setOpaque(false);
		newMember.setContentAreaFilled(false);
		newMember.setBorderPainted(false);
		newMember.setFocusPainted(false);
		newMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewUserForm(userID);				
			}
		});
		background.add(newMember);
		
		//memberLookUp
		memberLookUp = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/Look-upMemberButton.png")));
		memberLookUp.setBounds(360, 165, 483, 85);
		memberLookUp.setOpaque(false);
		memberLookUp.setContentAreaFilled(false);
		memberLookUp.setBorderPainted(false);
		memberLookUp.setFocusPainted(false);
		memberLookUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LookupForm();				
			}
		});
		background.add(memberLookUp);
		
		//Assessment Button
		//TODO: Finish assessments
		assessment = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/AssessmentsButton.png")));
		assessment.setBounds(360, 285, 483, 85);
		assessment.setOpaque(false);
		assessment.setContentAreaFilled(false);
		assessment.setBorderPainted(false);
		assessment.setFocusPainted(false);
		assessment.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new AssessmentView(userID);
			}
		});
		background.add(assessment);
	
		//Admin Controls
		//TODO: admin controls
		adminControls = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/AdminControls.png")));
		adminControls.setBounds(360, 405, 483, 85);
		adminControls.setOpaque(false);
		adminControls.setContentAreaFilled(false);
		adminControls.setBorderPainted(false);
		adminControls.setFocusPainted(false);
		adminControls.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminView();
			}
		});
		background.add(adminControls);
		
		//LogOut
		logout = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/LogOutButton.png")));
		logout.setBounds(360, 525, 483, 85);
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setFocusPainted(false);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		background.add(logout);

		
	}
	
	

};
