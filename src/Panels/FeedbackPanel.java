package Panels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Database.databaseConnector;

import Components.LeaveThanksPanel;

public class FeedbackPanel extends JPanel{
	
	private databaseConnector databaseConnector;
	private JPanel CardPanel;
	private JPanel HomePanel;
	private JTextField CommentTitleInputArea;
	
	
	//This panel is called after the leave comments button is pressed. The thank you panel is also encompassed in this class.
	
	FeedbackPanel(databaseConnector db, JPanel CardPanel, JPanel HomePanel){
		//Setup dependancies
		databaseConnector = db;  //Used to save feedback
		this.CardPanel = CardPanel; //Used to change the displayed panel to the thank you panel and the home screen after
		this.HomePanel = HomePanel; //Home screen to return to.
		
		JLabel returnFromCommentsButton = new JLabel("");
		returnFromCommentsButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Return.png")));
		returnFromCommentsButton.setBounds(319, 565, 182, 63);
		add(returnFromCommentsButton);
		
		JLabel SendCommentButton = new JLabel("");
		SendCommentButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Send.png")));
		SendCommentButton.setBounds(708, 564, 182, 63);
		add(SendCommentButton);
		
		JLabel FeelingsTextArea = new JLabel("");
		FeelingsTextArea.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/FeelingsDescription.png")));
		FeelingsTextArea.setBounds(319, 284, 599, 267);
		add(FeelingsTextArea);
		
		JLabel CommentTitleTextArea = new JLabel("");
		CommentTitleTextArea.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/TitleBar.png")));
		CommentTitleTextArea.setBounds(420, 191, 486, 70);
		add(CommentTitleTextArea);
		
		JLabel FeelingsDescription = new JLabel("");
		FeelingsDescription.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/FeelingsPanel.png")));
		FeelingsDescription.setBounds(267, 20, 696, 653);
		add(FeelingsDescription);
		
		JTextField CommentTitleInputArea = new JTextField();
		CommentTitleInputArea.setBorder(null);
		CommentTitleInputArea.setBounds(443, 203, 430, 28);
		add(CommentTitleInputArea);
		CommentTitleInputArea.setColumns(10);
		
		JTextArea CommentInputArea = new JTextArea();
		CommentInputArea.setBounds(348, 315, 525, 195);
		add(CommentInputArea);
		
		JPanel ThanksPanel = new JPanel();
		CardPanel.add(ThanksPanel, "name_7718352610600");
		ThanksPanel.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/ThanksPanel.png")));
		label_6.setBounds(267, 20, 696, 653);
		ThanksPanel.add(label_6);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Start of button Listeners
		
		returnFromCommentsButton.addMouseListener(new MouseListener() { //Return From Comments Panel to Home Panel Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				returnFromCommentsButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Return.png")));
				CardPanel.removeAll();
				CardPanel.add(HomePanel);
				CardPanel.repaint();
				CardPanel.revalidate();	
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				returnFromCommentsButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/feedbackReturnHovered.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				returnFromCommentsButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Return.png")));
			}
		});
		
		SendCommentButton.addMouseListener(new MouseListener() {        //Send Comment Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				String title = CommentTitleInputArea.getText();
				String description = CommentInputArea.getText();
				
				databaseConnector.sendUpdate("INSERT INTO `feedback`(`Title`, `Description`) VALUES (\"" + title + "\", \"" + description + "\")");
				SendCommentButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Send.png")));
				
				CardPanel.removeAll();
				CardPanel.add(ThanksPanel);
				CardPanel.repaint();
				CardPanel.revalidate();
				
				Timer leaveThanksPanel = new Timer();
				TimerTask task = new LeaveThanksPanel(HomePanel,CardPanel);
				leaveThanksPanel.schedule(task,800);
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				SendCommentButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/feedbackSendHovered.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SendCommentButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Send.png")));
			}
		});
	}

}
