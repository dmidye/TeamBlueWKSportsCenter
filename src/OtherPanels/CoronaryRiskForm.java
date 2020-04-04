package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.DbManager;
import Panels.StaffView;




public class CoronaryRiskForm extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame parentFrame;
	JTextField systolic;
	JTextField diastolic;
	JTextField yearsSmoked;
	JTextField idealBodyWeight;
	JTextField physicalActivity;
	JTextField stressNumber;
	JTextField totalCholesterol;
	JTextField hdlCholesterol;
	JTextField ldlCholesterol;
	JTextField hdlRatio;
	JTextField triglycerides;
	JTextField glucose;
	
	JLabel name;
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	JButton calculate;
	JButton save;
	JButton cancel;
	
	int staffID;
	
	public CoronaryRiskForm(String username, int staffID) {
		this.staffID = staffID;
		
		setTitle("Coronary Risk Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(CoronaryRiskForm.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(CoronaryRiskForm.class.getResource("/StaffViewAssets/CoronaryRiskForm.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		name = new JLabel (username);
		name.setBounds(880, 40, 200, 25);
		name.setFont(font1);
		form.add(name);
		
		systolic = new JTextField(10);
		systolic.setBounds(145, 118, 80, 25);
		systolic.setOpaque(false);
		systolic.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		systolic.setFont(font1);
		systolic.setEditable(true);
		form.add(systolic);
		
		diastolic = new JTextField(10);
		diastolic.setBounds(145, 153, 80, 25);
		diastolic.setOpaque(false);
		diastolic.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		diastolic.setFont(font1);
		diastolic.setEditable(true);
		form.add(diastolic);
				
		yearsSmoked = new JTextField(10);
		yearsSmoked.setBounds(192, 225, 80, 25);
		yearsSmoked.setOpaque(false);
		yearsSmoked.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		yearsSmoked.setFont(font1);
		yearsSmoked.setEditable(true);
		form.add(yearsSmoked);
		
		idealBodyWeight = new JTextField(10);
		idealBodyWeight.setBounds(218, 290, 80, 25);
		idealBodyWeight.setOpaque(false);
		idealBodyWeight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		idealBodyWeight.setFont(font1);
		idealBodyWeight.setEditable(true);
		form.add(idealBodyWeight);
		
		physicalActivity = new JTextField(10);
		physicalActivity.setBounds(218, 335, 80, 25);
		physicalActivity.setOpaque(false);
		physicalActivity.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		physicalActivity.setFont(font1);
		physicalActivity.setEditable(true);
		form.add(physicalActivity);
		
		stressNumber = new JTextField(10);
		stressNumber.setBounds(250, 415, 80, 25);
		stressNumber.setOpaque(false);
		stressNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stressNumber.setFont(font1);
		stressNumber.setEditable(true);
		form.add(stressNumber);

		totalCholesterol = new JTextField(10);
		totalCholesterol.setBounds(640, 125, 80, 25);
		totalCholesterol.setOpaque(false);
		totalCholesterol.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		totalCholesterol.setFont(font1);
		totalCholesterol.setEditable(true);
		form.add(totalCholesterol);
		
		hdlCholesterol = new JTextField(10);
		hdlCholesterol.setBounds(640, 160, 80, 25);
		hdlCholesterol.setOpaque(false);
		hdlCholesterol.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		hdlCholesterol.setFont(font1);
		hdlCholesterol.setEditable(true);
		form.add(hdlCholesterol);
		
		ldlCholesterol = new JTextField(10);
		ldlCholesterol.setBounds(640, 195, 80, 25);
		ldlCholesterol.setOpaque(false);
		ldlCholesterol.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ldlCholesterol.setFont(font1);
		ldlCholesterol.setEditable(true);
		form.add(ldlCholesterol);
		
		hdlRatio = new JTextField(10);
		hdlRatio.setBounds(640, 230, 80, 25);
		hdlRatio.setOpaque(false);
		hdlRatio.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		hdlRatio.setFont(font1);
		hdlRatio.setEditable(true);
		form.add(hdlRatio);
		
		triglycerides = new JTextField(10);
		triglycerides.setBounds(640, 268, 80, 25);
		triglycerides.setOpaque(false);
		triglycerides.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		triglycerides.setFont(font1);
		triglycerides.setEditable(true);
		form.add(triglycerides);
		
		glucose = new JTextField(10);
		glucose.setBounds(640, 300, 80, 25);
		glucose.setOpaque(false);
		glucose.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		glucose.setFont(font1);
		glucose.setEditable(true);
		form.add(glucose);
		
		
		
		//save and cancel
		
		save = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/SaveButton.png")));
		save.setBounds(600, 500, 156, 59);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.addActionListener(new saveButton(username));
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
		dispose();
	}
	
	//cancel button action listener than calls the closeFrame() method
		//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
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
				
				//getting each variable from text fields and parsing them if needed
				Integer sys = Integer.parseInt(systolic.getText());
				Integer dias = Integer.parseInt(diastolic.getText());
				Integer ibw = Integer.parseInt(idealBodyWeight.getText());
				String pa = physicalActivity.getText();
				Integer tc = Integer.parseInt(totalCholesterol.getText());
				Double hdlr = Double.parseDouble(hdlRatio.getText());
				Integer hdlc = Integer.parseInt(hdlCholesterol.getText());
				Integer ldlc = Integer.parseInt(ldlCholesterol.getText());
				Integer trig = Integer.parseInt(triglycerides.getText());
				Integer gluc = Integer.parseInt(glucose.getText());
				Integer ys = Integer.parseInt(yearsSmoked.getText());
				Integer sn = Integer.parseInt(stressNumber.getText());
				
				//call method to create the form
				if(db.createNewMemberCRForm(username, staffID, sys, dias, ys, ibw, pa, 
											sn, tc, hdlr, hdlc, ldlc, trig, gluc)) {
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