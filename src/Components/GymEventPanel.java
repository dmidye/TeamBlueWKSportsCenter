package Components;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class GymEventPanel extends JPanel {
	
	//This piece is used on the home page to display events. Upon the home screens creation one of these panels is created for each event held in the database.
	
	private String hour = "10";
	private String minute = "00";
	private String room = "Room A";
	private String title = "Introduction to Yoga";

	public GymEventPanel(String hour, String minute, String room, String title) {
		setBackground(Color.WHITE);
		this.hour = hour;
		this.minute = minute;
		this.room = room;
		this.title = title;
		
		setLayout(null);
		
		JLabel lblam = new JLabel(this.hour + ":" + this.minute + " AM");
		lblam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblam.setBounds(0, 0, 133, 37);
		add(lblam);
		
		JLabel lblMentalHealthAnd = new JLabel(this.title);
		lblMentalHealthAnd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMentalHealthAnd.setBounds(158, 0, 431, 37);
		add(lblMentalHealthAnd);
		
		JLabel lblNewLabel = new JLabel(this.room);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(158, 48, 92, 22);
		add(lblNewLabel);
	}
}
