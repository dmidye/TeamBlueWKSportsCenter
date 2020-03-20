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




public class coronaryRiskForm extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	JTextField glucos;
	
	JLabel name;
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	JButton calculate;
	JButton save;
	JButton cancel;

	public coronaryRiskForm(String username) {
		setTitle("Coronary Risk Form");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(coronaryRiskForm.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(coronaryRiskForm.class.getResource("/StaffViewAssets/CoronaryRiskForm.png")));
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
		
		glucos = new JTextField(10);
		glucos.setBounds(640, 300, 80, 25);
		glucos.setOpaque(false);
		glucos.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		glucos.setFont(font1);
		glucos.setEditable(true);
		form.add(glucos);
		
		
		
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