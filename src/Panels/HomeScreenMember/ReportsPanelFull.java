package Panels.HomeScreenMember;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public ReportsPanelFull(String username) {
		setBackground(new Color(243,243,243));
		setLayout(null);
		this.username = username;
		
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
		
		JLabel lblCurrentWeight = new JLabel("Weight:");
		lblCurrentWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentWeight.setBounds(70, 130, 70, 29);
		youAtAGlance.add(lblCurrentWeight);
		
		JLabel lblBmi = new JLabel("BMI");
		lblBmi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBmi.setBounds(70, 95, 46, 20);
		youAtAGlance.add(lblBmi);
		
		JLabel lblPercentBodyFat = new JLabel("Percent Body Fat:");
		lblPercentBodyFat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPercentBodyFat.setBounds(70, 175, 158, 20);
		youAtAGlance.add(lblPercentBodyFat);
		
		JLabel lblRestedHeartRate = new JLabel("Rested Heart Rate:");
		lblRestedHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRestedHeartRate.setBounds(70, 465, 171, 20);
		youAtAGlance.add(lblRestedHeartRate);
		
		JLabel lblWorkedHeartRate = new JLabel("Worked Heart Rate:");
		lblWorkedHeartRate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkedHeartRate.setBounds(70, 508, 192, 20);
		youAtAGlance.add(lblWorkedHeartRate);
		
		JLabel lblYouAtA = new JLabel("You at a Glance");
		lblYouAtA.setBounds(28, 31, 214, 32);
		youAtAGlance.add(lblYouAtA);
		lblYouAtA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblBloodWork = new JLabel("Blood Work");
		lblBloodWork.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBloodWork.setBounds(70, 243, 134, 29);
		youAtAGlance.add(lblBloodWork);
		
		JLabel lblBloodGlucose = new JLabel("Blood Glucose");
		lblBloodGlucose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodGlucose.setBounds(87, 309, 125, 20);
		youAtAGlance.add(lblBloodGlucose);
		
		JLabel lblBloodCholestorol = new JLabel("Blood Cholesterol");
		lblBloodCholestorol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodCholestorol.setBounds(87, 351, 156, 29);
		youAtAGlance.add(lblBloodCholestorol);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodPressure.setBounds(87, 402, 134, 29);
		youAtAGlance.add(lblBloodPressure);
		
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
	}
}
