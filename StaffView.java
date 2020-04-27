package OtherPanels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StaffView extends JFrame {
	public JButton newMember;
	public JButton memberLookUp;
	public JButton assessment;
	public JButton adminControls;
	public JButton logout;
	
	String enabledAdminControls = "AdminControls.png";
	String adminButton;
	String assessmentButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StaffView(String userID, String memberType) {
		if(memberType == "Trainer") {
			adminButton = "AdminControlsButtonPressed.png";
		}
		if(memberType == "FrontDesk") {
			adminButton = "AdminControlsButtonPressed.png";
			assessmentButton = "AssessmentsButtonPessed.png"; 
		}
		else {
			adminButton = "AdminControls.png";
			assessmentButton = "AssessmentsButton.png";
		}
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
				new NewUserForm(userID, memberType);				
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
				new LookupForm(memberType);				
			}
		});
		background.add(memberLookUp);
		
		//Assessment Button
		//TODO: Finish assessments
		assessment = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/" + assessmentButton)));
		assessment.setBounds(360, 285, 483, 85);
		assessment.setOpaque(false);
		assessment.setContentAreaFilled(false);
		assessment.setBorderPainted(false);
		assessment.setFocusPainted(false);
		assessment.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Disclaimer: The calculations made in the assessment forms are not meant to replace \n" +
			                                         "the guidance or instruction of your healthcare provider. By proceeding you acknowledge that \n" +
						                             "the calculations made might be incorrect or not up to date, and any concerns \n" +
			                                         "with the results of the calculations should be followed up by your healthcare provider." +
						                              " \n By continueing, in the event that the calculations are not accurate you do not hold WK Sports Center or \n" +
			                                          "the program's developers responsible. ", "Disclaimer",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
				new AssessmentView(userID);
				}
				else {
					JOptionPane.showMessageDialog(null, "Exiting Assessments");
				}
			}
		});
		background.add(assessment);
	
		//Admin Controls
		//TODO: admin controls
	
		adminControls = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/" + adminButton))); 
		
		
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
