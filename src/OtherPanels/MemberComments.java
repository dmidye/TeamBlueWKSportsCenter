package OtherPanels;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Database.DbManager;

public class MemberComments  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//instantiate components here (JTextfields, JLabels etc.)
	JPanel buttonPanel;
	JButton markClosed;
	JButton delete;
	JTabbedPane tabbedPane;
	JPanel panelOpen;
	JPanel panelClosed;
	JTable tableOpen;
	JTable tableClosed;
	Font font1 = new Font("Agency FB", Font.PLAIN, 25);
	
	public MemberComments() {
		this.
		setTitle("Member Comments");
		setSize(1200, 675);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(StaffView.class.getResource("/StaffViewAssets/staffViewBackground2.png")));
		add(background);
		background.setLayout(null);
		
		JLabel form = new JLabel(new ImageIcon(NewUserForm.class.getResource("/StaffViewAssets/memberComments.png")));
		form.setBounds(50, 20, 1105, 641);
		form.setLayout(null);
		
		//create tables to add to the tabbed pane
		try {
			loadCommentTabs();
			//grey out the "mark read" button when in closed tab
			ChangeListener changeListener = new ChangeListener() {
			    public void stateChanged(ChangeEvent changeEvent) {
			        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
			        int index = sourceTabbedPane.getSelectedIndex();
			        if(index == 1) {
			        	markClosed.setEnabled(false);
			        } else {
			        	markClosed.setEnabled(true);
			        }
			      }
			 };
			tabbedPane.addChangeListener(changeListener);
			
			//Allow user to select a table item and mark it as 'read'
			markClosed.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int idToActUpon;
					if(tableOpen.getSelectedRow() != -1) {
						try {
							idToActUpon = (int) tableOpen.getValueAt(tableOpen.getSelectedRow(), 0);
							DbManager db = new DbManager();
							db.markFeedBackClosed(idToActUpon);
							populateTables();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} 
					}
				}
			});
			
			//Allow user to delete feedback
			delete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int idToActUpon;
					if(tableOpen.getSelectedRow() != -1 && tabbedPane.getSelectedIndex() == 0) {
						try {
							idToActUpon = (int) tableOpen.getValueAt(tableOpen.getSelectedRow(), 0);
							DbManager db = new DbManager();
							db.deleteFeedBack(idToActUpon);
							JTabbedPane tp = populateTables();
							tp.setSelectedIndex(0);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} 
					}
					if(tableClosed.getSelectedRow() != -1 && tabbedPane.getSelectedIndex() == 1) {
						try {
							idToActUpon = (int) tableClosed.getValueAt(tableClosed.getSelectedRow(), 0);
							DbManager db = new DbManager();
							db.deleteFeedBack(idToActUpon);
							JTabbedPane tp = populateTables();
							tp.setSelectedIndex(1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} 
					}
				}
			});
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	// gets table data for open and closed comments, creates tables out of the data, and adds the table to a 
	// tab in the JTabbedPane
	private JTabbedPane populateTables() throws SQLException {
		DbManager db = new DbManager();
		Object[][] commentsOpen = db.getOpenFeedback();;
		Object[][] commentsClosed = db.getClosedFeedback();
		String[] columnNames = {"ID", "Title", "Description", "Open?", "Date Opened"};
		
		// if no comments at all
		if(commentsClosed == null && commentsOpen == null) {
			tableOpen = new JTable(new Object[0][0], columnNames);
			tableClosed = new JTable(new Object[0][0], columnNames);
		} else {
			// if no open comments
			if(commentsOpen == null) {
				tableOpen = new JTable(new Object[0][0], columnNames);
			} else {
				tableOpen = new JTable(commentsOpen, columnNames);
			}
			
			// if no closed comments
			if(commentsClosed == null) {
				tableClosed = new JTable(new Object[0][0], columnNames);
			} else {
				tableClosed = new JTable(commentsClosed, columnNames);
			}
		}
		
		tableOpen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableOpen.setDefaultEditor(Object.class, null);
		JTableHeader header = tableOpen.getTableHeader();
		panelOpen = new JPanel();
		panelOpen.setLayout(new BorderLayout());
		panelOpen.add(header, BorderLayout.NORTH);
		panelOpen.add(tableOpen, BorderLayout.CENTER);
		
		tableClosed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClosed.setDefaultEditor(Object.class, null);
		JTableHeader headerClosed = tableClosed.getTableHeader();
		panelClosed = new JPanel();
		panelClosed.setLayout(new BorderLayout());
		panelClosed.add(headerClosed, BorderLayout.NORTH);
		panelClosed.add(tableClosed, BorderLayout.CENTER);
		
		tabbedPane.removeAll();
		tabbedPane.add("Open", panelOpen);
		tabbedPane.add("Closed", panelClosed);
		
		return tabbedPane;
	}
	
	// Creates the initial tabbedPane and calls populateTables()
	private void loadCommentTabs() throws SQLException {
		tabbedPane = new JTabbedPane();
		populateTables();
		
		buttonPanel = new JPanel();
		markClosed = new JButton("Mark Closed");
		delete = new JButton("Delete");
		buttonPanel.add(markClosed);
		buttonPanel.add(delete);
		
		this.add(tabbedPane);
		this.add(buttonPanel,BorderLayout.SOUTH);	
	}
}