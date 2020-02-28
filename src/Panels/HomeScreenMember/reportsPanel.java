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

public class reportsPanel extends JPanel {
	private ResultSet rs;
	private databaseConnector connector = new databaseConnector();
	private Graph.graphFactory graphFactory = new Graph.graphFactory();
	private int id;
	private String username;
	
	JLabel CholesterolButton;
	JLabel BMILabel;
	JLabel BloodPressureLabel;
	JLabel WeightLabel;
	JPanel chartPanel;
	
	ImageIcon BMI;
	ImageIcon BloodPressure;
	ImageIcon Weight;
	ImageIcon Cholesterol;

	/**
	 * Create the panel.
	 */
	public reportsPanel(String username) {
		
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
		
		BMILabel = new JLabel("BMI");
		BMILabel.setBackground(Color.WHITE);
		BMILabel.setIcon(BMI);
		BMILabel.setBounds(53, 39, 122, 63);
		Health.add(BMILabel);
		
		BloodPressureLabel = new JLabel("BloodPressure");
		BloodPressureLabel.setIcon(BloodPressure);
		BloodPressureLabel.setBounds(182, 39, 223, 63);
		Health.add(BloodPressureLabel);
		
		WeightLabel = new JLabel("Weight");
		WeightLabel.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/Weight.png")));
		WeightLabel.setBounds(248, 120, 157, 63);
		Health.add(WeightLabel);
		
		CholesterolButton = new JLabel("Cholesterol");
		CholesterolButton.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/Cholesterol.png")));
		CholesterolButton.setBounds(53, 120, 191, 63);
		Health.add(CholesterolButton);
		
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
		SitupsButton.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/Situps.png")));
		SitupsButton.setBounds(49, 108, 164, 63);
		Capabillities.add(SitupsButton);
		
		JLabel PushupsButton = new JLabel("");
		PushupsButton.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/Pushups.png")));
		PushupsButton.setBounds(223, 108, 164, 63);
		Capabillities.add(PushupsButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/SitAndReach.png")));
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
		CholesterolButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(CholesterolButton);
				rs = connector.sendStatement("SELECT `date`,`totalCholesterol` FROM `coronaryrisk` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Cholesterol Over Time", "Dates", "Cholesterol"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
		BMILabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(BMILabel);
				rs = connector.sendStatement("SELECT `date`,`BMI` FROM `bodycomp` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "BMI Over Time", "Dates", "BMI"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
		WeightLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(WeightLabel);
				rs = connector.sendStatement("SELECT `date`,`fatWeight` FROM `bodycomp` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Weight Over Time", "Dates", "Weight"));
			    chartPanel.repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {	}
		});
		
		BloodPressureLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				displayNewGraph(BloodPressureLabel);
				rs = connector.sendStatement("SELECT `date`,`systolicBloodPressure` FROM `coronaryrisk` WHERE `memberID` = " + id);
				chartPanel.removeAll();
			    chartPanel.add(graphFactory.createGraph(rs, "Blood Pressure Over Time", "Dates", "Blood Pressure"));
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
		CholesterolButton.setIcon(Cholesterol);
		BloodPressureLabel.setIcon(BloodPressure);
		WeightLabel.setIcon(Weight);
		BMILabel.setIcon(BMI);
		chartPanel.removeAll();
		chartPanel.repaint();
	}
	
	private void loadIcons() {
		BMI = new ImageIcon(reportsPanel.class.getResource("/Assets/BMI.png"));
		BloodPressure = new ImageIcon(reportsPanel.class.getResource("/Assets/BloodPressure.png"));
		Weight = new ImageIcon(reportsPanel.class.getResource("/Assets/Weight.png"));
		Cholesterol = new ImageIcon(reportsPanel.class.getResource("/Assets/Cholesterol.png"));
	}
	
	private void displayNewGraph(JLabel pressedButton) {
		CholesterolButton.setIcon(Cholesterol);
		BloodPressureLabel.setIcon(BloodPressure);
		WeightLabel.setIcon(Weight);
		BMILabel.setIcon(BMI);
		pressedButton.setIcon(new ImageIcon(reportsPanel.class.getResource("/Assets/" + pressedButton.getText() +"Pressed.png")));
	}
}
