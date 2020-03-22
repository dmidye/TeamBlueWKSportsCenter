package Panels;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Assets.fonts;
import Components.GymEventPanel;
import Components.LeaveThanksPanel;
import Panels.HomeScreenMember.AccountPanel;
import Panels.HomeScreenMember.GoalObjectPanel;
import Panels.HomeScreenMember.ReportsPanelFull;
import Panels.HomeScreenMember.reportsPanel;

import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class HomeScreen extends JPanel {
	
	private JLabel currentLabel = new JLabel();
	private String username;
	private JFrame owningFrame;
	private fonts fontCatalog = new fonts();
	private AccountPanel accountPanel;
	private JPanel CardPanel;
	private Database.databaseConnector databaseConnector;
	private JPanel eventsPanel;

	/**
	 * Create the panel.
	 */
	
	CardLayout cardLayout;
	private JTextField CommentTitleInputArea;
	
	public HomeScreen(JFrame owningFrame,String username) throws IOException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		this.owningFrame = owningFrame;
		setLayout(null);
		databaseConnector = new Database.databaseConnector();
		
		welcomeBanner TopPanel = new welcomeBanner();
		TopPanel.setBounds(0, 0, 1226, 56);
		add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel lblPowerFitness = new JLabel("Power Fitness");
		lblPowerFitness.setFont(new Font("Arial", Font.BOLD, 40));
		lblPowerFitness.setForeground(Color.WHITE);
		lblPowerFitness.setBounds(146, 11, 275, 34);
		TopPanel.add(lblPowerFitness);
		
		JLabel label = new JLabel("New label");
		label.setBounds(521, 56, 46, 14);
		TopPanel.add(label);
		
		JLabel lblHome_1 = new JLabel("Home");
		lblHome_1.setForeground(Color.WHITE);
		lblHome_1.setBounds(705, 18, 51, 34);
		TopPanel.add(lblHome_1);
		lblHome_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setBounds(766, 23, 76, 23);
		TopPanel.add(lblAccount);
		
		JLabel lblGoals = new JLabel("Goals");
		lblGoals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setBounds(852, 23, 51, 23);
		
		TopPanel.add(lblGoals);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReports.setBounds(913, 21, 76, 27);
		TopPanel.add(lblReports);
		
		JLabel lblSignOut = new JLabel("Sign Out");
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSignOut.setBounds(999, 17, 108, 34);
		
		TopPanel.add(lblSignOut);
		
		CardPanel = new JPanel();
		CardPanel.setBounds(0, 55, 1226, 674);
		add(CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(new Color(243,243,243));
		CardPanel.add(HomePanel, "name_45716443487700");
		HomePanel.setLayout(null);
		
		JPanel CalanderPanel = new JPanel();
		CalanderPanel.setBackground(new Color(243,243,243));
		CalanderPanel.setBounds(87, 18, 312, 327);
		HomePanel.add(CalanderPanel);
		CalanderPanel.setLayout(null);
		
		JLabel label_1 = new JLabel("9");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		label_1.setBounds(123, 178, 54, 91);
		CalanderPanel.add(label_1);
		
		JPanel topOfCalanderPanel = new JPanel();
		topOfCalanderPanel.setBounds(0, 0, 300, 126);
		CalanderPanel.add(topOfCalanderPanel);
		topOfCalanderPanel.setLayout(null);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(Color.WHITE);
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDay.setBounds(68, 26, 164, 47);
		topOfCalanderPanel.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMonth.setBounds(64, 69, 172, 47);
		topOfCalanderPanel.add(lblMonth);
		
		JLabel TopOfCalander = new JLabel("New label");
		TopOfCalander.setBackground(Color.BLACK);
		TopOfCalander.setBounds(0, 19, 300, 107);
		topOfCalanderPanel.add(TopOfCalander);
		TopOfCalander.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/TopOfCalander.png")));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(-8, 7, 321, 315);
		CalanderPanel.add(label_2);
		label_2.setBackground(Color.WHITE);
		label_2.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/300x300Rect.png")));
		
		JPanel CommentPanel = new JPanel();
		CommentPanel.setBackground(new Color(243,243,243));
		CommentPanel.setBounds(85, 354, 314, 309);
		HomePanel.add(CommentPanel);
		CommentPanel.setLayout(null);
		
		JLabel lblWeWouldLove = new JLabel("<html><div style='text-align:center'> We would love to hear how you feel.</div></html>");
		lblWeWouldLove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWeWouldLove.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeWouldLove.setBounds(42, 35, 216, 51);
		CommentPanel.add(lblWeWouldLove);
		
		JLabel lblSoThatWe = new JLabel("<html><div style='text-align:center'> So that we can make your next visit even better.</div></html>");
		lblSoThatWe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoThatWe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoThatWe.setBounds(42, 106, 216, 75);
		CommentPanel.add(lblSoThatWe);
		
		JLabel lblLeaveAComment = new JLabel("");
		lblLeaveAComment.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Comment Button.png")));
		lblLeaveAComment.setBounds(28, 203, 238, 73);
		CommentPanel.add(lblLeaveAComment);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(-7, -7, 327, 327);
		CommentPanel.add(label_3);
		label_3.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/300x300Rect.png")));
		
		JPanel SchedulePanel = new JPanel();
		SchedulePanel.setBackground(new Color(243,243,243));
		SchedulePanel.setBounds(477, 28, 698, 646);
		HomePanel.add(SchedulePanel);
		SchedulePanel.setLayout(null);
		
		JLabel lblTodaysSchedule = new JLabel("Today's Schedule");
		lblTodaysSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodaysSchedule.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTodaysSchedule.setBounds(107, 70, 455, 61);
		SchedulePanel.add(lblTodaysSchedule);
		
		eventsPanel = new JPanel();
		eventsPanel.setBounds(10, 144, 654, 441);
		SchedulePanel.add(eventsPanel);
		eventsPanel.setLayout(new GridLayout(0, 1, 0, 0));		
		fillEventsList();                                                               //Fills up Event Panel
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/SchedulePanel.png")));
		label_4.setBounds(-6, -6, 696, 653);
		SchedulePanel.add(label_4);
		
		JPanel GoalPanel = new JPanel();
		GoalPanel.setBorder(null);
		GoalPanel.setBackground(Color.WHITE);
		CardPanel.add(GoalPanel, "name_44701725794100");
		GoalPanel.setLayout(null);
		
		GoalObjectPanel GoalList = new GoalObjectPanel(username);
		GoalList.setBounds(0, 0, 1226, 674);
		GoalPanel.add(GoalList);
		
		JPanel ReportsPanel = new ReportsPanelFull(username);
		CardPanel.add(ReportsPanel, "name_44731238982200");
		
		accountPanel = new AccountPanel(username);
		CardPanel.add(accountPanel);
		
		JPanel FeedbackPanel = new JPanel();
		CardPanel.add(FeedbackPanel, "name_3691353706700");
		FeedbackPanel.setLayout(null);
		
		JLabel returnFromCommentsButton = new JLabel("");
		returnFromCommentsButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Return.png")));
		returnFromCommentsButton.setBounds(319, 565, 182, 63);
		FeedbackPanel.add(returnFromCommentsButton);
		
		JLabel SendCommentButton = new JLabel("");
		SendCommentButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/Send.png")));
		SendCommentButton.setBounds(708, 564, 182, 63);
		FeedbackPanel.add(SendCommentButton);
		
		JLabel FeelingsTextArea = new JLabel("");
		FeelingsTextArea.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/FeelingsDescription.png")));
		FeelingsTextArea.setBounds(319, 284, 599, 267);
		FeedbackPanel.add(FeelingsTextArea);
		
		JLabel CommentTitleTextArea = new JLabel("");
		CommentTitleTextArea.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/TitleBar.png")));
		CommentTitleTextArea.setBounds(420, 191, 486, 70);
		FeedbackPanel.add(CommentTitleTextArea);
		
		JLabel FeelingsDescription = new JLabel("");
		FeelingsDescription.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/FeelingsPanel.png")));
		FeelingsDescription.setBounds(267, 20, 696, 653);
		FeedbackPanel.add(FeelingsDescription);
		
		CommentTitleInputArea = new JTextField();
		CommentTitleInputArea.setBorder(null);
		CommentTitleInputArea.setBounds(443, 203, 430, 28);
		FeedbackPanel.add(CommentTitleInputArea);
		CommentTitleInputArea.setColumns(10);
		
		JTextArea CommentInputArea = new JTextArea();
		CommentInputArea.setBounds(348, 315, 525, 195);
		FeedbackPanel.add(CommentInputArea);
		
		JPanel ThanksPanel = new JPanel();
		CardPanel.add(ThanksPanel, "name_7718352610600");
		ThanksPanel.setLayout(null);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HomeScreen.class.getResource("/Assets/ThanksPanel.png")));
		label_6.setBounds(267, 20, 696, 653);
		ThanksPanel.add(label_6);
		
		///////Start of Button Functionality Addition  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		lblHome_1.addMouseListener(new MouseListener() { //Navigation Bar Home Button
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(HomePanel);
				CardPanel.repaint();
				CardPanel.revalidate();	
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		lblAccount.addMouseListener(new MouseListener() { //Navigation Bar Account Button
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(accountPanel);
				CardPanel.repaint();
				CardPanel.revalidate();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		lblGoals.addMouseListener(new MouseListener() {  //Navigation Bar Goals Button
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(GoalPanel);
				CardPanel.repaint();
				CardPanel.revalidate();
			}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		lblReports.addMouseListener(new MouseListener() { //Navigation Bar Reports Button
			@Override
			public void mouseClicked(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(ReportsPanel);
				CardPanel.repaint();
				CardPanel.revalidate();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		lblSignOut.addMouseListener(new MouseListener() {  //Navigation Bar Sign Out Button

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					changePanel(new LoginPanel(owningFrame));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (FontFormatException e1) {
					e1.printStackTrace();
				}			
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		lblLeaveAComment.addMouseListener(new MouseListener() {     //Button to Comment Panel

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(FeedbackPanel);
				CardPanel.repaint();
				CardPanel.revalidate();	
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		returnFromCommentsButton.addMouseListener(new MouseListener() { //Return From Comments Panel to Home Panel Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(HomePanel);
				CardPanel.repaint();
				CardPanel.revalidate();	
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		SendCommentButton.addMouseListener(new MouseListener() {        //Send Comment Button

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				String title = CommentTitleInputArea.getText();
				String description = CommentInputArea.getText();
				
				databaseConnector.sendUpdate("INSERT INTO `feedback`(`Title`, `Description`, `Closed`) VALUES (\"" + title + "\", \"" + description + "\" , \"" + 1 + "\")");
				
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
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});

	}
	
	
	
	///Start of Functions ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void changePanel(JPanel nextPanel) throws IOException {
		owningFrame.getContentPane().add(nextPanel);
		owningFrame.getContentPane().remove(this);
		owningFrame.revalidate();
	}
	
	public void fillEventsList() {
		
		ResultSet rs = databaseConnector.sendStatement("SELECT `Title`, `Location`, `Hour`, `Minute`, `AM/PM` FROM `events`");
		
		try {
			while(rs.next()) {
				if(rs.getString(4).equals("0")) {
					eventsPanel.add(new GymEventPanel(rs.getString(3), "00", rs.getString(2), rs.getString(1)));
				}
				else {
					eventsPanel.add(new GymEventPanel(rs.getString(3), rs.getString(4), rs.getString(2), rs.getString(1)));
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
