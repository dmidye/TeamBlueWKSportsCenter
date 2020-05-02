package Components;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GymEventPanel extends JPanel {
	
	//This piece is used on the home page to display events. Upon the home screens creation one of these panels is created for each event held in the database.
	

	public GymEventPanel(String date, String description) {
		setBackground(Color.WHITE);
		
		setLayout(null);
		System.out.println(date+ description);
		
		JLabel lblam = new JLabel(date);
		lblam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblam.setBounds(0, 0, 185, 37);
		add(lblam);
		
		JLabel lblMentalHealthAnd = new JLabel(description);
		lblMentalHealthAnd.setVerticalAlignment(SwingConstants.TOP);
		lblMentalHealthAnd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMentalHealthAnd.setBounds(179, 0, 431, 93);
		add(lblMentalHealthAnd);
	}
}
