/*
 * The main staff view of all staff members. Buttons are set to editable depending on staff position.
 * 
 * 
 */

package OtherPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

import Database.DbManager;

import javax.swing.*;
public class StaffView {
	
JTextArea staffInfo;
JScrollPane staffInfoScrollPanel;
JPanel staffInfoPanel;


JPanel staffControl; // the main frame
CardLayout layout; // content panel card layout
 JPanel staffMenu; //  holds the buttons
 JPanel contentPanel; // holds the content
 JPanel controlButtons;
 JPanel loginPanel;
 JButton newMember;
 JButton lookUpMember;
 JButton updateMember;
 JButton removeMember;
 public JButton assessment;
 public JButton newStaff;
 
 // login panel
 JButton logOut;
 JLabel staffName;
 JLabel staffPosition;
 public JLabel staffPosition2;
 public JLabel staffName2;
 
 //lookup member GUI
 JLabel BMI;
 JTextField BMIText;
 JLabel accountNumber;
 JTextField accountNumberText;
 JButton lookup;
 JTextField firstNameTextLookup;
 JTextField lastNameTextLookup;
 //new member GUI
 JTextField maxVO2Text;
 JTextField restedHeartRateText;
 JTextField heartRateMaxText;
 JLabel restedHeartRate;
 JLabel heartRateMax;
 JLabel maxVO2;
 JTextField userNameTextUC2;
 JPanel updateMemberPanel;
 JPanel updateMemberPanel2;
 JPanel removeMemberPanel;
 JPanel newMemberPanel;
 JPanel memberLookupPanel;
 JLabel memberType;
 JLabel userName;
 JLabel firstName;
 JLabel lastName;
 JLabel email;
 JLabel birthday;
 JLabel phoneNumber;
 JLabel newPassword;
 JLabel areaCode;
 JTextField userNameText1;
 JTextField userNameText;
 JTextField firstNameTextNM;
 JTextField lastNameTextNM;
 JTextField firstNameTextUpdate;
 JTextField lastNameTextUpdate;
 JTextField emailText;
 JDateChooser birthdayChooser;
 JTextField areaCodeText;
 JTextField phoneNumberText;
 JPasswordField newPasswordText;
 JButton save;
 JButton cancel;
 JRadioButton memberUp;
 JRadioButton fStaffUp;
 JRadioButton trainerUp;
 JRadioButton adminUp;
 ButtonGroup groupUp;
 
 // Update Calculations panels
 JLabel userNameUC;
 JTextField userNameTextUC;
 JPanel updateCalcsPanel2;
 JLabel staffFirstName;
 JLabel staffLastName;
 JLabel staffEmail;
 JLabel staffPassword;
 JPanel updateCalcsPanel;
 JTextField staffFirstNameText;
 JTextField staffLastNameText;
 JTextField staffEmailText;
 JPasswordField staffPasswordText;
 JButton staffSave;
 
 
 /*
  * Creates the staff member controls.
  * For the prototype purposes, only "New Member"
  * and Assessment Work. 
  * 
  * Functions:
  * New Member: add new member
  * Look Up: Look Up a Member
  * Update Member: Look up a member and edit their information (not currently functional)
  * Assessment: perform the fitness assessment (only functional with Admin and Trainer Logins)
  * Remove Member: Removes a member from the database (not currently functional)
  * 
  */
public void createStaffView() throws SQLException {
    JFrame staffControl = new JFrame();
    staffControl.setLayout(new GridBagLayout());
    staffControl.setVisible(true);
    staffControl.setSize(500, 500);

    
    GridBagConstraints sc = new GridBagConstraints();
    sc.fill = GridBagConstraints.HORIZONTAL;

    sc.weighty = 1;
	
    /*
     * create the panel that holds the control buttons
     */
	
	controlButtons = new JPanel();
	
	controlButtons.setBorder(BorderFactory.createTitledBorder("Control Panel"));
	controlButtons.setLayout(new GridBagLayout());
	GridBagConstraints cb = new GridBagConstraints();
	cb.fill = GridBagConstraints.HORIZONTAL;
	cb.anchor = GridBagConstraints.FIRST_LINE_START;
	cb.insets = new Insets(10, 0, 0, 0);
	cb.weighty = 1;
	
	
	cb.gridx = 0;
	cb.gridy = 0;
	newMember = new JButton("New Member");	
	newMember.addActionListener(new commandEvent());
	controlButtons.add(newMember, cb);
	
	
	cb.gridx = 0;
	cb.gridy = 1;
	lookUpMember = new JButton("Look Up");	
	lookUpMember.addActionListener(new commandEvent());
	controlButtons.add(lookUpMember, cb);
	
	cb.gridx = 0;
	cb.gridy = 2;
	updateMember = new JButton("Update Member");
	updateMember.addActionListener(new commandEvent());
	controlButtons.add(updateMember, cb);
	
	cb.gridx = 0;
	cb.gridy = 3;
	assessment = new JButton("Assessment");
	assessment.addActionListener(new assessmentEvent());
	controlButtons.add(assessment, cb);
	assessment.setEnabled(false);
	
	
	cb.gridx = 0;
	cb.gridy = 4;
	removeMember = new JButton("Remove Member");
	removeMember.addActionListener(new commandEvent());
	controlButtons.add(removeMember, cb);
	
	cb.gridx = 0;
	cb.gridy = 5;
	newStaff = new JButton("Update Calculations");
	newStaff.setEnabled(false);
	newStaff.addActionListener(new commandEvent());
	controlButtons.add(newStaff, cb);
	
	sc.gridx = 0;
	sc.gridy = 1;
	sc.anchor = GridBagConstraints.PAGE_START;
	staffControl.add(controlButtons, sc);
	
	
	
	
	/*
	 * creates the panel that displays name, position, and logout button
	 */
	loginPanel = new JPanel();
	loginPanel.setLayout(new GridBagLayout());
	loginPanel.setBorder(BorderFactory.createTitledBorder("Info"));
	GridBagConstraints lg = new GridBagConstraints();
	lg.fill = GridBagConstraints.HORIZONTAL;
	
	lg.weightx = 1.0;
	lg.gridx = 0;
	lg.gridy = 0;
	
	staffName = new JLabel("name:  ");
	loginPanel.add(staffName, lg);
	
	lg.gridx = 1;
	lg.gridy = 0; 
	
	staffName2 = new JLabel("John Smith"); // change to pull from database
	loginPanel.add(staffName2, lg);
	
	lg.gridx = 0;
	lg.gridy = 1;
	lg.anchor = GridBagConstraints.NORTHEAST;
	staffPosition = new JLabel("position:   ");
	loginPanel.add(staffPosition, lg);
	
	lg.gridx = 1;
	lg.gridy = 1;
	lg.anchor = GridBagConstraints.NORTHEAST;
	staffPosition2 = new JLabel("Front Desk"); // change to switch depending on account
	loginPanel.add(staffPosition2, lg);
	
	
	lg.gridx = 2;
	lg.gridy = 1;
	lg.anchor = GridBagConstraints.FIRST_LINE_END;
	lg.insets = new Insets(0, 0, 0, 0);
	logOut = new JButton("Log Out");
	logOut.addActionListener(new logOutEvent());
	loginPanel.add(logOut, lg);
	
	sc.gridwidth = 4;
	sc.gridheight = 1;
	sc.weighty = 0;
	sc.gridx = 0;
	sc.gridy = 0;
	sc.anchor = GridBagConstraints.FIRST_LINE_START;
	staffControl.add(loginPanel, sc);

	layout = new CardLayout();
	contentPanel = new JPanel(layout);
	
	sc.gridx = 1;
	sc.gridy = 1;
	sc.weightx = 1;	
	sc.gridheight = 2;
	sc.anchor = GridBagConstraints.FIRST_LINE_START;
	staffControl.add(contentPanel, sc);
	
	/*
	 * create the panel for the new member
	 */
	newMemberPanel = new JPanel();
	newMemberPanel.setLayout(new GridBagLayout());
	newMemberPanel.setBorder(BorderFactory.createTitledBorder("New Member"));
	GridBagConstraints mp = new GridBagConstraints();
	mp.fill = GridBagConstraints.HORIZONTAL;
	mp.insets = new Insets(0, 0, 10, 5);
	
	mp.gridx = 0;
	mp.gridy = 0;
	userName = new JLabel("Username: ");
	newMemberPanel.add(userName, mp);
	
	mp.gridx = 1;
	mp.gridy = 0;
	mp.gridwidth = 2;
	JTextField userNameTextNM = new JTextField(20);
	userNameTextNM.setEditable(true);
	newMemberPanel.add(userNameTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 1;
	newPassword = new JLabel("Password: ");
	newMemberPanel.add(newPassword, mp);
	
	mp.gridx = 1;
	mp.gridy = 1;
	JTextField newPasswordTextNM = new JPasswordField(30);
	newPasswordTextNM.setEditable(true);
	newMemberPanel.add(newPasswordTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 2;
	firstName = new JLabel("First Name: ");
	newMemberPanel.add(firstName, mp);
	
	mp.gridx = 1;
	mp.gridy = 2;
	mp.gridwidth = 2;
	firstNameTextNM = new JTextField(20);//changed name of firstNameText and lastNameText because other forms were
	firstNameTextNM.setEditable(true);   //using firstNameText and lastNameText as textfield names.
	newMemberPanel.add(firstNameTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 3;
	lastName = new JLabel("Last Name: ");
	newMemberPanel.add(lastName, mp);
	
	mp.gridx = 1;
	mp.gridy = 3;
	lastNameTextNM = new JTextField(20);
	lastNameTextNM.setEditable(true);
	newMemberPanel.add(lastNameTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 4;
	email = new JLabel("Email: ");
	newMemberPanel.add(email, mp);
	
	mp.gridx = 1;
	mp.gridy = 4;
	JTextField emailTextNM = new JTextField(20);
	emailTextNM.setEditable(true);
	newMemberPanel.add(emailTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 5;
	birthday = new JLabel("Birthday: ");
	newMemberPanel.add(birthday, mp);
	
	mp.gridx = 1;
	mp.gridy = 5;
	mp.gridwidth = 2;
	JDateChooser birthdayChooserNM = new JDateChooser();
	
	newMemberPanel.add(birthdayChooserNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 6;
	areaCode = new JLabel("Area Code: ");
	newMemberPanel.add(areaCode, mp);
	
	mp.gridx = 1;
	mp.gridy = 6;
	JTextField areaCodeTextNM = new JTextField(20);
	areaCodeTextNM.setEditable(true);
	newMemberPanel.add(areaCodeTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 7;
	phoneNumber = new JLabel("Phone: ");
	newMemberPanel.add(phoneNumber, mp);
	
	mp.gridx = 1;
	mp.gridy = 7;
	JTextField phoneNumberTextNM = new JTextField(20);
	phoneNumberTextNM.setEditable(true);
	newMemberPanel.add(phoneNumberTextNM, mp);
	
	mp.gridx = 0;
	mp.gridy = 8;
	memberType = new JLabel("Type: ");
	newMemberPanel.add(memberType, mp);
	
	ButtonGroup group = new ButtonGroup();
	JRadioButton member = new JRadioButton();
	member.setText("Member");
	JRadioButton fStaff = new JRadioButton();
	fStaff.setText("Trainer");
	JRadioButton trainer = new JRadioButton();
	trainer.setText("Front Desk");
	JRadioButton admin = new JRadioButton();
	admin.setText("Admin");
	
	group.add(member);
	group.add(fStaff);
	group.add(trainer);
	group.add(admin);
	
	mp.gridx = 1;
	mp.gridy = 8;
	newMemberPanel.add(member, mp);
	mp.gridx = 3;
	mp.gridy = 8;
	newMemberPanel.add(fStaff, mp);
	mp.gridx = 5;
	mp.gridy = 8;
	newMemberPanel.add(trainer, mp);
	mp.gridx = 7;
	mp.gridy = 8;
	newMemberPanel.add(admin, mp);

	mp.gridx = 0;
	mp.gridy = 9;
	save = new JButton("Save");
	newMemberPanel.add(save, mp);
	
	mp.gridx = 1;
	mp.gridy = 9;
	cancel = new JButton("Cancel");
	newMemberPanel.add(cancel, mp);

	contentPanel.add(newMemberPanel, "New Member");
	
	
	/* Implement capability to add new member to database
	 */
	save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {	
        		//collect the values from each field
        		String status = null;
        		Enumeration<AbstractButton> buttons = group.getElements();
        		while(buttons.hasMoreElements()) {
        			AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        status = button.getText().replaceAll(" ", "");//trim spaces
                    }
        		}
        		if(status == null) {//if no button is selected, initialize member to member status
        			status = "member";
        		}
        		String username = userNameTextNM.getText();
        		String firstName = firstNameTextNM.getText();
        		String lastName = lastNameTextNM.getText();
        		String email = emailTextNM.getText();
        		birthdayChooserNM.setDateFormatString("yyyy-MM-dd");
        		Date birthday = birthdayChooserNM.getDate();
        		Integer phone = Integer.parseInt(phoneNumberTextNM.getText());
        		Integer areaCode = Integer.parseInt(areaCodeTextNM.getText());
        		
        		int createdBy = 0;
        		String password = newPasswordTextNM.getText(); //TODO:use getPassword() instead. I think we need to change the
        														//  password field in the db to a character array
        		try {
        			DbManager dbManager = new DbManager();
				
					try {
						if(dbManager.createNewMember(username, firstName, lastName, email, birthday, password, createdBy, phone, areaCode, status) 
							) {
							JOptionPane.showMessageDialog(newMember, "Success! New member added.");
						} else {
							JOptionPane.showMessageDialog(newMember, "Unable to add member. Please make sure fields are valid.");
						}
					} catch (HeadlessException | SQLException | ParseException e1) {
						e1.printStackTrace();
					}
        		} catch(Exception e1) {
        			e1.printStackTrace();
        		}
    		
        }
	});
	
	/*
	 * create the panel for updating a member
	 */
	updateMemberPanel = new JPanel();
	updateMemberPanel.setLayout(new GridBagLayout());
	updateMemberPanel.setBorder(BorderFactory.createTitledBorder("Update Member"));
	GridBagConstraints um = new GridBagConstraints();
	um.fill = GridBagConstraints.HORIZONTAL;
	um.insets = new Insets(0, 0, 10, 5);
	
	um.gridx = 0;
	um.gridy = 0;
	userName = new JLabel("Username: ");
	updateMemberPanel.add(userName, um);
	
	um.gridx = 1;
	um.gridy = 0;
	um.gridwidth = 2;
	userNameText1 = new JTextField(20);
	userNameText1.setEditable(true);
	updateMemberPanel.add(userNameText1, um);
	
	//get values to prefill fields
	
		DbManager db = new DbManager();
		mp.gridx = 1;
		mp.gridy = 1;
		JButton lookup = new JButton("Go To Member");
		lookup.setPreferredSize(new Dimension(20, 20));
		updateMemberPanel.add(lookup, mp);
		contentPanel.add(updateMemberPanel, "Update Member");
		
		lookup.addActionListener(new commandEvent());
		
		updateMemberPanel2 = new JPanel();
		updateMemberPanel2.setLayout(new GridBagLayout());
		updateMemberPanel2.setBorder(BorderFactory.createTitledBorder("Update Member"));
    	
		userNameText = new JTextField(20);
		userNameText.setEditable(false);
		
		newPasswordText = new JPasswordField(30);
		newPasswordText.setEditable(true);

		firstNameTextUpdate = new JTextField(20);
		firstNameTextUpdate.setEditable(true); 

		lastNameTextUpdate = new JTextField(20);
		lastNameTextUpdate.setEditable(true);

		emailText = new JTextField(20);
		emailText.setEditable(true);

		birthdayChooser = new JDateChooser();

		areaCodeText = new JTextField(20);
		areaCodeText.setEditable(true);

		phoneNumberText = new JTextField(20);
		phoneNumberText.setEditable(true);
		
		groupUp = new ButtonGroup();
		memberUp = new JRadioButton();
		memberUp.setText("Member");
		fStaffUp = new JRadioButton();
		fStaffUp.setText("Front Desk");
		trainerUp = new JRadioButton();
		trainerUp.setText("Trainer");
		adminUp = new JRadioButton();
		adminUp.setText("Admin");
		
		groupUp.add(memberUp);
		groupUp.add(fStaffUp);
		groupUp.add(trainerUp);
		groupUp.add(adminUp);
		
	/*
	 * Create panel for removing a member(staff, trainer, admin, member)
	 */
	removeMemberPanel = new JPanel();
	removeMemberPanel.setLayout(new GridBagLayout());
	removeMemberPanel.setBorder(BorderFactory.createTitledBorder("Remove Member"));
	GridBagConstraints rm = new GridBagConstraints();
	rm.fill = GridBagConstraints.HORIZONTAL;
	rm.insets = new Insets(0, 0, 10, 5);
	
	rm.gridx = 0;
	rm.gridy = 0;
	userName = new JLabel("Username: ");
	removeMemberPanel.add(userName, rm);
	
	rm.gridx = 1;
	rm.gridy = 0;
	rm.gridwidth = 2;
	JTextField userNameTextRemove = new JTextField(20);
	userNameTextRemove.setEditable(true);
	removeMemberPanel.add(userNameTextRemove, rm);
	
	rm.gridx = 1;
	rm.gridy = 1;
	JButton remove = new JButton("Remove Member");
	removeMemberPanel.add(remove, rm);
	
	contentPanel.add(removeMemberPanel, "Remove Member");
	
	/* Implement capability to remove member to database
	 */
	remove.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        		DbManager db;
				try {
					db = new DbManager();
					String userName = userNameTextRemove.getText().trim();
	        		
	        		try {
						if(db.deleteMember(userName)) {
							JOptionPane.showMessageDialog(removeMember, "Member deleted.");
						} else {
							JOptionPane.showMessageDialog(removeMember, "Unable to delete member. Please enter a valid username.");
						}
					} catch (SQLException | ParseException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
        	}
		});
	
	
	/*
	 * create the panel for the member lookup
	 */
	memberLookupPanel = new JPanel();
	memberLookupPanel.setLayout(new GridBagLayout());
	memberLookupPanel.setBorder(BorderFactory.createTitledBorder("Look Up Member"));
		GridBagConstraints ml = new GridBagConstraints();
		ml.fill = GridBagConstraints.HORIZONTAL;
		ml.insets = new Insets(0, 0, 10, 5);
		
		
		ml.gridx = 0;
		ml.gridy = 0;
		firstName = new JLabel("First Name: ");
		memberLookupPanel.add(firstName, ml);
		
		ml.gridx = 1;
		ml.gridy = 0;
		
		firstNameTextLookup = new JTextField(20);
		firstNameTextLookup.setEditable(true);
		memberLookupPanel.add(firstNameTextLookup, ml);
		
		ml.gridx = 0;
		ml.gridy = 1;
		lastName = new JLabel("Last Name: ");
		memberLookupPanel.add(lastName, ml);
		
		ml.gridx = 1;
		ml.gridy = 1;
		lastNameTextLookup = new JTextField(20);
		lastNameTextLookup.setEditable(true);
		memberLookupPanel.add(lastNameTextLookup, ml);
		
		ml.gridx = 0;
		ml.gridy = 2;
		accountNumber = new JLabel("Account Number: ");
		memberLookupPanel.add(accountNumber, ml);
		
		ml.gridx = 1;
		ml.gridy = 2;
	
		accountNumberText = new JTextField(20);
		accountNumberText.setEditable(true);
		memberLookupPanel.add(accountNumberText, ml);
		
		ml.gridx = 0;
		ml.gridy = 3;
		lookup = new JButton("Look Up");
		lookup.addActionListener(new lookUpEvent());
		memberLookupPanel.add(lookup, ml);
		
		ml.gridx = 1;
		ml.gridy = 3;
		cancel = new JButton("Cancel");
		memberLookupPanel.add(cancel, ml);
		
		contentPanel.add(memberLookupPanel, "Look Up");
		
		/*
		 * create the panel for the Update Calculations panel
		 */
		updateCalcsPanel = new JPanel();
		updateCalcsPanel.setLayout(new GridBagLayout());
		updateCalcsPanel.setBorder(BorderFactory.createTitledBorder("Update Calculations"));
		GridBagConstraints uc = new GridBagConstraints();
		uc.fill = GridBagConstraints.HORIZONTAL;
		uc.insets = new Insets(0, 0, 10, 5);
		
		
		uc.gridx = 0;
		uc.gridy = 0;
		userNameUC = new JLabel("Username: ");
		updateCalcsPanel.add(userNameUC, uc);
		
		uc.gridx = 1;
		uc.gridy = 0;
		uc.gridwidth = 2;
		userNameTextUC = new JTextField(20);
		userNameTextUC.setEditable(true);
		updateCalcsPanel.add(userNameTextUC, uc);
		
		//get values to prefill fields
		
		DbManager db1 = new DbManager();
		uc.gridx = 1;
		uc.gridy = 1;
		JButton lookup1 = new JButton("Go");
		lookup1.setPreferredSize(new Dimension(20, 20));
		updateCalcsPanel.add(lookup1, uc);
		contentPanel.add(updateCalcsPanel, "Update Calculations");
		
		lookup1.addActionListener(new commandEvent());
		
		updateCalcsPanel2 = new JPanel();
		updateCalcsPanel2.setLayout(new GridBagLayout());
		updateCalcsPanel2.setBorder(BorderFactory.createTitledBorder("Update Calculations"));
    	
		userNameTextUC2= new JTextField(20);
		userNameTextUC2.setEditable(false);
		
//		newPasswordText = new JPasswordField(30);
//		newPasswordText.setEditable(true);

		
//		contentPanel.add(updateCalcsPanel2, "Update Calculations");
		
//		 /*
//	     * create the panel that holds the text area where the information is
//	     * sent
//	     */
//	    
//	    staffInfo = new JTextArea(5, 40);
//	    staffInfo.setEditable(false);
//	    staffInfoScrollPanel = new JScrollPane(staffInfo);
//	    staffInfoPanel = new JPanel();
//	    staffInfo.setLayout(new BorderLayout());
//	    staffInfoPanel.add(staffInfo);
//	    staffInfoPanel.setBorder(BorderFactory.createTitledBorder("Information"));
//	    sc.gridx = 0;
//	    sc.gridy = 2;
//	    sc.gridwidth = 2;
//	    sc.weighty = 1;
//	    sc.weightx = 1;
//	    sc.anchor = GridBagConstraints.NORTH;
//	    staffControl.add(staffInfoPanel, sc);
	

} // end createStaffView()

//action Listeners

	// switches between New Member, Look Up, and Update Calculations
	private class commandEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 String command = e.getActionCommand();
	            if ("New Member".equals(command)) {
	                layout.show(contentPanel, "New Member");
	            }
	            else if("Look Up".equals(command)) {
	            	layout.show(contentPanel, "Look Up");
	            }
	            else if("Update Calculations".equals(command)) {
	            	layout.show(contentPanel, "Update Calculations");
	            }
	            else if("Remove Member".equals(command)) {
	            	layout.show(contentPanel, "Remove Member");
	            }
	            else if("Update Member".equals(command)) {
	            	layout.show(contentPanel, "Update Member");
	            }
	            else if("Go".equals(command)) {
	            	contentPanel.getRootPane().getParent().setSize(new Dimension(800, 675));
	            	if(updateCalcsPanel2 != null) {
	            		updateCalcsPanel2 = new JPanel();
	            		updateCalcsPanel2.setLayout(new GridBagLayout());
	            		updateCalcsPanel2.setBorder(BorderFactory.createTitledBorder("Update Calculations"));
	                	
	            		userNameTextUC2= new JTextField(20);
	            		userNameTextUC2.setEditable(false);
	            	}
	            	
	            	try {
	            		if(!userNameTextUC.getText().equals("")) {
	            			GridBagConstraints uc = new GridBagConstraints();
	        				uc.fill = GridBagConstraints.HORIZONTAL;
	        				uc.insets = new Insets(0, 0, 10, 5);
	        				DbManager db = new DbManager();
		            		ResultSet rs = db.lookupMember(userNameTextUC.getText().trim());
		            		if(rs == null) {
		            			layout.show(contentPanel, "Update Calculations");
		            		} else {
			            		rs.first();
			        			uc.gridx = 0;
			        			uc.gridy = 0;
			        			userName = new JLabel("Username: ");
			        			updateCalcsPanel2.add(userName, uc);
			        			
			        			uc.gridx = 1;
			        			uc.gridy = 0;
			        			uc.gridwidth = 2;
			        			userNameText.setText(rs.getString("Username"));
			        			updateCalcsPanel2.add(userNameText, uc);
			            		
			        			uc.gridx = 0;
			        			uc.gridy = 9;
			        			BMI = new JLabel("BMI: ");
			        			updateCalcsPanel2.add(BMI, uc);
			        		
			        			uc.gridx = 1;
			        			uc.gridy = 9;
			        			BMIText = new JTextField(20);
			        			BMIText.setEditable(false);
			        			updateCalcsPanel2.add(BMIText, uc);
			        			
			        			uc.gridx = 3;
			        			uc.gridy = 9;
			        			JButton calculateBMI = new JButton("Calculate");
			        			updateCalcsPanel2.add(calculateBMI, uc);
			        			
			        			uc.gridx = 0;
			        			uc.gridy = 10;
			        			restedHeartRate = new JLabel("Rested Heart Rate: ");
			        			updateCalcsPanel2.add(restedHeartRate, uc);
			        		
			        			uc.gridx = 2;
			        			uc.gridy = 10;
			        			
			        			restedHeartRateText = new JTextField(20);
			        			restedHeartRateText.setEditable(true);
			        			updateCalcsPanel2.add(restedHeartRateText, uc);
			        			
			        			uc.gridx = 0;
			        			uc.gridy = 11;
			        			heartRateMax = new JLabel("Max Heart Rate: ");
			        			updateCalcsPanel2.add(heartRateMax, uc);
			        		
			        			uc.gridx = 2;
			        			uc.gridy = 11;
			        			
			        			heartRateMaxText = new JTextField(20);
			        			heartRateMaxText.setEditable(true);
			        			updateCalcsPanel2.add(heartRateMaxText, uc);
			        			
			        			uc.gridx = 0;
			        			uc.gridy = 12;
			        			maxVO2 = new JLabel("Max VO2: ");
			        			updateCalcsPanel2.add(maxVO2, uc);
			        		
			        			uc.gridx = 1;
			        			uc.gridy = 12;
			        			maxVO2Text = new JTextField(20);
			        			maxVO2Text.setEditable(false);
			        			updateCalcsPanel2.add(maxVO2Text, uc);
			        			
			        			uc.gridx = 3;
			        			uc.gridy = 12;
			        			JButton calculateAC = new JButton("Calculate");
			        			calculateAC.addActionListener(new ActionListener() {
			        				public void actionPerformed(ActionEvent e) {
			        					maxVO2Text.setText(calculateAC(restedHeartRateText.getText(),heartRateMaxText.getText()));
			        				}
			        			});
			        			updateCalcsPanel2.add(calculateAC, uc);
			        			
			        			calculateBMI.addActionListener(new ActionListener() {
			        				@Override
			        				public void actionPerformed(ActionEvent e){
			        					String weight = "Weight: ";
			        					String feet = "Feet: ";
			        					String inches = "Inches: ";
			        					
			        					JOptionPane.showMessageDialog(null,"Please enter Weight in pounds");
			        					String bmiWeight = JOptionPane.showInputDialog(weight);
			        					
			        					if(weight != null) {
			        						
			        						JOptionPane.showMessageDialog(null, "Please enter Height in Feet and Inches");
			        						String bmiFeet = JOptionPane.showInputDialog(feet);
			        							
			        						if(bmiFeet != null) {
			        							
			        							String bmiInches = JOptionPane.showInputDialog(inches);
			        							
			        							if(bmiInches != null) {
			        								
			        								String calculatedBMI = calculateBMI(bmiWeight, bmiFeet, bmiInches);
			        								BMIText.setText(calculatedBMI);
			        							}
			        						}
			        					}
			        				}
			        			});
			        			uc.gridx = 0;
			        			uc.gridy = 13;
			        			JButton update = new JButton("Update");
			        			updateCalcsPanel2.add(update, uc);
			        			
			        			uc.gridx = 2;
			        			uc.gridy = 13;
			        			cancel = new JButton("Cancel");
			        			updateCalcsPanel2.add(cancel, uc);
			        			
			        			cancel.addActionListener(new ActionListener() {
			        				@Override
			        		        public void actionPerformed(ActionEvent e) {	
			        					layout.show(contentPanel, "Update Calculations");
			        					userNameTextUC.setText("");
			        					updateCalcsPanel2 = null;
			        				}
			        			});
			        			
			        			contentPanel.add(updateCalcsPanel2, "Update Calculations 2");
			        			/* Implement capability to update member
			        			 */
			        			update.addActionListener(new ActionListener() {
			        		        @Override
			        		        public void actionPerformed(ActionEvent e) {	
			        		        		//collect the values from each field
			        		        		Double bmi;
			        		        		if(!BMIText.getText().isEmpty()) {
			        		        			bmi = Double.parseDouble(BMIText.getText());
			        		        		} else {
			        		        			bmi = null;
			        		        		}
			        		        		boolean successBMI = false;
			        		        		try {
			        		        			DbManager dbManager = new DbManager();
			        		        			if(bmi != null) {
			        		        				successBMI = dbManager.updateBMI(Integer.parseInt(rs.getString("memberID")), bmi);
			        								if(successBMI) {
			        									JOptionPane.showMessageDialog(newMember, "Success! BMI updated.");
			        								} else {
			        									JOptionPane.showMessageDialog(newMember, "Error updating BMI.");
			        								}
			        		        			}
			        		        		} catch(Exception e1) {
			        		        			e1.printStackTrace();
			        		        		}
			        		        		
			        		        		Double maxVO2;
			        		        		if(!maxVO2Text.getText().isEmpty()) {
			        		        			maxVO2 = Double.parseDouble(maxVO2Text.getText());
			        		        		} else {
			        		        			maxVO2 = null;
			        		        		}

			        		        		try {
			        		        			DbManager dbManager = new DbManager();
			        		        			boolean successVO2 = false;
			        		        			if(maxVO2 != null) {
			        		        				successVO2 = dbManager.updateVO2(Integer.parseInt(rs.getString("memberID")), maxVO2);
			        								if(successVO2) {
			        									JOptionPane.showMessageDialog(newMember, "Success! Max VO2 updated.");
			        								} else {
			        									JOptionPane.showMessageDialog(newMember, "Error updating Max VO2.");
			        								}
			        		        			}
			        		        		} catch(Exception e1) {
			        		        			e1.printStackTrace();
			        		        		}
			        		        } 
			        			});
			        		}
	            		}	            	
		            } catch (Exception e1) {
            			e1.printStackTrace();
            		}
	            	try {
            			DbManager db = new DbManager();
            			ResultSet rs = db.lookupMember(userNameTextUC.getText());
            			if(userNameTextUC.getText().equals("") || rs == null) {
            				layout.show(contentPanel, "Update Calculations");
	            		} else {
	            			layout.show(contentPanel, "Update Calculations 2");
	            		}
	            	} catch (Exception e1) {
            			e1.printStackTrace();
            		}
	            	
	            }
		            	
	            	
	            
	            else if("Go To Member".equals(command)) {
	            	try {
		        			if(!userNameText1.getText().equals("")) {
		        				GridBagConstraints um = new GridBagConstraints();
		        				um.fill = GridBagConstraints.HORIZONTAL;
		        				um.insets = new Insets(0, 0, 10, 5);
		        				DbManager db = new DbManager();
			            		ResultSet rs = db.lookupMember(userNameText1.getText().trim());
			            		if(rs == null) {
			            			layout.show(contentPanel, "Update Member");
			            		} else {
			            		rs.first();
			        			um.gridx = 0;
			        			um.gridy = 0;
			        			userName = new JLabel("Username: ");
			        			updateMemberPanel2.add(userName, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 0;
			        			um.gridwidth = 2;
			        			userNameText.setText(rs.getString("Username"));
			        			updateMemberPanel2.add(userNameText, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 1;
			        			newPassword = new JLabel("Password: ");
			        			updateMemberPanel2.add(newPassword, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 1;
			        			
			        			newPasswordText.setText(rs.getString("memberPswd"));
			        			updateMemberPanel2.add(newPasswordText, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 2;
			        			firstName = new JLabel("First Name: ");
			        			updateMemberPanel2.add(firstName, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 2;
			        			um.gridwidth = 2;
			        			
			        			firstNameTextUpdate.setText(rs.getString("memberFirst"));
			        			updateMemberPanel2.add(firstNameTextUpdate, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 3;
			        			lastName = new JLabel("Last Name: ");
			        			updateMemberPanel2.add(lastName, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 3;
			        			
			        			lastNameTextUpdate.setText(rs.getString("memberLast"));
			        			updateMemberPanel2.add(lastNameTextUpdate, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 4;
			        			email = new JLabel("Email: ");
			        			updateMemberPanel2.add(email, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 4;
			        			
			        			emailText.setText(rs.getString("memberEmail"));
			        			updateMemberPanel2.add(emailText, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 5;
			        			birthday = new JLabel("Birthday: ");
			        			try {
			        				birthdayChooser.setDate(rs.getDate("memberBday"));
			        			} catch(Exception e2) {
			        				System.out.println("Could not retrieve birthday.");
			        				birthdayChooser.setDate(null);
			        			}
			        			updateMemberPanel2.add(birthday, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 5;
			        			um.gridwidth = 2;
			        			
			        			updateMemberPanel2.add(birthdayChooser, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 6;
			        			areaCode = new JLabel("Area Code: ");
			        			updateMemberPanel2.add(areaCode, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 6;
			        			
			        			areaCodeText.setText(rs.getString("areaCode"));
			        			updateMemberPanel2.add(areaCodeText, um);
			        			
			        			um.gridx = 0;
			        			um.gridy = 7;
			        			phoneNumber = new JLabel("Phone: ");
			        			updateMemberPanel2.add(phoneNumber, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 7;
			        			
			        			phoneNumberText.setText(rs.getString("phone"));
			        			updateMemberPanel2.add(phoneNumberText, um);
			                	
			        			um.gridx = 0;
			        			um.gridy = 8;
			        			memberType = new JLabel("Type: ");
			        			updateMemberPanel2.add(memberType, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 8;
			        			updateMemberPanel2.add(memberUp, um);
			        			um.gridx = 3;
			        			um.gridy = 8;
			        			updateMemberPanel2.add(fStaffUp, um);
			        			um.gridx = 5;
			        			um.gridy = 8;
			        			updateMemberPanel2.add(trainerUp, um);
			        			um.gridx = 7;
			        			um.gridy = 8;
			        			updateMemberPanel2.add(adminUp, um);
			        			
			        			String status = rs.getString("status");
			        			System.out.println("status: " + status);
			        			System.out.println("front desk: " + fStaffUp.getText().replaceAll(" ", ""));
			        			if(status.equals(memberUp.getText())) {
			        				memberUp.setSelected(true);
			        			}
			        			if(status.equals(fStaffUp.getText().replaceAll(" ", ""))) {
			        				fStaffUp.setSelected(true);
			        			}
			        			if(status.equals(trainerUp.getText())) {
			        				trainerUp.setSelected(true);
			        			}
			        			if(status.equals(adminUp.getText())) {
			        				adminUp.setSelected(true);
			        			}
			        			
			        			um.gridx = 0;
			        			um.gridy = 9;
			        			BMI = new JLabel("BMI: ");
			        			updateMemberPanel2.add(BMI, um);
			        		
			        			um.gridx = 1;
			        			um.gridy = 9;
			        			BMIText = new JTextField(20);
			        			BMIText.setEditable(false);
			        			updateMemberPanel2.add(BMIText, um);
			        			
			        			um.gridx = 3;
			        			um.gridy = 9;
			        			JButton calculateBMI = new JButton("Calculate");
			        			updateMemberPanel2.add(calculateBMI, um);
			        			calculateBMI.addActionListener(new ActionListener() {
			        				
			        				@Override
			        				public void actionPerformed(ActionEvent e){
			        					String weight = "Weight: ";
			        					String feet = "Feet: ";
			        					String inches = "Inches: ";
			        					
			        					JOptionPane.showMessageDialog(null,"Please enter Weight in pounds");
			        					String bmiWeight = JOptionPane.showInputDialog(weight);
			        					
			        					if(weight != null) {
			        						
			        						JOptionPane.showMessageDialog(null, "Please enter Height in Feet and Inches");
			        						String bmiFeet = JOptionPane.showInputDialog(feet);
			        							
			        						if(bmiFeet != null) {
			        							
			        							String bmiInches = JOptionPane.showInputDialog(inches);
			        							
			        							if(bmiInches != null) {
			        								
			        								String calculatedBMI = calculateBMI(bmiWeight, bmiFeet, bmiInches);
			        								BMIText.setText(calculatedBMI);
			        							}
			        						}
			        					}
			        				}
			        			});
			        			um.gridx = 0;
			        			um.gridy = 10;
			        			JButton update = new JButton("Update");
			        			updateMemberPanel2.add(update, um);
			        			
			        			um.gridx = 1;
			        			um.gridy = 10;
			        			cancel = new JButton("Cancel");
			        			updateMemberPanel2.add(cancel, um);
			        			
			        			cancel.addActionListener(new ActionListener() {
			        				@Override
			        		        public void actionPerformed(ActionEvent e) {	
			        					layout.show(contentPanel, "Update Member");
			        					userNameText1.setText("");
			        					updateMemberPanel2 = null;
			        				}
			        			});
			        			
			        			contentPanel.add(updateMemberPanel2, "Update Member 2");
			        			/* Implement capability to update member
			        			 */
			        			update.addActionListener(new ActionListener() {
			        		        @Override
			        		        public void actionPerformed(ActionEvent e) {	
			        		        		//collect the values from each field
			        		        		String status = null;
			        		        		Enumeration<AbstractButton> buttons = groupUp.getElements();
			        		        		while(buttons.hasMoreElements()) {
			        		        			AbstractButton button = buttons.nextElement();
	
			        		                    if (button.isSelected()) {
			        		                        status = button.getText().replaceAll(" ", "");//trim spaces
			        		                    }
			        		        		}
			        		        		if(status == null) {//if no button is selected, initialize member to member status
			        		        			status = "Member";
			        		        		}
			        		        		String username = userNameText.getText();
			        		        		String firstName = firstNameTextUpdate.getText();
			        		        		String lastName = lastNameTextUpdate.getText();
			        		        		String email = emailText.getText();
			        		        		birthdayChooser.setDateFormatString("yyyy-MM-dd");
			        		        		Date birthday = birthdayChooser.getDate();
			        		        		Integer phone = Integer.parseInt(phoneNumberText.getText());
			        		        		Integer areaCode = Integer.parseInt(areaCodeText.getText());
			        		        		Double bmi;
			        		        		if(!BMIText.getText().isEmpty()) {
			        		        			bmi = Double.parseDouble(BMIText.getText());
			        		        		} else {
			        		        			bmi = null;
			        		        		}
			        		        		int createdBy = 0;
			        		        		String password = newPasswordText.getText(); //TODO:use getPassword() instead. I think we need to change the
			        		        														//  password field in the db to a character array
			        		        		try {
			        		        			DbManager dbManager = new DbManager();
			        		        			if(bmi != null) {
			        		        				dbManager.updateBMI(Integer.parseInt(rs.getString("memberID")), bmi);
			        		        			}
			        							try {
			        								if(dbManager.updateMember(username, firstName, lastName, email, birthday, password, createdBy, phone, areaCode, status) 
			        									) {
			        									JOptionPane.showMessageDialog(newMember, "Success! Member updated.");
			        								} else {
			        									JOptionPane.showMessageDialog(newMember, "Unable to update member. Please make sure fields are valid.");
			        								}
			        							} catch (HeadlessException | SQLException | ParseException e1) {
			        								e1.printStackTrace();
			        							}
			        		        		} catch(Exception e1) {
			        		        			e1.printStackTrace();
			        		        		}
			        		        } 
			        			});
			        		}
		        		}
	        			} catch(Exception e2) {
	        			     e2.printStackTrace();
	        		    }
	            		try {
	            			DbManager db = new DbManager();
	            			ResultSet rs = db.lookupMember(userNameText1.getText());
	            			if(userNameText1.getText().equals("") || rs == null) {
	            				layout.show(contentPanel, "Update Member");
		            		} else {
		            			layout.show(contentPanel, "Update Member 2");
		            		}
		            	} catch (Exception e1) {
	            			e1.printStackTrace();
	            		}
	            		
		            }
		}
	}

	// opens the fitness assessment forms
	private class assessmentEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			 FitnessGUI newAssessment = new FitnessGUI();
			 newAssessment.createAssessment();
		}
	}
	
	//closes the staff view frame
	private class logOutEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
	
	// look up member
	private class lookUpEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		/*
		 * this is supposed to look up the member and display the information
		 * in the JTextArea
		 */
		}
	}
	
	//calculate BMI
	private String calculateBMI(String w, String f, String i) {
		double weight = Double.parseDouble(w);
		double feet = Double.parseDouble(f);
		double inches = Double.parseDouble(i);
		
		double k = weight / 2.20462; // convert pounds to kilogram
		double cm = inches / 2.54;
		double m = (feet / 3.2808) + (cm / 100); //convert height to meters
		double bmi = (k / (m * m));
		String calculation = String.format("%.2f", bmi);
		return calculation;
	}
	//calculate aerobic capacity or Max VO2
	private String calculateAC(String rhr, String mhr) {
		String calculation ="";
		double rhrate = Double.parseDouble(rhr);
		double mhrate = Double.parseDouble(mhr);
		double maxVO2 = 15.3*(rhrate/mhrate);
		//calculation = String.valueOf(maxVO2);
		 calculation = String.format("%.2f", maxVO2);
		return calculation;
	}
}