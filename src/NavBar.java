import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NavBar {
	public NavBar(){
		JFrame frame = new JFrame("Test space");
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1200, 50));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		mainPanel.add(new JLabel(new ParsedImageIcon("noImage.jpg", 50, 50)));
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String args[]){
		new NavBar();
	}

}


