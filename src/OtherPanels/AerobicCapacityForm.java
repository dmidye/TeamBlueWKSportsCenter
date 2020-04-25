package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import Database.DbManager;

public class AerobicCapacityForm  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame parentFrame;
	JTextField heartRateMax;
	JTextField restingHeartRate;
	JTextField minHRPercent;
	JTextField maxHRPercent;
	JTextField finalTestedHeartRate;
	JTextField protocol;
	JTextField timeInMinutes;
	JTextField workTarget;
	
	JLabel name;
	
	//place holder labels
	JLabel MaxVO2;
	JLabel heartRateRange;
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	JButton calculate;
	JButton calculate2;
	JButton saveNote;
	JButton saveNote2;
	JButton save;
	JButton cancel;
	ResultSet rs;
	String staffID;
	int dob;
	String username;
	
	public AerobicCapacityForm(String username, String staffID) throws SQLException, ParseException {
		this.staffID = staffID;
		this.username = username;
		DbManager db = new DbManager();
		dob = Integer.parseInt(db.getAge(username));
	    rs = db.lookupMember(username);
		setTitle("Aerobic Capacity Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/AerobicCapacityForm.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		name = new JLabel (rs.getString("memberFirst") + " " + rs.getString("memberLast"));
		name.setBounds(880, 40, 200, 25);
		name.setFont(font1);
		form.add(name);
		
		restingHeartRate = new JTextField(10);
		restingHeartRate.setBounds(448, 165, 80, 25);
		restingHeartRate.setOpaque(false);
		restingHeartRate.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		restingHeartRate.setFont(font1);
		restingHeartRate.setEditable(true);
		form.add(restingHeartRate);
		
		minHRPercent = new JTextField(10);
		minHRPercent.setBounds(448, 197, 80, 25);
		minHRPercent.setOpaque(false);
		minHRPercent.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		minHRPercent.setFont(font1);
		minHRPercent.setEditable(true);
		form.add(minHRPercent);
		
		maxHRPercent = new JTextField(10);
		maxHRPercent.setBounds(445, 232, 80, 25);
		maxHRPercent.setOpaque(false);
		maxHRPercent.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		maxHRPercent.setFont(font1);
		maxHRPercent.setEditable(true);
		form.add(maxHRPercent);
		
		heartRateMax = new JTextField(10);
		heartRateMax.setBounds(448, 270, 80, 25);
		heartRateMax.setOpaque(false);
		heartRateMax.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		heartRateMax.setFont(font1);
		heartRateMax.setEditable(true);
		form.add(heartRateMax);
		
				
		finalTestedHeartRate = new JTextField(10);
		finalTestedHeartRate.setBounds(448, 310, 80, 25);
		finalTestedHeartRate.setOpaque(false);
		finalTestedHeartRate.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		finalTestedHeartRate.setFont(font1);
		finalTestedHeartRate.setEditable(true);
		form.add(finalTestedHeartRate);
		
		protocol = new JTextField(10);
		protocol.setBounds(210, 400, 80, 25);
		protocol.setOpaque(false);
		protocol.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		protocol.setFont(font1);
		protocol.setEditable(true);
		form.add(protocol);
		
		timeInMinutes = new JTextField(10);
		timeInMinutes.setBounds(210, 432, 80, 25);
		timeInMinutes.setOpaque(false);
		timeInMinutes.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		timeInMinutes.setFont(font1);
		timeInMinutes.setEditable(true);
		form.add(timeInMinutes);
		
		workTarget = new JTextField(10);
		workTarget.setBounds(210, 470, 80, 25);
		workTarget.setOpaque(false);
		workTarget.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		workTarget.setFont(font1);
		workTarget.setEditable(true);
		form.add(workTarget);
		
		calculate = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CalculateButton.png")));
		calculate.setBounds(300, 470, 153, 33);
		calculate.setOpaque(false);
		calculate.setContentAreaFilled(false);
		calculate.setBorderPainted(false);
		calculate.setFocusPainted(false);
		calculate.addActionListener(new calculateButton());
		form.add(calculate);
		
		calculate2 = new JButton(new ImageIcon(AerobicCapacityForm.class.getResource("/StaffViewAssets/CalculateButton.png")));
		calculate2.setBounds(520, 270, 153, 33);
		calculate2.setOpaque(false);
		calculate2.setContentAreaFilled(false);
		calculate2.setBorderPainted(false);
		calculate2.setFocusPainted(false);
		calculate2.addActionListener(new calculateButton2());
		form.add(calculate2);
		
		saveNote = new JButton(new ImageIcon(AerobicCapacityForm.class.getResource("/StaffViewAssets/saveNoteSmall.png")));
		saveNote.setBounds(585, 200, 166, 26);
		saveNote.setOpaque(false);
		saveNote.setContentAreaFilled(false);
		saveNote.setBorderPainted(false);
		saveNote.setFocusPainted(false);
		saveNote.addActionListener(new saveNoteButton1());
		saveNote.setVisible(false);
		form.add(saveNote);
		
		saveNote2 = new JButton(new ImageIcon(AerobicCapacityForm.class.getResource("/StaffViewAssets/saveNoteSmall.png")));
		saveNote2.setBounds(300, 440, 166, 26);
		saveNote2.setOpaque(false);
		saveNote2.setContentAreaFilled(false);
		saveNote2.setBorderPainted(false);
		saveNote2.setFocusPainted(false);
		saveNote2.addActionListener(new saveNoteButton2());
		saveNote2.setVisible(false);
		form.add(saveNote2);
		
		heartRateRange = new JLabel ("Your heart range is:");
		heartRateRange.setBounds(585, 155, 700, 50);
		heartRateRange.setFont(font1);
		form.add(heartRateRange);
		
		MaxVO2 = new JLabel("Your MaxVO2 is: ");
		MaxVO2.setBounds(300, 400, 200, 50);
		MaxVO2.setFont(font1);
		form.add(MaxVO2);
		
		//save and cancel
		
		save = new JButton(new ImageIcon(AerobicCapacityForm.class.getResource("/StaffViewAssets/SaveButton.png")));
		save.setBounds(600, 500, 156, 59);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.addActionListener(new saveButton(username));
		form.add(save);
		
		cancel = new JButton(new ImageIcon(AerobicCapacityForm.class.getResource("/StaffViewAssets/CancelAssessment.png")));
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
		dispose();
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
	
	private class calculateButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			workTarget.setText(calculateAC(restingHeartRate.getText(), heartRateMax.getText()));
			MaxVO2.setText("Your Max VO2 is " + workTarget.getText());
			saveNote2.setVisible(true);
		}
	}
	
	private class calculateButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Calculations calc = new Calculations();
			String hm = calc.calculateMaxHeartRate(dob);
			heartRateMax.setText(hm);
			heartRateRange.setText("Your target heart rate is between " + calc.minHRPercentageCalc(hm, minHRPercent.getText()) + " and " + calc.maxHRPercentageCalc(hm, maxHRPercent.getText()) + " BPM");
			saveNote.setVisible(true);
			
 		}
	}
	
	//cancel button action listener than calls the closeFrame() method
	//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
		}
	}
	
	private class saveNoteButton1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TODO:
			try {
				DbManager db = new DbManager();
				if(db.newTrainerNotes(username, staffID, heartRateRange.getText())) {
					JOptionPane.showMessageDialog(null, "Success! New note has been added for " + name.getText());
					
				} else {
					JOptionPane.showMessageDialog(null, "Unable to add values. Please make sure valid IDs are being entered.");
				}			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
	private class saveNoteButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				DbManager db = new DbManager();
				if(db.newTrainerNotes(username, staffID, MaxVO2.getText())) {
					JOptionPane.showMessageDialog(null, "Success! New note has been added for " + name.getText());
					
				} else {
					JOptionPane.showMessageDialog(null, "Unable to add values. Please make sure valid IDs are being entered.");
				}			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class saveButton implements ActionListener{
		private String username;
		public saveButton(String username) {
			this.username = username;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				DbManager db = new DbManager();
				Integer hrm = Integer.parseInt(heartRateMax.getText());
				Integer rhr = Integer.parseInt(restingHeartRate.getText());
				Integer fthr = Integer.parseInt(finalTestedHeartRate.getText());
				String prot = protocol.getText();
				Integer tim = Integer.parseInt(timeInMinutes.getText());
				Double wt = Double.parseDouble(workTarget.getText());
				
				
				//call method to create the form
				if(db.createNewMemberACForm(username, staffID, hrm, rhr, fthr, prot, tim, wt)) {
					JOptionPane.showMessageDialog(null, "Form added.");
					closeFrame();
				}

			} catch (SQLException e1) {
				System.out.println("Error connecting to database.");
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
}
