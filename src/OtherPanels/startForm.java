package OtherPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import Database.DbManager;



public class startForm extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font1 = new Font("Agency FB", Font.PLAIN, 30);
	JScrollPane scrollpane1;
	JList forms;
	JButton lookUpUser;
	JButton Cancel;
	JButton remove;
	ResultSet rs;
	DbManager db;
	
	String assessment;
	String userName;
	String trainerID;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public startForm(String userName, String trainerID, String assessment) throws SQLException, ParseException {
		this.assessment = assessment;
		this.userName = userName;
		this.trainerID = trainerID;
		db = new DbManager();
		setTitle("Look-Up Form");
		setSize(500, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/NewUserFormBackground.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/Look-UpAssessment.png")));
		form.setBounds(22, 32, 472, 597);
		form.setLayout(null);
		
		forms = new JList(db.lookupForm(userName, assessment));
		forms.setFont(font1);
		forms.setVisibleRowCount(10);
		scrollpane1 = new JScrollPane(forms);
		scrollpane1.setBounds(45, 100, 350, 250);
		scrollpane1.setOpaque(false);
		scrollpane1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollpane1.setFont(font1);
		form.add(scrollpane1, BorderLayout.NORTH);
		
		lookUpUser = new JButton(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/openForm.png")));
		lookUpUser.setBounds(10, 480,142, 59);
		lookUpUser.setOpaque(false);
		lookUpUser.setContentAreaFilled(false);
		lookUpUser.setBorderPainted(false);
		lookUpUser.setFocusPainted(false);
		lookUpUser.addActionListener(new lookUpUserForm());
		form.add(lookUpUser);
		
		remove = new JButton(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/RemoveButton.png")));
		remove.setBounds(150, 480,142, 59);
		remove.setOpaque(false);
		remove.setContentAreaFilled(false);
		remove.setBorderPainted(false);
		remove.setFocusPainted(false);
		remove.addActionListener(new removeButton());
		form.add(remove);
		
		Cancel = new JButton(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/CancelLookUpButton.png")));
		Cancel.setBounds(300, 480,142, 59);
		Cancel.setOpaque(false);
		Cancel.setContentAreaFilled(false);
		Cancel.setBorderPainted(false);
		Cancel.setFocusPainted(false);
		Cancel.addActionListener(new cancelButton());
		form.add(Cancel);
		
		
		
		
		background.add(form);
		setVisible(true);
		
		
	}
	
	//close frame method
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
			
			private class removeButton implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String date = (String) forms.getSelectedValue();
					
					int confirmed = JOptionPane.showConfirmDialog(null, 
					        "Are you sure you want to delete this form for date " + date, "Exit Program Message Box",
					        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      	try {
							DbManager db = new DbManager();
							db.deleteForm(userName, date, assessment);
							dispose();
						} catch (SQLException | ParseException e1) {
							e1.printStackTrace();
						}	
				    }
				}
			}
			
	
			private class lookUpUserForm implements ActionListener{
				public void actionPerformed(ActionEvent e)  {
					String date = (String) forms.getSelectedValue();
					
					if (assessment.equals("aerobiccapacity")) {
						
						try {
							rs = db.populateForm(userName, assessment, date);
							AerobicCapacityForm ac = new AerobicCapacityForm(userName, trainerID);
							ac.heartRateMax.setText(rs.getString("heartRateMax"));
							ac.restingHeartRate.setText(rs.getString("restedHeartRate"));
							ac.finalTestedHeartRate.setText(rs.getString("finalTestHeartRate"));
							ac.protocol.setText(rs.getString("protocol"));
							ac.timeInMinutes.setText(rs.getString("timeInMin"));
							ac.workTarget.setText(rs.getString("maxVO2"));
							ac.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						
					}
					
					if (assessment.equals("strengthflexibility")) {
						
						try {
							rs = db.populateForm(userName, assessment, date);
							StrengthAndFlexForm sf = new StrengthAndFlexForm(userName, trainerID);
							sf.pushups.setText(rs.getString("pushups"));
							sf.oneMinuteSitUps.setText(rs.getString("situps"));
							sf.sitAndReach.setText(rs.getString("sitReach"));
							sf.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						
					}
					
					if (assessment.equals("coronaryrisk")) {
						
						try {
							rs = db.populateForm(userName, assessment, date);
							CoronaryRiskForm cr = new CoronaryRiskForm(userName, trainerID);
							cr.systolic.setText(rs.getString("systolicBloodPressure"));
							cr.diastolic.setText(rs.getString("diastolicBloodPressure"));
							cr.yearsSmoked.setText(rs.getString("yearsSmoked"));
							cr.idealBodyWeight.setText(rs.getString("idealBodyWeight"));
							cr.physicalActivity.setText(rs.getString("physicalActivity"));
							cr.stressNumber.setText(rs.getString("stressNumber"));
							cr.totalCholesterol.setText(rs.getString("totalCholesterol"));
							cr.hdlCholesterol.setText(rs.getString("hdlCholesterol"));
							cr.ldlCholesterol.setText(rs.getString("ldlCholesterol"));
							cr.hdlRatio.setText(rs.getString("hdlRatio"));
							cr.triglycerides.setText(rs.getString("triglycerides"));
							cr.glucose.setText(rs.getString("glucose"));
							cr.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						
					}

					if (assessment.equals("bodycomp")) {
						
						try {
							rs = db.populateForm(userName, assessment, date);
							BodyCompForm bodycomp = new BodyCompForm(userName, trainerID);
							bodycomp.bmi.setText(rs.getString("bmi"));
							bodycomp.forearm.setText(rs.getString("domForearm"));
							bodycomp.arm.setText(rs.getString("domArm"));
							bodycomp.thigh.setText(rs.getString("domThigh"));
							bodycomp.abdomen.setText(rs.getString("domAbdomen"));
							bodycomp.calf.setText(rs.getString("domCalf"));
							bodycomp.waistCircumference.setText(rs.getString("waistCircumference"));
							bodycomp.hipCircumference.setText(rs.getString("hipCircumference"));
							bodycomp.waistToHipRatio.setText(rs.getString("waistToHipRatio"));
							bodycomp.protocol.setText(rs.getString("protocol"));
							bodycomp.chest.setText(rs.getString("chest"));
							bodycomp.midaxillary.setText(rs.getString("midaxillary"));
							bodycomp.triceps.setText(rs.getString("triceps"));
							bodycomp.subscapular.setText(rs.getString("subscapular"));
							bodycomp.abdomenType.setText(rs.getString("abdomen"));
							bodycomp.suprailiac.setText(rs.getString("suprailliac"));
							bodycomp.thighType.setText(rs.getString("thigh"));
							bodycomp.bodyDensity.setText(rs.getString("bodyDensity"));
							bodycomp.percentBodyFat.setText(rs.getString("percentBodyFat"));
							bodycomp.leanWeight.setText(rs.getString("leanWeight"));
							bodycomp.fatWeight.setText(rs.getString("fatWeight"));
							bodycomp.desiredBodyFat.setText(rs.getString("desiredWeight"));
							bodycomp.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						
					}
				}
			}
}