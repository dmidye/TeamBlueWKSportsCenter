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


public class BodyCompForm extends JFrame{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	calculations result = new calculations();
	JLabel bmiResult;
	JButton calculate2;
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	JFrame parentFrame;
	JTextField bmi;
	JTextField forearm;
	JTextField arm;
	JTextField thigh;
	JTextField abdomen;
	JTextField calf;
	JTextField waistCircumference;
	JTextField hipCircumference;
	JTextField waistToHipRatio;
	JTextField protocol;
	JTextField chest;
	JTextField midaxillary;
	JTextField triceps;
	JTextField subscapular;
	JTextField abdomenType;
	JTextField suprailiac;
	JTextField thighType;
	JTextField bodyDensity;
	JTextField percentBodyFat;
	JTextField leanWeight;
	JTextField fatWeight;
	JTextField desiredBodyFat;
	
	JLabel waistToHipRatioResult;
	JLabel name;
	ResultSet rs;
	JButton calculate;
	JButton calculate3;
	JButton save;
	JButton cancel;
	String staffID;
	int dob;
	String gender;
	public BodyCompForm(String username, String staffID) throws SQLException, ParseException {
		this.staffID = staffID;

		DbManager db = new DbManager();
		dob = Integer.parseInt(db.getAge(username));
	  rs = db.lookupMember(username);
		gender = rs.getString("membergender");

		setTitle("Body Compositions Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/BodyCompForm.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		name = new JLabel (rs.getString("memberFirst") + " " + rs.getString("memberLast"));
		name.setBounds(880, 40, 200, 25);
		name.setFont(font1);
		form.add(name);
		
		
		bmi = new JTextField(10);
		bmi.setBounds(85, 72, 80, 25);
		bmi.setOpaque(false);
		bmi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bmi.setFont(font1);
		bmi.setEditable(true);
		form.add(bmi);
		
		bmiResult = new JLabel("Results Here");
		bmiResult.setBounds(350, 77, 150, 25);
		bmiResult.setFont(font1);
		form.add(bmiResult);
		
		calculate = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CalculateButton.png")));
		calculate.setBounds(175, 72, 153, 33);
		calculate.setOpaque(false);
		calculate.setContentAreaFilled(false);
		calculate.setBorderPainted(false);
		calculate.setFocusPainted(false);
		calculate.addActionListener(new calculateButton());
		form.add(calculate);
		
		forearm = new JTextField(10);
		forearm.setBounds(120, 144, 80, 25);
		forearm.setOpaque(false);
		forearm.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		forearm.setFont(font1);
		forearm.setEditable(true);
		form.add(forearm);
		
		arm = new JTextField(10);
		arm.setBounds(120, 174, 80, 25);
		arm.setOpaque(false);
		arm.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		arm.setFont(font1);
		arm.setEditable(true);
		form.add(arm);
		
		thigh = new JTextField(10);
		thigh.setBounds(120, 205, 80, 25);
		thigh.setOpaque(false);
		thigh.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		thigh.setFont(font1);
		thigh.setEditable(true);
		form.add(thigh);
		
		abdomen = new JTextField(10);
		abdomen.setBounds(120, 235, 80, 25);
		abdomen.setOpaque(false);
		abdomen.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		abdomen.setFont(font1);
		abdomen.setEditable(true);
		form.add(abdomen);
		
		calf = new JTextField(10);
		calf.setBounds(120, 265, 80, 25);
		calf.setOpaque(false);
		calf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		calf.setFont(font1);
		calf.setEditable(true);
		form.add(calf);
		
		//Waist and Hip Measurements
		
		waistCircumference = new JTextField(10);
		waistCircumference.setBounds(502, 145, 80, 25);
		waistCircumference.setOpaque(false);
		waistCircumference.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		waistCircumference.setFont(font1);
		waistCircumference.setEditable(true);
		form.add(waistCircumference);
		
		hipCircumference = new JTextField(10);
		hipCircumference.setBounds(502, 175, 80, 25);
		hipCircumference.setOpaque(false);
		hipCircumference.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		hipCircumference.setFont(font1);
		hipCircumference.setEditable(true);
		form.add(hipCircumference);
		
		waistToHipRatio = new JTextField(10);
		waistToHipRatio.setBounds(502, 205, 80, 25);
		waistToHipRatio.setOpaque(false);
		waistToHipRatio.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		waistToHipRatio.setFont(font1);
		waistToHipRatio.setEditable(true);
		form.add(waistToHipRatio);
		
		calculate2 = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CalculateButton.png")));
		calculate2.setBounds(600, 205, 153, 33);
		calculate2.setOpaque(false);
		calculate2.setContentAreaFilled(false);
		calculate2.setBorderPainted(false);
		calculate2.setFocusPainted(false);
		calculate2.addActionListener(new calculateButton2());
		form.add(calculate2);
		
		waistToHipRatioResult = new JLabel();
		waistToHipRatioResult.setBounds(502, 235, 80, 25);
		waistToHipRatioResult.setFont(font1);
		form.add(waistToHipRatioResult);
		
		//Select Assessment Type
		
		protocol = new JTextField(10);
		protocol.setBounds(858, 147, 80, 25);
		protocol.setOpaque(false);
		protocol.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		protocol.setFont(font1);
		protocol.setEditable(true);
		form.add(protocol);
		
		chest = new JTextField(10);		
		chest.setBounds(858, 177, 80, 25);
		chest.setOpaque(false);
		chest.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		chest.setFont(font1);
		chest.setEditable(true);
		form.add(chest);
		
		midaxillary = new JTextField(10);
		midaxillary.setBounds(858, 207, 80, 25);
		midaxillary.setOpaque(false);
		midaxillary.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		midaxillary.setFont(font1);
		midaxillary.setEditable(true);
		form.add(midaxillary);
		
		triceps = new JTextField(10);
		triceps.setBounds(858, 235, 80, 25);
		triceps.setOpaque(false);
		triceps.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		triceps.setFont(font1);
		triceps.setEditable(true);
		form.add(triceps);
		
		
		subscapular = new JTextField(10);
		subscapular.setBounds(858, 265, 80, 25);
		subscapular.setOpaque(false);
		subscapular.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subscapular.setFont(font1);
		subscapular.setEditable(true);
		form.add(subscapular);
		
		abdomenType = new JTextField(10);
		abdomenType.setBounds(858, 293, 80, 25);
		abdomenType.setOpaque(false);
		abdomenType.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		abdomenType.setFont(font1);
		abdomenType.setEditable(true);
		form.add(abdomenType);
		
		suprailiac = new JTextField(10);
		suprailiac.setBounds(858, 322, 80, 25);
		suprailiac.setOpaque(false);
		suprailiac.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		suprailiac.setFont(font1);
		suprailiac.setEditable(true);
		form.add(suprailiac);
		
		thighType = new JTextField(10);
		thighType.setBounds(858, 353, 80, 25);
		thighType.setOpaque(false);
		thighType.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		thighType.setFont(font1);
		thighType.setEditable(true);
		form.add(thighType);
		
		calculate3 = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/CalculateButton.png")));
		calculate3.setBounds(810, 400, 153, 33);
		calculate3.setOpaque(false);
		calculate3.setContentAreaFilled(false);
		calculate3.setBorderPainted(false);
		calculate3.setFocusPainted(false);
		calculate3.addActionListener(new calculateButton3());
		form.add(calculate3);
		
		// body
		
		bodyDensity = new JTextField(10);
		bodyDensity.setBounds(165, 399, 80, 25);
		bodyDensity.setOpaque(false);
		bodyDensity.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bodyDensity.setFont(font1);
		bodyDensity.setEditable(true);
		form.add(bodyDensity);
		
		percentBodyFat = new JTextField(10);
		percentBodyFat.setBounds(165, 427, 80, 25);
		percentBodyFat.setOpaque(false);
		percentBodyFat.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		percentBodyFat.setFont(font1);
		percentBodyFat.setEditable(true);
		form.add(percentBodyFat);
		
		leanWeight = new JTextField(10);
		leanWeight.setBounds(165, 458, 80, 25);
		leanWeight.setOpaque(false);
		leanWeight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		leanWeight.setFont(font1);
		leanWeight.setEditable(true);
		form.add(leanWeight);
		
		fatWeight = new JTextField(10);
		fatWeight.setBounds(365, 460, 80, 25);
		fatWeight.setOpaque(false);
		fatWeight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fatWeight.setFont(font1);
		fatWeight.setEditable(true);
		form.add(fatWeight);
		
		desiredBodyFat = new JTextField(10);
		desiredBodyFat.setBounds(245, 486, 80, 25);
		desiredBodyFat.setOpaque(false);
		desiredBodyFat.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		desiredBodyFat.setFont(font1);
		desiredBodyFat.setEditable(true);
		form.add(desiredBodyFat);
		
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
	}//end closeFrame()
	
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
	}// calculateBMI()

	//cancel button action listener than calls the closeFrame() method
	//to close the frame.
	private class cancelButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeFrame();			
		}
	}//end cancelButton()
	
	//save button action listener
	//saves to the database	
	private class saveButton implements ActionListener{
		private String username;
		public saveButton(String username) {
			this.username = username;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				DbManager db = new DbManager();
				double BMI = Double.parseDouble(bmi.getText());
				double fa = Double.parseDouble(forearm.getText());
				double a = Double.parseDouble(arm.getText());
				double thi = Double.parseDouble(thigh.getText());
				double abd = Double.parseDouble(abdomen.getText());
				double ca = Double.parseDouble(calf.getText());
				double wc = Double.parseDouble(waistCircumference.getText());
				double hc = Double.parseDouble(hipCircumference.getText());
				double wthr = Double.parseDouble(waistToHipRatio.getText());
				String prot = protocol.getText();
				double ch = Double.parseDouble(chest.getText());
				double ma = Double.parseDouble(midaxillary.getText());
				double tri = Double.parseDouble(triceps.getText());
				double sub = Double.parseDouble(subscapular.getText());
				double at = Double.parseDouble(abdomenType.getText());
				double sup = Double.parseDouble(suprailiac.getText());
				double tt = Double.parseDouble(thighType.getText());
				double bd = Double.parseDouble(bodyDensity.getText());
				double pbf = Double.parseDouble(percentBodyFat.getText());
				double lw = Double.parseDouble(leanWeight.getText());
				double fw = Double.parseDouble(fatWeight.getText());
				double dbf = Double.parseDouble(desiredBodyFat.getText());
				
				//call method to create the form
				if(db.createNewMemberBCForm(username, staffID, BMI, fa, a, thi, abd, ca, wc, hc, wthr, prot, ch, 
											ma, tri, sub, at, sup, tt, pbf, lw, bd, fw, dbf)) {
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
	
	// calculate button action listener
	public class calculateButton implements ActionListener{
		
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
					calculations calc = new calculations();
					String calculatedBMI = calculateBMI(bmiWeight, bmiFeet, bmiInches);
					String bfp = calc.bodyFatPercentage(gender, calculatedBMI, dob);
					String fw = calc.calculateBodyFat(bfp, bmiWeight);
					String lw = calc.calculateLeanWeight(fw, bmiWeight);
					bmi.setText(calculatedBMI);
					
					percentBodyFat.setText(bfp);
					fatWeight.setText(fw);
					leanWeight.setText(lw);
					
				
					
				}				
			}
		}
		bmiResult.setText(result.resultBMI(bmi.getText()));
		}
	} // end CalculateButton()
	
	public class calculateButton2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Double hip = Double.parseDouble(hipCircumference.getText());
			Double waist = Double.parseDouble(waistCircumference.getText());
			String calculation = String.format("%.2f", result.waistToHipRatio(hip, waist));
			waistToHipRatio.setText(calculation);
			waistToHipRatioResult.setText(result.waistToHipRatioResult(calculation, gender));			
		}
	}
	
	public class calculateButton3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String ch = chest.getText();
			String ma = midaxillary.getText();
			String tri = triceps.getText();
			String sub = subscapular.getText();
			String at = abdomenType.getText();
			String sup = suprailiac.getText();
			String tt = thighType.getText();
		
			
			calculations calc = new calculations();
			String result = calc.calculateBodyDesnsity(dob, gender, ch, ma, tri, sub, at, sup, tt);
			bodyDensity.setText(result);
			
		}
	}
}
