package Components;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class LeaveThanksPanel extends TimerTask{
	
	//This piece is called after someone submits a suggestion to thank them before they are returned to the home menu.
	
	JPanel HomePanel;
	JPanel CardPanel;
	
	public LeaveThanksPanel(JPanel HomePanel, JPanel CardPanel){
		this.HomePanel = HomePanel;
		this.CardPanel = CardPanel;
	}

	@Override
	public void run() {
		CardPanel.removeAll();
		CardPanel.add(HomePanel);
		CardPanel.repaint();
		CardPanel.revalidate();
	}

}
