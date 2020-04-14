package Panels.HomeScreenMember;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import Database.databaseConnector;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class GoalObjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private databaseConnector database = new databaseConnector();
	private ArrayList<String> goals = new ArrayList<String>();
	private String username;
	private int goalsCounter = 0;
	private JLabel subToGo;
	private JTextField subDescription;
	private JTextField subCurrent;
	private JTextField subGoal;
	private int memberID;
	private String currentDescription;
	private JComboBox<String> goalComboBox;
	private JLabel GoalsLeftCounter;
	private JLabel AuthorLabel;
	private JLabel QuoteLabel;
	private final JTextField requestItem = new JTextField();
	
	private boolean isDescActive = false;
	private boolean isCurrActive = false;
	private boolean isGoalActive = false;
	
	//buttons
	private JLabel editDescriptionButton;
	private JLabel CurrentValueButton;
	private JLabel GoalValueButton;
	
	//Are goals being Created?
	public boolean creatingGoals = false;
	
	public GoalObjectPanel(String username) {
		this.username = username;
		currentDescription = "Select a Goal";
		//ResultSet rs = database.sendStatement("SELECT `user`.`memberID` FROM `user` WHERE username` = \"" + username + "\"");
//		try {
//			while(rs.next()) {
//				memberID = rs.getInt(1);
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		setBackground(new Color(243,243,243));
		setBorder(null);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(243,243,243));
		panel.setBorder(null);
		panel.setBounds(477, 28, 696, 653);
		add(panel);
		panel.setLayout(null);
		
		JPanel subPanel = new JPanel();
		subPanel.setBorder(null);
		subPanel.setBackground(new Color(243,243,243));
		subPanel.setBounds(0, 0, 696, 653);
		panel.add(subPanel);
		subPanel.setLayout(null);
		
		subCurrent = new JTextField();
		subCurrent.setEditable(false);
		subCurrent.setBackground(Color.white);
		subCurrent.setBorder(null);
		subCurrent.setBounds(184, 378, 82, 23);
		subPanel.add(subCurrent);
		subCurrent.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/ValueBar.png")));
		label_5.setBounds(168, 363, 122, 63);
		subPanel.add(label_5);
		//subPanel.setVisible(false);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setBounds(53, 151, 89, 26);
		subPanel.add(lblDescription);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblGoalValue = new JLabel("Goal Value:");
		lblGoalValue.setForeground(Color.BLACK);
		lblGoalValue.setBackground(new Color(171,0,255));
		lblGoalValue.setBounds(34, 373, 82, 27);
		subPanel.add(lblGoalValue);
		lblGoalValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCurrentValue = new JLabel("Current Value:");
		lblCurrentValue.setForeground(Color.BLACK);
		lblCurrentValue.setBounds(34, 316, 103, 27);
		subPanel.add(lblCurrentValue);
		lblCurrentValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAmountToGo = new JLabel("Amount to Go:");
		lblAmountToGo.setForeground(Color.BLACK);
		lblAmountToGo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmountToGo.setBounds(487, 316, 114, 26);
		subPanel.add(lblAmountToGo);
		
		subToGo = new JLabel("");
		subToGo.setForeground(Color.BLACK);
		subToGo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		subToGo.setBounds(609, 318, 60, 22);
		subPanel.add(subToGo);
		
		subDescription = new JTextField();
		subDescription.setEditable(false);
		subDescription.setBackground(Color.white);
		subDescription.setBorder(null);
		subDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		subDescription.setBounds(232, 165, 369, 67);
		subPanel.add(subDescription);
		subDescription.setColumns(10);
		
		subGoal = new JTextField();
		subGoal.setEditable(false);
		subGoal.setBorder(null);
		subGoal.setBounds(184, 318, 82, 23);
		subGoal.setBackground(Color.white);
		subPanel.add(subGoal);
		subGoal.setColumns(10);
		
		goalComboBox = new JComboBox<String>();
		goalComboBox.setBorder(null);
		goalComboBox.setBounds(53, 61, 562, 56);
		subPanel.add(goalComboBox);
		goalComboBox.setBackground(Color.WHITE);
		goalComboBox.setFont(new Font("Tahoma", Font.PLAIN, 26));
		goalComboBox.setModel(new DefaultComboBoxModel(goals.toArray()));
		
		JLabel lblNewLabel = new JLabel("Your Progress:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 426, 162, 26);
		subPanel.add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(34, 471, 562, 17);
		subPanel.add(progressBar);
		
		editDescriptionButton = new JLabel("Edit");
		editDescriptionButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButton.png")));
		editDescriptionButton.setBounds(493, 252, 122, 63);		
		subPanel.add(editDescriptionButton);
		
		JLabel FinishGoalButton = new JLabel("New label");
		FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/MarkAsFinishedButton.png")));
		FinishGoalButton.setBounds(190, 533, 295, 67);
		subPanel.add(FinishGoalButton);
		
		CurrentValueButton = new JLabel("Edit");
		CurrentValueButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButton.png")));
		CurrentValueButton.setBounds(313, 302, 122, 63);
		subPanel.add(CurrentValueButton);
		
		GoalValueButton = new JLabel("Edit");
		GoalValueButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButton.png")));
		GoalValueButton.setBounds(313, 363, 122, 63);
		subPanel.add(GoalValueButton);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/ValueBar.png")));
		label_3.setBounds(168, 302, 122, 63);
		subPanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/DescriptionGoalBar.png")));
		label_4.setBounds(216, 151, 415, 107);
		subPanel.add(label_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, -15, 696, 653);
		subPanel.add(label_2);
		label_2.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/GoalPanel.png")));
		requestItem.setBounds(53, 19, 6, 0);
		subPanel.add(requestItem);
		requestItem.setColumns(10);
		
		setLayout(null);
		
		JPanel goalsLeftPanel = new JPanel();
		goalsLeftPanel.setBounds(85, 24, 346, 319);
		goalsLeftPanel.setBackground(new Color(243,243,243));
		add(goalsLeftPanel);
		goalsLeftPanel.setLayout(null);
		
		JLabel lblGoalsLeft = new JLabel("Current Goals:");
		lblGoalsLeft.setForeground(Color.BLACK);
		lblGoalsLeft.setBounds(66, 59, 149, 47);
		goalsLeftPanel.add(lblGoalsLeft);
		lblGoalsLeft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GoalsLeftCounter = new JLabel(Integer.toString(goalsCounter));
		GoalsLeftCounter.setForeground(Color.BLACK);
		GoalsLeftCounter.setBounds(204, 59, 88, 73);
		goalsLeftPanel.add(GoalsLeftCounter);
		GoalsLeftCounter.setFont(new Font("Tahoma", Font.PLAIN, 80));
		
		JLabel AddAGoalButton = new JLabel("");
		AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/AddAGoal.png")));
		AddAGoalButton.setBounds(71, 217, 165, 65);
		goalsLeftPanel.add(AddAGoalButton);
		
		JLabel label = new JLabel("");
		label.setBounds(-10, -15, 327, 337);
		goalsLeftPanel.add(label);
		label.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/300x300Rect.png")));
		
		JPanel inspirtationPanel = new JPanel();
		inspirtationPanel.setBackground(new Color(243,243,243));
		inspirtationPanel.setBounds(85, 354, 346, 345);
		add(inspirtationPanel);
		inspirtationPanel.setLayout(null);
		
		JLabel lblInspirationForSuccess = new JLabel("Inspiration for Success");
		lblInspirationForSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblInspirationForSuccess.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInspirationForSuccess.setBounds(42, 30, 224, 41);
		inspirtationPanel.add(lblInspirationForSuccess);
		
		QuoteLabel = new JLabel("<html>The journey of a thousand miles starts with one step.</html>");
		QuoteLabel.setVerticalAlignment(SwingConstants.TOP);
		QuoteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		QuoteLabel.setBounds(31, 109, 261, 89);
		inspirtationPanel.add(QuoteLabel);
		
		AuthorLabel = new JLabel("-Lao Tzo");
		AuthorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		AuthorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AuthorLabel.setBounds(45, 243, 221, 30);
		inspirtationPanel.add(AuthorLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/300x300Rect.png")));
		lblNewLabel_2.setBounds(0, 0, 327, 327);
		inspirtationPanel.add(lblNewLabel_2);

		retriveInspiration();
		
		updateComboBox();
		
		
		//Start of Button Functionality Addition ///////////////////////////////////////////////////////////////////////////////////
		
		
		editDescriptionButton.addMouseListener(new MouseListener() { // Enable / Disable Description and Save Change Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				editValue(editDescriptionButton, subDescription, "description");
				if(isDescActive) {
					isDescActive = false;
				}
				else {
					isDescActive = true;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				changeGoalButton(editDescriptionButton, isDescActive, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeGoalButton(editDescriptionButton, isDescActive, false);
			}	
		});
		
		GoalValueButton.addMouseListener(new MouseListener() {  //Enable / Disable Goal Value and Save Change Button

			@Override
			public void mouseClicked(MouseEvent e) {	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				editValue(GoalValueButton, subCurrent, "currentValue");
				if(isGoalActive) {
					isGoalActive = false;
				}
				else {
					isGoalActive = true;
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				changeGoalButton(GoalValueButton, isGoalActive, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeGoalButton(GoalValueButton, isGoalActive, false);
			}
		});
		
		CurrentValueButton.addMouseListener(new MouseListener() {  // Enable / Disable Current Value and Save Change Button

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				editValue(CurrentValueButton, subGoal, "goalValue");
				if(isCurrActive) {
					isCurrActive = false;
				}
				else {
					isCurrActive = true;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				changeGoalButton(CurrentValueButton, isCurrActive, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeGoalButton(CurrentValueButton, isCurrActive, false);
			}
		});
		
		
		goalComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				System.out.println("GGG");
				if(goalComboBox.getSelectedItem() != null && !goalComboBox.getSelectedItem().equals("Select a Goal")) {
					updateSubGoalPanel(goalComboBox.getSelectedItem().toString());
					System.out.println("NotSelectGoal");
				}
				else {
					System.out.println("Select Goal");
					currentDescription = "Select a Goal";
				}
			}
		});
		
		FinishGoalButton.addMouseListener(new MouseListener() {  //Button that deletes goals 

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				if(creatingGoals) {  //Handle if saving new goal
					if(!subDescription.getText().equals("")){
						try {  
							Integer.parseInt(subGoal.getText());
							Integer.parseInt(subCurrent.getText());
							FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButton.png")));
							AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/AddAGoal.png")));
							FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/MarkAsFinishedButton.png")));
							database.sendUpdate("INSERT INTO `goals` (`username`,`description`, `currentValue`,`goalValue`) VALUES ('" + username + ",'" + subDescription.getText() + "'," + subCurrent.getText() + "," + subGoal.getText() + ")");
							
							goalComboBox.setEnabled(true); //Setup buttons and fields
							GoalValueButton.setEnabled(true);
							CurrentValueButton.setEnabled(true);
							editDescriptionButton.setEnabled(true);
							subDescription.setEditable(false);
							subGoal.setEditable(false);
							subCurrent.setEditable(false);
							creatingGoals = false;
							
							updateComboBox();  //Fix combo box
							
							subCurrent.setText("");//Clear fields
							subGoal.setText("");
							subDescription.setText("");
							
						} catch (Exception e1) { // Handle if goal and current fields are empty
							FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButtonFailed.png")));
							e1.printStackTrace();
						}
					}
					else {  //Handle if description field is empty 
						FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButtonFailed.png")));
					}
				} //Handle is deleting goal
				else {
					database.sendUpdate("DELETE FROM `goals` WHERE `username` = " + username + " AND `description` = '" + subDescription.getText()+ "'");
					updateComboBox();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(!creatingGoals) {
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/MarkAsFinishedButtonHovered.png")));
				}
				else {
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButtonHovered.png")));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!creatingGoals) {
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/MarkAsFinishedButton.png")));
				}
				else {
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButton.png")));
				}
			}
		});
		
		AddAGoalButton.addMouseListener(new MouseListener() {     //Changes the main panel to create a new goal.

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!creatingGoals) {
					AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/QuitNewGoalButton.png")));
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveGoalButton.png")));
					goalComboBox.setEnabled(false);
					GoalValueButton.setEnabled(false);
					CurrentValueButton.setEnabled(false);
					editDescriptionButton.setEnabled(false);
					subDescription.setEditable(true);
					subGoal.setEditable(true);
					subCurrent.setEditable(true);
					creatingGoals = true;
				}
				else {
					AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/AddAGoal.png")));
					FinishGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/MarkAsFinishedButton.png")));
					goalComboBox.setEnabled(true);
					GoalValueButton.setEnabled(true);
					CurrentValueButton.setEnabled(true);
					editDescriptionButton.setEnabled(true);
					subDescription.setEditable(false);
					subGoal.setEditable(false);
					subCurrent.setEditable(false);
					subCurrent.setText("");
					subGoal.setText("");
					subDescription.setText("");
					creatingGoals = false;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(!creatingGoals) {
					AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/AddAGoalHovered.png")));	
				}
				else {
					
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!creatingGoals) {
					AddAGoalButton.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/AddAGoal.png")));
				}
				else {
					
				}
			}
			
		});
	}
	
	///Start of Functions //////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Description: Update the goal combo box and counter
	//
	//
	public void updateComboBox() {
		goalComboBox.removeAllItems();
		goalComboBox.addItem("Select a Goal");
		goalsCounter = 0;
		ResultSet rs = database.sendStatement("SELECT `goals`.`description` FROM `goals` INNER JOIN `user` ON `user`.`Username` = \"" + username + "\"");
		try {
			while(rs.next()) {
				String nextGoal = rs.getString(1);
				goalComboBox.addItem(nextGoal);
				goalsCounter++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//Description: Update the values of the fields in the sub panel.
	//
	//
	public void updateSubGoalPanel(String description) {
		
		ResultSet rs = database.sendStatement("SELECT `goals`.`currentValue`, `goals`.`goalValue` FROM `goals` INNER JOIN `user` ON `user`.`Username` = \"" + username + "\" WHERE `goals`.`description` = \"" + description + "\"");
		try {
			while(rs.next()) {
				currentDescription = description;
				subDescription.setText(description);
				subCurrent.setText(Integer.toString(rs.getInt(1)));
				subGoal.setText(Integer.toString(rs.getInt(2)));
				subToGo.setText(Integer.toString(Math.abs(rs.getInt(1) - rs.getInt(2))));
				memberID = rs.getInt(3);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//Description: When this is called it checks the text of the button passed in. It will flip it to the inverse and perform the necessary house cleaning. Ex) Save the change made and make the field inactive.
	//
	//
	public void editValue(JLabel button, JTextField field, String attribute) {
		if(button.getText().equals("Edit")) {  //If editing value
			field.setEditable(true);
			field.requestFocus();
			button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveButtonHovered.png")));
			button.setText("Save");
		}
		else {                                 //If saving value
			requestItem.requestFocus();
			button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButtonHovered.png")));
			button.setText("Edit");
			field.setEditable(false);
			database.sendUpdate("UPDATE `goals` SET `" + attribute + "` = \"" + field.getText() + "\" WHERE username = \"" + username + "\" AND `description` = \"" + currentDescription + "\"");
			if(attribute.equals("description")) {
				currentDescription = field.getText();
			}
			goalComboBox.setEditable(true);
			goalComboBox.setSelectedItem(currentDescription);
			goalComboBox.setEditable(false);
		}
	}
	
	//Description: This is called to retrieve data from the inspiration table and fill the inspiration panel with the returned data.
	//
	//
	public void retriveInspiration() {
		String author = "";
		String quote = "";
		ResultSet rs = database.sendStatement("SELECT `Author`, `Quote` FROM `quotes` order by RAND() LIMIT 1");
		try {
			while(rs.next()) {
				author = rs.getString(1);
				quote = rs.getString(2);
			}
			
			QuoteLabel.setText("<html>" + quote + "</html>");
			AuthorLabel.setText("-" + author);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void changeGoalButton(JLabel button, boolean mode, boolean entered) {
		if(!entered) {
			if(mode) {
				button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveButton.png")));
			}
			else {
				button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButton.png")));
			}
		}
		else {
			if(mode) {
				button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/SaveButtonHovered.png")));
			}
			else {
				button.setIcon(new ImageIcon(GoalObjectPanel.class.getResource("/Assets/EditButtonHovered.png")));
			}
		}	
	}
}
