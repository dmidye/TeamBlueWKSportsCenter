/*
 * The frame that holds all the fitness assessment forms. The date is set to editable(false) and is set
 * to the current date in yyyy-MM-dd format
 * The panels are tabbed, but the user can return to the Staff View by clicking cancel on any for the forms
 * 
 */

package OtherPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.DbManager;

	public class FitnessGUI {
	//current date and time in yyyy-MM-dd format
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate currentDate = LocalDate.now();
	
	JButton cancel;
	JTabbedPane tabbedPane;
	JFrame AssessmentFrame;
	JScrollPane scrollPane;
	
	//Coronary Risk
	JPanel coronaryRiskPanel;
	JLabel accountNumberCR;  //added this to fix issues with getText()  - Erika Clark
	JTextField accountNumberCRText;//added this to fix issues with getText()  - Erika Clark
	JTextField trainerIDCRText; //added this to fix issues with getText()  - Erika Clark
	JLabel systolicBP;
	JLabel diastolicBP;
	JLabel idealBodyWeight;
	JLabel physicalActivity;
	JLabel totalCholesteral;
	JLabel hdlRatio;
	JLabel hdlCholesterol;
	JLabel ldlCholesterol;
	JLabel triglycerides;
	JLabel glucose;


	JTextField systolicBPText;
	JTextField diastolicBPText;
	JTextField idealBodyWeightText;
	JTextField physicalActivityText;
	JTextField totalCholesteralText;
	JTextField hdlRatioText;
	JTextField hdlCholesterolText;
	JTextField ldlCholesterolText;
	JTextField triglyceridesText;
	JTextField glucoseText;
	JButton crButton;
	
	//Body Comp. Variables
	
	JPanel bodyCompPanel;
	JLabel accountNumberBodyComp;  //added this to fix issues with getText()  - Erika Clark
	JTextField accountNumberBodyCompText;//added this to fix issues with getText()  - Erika Clark
	JTextField trainerIDBCText; //added this to fix issues with getText()  - Erika Clark
	JLabel height;
	JTextField heightText;
	JLabel weight;
	JTextField weightText;
	JLabel BMI;
	JLabel domForearm;
	JLabel domArm;
	JLabel domThigh;
	JLabel abdomen;
	JLabel domAbdomen;
	JLabel waistCircumference;
	JLabel hipCircumference;
	JLabel bodyCompProtocol;
	JLabel chest;
	JLabel midAxillary;
	JLabel triceps;
	JLabel subscapular;
	JLabel suprailliac;
	JLabel thigh;
	JLabel percentBodyFat;
	JLabel leanWeight;
	JLabel fatWeight;
	JLabel desiredWeight;
	JTextField BMIText;
	JTextField domForearmText;
	JTextField domArmText;
	JTextField domThighText;
	JTextField abdomenText;
	JTextField domAbdomenText;
	JTextField waistCircumferenceText;
	JTextField hipCircumferenceText;
	JTextField bodyCompProtocolText;
	JTextField chestText;
	JTextField midAxillaryText;
	JTextField tricepsText;
	JTextField subscapularText;
	JTextField suprailliacText;
	JTextField thighText;
	JTextField percentBodyFatText;
	JTextField leanWeightText;
	JTextField fatWeightText;
	JTextField desiredWeightText;
	
	JButton bcButton;
	
	//Strength and Flex Variables
	JPanel strengthAndFlex;
	JLabel accountNumber;
	JLabel trainerID;
	JLabel date;
	JLabel pushups;
	JLabel situps;
	JLabel sitReach;
	JTextField accountNumberText;
	JTextField trainerIDText;
	JTextField dateInput;
	JTextField pushUpsText;
	JTextField sitUpsText;
	JTextField sitReachText;
	JButton sfButton;
	
	
	//Aerobic Capacity Variables
	
	JPanel aerobicCapacity;
	JLabel heartRateMax;
	JLabel restedHeartRate;
	JLabel finalTestHeartRate;
	JLabel minTargetHeartRate;
	JLabel maxTargetHeartRate;
	JLabel protocol;
	JLabel timeInMin;
	JLabel maxVO2;
	JTextField heartRateMaxText;
	JTextField restedHeartRateText;
	JTextField finalTestHeartRateText;
	JTextField minTargetHeartRateText;
	JTextField maxTargetHeartRateText;
	JTextField protocolText;
	JTextField timeInMinText;
	JTextField maxVO2Text;
	JButton acButton;
	
	//Trainer Notes - added by Erika Clark
	JLabel trainerNotesTrainerID;
	JTextField trainerNotesTrainerIDText;
	JLabel trainerNotesDate;
	JTextField trainerNotesDateText;
	JLabel trainerNotesMemberID;
	JTextField trainerNotesMemberIDText;
	JLabel trainerNotes;
	JTextArea trainerNotesText;
	JPanel notesPanel;
	JButton npButton;

	public void createAssessment() {
		// create the frame
		AssessmentFrame = new JFrame();
		AssessmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		AssessmentFrame.setSize(700, 700);
		
		//create the tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(50, 50, 400, 400);
		

	    notesPanel = new JPanel();
		notesPanel.setLayout(new GridBagLayout());
		GridBagConstraints np = new GridBagConstraints();
		np.fill = GridBagConstraints.HORIZONTAL;
		np.insets = new Insets(0, 0, 10, 5);
		
		np.gridx = 0;
		np.gridy = 0;
		trainerNotesTrainerID = new JLabel("Trainer ID: ");
		notesPanel.add(trainerNotesTrainerID, np);
		
		np.gridx = 1;
		np.gridy = 0;
		trainerNotesTrainerIDText = new JTextField(20);
		notesPanel.add(trainerNotesTrainerIDText, np);
		
		np.gridx = 0;
		np.gridy = 1;
		trainerNotesMemberID = new JLabel("Member ID: ");
		notesPanel.add(trainerNotesMemberID, np);
		
		
		np.gridx = 1;
		np.gridy = 1;
		trainerNotesMemberIDText = new JTextField(20);
		notesPanel.add(trainerNotesMemberIDText, np);
		
		np.gridx = 0;
		np.gridy = 2;
		trainerNotesDate = new JLabel("Date: ");
		notesPanel.add(trainerNotesDate, np);
		
		np.gridx = 1;
		np.gridy = 2;
		dateInput = new JTextField(dtf.format(currentDate));
		dateInput.setEditable(false);
		notesPanel.add(dateInput, np);
		
		np.gridx = 0;
		np.gridy = 3;
		trainerNotes = new JLabel("Notes:");
		notesPanel.add(trainerNotes, np);
		
		np.gridx = 1;
		np.gridy = 3;
		trainerNotesText = new JTextArea(5, 20);
		notesPanel.add(trainerNotesText, np); 
		
		np.gridx = 0;
		np.gridy = 4;
		npButton = new JButton("Save");
		notesPanel.add(npButton, np);
		
		npButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	
                	
            		//collect the values from each field
            		Integer trainingNotesID = Integer.parseInt(trainerNotesTrainerIDText.getText());
            		Integer trainingNotesMemberID = Integer.parseInt(trainerNotesMemberIDText.getText());
            		String trainernotes = trainerNotesText.getText();
            		
            		
            		DbManager dbManager = new DbManager();
				
            	
						if(dbManager.newTrainerNotes( trainingNotesMemberID, trainingNotesID, trainernotes)) {
							JOptionPane.showMessageDialog(aerobicCapacity, "Success! Trainer notes entered.");
						} else {
							JOptionPane.showMessageDialog(aerobicCapacity, "Unable to add values. Please make sure valid IDs are being entered.");
						}
            		
                } catch (Exception e1) {
                	//catches mismatched value exceptions when assigning variables.
                	//The mismatches will have already been dealt with in the for each block so we do nothing on the exception.
                	//e1.printStackTrace();
				}
         	}
        });
		
		
		
		/*
		 * create the strength and Flex Form
		 */
		strengthAndFlex = new JPanel();
		strengthAndFlex.setLayout(new GridBagLayout());
		GridBagConstraints sf = new GridBagConstraints();
		sf.fill = GridBagConstraints.HORIZONTAL;
		sf.insets = new Insets(0, 0, 10, 5);
	
	
		sf.gridx = 0;
		sf.gridy = 0;
		accountNumber = new JLabel("Account Number: ");
		strengthAndFlex.add(accountNumber, sf);
	
		sf.gridx = 1;
		sf.gridy = 0;
	
		JTextField accountNumberTextSF = new JTextField(20);//edited because the getText() method was picking up the coronary risk form and nothing else           
		accountNumberTextSF.setEditable(true);              //creating a new textfield to put here resolves the issue
		strengthAndFlex.add(accountNumberTextSF, sf);
	
		
		
		sf.gridx = 0;
		sf.gridy = 1;
		trainerID = new JLabel("Trainer ID: ");
		strengthAndFlex.add(trainerID, sf);
	
		sf.gridx = 1;
		sf.gridy = 1;

		JTextField trainerIDTextSF = new JTextField(20);//edited because the getText() method was picking up the coronary risk form and nothing else
		trainerIDTextSF.setEditable(true);              //creating a new textfield resolves the issue
		strengthAndFlex.add(trainerIDTextSF, sf);
	
		sf.gridx = 0;
		sf.gridy = 2;
		date = new JLabel("Date: ");
		strengthAndFlex.add(date, sf);
	
		sf.gridx = 1;
		sf.gridy = 2;
		dateInput = new JTextField(dtf.format(currentDate));
		dateInput.setEditable(false);
		strengthAndFlex.add(dateInput, sf);
	
		sf.gridx = 0;
		sf.gridy = 3;
		pushups = new JLabel("Push Ups: ");
		strengthAndFlex.add(pushups, sf);
	
		sf.gridx = 1;
		sf.gridy = 3;
		pushUpsText = new JTextField(5);
		pushUpsText.setEditable(true);
		strengthAndFlex.add(pushUpsText, sf);
	
		sf.gridx = 0;
		sf.gridy = 4;
		situps = new JLabel("Sit Ups: ");
		strengthAndFlex.add(situps, sf);
	
		sf.gridx = 1;
		sf.gridy = 4;
		sitUpsText = new JTextField(5);
		sitUpsText.setEditable(true);
		strengthAndFlex.add(sitUpsText, sf);
	
		sf.gridx = 0;
		sf.gridy = 5;
		sitReach = new JLabel("Sit Reach: ");
		strengthAndFlex.add(sitReach, sf);
	
		sf.gridx = 1;
		sf.gridy = 5;
		sitReachText = new JTextField(5);
		sitReachText.setEditable(true);
		strengthAndFlex.add(sitReachText, sf);
		
		sf.gridx = 0;
		sf.gridy = 6;
		sfButton = new JButton("Save");
		strengthAndFlex.add(sfButton, sf);
		
		LinkedList<JTextField> sfList = new LinkedList<JTextField>();
		sfList.add(accountNumberTextSF);
		sfList.add(trainerIDTextSF);
		sfList.add(pushUpsText);
		sfList.add(sitUpsText);
		sfList.add(sitReachText);
		
		/* Additions for the strength and flexibility "save" button made by Daniel Midyett
		 * Action Listener for the "save" button in the Strength and Flexibility form.
		 * Takes in values in the field and adds them to the database for the appropriate member.
		 * Validates data for some major cases.
		 * NOTE: The first name and last name fields are disregarded as they are not needed for the strengthflexibility table.
		 */
		sfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	for(JTextField t : sfList) {//this loop checks each field for a valid value. displays a pane to user if not valid
            			try {
            				Integer.parseInt(t.getText());//if this succeeds the value is valid
            			} catch(Exception e1) {
    						JOptionPane.showMessageDialog(strengthAndFlex, "Invalid value: " + t.getText());
            			}		
                	}
                	
            		//collect the values from each field
            		Integer memberID = Integer.parseInt(accountNumberTextSF.getText());
            		Integer trainerID = Integer.parseInt(trainerIDTextSF.getText());
            		Integer pushUps = Integer.parseInt(pushUpsText.getText());
            		Integer sitUps = Integer.parseInt(sitUpsText.getText());
            		Integer sitReach = Integer.parseInt(sitReachText.getText());
            		
            		DbManager dbManager = new DbManager();
					
            		if(dbManager.createNewMemberSFForm(memberID, trainerID, pushUps, sitUps, sitReach)) {
						JOptionPane.showMessageDialog(aerobicCapacity, "Success! Strength and Flexibility information entered.");
					} else {
						JOptionPane.showMessageDialog(aerobicCapacity, "Unable to add values. Please make sure valid member and trainer IDs are entered.");
					}
            		
                } catch (Exception e1) {
                	//catches mismatched value exceptions when assigning variables.
                	//The mismatches will have already been dealt with in the for each block so we do nothing on the exception.
                	e1.printStackTrace();
				}
         	}
        });
		
		sf.gridx = 1;
		sf.gridy = 6;
		cancel = new JButton("Cancel");
		cancel.addActionListener(new cancelEvent());
		strengthAndFlex.add(cancel, sf);
	
		/*
		 * create the Aerobic Capacity Form
		 */
		
		aerobicCapacity = new JPanel();
		aerobicCapacity.setLayout(new GridBagLayout());
		GridBagConstraints ac = new GridBagConstraints();
		ac.fill = GridBagConstraints.HORIZONTAL;
		ac.insets = new Insets(0, 0, 10, 5);
	
	
		ac.gridx = 0;
		ac.gridy = 0;
		accountNumber = new JLabel("Account Number: ");
		aerobicCapacity.add(accountNumber, ac);
	
		ac.gridx = 1;
		ac.gridy = 0;
	
		JTextField accountNumberTextAC = new JTextField(20);//edited because the getText() method was picking up the coronary risk form and nothing else
		accountNumberTextAC.setEditable(true); //creating a new textfield here resolves the issue
		aerobicCapacity.add(accountNumberTextAC, ac);
	
		ac.gridx = 0;
		ac.gridy = 1;
		trainerID = new JLabel("Trainer ID: ");
		aerobicCapacity.add(trainerID, ac);
	
		ac.gridx = 1;
		ac.gridy = 1;

		JTextField trainerIDTextAC = new JTextField(20);//edited because the getText() method was picking up the coronary risk form and nothing else
		trainerIDTextAC.setEditable(true);              //creating a new textfield here resolves the issue
		aerobicCapacity.add(trainerIDTextAC, ac);
	
		ac.gridx = 0;
		ac.gridy = 2;
		date = new JLabel("Date: ");
		aerobicCapacity.add(date, ac);
	
		ac.gridx = 1;
		ac.gridy = 2;
		dateInput = new JTextField(dtf.format(currentDate));
		dateInput.setEditable(false);
		aerobicCapacity.add(dateInput, ac);
	
		ac.gridx = 0;
		ac.gridy = 3;
		heartRateMax = new JLabel("Max Heart Rate: ");
		aerobicCapacity.add(heartRateMax, ac);
	
		ac.gridx = 1;
		ac.gridy = 3;
		heartRateMaxText = new JTextField(20);
		heartRateMaxText.setEditable(true);
		aerobicCapacity.add(heartRateMaxText, ac);
		
		ac.gridx = 0;
		ac.gridy = 4;
		restedHeartRate = new JLabel("Rested Heart Rate: ");
		aerobicCapacity.add(restedHeartRate, ac);
	
		ac.gridx = 1;
		ac.gridy = 4;
		restedHeartRateText = new JTextField(20);
		restedHeartRateText.setEditable(true);
		aerobicCapacity.add(restedHeartRateText, ac);
		
		ac.gridx = 0;
		ac.gridy = 5;
		finalTestHeartRate = new JLabel("Final Test Heart Rate: ");
		aerobicCapacity.add(finalTestHeartRate, ac);
	
		ac.gridx = 1;
		ac.gridy = 5;
		finalTestHeartRateText = new JTextField(20);
		finalTestHeartRateText.setEditable(true);
		aerobicCapacity.add(finalTestHeartRateText, ac);
		
		
		ac.gridx = 0;
		ac.gridy = 6;
		minTargetHeartRate = new JLabel("Target Heart Rate (Min): ");
		aerobicCapacity.add(minTargetHeartRate, ac);
	
		ac.gridx = 1;
		ac.gridy = 6;
		minTargetHeartRateText = new JTextField(20);
		minTargetHeartRateText.setEditable(true);
		aerobicCapacity.add(minTargetHeartRateText, ac);
		
		ac.gridx = 0;
		ac.gridy = 7;
		maxTargetHeartRate = new JLabel("Target Heart Rate (Max): ");
		aerobicCapacity.add(maxTargetHeartRate, ac);
	
		ac.gridx = 1;
		ac.gridy = 7;
		maxTargetHeartRateText = new JTextField(20);
		maxTargetHeartRateText.setEditable(true);
		aerobicCapacity.add(maxTargetHeartRateText, ac);
		
		ac.gridx = 0;
		ac.gridy = 8;
		protocol = new JLabel("Protocol: ");
		aerobicCapacity.add(protocol, ac);
	
		ac.gridx = 1;
		ac.gridy = 8;
		protocolText = new JTextField(20);
		protocolText.setName("protocol");
		protocolText.setEditable(true);
		aerobicCapacity.add(protocolText, ac);
		
		ac.gridx = 0;
		ac.gridy = 9;
		timeInMin = new JLabel("Time In Minutes: ");
		aerobicCapacity.add(timeInMin, ac);
	
		ac.gridx = 1;
		ac.gridy = 9;
		timeInMinText = new JTextField(20);
		timeInMinText.setEditable(true);
		aerobicCapacity.add(timeInMinText, ac);
		
		
		ac.gridx = 0;
		ac.gridy = 11;
		maxVO2 = new JLabel("Max VO2: ");
		aerobicCapacity.add(maxVO2, ac);
	
		ac.gridx = 1;
		ac.gridy = 11;
		maxVO2Text = new JTextField(20);
		maxVO2Text.setEditable(false);
		aerobicCapacity.add(maxVO2Text, ac);
		
		ac.gridx = 2;
		ac.gridy = 11;
		JButton calculateAC = new JButton("Calculate");
		calculateAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxVO2Text.setText(calculateAC(restedHeartRateText.getText(),heartRateMaxText.getText()));
			}
		});
		aerobicCapacity.add(calculateAC, ac);
		
		
		ac.gridx = 0;
		ac.gridy = 12;
		acButton = new JButton("Save");
		aerobicCapacity.add(acButton, ac);
		
		LinkedList<JTextField> acList = new LinkedList<JTextField>();//list contains all fields except for protocol
		acList.add(accountNumberTextAC);
		acList.add(trainerIDTextAC);
		acList.add(heartRateMaxText);
		acList.add(restedHeartRateText);
		acList.add(finalTestHeartRateText);
		acList.add(minTargetHeartRateText);
		acList.add(maxTargetHeartRateText);
		acList.add(timeInMinText);
	
		
		/* Additions for the aerobic capacity form made by Daniel Midyett
		 * Action Listener for the "save" button in the Aerobic Capacity form.
		 * Takes in values in the field and adds them to the database for the appropriate member.
		 * Validates data for some major cases.
		 * NOTE: The first name and last name fields are disregarded as they are not needed for the aerobiccapacity table.
		 */
		acButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	for(JTextField t : acList) {//this loop checks each field for a valid value. displays a pane to user if not valid
            			try {
            				Integer.parseInt(t.getText());//if this succeeds the value is valid
            			} catch(Exception e1) {
            				//currently shows the dialog for every empty/invalid value. Could be annoying to click through them all
            				JOptionPane.showMessageDialog(aerobicCapacity, "Invalid value: " + t.getText());
            			}		
                	}
                	
            		//collect the values from each field
            		Integer memberID = Integer.parseInt(accountNumberTextAC.getText());
            		Integer trainrID = Integer.parseInt(trainerIDTextAC.getText());
            		Integer heartRMax = Integer.parseInt(heartRateMaxText.getText());
            		Integer restedHeartR = Integer.parseInt(restedHeartRateText.getText());
            		Integer finalTestHeartR = Integer.parseInt(finalTestHeartRateText.getText());
            		Integer minTargetHeartR = Integer.parseInt(minTargetHeartRateText.getText());
            		Integer maxTargetHeartR = Integer.parseInt(maxTargetHeartRateText.getText());
            		Integer timeInMins = Integer.parseInt(timeInMinText.getText());
            		double maxVO2 = Double.parseDouble(maxVO2Text.getText());       
            		String protocol = protocolText.getText().toLowerCase();
            		
            		DbManager dbManager = new DbManager();
					
            		try {
            			Integer.parseInt(protocol);//if this succeeds, protocol is an integer and invalid.
    					JOptionPane.showMessageDialog(aerobicCapacity, "Invald protocol value.");
            		} catch(Exception e1) {
						if(dbManager.createNewMemberACForm(memberID, trainrID, heartRMax, restedHeartR, finalTestHeartR, 
							minTargetHeartR, maxTargetHeartR, protocol, timeInMins, maxVO2)) {
							JOptionPane.showMessageDialog(aerobicCapacity, "Success! Aerobic Capacity information entered.");
						} else {
							JOptionPane.showMessageDialog(aerobicCapacity, "Unable to add values. Please make sure valid IDs are being entered.");
						}
            		}
                } catch (Exception e1) {
                	//catches mismatched value exceptions when assigning variables.
                	//The mismatches will have already been dealt with in the for each block so we do nothing on the exception.
                	//e1.printStackTrace();
				}
         	}
        });
		
		
		ac.gridx = 1;
		ac.gridy = 12;
		cancel = new JButton("Cancel");
		cancel.addActionListener(new cancelEvent());
		aerobicCapacity.add(cancel, ac);
		
		/*
		 * create the Body Composition Form
		 */
		bodyCompPanel = new JPanel();
		bodyCompPanel.setLayout(new GridBagLayout());
		GridBagConstraints bc = new GridBagConstraints();
		bc.fill = GridBagConstraints.HORIZONTAL;
		bc.insets = new Insets(0, 0, 5, 0);
		bc.weightx = 1.0;
		
	
		bc.gridx = 0;
		bc.gridy = 0;
		accountNumberBodyComp = new JLabel("Account Number: ");
		bodyCompPanel.add(accountNumberBodyComp, bc);
	
		bc.gridx = 1;
		bc.gridy = 0;
	
		accountNumberBodyCompText = new JTextField(20);
		accountNumberBodyCompText.setEditable(true);
		bodyCompPanel.add(accountNumberBodyCompText, bc);
	
		
		
		bc.gridx = 0;
		bc.gridy = 1;
		trainerID = new JLabel("Trainer ID: ");
		bodyCompPanel.add(trainerID, bc);
	
		bc.gridx = 1;
		bc.gridy = 1;
		trainerIDBCText = new JTextField(20);
		trainerIDBCText.setEditable(true);
		bodyCompPanel.add(trainerIDBCText, bc);
	
		bc.gridx = 0;
		bc.gridy = 2;
		date = new JLabel("Date: ");
		bodyCompPanel.add(date, bc);
	
		bc.gridx = 1;
		bc.gridy = 2;
		dateInput = new JTextField(dtf.format(currentDate));
		dateInput.setEditable(false);
		bodyCompPanel.add(dateInput, bc);
		

		bc.gridx = 0;
		bc.gridy = 3;
		BMI = new JLabel("BMI: ");
		bodyCompPanel.add(BMI, bc);
	
		bc.gridx = 1;
		bc.gridy = 3;
		BMIText = new JTextField(20);
		BMIText.setEditable(false);
		bodyCompPanel.add(BMIText, bc);
		
		bc.gridx = 2;
		bc.gridy = 3;
		JButton calculateBMI = new JButton("Calculate");
		bodyCompPanel.add(calculateBMI, bc);
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
		
		bc.gridx = 0;
		bc.gridy = 4;
		domForearm = new JLabel("Dominant Forearm: ");
		bodyCompPanel.add(domForearm, bc);
	
		bc.gridx = 1;
		bc.gridy = 4;
		domForearmText = new JTextField(20);
		domForearmText.setEditable(true);
		bodyCompPanel.add(domForearmText, bc);
		
		bc.gridx = 0;
		bc.gridy = 5;
		domArm = new JLabel("Dominant Arm: ");
		bodyCompPanel.add(domArm, bc);
	
		bc.gridx = 1;
		bc.gridy = 5;
		domArmText = new JTextField(20);
		domArmText.setEditable(true);
		bodyCompPanel.add(domArmText, bc);
		
		bc.gridx = 0;
		bc.gridy = 6;
		domThigh = new JLabel("Dominant Thigh: ");
		bodyCompPanel.add(domThigh, bc);
	
		bc.gridx = 1;
		bc.gridy = 6;
		domThighText = new JTextField(20);
		domThighText.setEditable(true);
		bodyCompPanel.add(domThighText, bc);
		
		bc.gridx = 0;
		bc.gridy = 7;
		domAbdomen = new JLabel("Dominant Abdomen: ");
		bodyCompPanel.add(domAbdomen, bc);
	
		bc.gridx = 1;
		bc.gridy = 7;
		domAbdomenText = new JTextField(20);
		domAbdomenText.setEditable(true);
		bodyCompPanel.add(domAbdomenText, bc);
		
		bc.gridx = 0;
		bc.gridy = 8;
		waistCircumference = new JLabel("Waist Circumference: ");
		bodyCompPanel.add(waistCircumference, bc);
	
		bc.gridx = 1;
		bc.gridy = 8;
		waistCircumferenceText = new JTextField(20);
		waistCircumferenceText.setEditable(true);
		bodyCompPanel.add(waistCircumferenceText, bc);
		
		bc.gridx = 0;
		bc.gridy = 9;
		hipCircumference = new JLabel("Hip Circumference: ");
		bodyCompPanel.add(hipCircumference, bc);
	
		bc.gridx = 1;
		bc.gridy = 9;
		hipCircumferenceText = new JTextField(20);
		hipCircumferenceText.setEditable(true);
		bodyCompPanel.add(hipCircumferenceText, bc);
		
		bc.gridx = 0;
		bc.gridy = 10;
		bodyCompProtocol = new JLabel("Body Composition Protocol: ");
		bodyCompPanel.add(bodyCompProtocol, bc);
	
		bc.gridx = 1;
		bc.gridy = 10;
		bodyCompProtocolText = new JTextField(20);
		bodyCompProtocolText.setEditable(true);
		bodyCompPanel.add(bodyCompProtocolText, bc);
		
		bc.gridx = 0;
		bc.gridy = 11;
		chest = new JLabel("Chest: ");
		bodyCompPanel.add(chest, bc);
	
		bc.gridx = 1;
		bc.gridy = 11;
		chestText = new JTextField(20);
		chestText.setEditable(true);
		bodyCompPanel.add(chestText, bc);
		
		bc.gridx = 0;
		bc.gridy = 12;
		midAxillary = new JLabel("Mid Axillary: ");
		bodyCompPanel.add(midAxillary, bc);
	
		bc.gridx = 1;
		bc.gridy = 12;
		midAxillaryText = new JTextField(20);
		midAxillaryText.setEditable(true);
		bodyCompPanel.add(midAxillaryText, bc);
		
		bc.gridx = 0;
		bc.gridy = 13;
		triceps = new JLabel("Triceps: ");
		bodyCompPanel.add(triceps, bc);
	
		bc.gridx = 1;
		bc.gridy = 13;
		tricepsText = new JTextField(20);
		tricepsText.setEditable(true);
		bodyCompPanel.add(tricepsText, bc);
		
		bc.gridx = 0;
		bc.gridy = 14;
		subscapular = new JLabel("Sub Scapular: ");
		bodyCompPanel.add(subscapular, bc);
	
		bc.gridx = 1;
		bc.gridy = 14;
		subscapularText = new JTextField(20);
		subscapularText.setEditable(true);
		bodyCompPanel.add(subscapularText, bc);
	
		bc.gridx = 0;
		bc.gridy = 15;
		abdomen = new JLabel("Abdomen: ");
		bodyCompPanel.add(abdomen, bc);
	
		bc.gridx = 1;
		bc.gridy = 15;
		abdomenText = new JTextField(20);
		abdomenText.setEditable(true);
		bodyCompPanel.add(abdomenText, bc);
		
		bc.gridx = 0;
		bc.gridy = 16;
		suprailliac = new JLabel("Suprailliac: ");
		bodyCompPanel.add(suprailliac, bc);
	
		bc.gridx = 1;
		bc.gridy = 16;
		suprailliacText = new JTextField(20);
		suprailliacText.setEditable(true);
		bodyCompPanel.add(suprailliacText, bc);
		
		bc.gridx = 0;
		bc.gridy = 17;
		thigh = new JLabel("Thigh: ");
		bodyCompPanel.add(thigh, bc);
	
		bc.gridx = 1;
		bc.gridy = 17;
		thighText = new JTextField(20);
		thighText.setEditable(true);
		bodyCompPanel.add(thighText, bc);
		
		
		bc.gridx = 0;
		bc.gridy = 18;
		percentBodyFat = new JLabel("Percent Body Fat: ");
		bodyCompPanel.add(percentBodyFat, bc);
	
		bc.gridx = 1;
		bc.gridy = 18;
		percentBodyFatText = new JTextField(20);
		percentBodyFatText.setEditable(true);
		bodyCompPanel.add(percentBodyFatText, bc);
		
		bc.gridx = 0;
		bc.gridy = 19;
		leanWeight = new JLabel("Lean Weight: ");
		bodyCompPanel.add(leanWeight, bc);
	
		bc.gridx = 1;
		bc.gridy = 19;
		leanWeightText = new JTextField(20);
		leanWeightText.setEditable(true);
		bodyCompPanel.add(leanWeightText, bc);
		
		
		bc.gridx = 0;
		bc.gridy = 20;
		fatWeight = new JLabel("Fat Weight: ");
		bodyCompPanel.add(fatWeight, bc);
	
		bc.gridx = 1;
		bc.gridy = 20;
		fatWeightText = new JTextField(20);
		fatWeightText.setEditable(true);
		bodyCompPanel.add(fatWeightText, bc);
		

		bc.gridx = 0;
		bc.gridy = 21;
		desiredWeight = new JLabel("Desired Weight: ");
		bodyCompPanel.add(desiredWeight, bc);
	
		bc.gridx = 1;
		bc.gridy = 21;
		desiredWeightText = new JTextField(20);
		desiredWeightText.setEditable(true);
		bodyCompPanel.add(desiredWeightText, bc);
		
		
		bc.gridx = 0;
		bc.gridy = 22;
		bcButton = new JButton("Save");
		bodyCompPanel.add(bcButton, bc);
		
		bc.gridx = 1;
		bc.gridy = 22;
		cancel = new JButton("Cancel");
		cancel.addActionListener(new cancelEvent());
		bodyCompPanel.add(cancel, bc);
		
		
		LinkedList<JTextField> bcList = new LinkedList<JTextField>();
		bcList.add(accountNumberBodyCompText);
		bcList.add(trainerIDBCText);
		bcList.add(domForearmText);
		bcList.add(domArmText);
		bcList.add(domThighText);
		bcList.add(abdomenText);
		bcList.add(waistCircumferenceText);
		bcList.add(hipCircumferenceText);
		bcList.add(chestText);
		bcList.add(midAxillaryText);
		bcList.add(tricepsText);
		bcList.add(subscapularText);
		bcList.add(suprailliacText);
		bcList.add(thighText);
		bcList.add(percentBodyFatText);
		bcList.add(leanWeightText);
		bcList.add(fatWeightText); 
		bcList.add(desiredWeightText);
		//Additions for the body composition form 
	
		bcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                	for(JTextField t : bcList) {//this loop checks each field for a valid value. displays a pane to user if not valid
            			try {
            				Integer.parseInt(t.getText());//if this succeeds the value is valid
            			} catch(Exception e1) {
    						JOptionPane.showMessageDialog(bodyCompPanel, "Invalid value: " + t.getText());
            			}		
                	} 
               
            		//collect the values from each field
            		Integer memberID = Integer.parseInt(accountNumberBodyCompText.getText());
            		Integer trainerID = Integer.parseInt(trainerIDBCText.getText());
            		Double BMI = Double.parseDouble(BMIText.getText());
            		Integer domForearm = Integer.parseInt(domForearmText.getText());
            		Integer domArm = Integer.parseInt(domArmText.getText());
            		Integer domThigh = Integer.parseInt(domThighText.getText());
            		Integer domAbdomen = Integer.parseInt(domAbdomenText.getText());
            		Integer waistCircumference= Integer.parseInt(waistCircumferenceText.getText());
            		Integer hipCircumference = Integer.parseInt(hipCircumferenceText.getText());
            		String bodyCompProtocol = bodyCompProtocolText.getText().toLowerCase();
            		Integer chest = Integer.parseInt(chestText.getText());
            		Integer midAxillary = Integer.parseInt(midAxillaryText.getText());
            		Integer triceps = Integer.parseInt(tricepsText.getText());
            		Integer subscapular = Integer.parseInt(subscapularText.getText());
            		Integer abdomenField = Integer.parseInt(abdomenText.getText());
            		Integer suprailliac = Integer.parseInt(suprailliacText.getText());
            		Integer thighField = Integer.parseInt(thighText.getText());
            		Integer percentBodyFat = Integer.parseInt(percentBodyFatText.getText());
            		Integer leanWeight = Integer.parseInt(leanWeightText.getText());
            		Integer fatWeight = Integer.parseInt(fatWeightText.getText());
            		Integer desiredWeightField = Integer.parseInt(desiredWeightText.getText());
            		
            		
            		DbManager dbManager = new DbManager();
					
            		if(dbManager.createNewMemberBCForm(memberID, trainerID, BMI, domForearm, domArm, domThigh, domAbdomen, waistCircumference,
            				hipCircumference, bodyCompProtocol, chest, midAxillary, triceps, subscapular, abdomenField, suprailliac, thighField, percentBodyFat,
            				leanWeight, fatWeight, desiredWeightField)) {
						JOptionPane.showMessageDialog(bodyCompPanel, "Success! Body Composition information entered." + BMIText.getText());
					} else {
						JOptionPane.showMessageDialog(bodyCompPanel, "Unable to add values. Please make sure valid member and trainer IDs are being entered." +  BMIText.getText());
					}
            		
                } catch (Exception e1) {
                	//catches mismatched value exceptions when assigning variables.
                	//The mismatches will have already been dealt with in the for each block so we do nothing on the exception.
                	e1.printStackTrace();
				}
         	}
        });

		//add bodyComp to scroll Pane
		scrollPane = new JScrollPane(bodyCompPanel);
		
		
		/*
		 * create coronory risk panel
		 */
		coronaryRiskPanel = new JPanel();
		coronaryRiskPanel.setLayout(new GridBagLayout());
		GridBagConstraints cr = new GridBagConstraints();
		cr.fill = GridBagConstraints.HORIZONTAL;
		cr.insets = new Insets(0, 0, 5, 0);
		cr.weightx = 1.0;
		
	
		cr.gridx = 0;
		cr.gridy = 0;
		accountNumberCR = new JLabel("Account Number: ");
		coronaryRiskPanel.add(accountNumberCR, cr);
	
		cr.gridx = 1;
		cr.gridy = 0;
	
		accountNumberCRText = new JTextField(20);
		accountNumberCRText.setEditable(true);
		coronaryRiskPanel.add(accountNumberCRText, cr);
	
	
		
		cr.gridx = 0;
		cr.gridy = 1;
		trainerID = new JLabel("Trainer ID: ");
		coronaryRiskPanel.add(trainerID, cr);
	
		cr.gridx = 1;
		cr.gridy = 1;
		trainerIDCRText = new JTextField(20);
		trainerIDCRText.setEditable(true);
		coronaryRiskPanel.add(trainerIDCRText, cr);
	
		cr.gridx = 0;
		cr.gridy = 2;
		date = new JLabel("Date: ");
		coronaryRiskPanel.add(date, cr);
	
		cr.gridx = 1;
		cr.gridy = 2;
		dateInput = new JTextField(dtf.format(currentDate));
		dateInput.setEditable(false);
		coronaryRiskPanel.add(dateInput, cr);
		

		cr.gridx = 0;
		cr.gridy = 3;
		systolicBP = new JLabel("Systolic Blood Pressure: ");
		coronaryRiskPanel.add(systolicBP, cr);
	
		cr.gridx = 1;
		cr.gridy = 3;
		systolicBPText = new JTextField(20);
		systolicBPText.setEditable(true);
		coronaryRiskPanel.add(systolicBPText, cr);
		
		cr.gridx = 0;
		cr.gridy = 4;
		diastolicBP = new JLabel("Diastolic Blood Pressure: ");
		coronaryRiskPanel.add(diastolicBP, cr);
	
		cr.gridx = 1;
		cr.gridy = 4;
		diastolicBPText = new JTextField(20);
		diastolicBPText.setEditable(true);
		coronaryRiskPanel.add(diastolicBPText, cr);
		
		cr.gridx = 0;
		cr.gridy = 5;
		idealBodyWeight= new JLabel("Ideal Body Weight: ");
		coronaryRiskPanel.add(idealBodyWeight, cr);
	
		cr.gridx = 1;
		cr.gridy = 6;
		idealBodyWeightText = new JTextField(20);
		idealBodyWeightText.setEditable(true);
		coronaryRiskPanel.add(idealBodyWeightText, cr);
		
		cr.gridx = 0;
		cr.gridy = 7;
		physicalActivity = new JLabel("Physical Activity: ");
		coronaryRiskPanel.add(physicalActivity, cr);
	
		cr.gridx = 1;
		cr.gridy = 7;
		physicalActivityText = new JTextField(20);
		physicalActivityText.setEditable(true);
		coronaryRiskPanel.add(physicalActivityText, cr);
		
		cr.gridx = 0;
		cr.gridy = 8;
		totalCholesteral = new JLabel("Total Cholesterol: ");
		coronaryRiskPanel.add(totalCholesteral, cr);
	
		cr.gridx = 1;
		cr.gridy = 8;
		totalCholesteralText = new JTextField(20);
		totalCholesteralText.setEditable(true);
		coronaryRiskPanel.add(totalCholesteralText, cr);
		
		cr.gridx = 0;
		cr.gridy = 9;
		hdlRatio = new JLabel("HDL Ratio: ");
		coronaryRiskPanel.add(hdlRatio, cr);
	
		cr.gridx = 1;
		cr.gridy = 9;
		hdlRatioText = new JTextField(20);
		hdlRatioText.setEditable(true);
		coronaryRiskPanel.add(hdlRatioText, cr);
		
		cr.gridx = 0;
		cr.gridy = 10;
		hdlCholesterol = new JLabel("HDL Cholesterol: ");
		coronaryRiskPanel.add(hdlCholesterol, cr);
	
		cr.gridx = 1;
		cr.gridy = 10;
		hdlCholesterolText = new JTextField(20);
		hdlCholesterolText.setEditable(true);
		coronaryRiskPanel.add(hdlCholesterolText, cr);
		
		cr.gridx = 0;
		cr.gridy = 11;
		ldlCholesterol = new JLabel("LDL Cholesterol: ");
		coronaryRiskPanel.add(ldlCholesterol, cr);
	
		cr.gridx = 1;
		cr.gridy = 11;
		ldlCholesterolText = new JTextField(20);
		ldlCholesterolText.setEditable(true);
		coronaryRiskPanel.add(ldlCholesterolText, cr);
		
		cr.gridx = 0;
		cr.gridy = 12;
		triglycerides = new JLabel("Triglycerides: ");
		coronaryRiskPanel.add(triglycerides, cr);
	
		cr.gridx = 1;
		cr.gridy = 12;
		triglyceridesText = new JTextField(20);
		triglyceridesText.setEditable(true);
		coronaryRiskPanel.add(triglyceridesText, cr);
		
		cr.gridx = 0;
		cr.gridy = 13;
		glucose = new JLabel("Mid Axillary: ");
		coronaryRiskPanel.add(glucose, cr);
	
		cr.gridx = 1;
		cr.gridy = 13;
		glucoseText = new JTextField(20);
		glucoseText.setEditable(true);
		coronaryRiskPanel.add(glucoseText, cr);
		
		cr.gridx = 0;
		cr.gridy = 14;
		crButton = new JButton("Save");
		coronaryRiskPanel.add(crButton, cr);
		cr.gridx = 1;
		cr.gridy = 14;
		cancel = new JButton("Cancel");
		cancel.addActionListener(new cancelEvent());
		coronaryRiskPanel.add(cancel, cr);
		
		
		
		LinkedList<JTextField> crList = new LinkedList<JTextField>();
		crList.add(accountNumberCRText);
		crList.add(trainerIDCRText);
		crList.add(systolicBPText);
		crList.add(diastolicBPText);
		crList.add(idealBodyWeightText);
		crList.add(totalCholesteralText);
		crList.add(hdlRatioText);
		crList.add(hdlCholesterolText);
		crList.add(ldlCholesterolText);
		crList.add(triglyceridesText);
		crList.add(glucoseText);

		/* Additions for the coronary risk form */
		
		crButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	for(JTextField t : crList) {//this loop checks each field for a valid value. displays a pane to user if not valid
            			try {
            				Integer.parseInt(t.getText());//if this succeeds the value is valid
            			} catch(Exception e1) {
    						JOptionPane.showMessageDialog(coronaryRiskPanel, "Invalid value: " + t.getText());
            			}		
                	}
                	
            		//collect the values from each field
            		Integer memberID = Integer.parseInt(accountNumberCRText.getText());
            		Integer trainerID = Integer.parseInt(trainerIDCRText.getText());
            		Integer systolicBP = Integer.parseInt(systolicBPText.getText());
            		Integer diastolicBP = Integer.parseInt(diastolicBPText.getText());
            		Integer idealBodyWeight = Integer.parseInt(idealBodyWeightText.getText());
            		String physicalActivity = physicalActivityText.getText();
            		Integer totalCholesteral = Integer.parseInt(totalCholesteralText.getText());
            		Integer hdlRatio= Integer.parseInt(hdlRatioText.getText());
            		Integer hdlCholesterol = Integer.parseInt(hdlCholesterolText.getText());
            		Integer ldlCholesterol = Integer.parseInt(ldlCholesterolText.getText());
            		Integer triglycerides = Integer.parseInt(triglyceridesText.getText());      		
            		Integer glucose = Integer.parseInt(glucoseText.getText());           		
            		
            		DbManager dbManager = new DbManager();
					
            		if(dbManager.createNewMemberCRForm(memberID, trainerID, systolicBP, diastolicBP, idealBodyWeight, physicalActivity, totalCholesteral, hdlRatio,
            				hdlCholesterol, ldlCholesterol, triglycerides, glucose)) {
						JOptionPane.showMessageDialog(coronaryRiskPanel, "Success! Coronary Risk information entered.");
					} else {
						JOptionPane.showMessageDialog(coronaryRiskPanel, "Unable to add values. Please make sure valid member and trainer IDs are being entered.");
					}
            		
                } catch (Exception e1) {
                	//catches mismatched value exceptions when assigning variables.
                	//The mismatches will have already been dealt with in the for each block so we do nothing on the exception.
                	//e1.printStackTrace();
				}
         	}
        });
		
		
	
		tabbedPane.add("Coronary Risk", coronaryRiskPanel);
		tabbedPane.add("Body Composition", scrollPane);
		tabbedPane.add("Strength and Flex", strengthAndFlex);
		tabbedPane.add("Aerobic Capacity", aerobicCapacity);
		tabbedPane.add("Trainer Notes", notesPanel);
		AssessmentFrame.add(tabbedPane);
		AssessmentFrame.setVisible(true);	
	
	}//end createAssessment
	
	private class cancelEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AssessmentFrame.dispose();
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
