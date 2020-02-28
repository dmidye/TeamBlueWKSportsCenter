package Panels.HomeScreenMember;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;

import Database.databaseConnector;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

public class ReportsPanelCapabilities extends JPanel {
	private ResultSet rs;
	private databaseConnector connector = new databaseConnector();
	private Graph.graphFactory graphFactory = new Graph.graphFactory();
	private int id;
	private String username;
	
	JLabel SitAndReachButton;
	JLabel PushupsLabel;
	JLabel SitupsLabel;
	JPanel chartPanel;
	
	ImageIcon Situps;
	ImageIcon Pushups;
	ImageIcon SitAndReach;

	/**
	 * Create the panel.
	 */
	public ReportsPanelCapabilities(String username) {
		
		loadIcons();
		
		setBackground(Color.WHITE);
		this.username = username;
		setBounds(100, 100, 416, 396);
		rs = connector.sendStatement("SELECT `memberID` FROM `user` WHERE `Username` = \"" + username + "\"");
		try {
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		setLayout(null);
		setLayout(new CardLayout(0, 0));
		
		JPanel Health = new JPanel();
		Health.setBackground(Color.WHITE);
		add(Health, "name_22233670369700");
		Health.setLayout(null);
		
		PushupsLabel = new JLabel("Pushups");
		PushupsLabel.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Pushups.png")));
		PushupsLabel.setBounds(124, 23, 164, 63);
		Health.add(PushupsLabel);
		
		SitupsLabel = new JLabel("Situps");
		SitupsLabel.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Situps.png")));
		SitupsLabel.setBounds(124, 73, 164, 63);
		Health.add(SitupsLabel);
		
		SitAndReachButton = new JLabel("SitAndReach");
		SitAndReachButton.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/SitAndReach.png")));
		SitAndReachButton.setBounds(107, 125, 208, 63);
		Health.add(SitAndReachButton);
		
		chartPanel = new JPanel();
		chartPanel.setBounds(30, 185, 350, 200);
		Health.add(chartPanel);
		
		JPanel Capabillities = new JPanel();
		Capabillities.setSize(427, 396);
		Capabillities.setBackground(Color.WHITE);
		add(Capabillities, "name_22233654532400");
		Capabillities.setLayout(null);
		
		JButton btnNewButton = new JButton("Pecent Body Fat");
		btnNewButton.setBounds(73, 327, 111, 23);
		Capabillities.add(btnNewButton);
		
		JButton btnBmi = new JButton("BMI");
		btnBmi.setBounds(189, 327, 51, 23);
		Capabillities.add(btnBmi);
		
		JButton btnNewButton_1 = new JButton("Resting Heart Rate");
		btnNewButton_1.setBounds(245, 327, 125, 23);
		Capabillities.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Diastolic Blood Pressure");
		btnNewButton_3.setBounds(39, 301, 145, 23);
		Capabillities.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Systolic Blood Pressure");
		btnNewButton_2.setBounds(173, 355, 143, 23);
		Capabillities.add(btnNewButton_2);
		
		JButton btnSitAndReach = new JButton("Sit and Reach");
		btnSitAndReach.setBounds(199, 301, 99, 23);
		Capabillities.add(btnSitAndReach);
		
		JButton btnPushups = new JButton("Pushups");
		btnPushups.setBounds(126, 273, 73, 23);
		Capabillities.add(btnPushups);
		
		JButton btnSitups = new JButton("Situps");
		btnSitups.setBounds(204, 273, 61, 23);
		Capabillities.add(btnSitups);
		
		JLabel SitupsButton = new JLabel("");
		SitupsButton.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Situps.png")));
		SitupsButton.setBounds(49, 108, 164, 63);
		Capabillities.add(SitupsButton);
		
		JLabel PushupsButton = new JLabel("");
		PushupsButton.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Pushups.png")));
		PushupsButton.setBounds(223, 108, 164, 63);
		Capabillities.add(PushupsButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/SitAndReach.png")));
		label.setBounds(121, 34, 208, 63);
		Capabillities.add(label);
		
		btnSitups.addActionListener(new ActionListener() {           /////////////////////////////////////////////////TODO Hook this up to the current buttons
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`situps` FROM `strengthflexibility` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Situps Performed Over Time", "Dates", "Situps Performed");
			}
		});
		btnPushups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`pushups` FROM `strengthflexibility` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Pushups Performed Over Time", "Dates", "Pushups Performed");
			}
		});
		btnSitAndReach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`sitReach` FROM `strengthflexibility` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Distance Reached Over Time", "Dates", "Distance Reached");
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`systolicBloodPressure` FROM `coronaryrisk` WHERE `memberID` = " + id);
			   graphFactory.createGraph(rs, "Systolic Blood Pressure Over Time", "Dates", "Systolic Blood Pressure");
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`diastolicBloodPressure` FROM `coronaryrisk` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Diastolic Blood Pressure Over Time", "Dates", "Diastolic Blood Pressure");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rs = connector.sendStatement("SELECT `date`,`restedHeartRate` FROM `aerobiccapacity` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Resting Heart Rate Over Time", "Dates", "Resting Heart Rate");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rs = connector.sendStatement("SELECT `date`,`percentBodyFat` FROM `bodycomp` WHERE `memberID` = " + id);
			    graphFactory.createGraph(rs, "Percent Body Fat Over Time", "Dates", "Percent Body Fat");
			}
		});
		
	/////////////////////////////
		SitAndReachButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(SitAndReachButton);
				rs = connector.sendStatement("SELECT `date`,`sitReach` FROM `strengthflexibility` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Sit and Reach Over Time", "Dates", "Distance"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
		SitupsLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(SitupsLabel);
				rs = connector.sendStatement("SELECT `date`,`situps` FROM `strengthflexibility` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Situps Over Time", "Dates", "Situps"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
		PushupsLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(PushupsLabel);
				rs = connector.sendStatement("SELECT `date`,`pushups` FROM `strengthflexibility` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Pushups Over Time", "Dates", "Pushups"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
	}
	
	public void clearSelection() {
		SitAndReachButton.setIcon(SitAndReach);
		SitupsLabel.setIcon(Situps);
		PushupsLabel.setIcon(Pushups);
		chartPanel.removeAll();
		chartPanel.repaint();
	}
	
	private void loadIcons() {
		Pushups = new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Pushups.png"));
		Situps = new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/Situps.png"));
		SitAndReach = new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/SitAndReach.png"));
	}
	
	private void displayNewGraph(JLabel pressedButton) {
		
		SitAndReachButton.setIcon(SitAndReach);
		PushupsLabel.setIcon(Pushups);
		SitupsLabel.setIcon(Situps);
		pressedButton.setIcon(new ImageIcon(ReportsPanelCapabilities.class.getResource("/Assets/" + pressedButton.getText() +"Pressed.png")));
	}
}
