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







public class CalculationControls  extends JFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//instantiate components here (JTextfields, JLabels etc.)
	JButton save;
	JButton save2;
	JButton save3;
	JButton save4;
	JButton cancel;
	
	JTextField BMIunderweight;
	JTextField BMInormal;
	JTextField BMIoverweight;
	JTextField wthrMale;
	JTextField wthrFemale;
	JTextField bpsNormal;
	JTextField bpsElevated;
	JTextField bpsStage1;
	JTextField bpsStage2;
	JTextField bpdNormal;
	JTextField bpdElevated;
	JTextField bpdStage1; 
	JTextField bpdStage2;
	
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	

	public CalculationControls() {
		setTitle("Calculation Controls");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/calculationsControls.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);		
		
		
		BMIunderweight = new JTextField();
		BMIunderweight.setBounds(188, 107, 100, 25);
		BMIunderweight.setOpaque(false);
		BMIunderweight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		BMIunderweight.setFont(font1);
		BMIunderweight.setEditable(true);
		form.add(BMIunderweight);
		
		BMInormal = new JTextField();
		BMInormal.setBounds(188, 136, 100, 25);
		BMInormal.setOpaque(false);
		BMInormal.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		BMInormal.setFont(font1);
		BMInormal.setEditable(true);
		form.add(BMInormal);
		
		BMIoverweight = new JTextField();
		BMIoverweight.setBounds(188, 167, 100, 25);
		BMIoverweight.setOpaque(false);
		BMIoverweight.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		BMIoverweight.setFont(font1);
		BMIoverweight.setEditable(true);
		form.add(BMIoverweight);
		
		save = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/saveSmall.png")));
		save.setBounds(250, 157, 156, 59);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		form.add(save);
		
		wthrMale = new JTextField();
		wthrMale.setBounds(188, 232, 100, 25);
		wthrMale.setOpaque(false);
		wthrMale.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		wthrMale.setFont(font1);
		wthrMale.setEditable(true);
		form.add(wthrMale);
		
		wthrFemale = new JTextField();
		wthrFemale.setBounds(188, 260, 100, 25);
		wthrFemale.setOpaque(false);
		wthrFemale.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		wthrFemale.setFont(font1);
		wthrFemale.setEditable(true);
		form.add(wthrFemale);
		
		save2 = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/saveSmall.png")));
		save2.setBounds(250, 240, 156, 59);
		save2.setOpaque(false);
		save2.setContentAreaFilled(false);
		save2.setBorderPainted(false);
		save2.setFocusPainted(false);
		form.add(save2);
		
		bpsNormal = new JTextField();
		bpsNormal.setBounds(188, 317, 100, 25);
		bpsNormal.setOpaque(false);
		bpsNormal.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpsNormal.setFont(font1);
		bpsNormal.setEditable(true);
		form.add(bpsNormal);
		
		bpsElevated = new JTextField();
		bpsElevated.setBounds(188, 347, 100, 25);
		bpsElevated.setOpaque(false);
		bpsElevated.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpsElevated.setFont(font1);
		bpsElevated.setEditable(true);
		form.add(bpsElevated);
		
		bpsStage1 = new JTextField();
		bpsStage1.setBounds(188, 375, 100, 25);
		bpsStage1.setOpaque(false);
		bpsStage1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpsStage1.setFont(font1);
		bpsStage1.setEditable(true);
		form.add(bpsStage1);
		
		bpsStage2 = new JTextField();
		bpsStage2.setBounds(188, 405, 100, 25);
		bpsStage2.setOpaque(false);
		bpsStage2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpsStage2.setFont(font1);
		bpsStage2.setEditable(true);
		form.add(bpsStage2);
		
		save3 = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/saveSmall.png")));
		save3.setBounds(250, 390, 156, 59);
		save3.setOpaque(false);
		save3.setContentAreaFilled(false);
		save3.setBorderPainted(false);
		save3.setFocusPainted(false);
		form.add(save3);
		
		
		bpdNormal = new JTextField();
		bpdNormal.setBounds(188, 460, 100, 25);
		bpdNormal.setOpaque(false);
		bpdNormal.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpdNormal.setFont(font1);
		bpdNormal.setEditable(true);
		form.add(bpdNormal);
		
		bpdElevated = new JTextField();
		bpdElevated.setBounds(188, 488, 100, 25);
		bpdElevated.setOpaque(false);
		bpdElevated.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpdElevated.setFont(font1);
		bpdElevated.setEditable(true);
		form.add(bpdElevated);
		
		bpdStage1 = new JTextField();
		bpdStage1.setBounds(188, 515, 100, 25);
		bpdStage1.setOpaque(false);
		bpdStage1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpdStage1.setFont(font1);
		bpdStage1.setEditable(true);
		form.add(bpdStage1);
		
		bpdStage2 = new JTextField();
		bpdStage2.setBounds(188, 545, 100, 25);
		bpdStage2.setOpaque(false);
		bpdStage2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		bpdStage2.setFont(font1);
		bpdStage2.setEditable(true);
		form.add(bpdStage2);
		
		save4 = new JButton(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/saveSmall.png")));
		save4.setBounds(250, 530, 156, 59);
		save4.setOpaque(false);
		save4.setContentAreaFilled(false);
		save4.setBorderPainted(false);
		save4.setFocusPainted(false);
		form.add(save4);
		
		//start adding components here remember to add them to the form
		
		//save and cancel
		
		
		
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