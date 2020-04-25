package Panels.HomeScreenMember;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ReportsPanelFull extends JPanel {

	/**
	 * Create the panel.
	 */
	private String username;
	
	private Database.databaseConnector databaseConnector;
	
	JLabel lblBmiInfo;  //You at a glance
	JLabel lblWeightInfo;
	JLabel lblPercentInfo;
	JLabel lblBginfo;
	JLabel lblBcinfo;
	JLabel lblBpinfo;
	JLabel lblRestedInfo;
	JLabel lblWorkerdInfo;
	
	public ReportsPanelFull(String username) {
		setBackground(new Color(243,243,243));
		setLayout(null);
		this.username = username;
		databaseConnector = new Database.databaseConnector();
		
		ReportsPanelCapabilities capabilitiesPanel = new ReportsPanelCapabilities(username);////////////////////////////////////////////////////////////////////////// Fix
		capabilitiesPanel.setSize(416, 396);
		capabilitiesPanel.setBackground(new Color(243,243,243));
		capabilitiesPanel.setLocation(673, 166);
		capabilitiesPanel.setVisible(false);
		add(capabilitiesPanel);
		
		reportsPanel healthPanel = new reportsPanel(username);////////////////////////////////////////////////////////////////////////// Fix
		healthPanel.setSize(416, 396);
		healthPanel.setBackground(new Color(243,243,243));
		healthPanel.setLocation(673, 166);
		add(healthPanel);
		
		JPanel youAtAGlance = new JPanel();
		youAtAGlance.setBackground(new Color(243,243,243));
		youAtAGlance.setBounds(92, 11, 532, 653);
		add(youAtAGlance);
		youAtAGlance.setLayout(null);
		
		JLabel lblBmi = new JLabel("BMI:");
		lblBmi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBmi.setBounds(70, 95, 46, 20);
		youAtAGlance.add(lblBmi);
		
		lblBmiInfo = new JLabel("BMI INFO");
		lblBmiInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBmiInfo.setBounds(126, 95, 84, 20);
		youAtAGlance.add(lblBmiInfo);
		
		JLabel lblCurrentWeight = new JLabel("Weight:");
		lblCurrentWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentWeight.setBounds(70, 130, 70, 29);
		youAtAGlance.add(lblCurrentWeight);
		
		lblWeightInfo = new JLabel("Weight INFO");
		lblWeightInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWeightInfo.setBounds(150, 134, 84, 20);
		youAtAGlance.add(lblWeightInfo);
		
		JLabel lblPercentBodyFat = new JLabel("Percent Body Fat:");
		lblPercentBodyFat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercentBodyFat.setBounds(70, 175, 158, 20);
		youAtAGlance.add(lblPercentBodyFat);
		
		lblPercentInfo = new JLabel("Percent Info");
		lblPercentInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercentInfo.setBounds(238, 175, 84, 20);
		youAtAGlance.add(lblPercentInfo);
		
		JLabel lblBloodGlucose = new JLabel("Blood Glucose:");
		lblBloodGlucose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodGlucose.setBounds(87, 309, 134, 20);
		youAtAGlance.add(lblBloodGlucose);
		
		lblBginfo = new JLabel("BGInfo");
		lblBginfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBginfo.setBounds(231, 309, 84, 20);
		youAtAGlance.add(lblBginfo);
		
		JLabel lblBloodCholestorol = new JLabel("Blood Cholesterol:");
		lblBloodCholestorol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodCholestorol.setBounds(87, 351, 163, 29);
		youAtAGlance.add(lblBloodCholestorol);
		
		lblBcinfo = new JLabel("BCInfo");
		lblBcinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBcinfo.setBounds(260, 355, 84, 20);
		youAtAGlance.add(lblBcinfo);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		lblBloodPressure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodPressure.setBounds(87, 402, 139, 29);
		youAtAGlance.add(lblBloodPressure);
		
		lblBpinfo = new JLabel("BPInfo");
		lblBpinfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBpinfo.setBounds(238, 406, 84, 20);
		youAtAGlance.add(lblBpinfo);
		
		JLabel lblRestedHeartRate = new JLabel("Rested Heart Rate:");
		lblRestedHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRestedHeartRate.setBounds(70, 465, 171, 20);
		youAtAGlance.add(lblRestedHeartRate);
		
		lblRestedInfo = new JLabel("RestedInfo");
		lblRestedInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRestedInfo.setBounds(251, 465, 84, 20);
		youAtAGlance.add(lblRestedInfo);
		
		JLabel lblWorkedHeartRate = new JLabel("Worked Heart Rate:");
		lblWorkedHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkedHeartRate.setBounds(70, 508, 192, 20);
		youAtAGlance.add(lblWorkedHeartRate);
		
		lblWorkerdInfo = new JLabel("WorkedInfo");
		lblWorkerdInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkerdInfo.setBounds(267, 508, 84, 20);
		youAtAGlance.add(lblWorkerdInfo);
		
		JLabel lblYouAtA = new JLabel("You at a Glance");
		lblYouAtA.setBounds(28, 31, 214, 32);
		youAtAGlance.add(lblYouAtA);
		lblYouAtA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblBloodWork = new JLabel("Blood Work");
		lblBloodWork.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBloodWork.setBounds(70, 243, 134, 29);
		youAtAGlance.add(lblBloodWork);
		
		JLabel YouAtAGlancePanel = new JLabel("");
		YouAtAGlancePanel.setBounds(0, 0, 532, 653);
		youAtAGlance.add(YouAtAGlancePanel);
		YouAtAGlancePanel.setIcon(new ImageIcon(ReportsPanelFull.class.getResource("/Assets/YouAtAGlance.png")));
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		label_1.setBounds(660, 113, 472, 517);
		label_1.setIcon(new ImageIcon(ReportsPanelFull.class.getResource("/Assets/YouOverTimePanel.png")));
		
		JLabel RightTab = new JLabel("");
		RightTab.setVerticalAlignment(SwingConstants.TOP);
		add(RightTab);
		RightTab.setBounds(880, 119, 214, 82);
		RightTab.setIcon(new ImageIcon(ReportsPanelFull.class.getResource("/Assets/CapabilitiesTab.png")));
		
		JLabel LeftTab = new JLabel("New label");
		LeftTab.setVerticalAlignment(SwingConstants.TOP);
		add(LeftTab);
		LeftTab.setBounds(668, 100, 213, 101);
		LeftTab.setIcon(new ImageIcon(ReportsPanelFull.class.getResource("/Assets/HealthTab.png")));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ReportsPanelFull.class.getResource("/Assets/YouOverTime Panel.png")));
		label_2.setBounds(634, 11, 520, 653);
		add(label_2);
		
		////
		LeftTab.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				LeftTab.setLocation(668, 100);
				RightTab.setLocation(880, 119);
				healthPanel.clearSelection();
				capabilitiesPanel.setVisible(false);
				healthPanel.setVisible(true);
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		RightTab.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {	
				LeftTab.setLocation(668, 119);
				RightTab.setLocation(880, 100);
				capabilitiesPanel.clearSelection();
				capabilitiesPanel.setVisible(true);
				healthPanel.setVisible(false);
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		SetYouAtAGlance();
	}
	
	public void SetYouAtAGlance() {
		ResultSet rs1 = databaseConnector.sendStatement("SELECT `BMI`, `fatWeight`, `percentBodyFat` FROM bodycomp WHERE `username` = \"" + username + "\"");
		ResultSet rs2 = databaseConnector.sendStatement("SELECT `glucose`, `totalCholesterol`, `systolicBloodPressure` FROM coronaryrisk WHERE `username` = \"" + username + "\"");
		ResultSet rs3 = databaseConnector.sendStatement("SELECT `restedHeartRate`, `heartRateMax` FROM aerobiccapacity WHERE `username` = \"" + username + "\"");
		try {
			while(rs1.next()) {
				lblBmiInfo.setText(rs1.getString(1));
				lblWeightInfo.setText(rs1.getString(2));
				lblPercentInfo.setText(rs1.getString(3));
			}
			while(rs2.next()) {
				lblBginfo.setText(rs2.getString(1));
				lblBcinfo.setText(rs2.getString(2));
				lblBpinfo.setText(rs2.getString(3));
			}
			while(rs3.next()) {
				lblRestedInfo.setText(rs3.getString(1));
				lblWorkerdInfo.setText(rs3.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
