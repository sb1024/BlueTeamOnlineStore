import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class CartPage {
	private JFrame frame;
	private JPanel mainPanel;
	
	CartPage() {

		frame = new JFrame("Test");
		 JScrollPane scrollPane = new JScrollPane();


		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new GridBagLayout());
		
		JLabel shoppingTitle = new JLabel("<HTML><u>Shopping Cart</u></HTML>");
		shoppingTitle.setFont(new Font("Arial", Font.PLAIN, 50));
		
		JScrollPane checkOutArea = new JScrollPane();
		checkOutArea.setPreferredSize(new Dimension(900, 470));
		checkOutArea.setBackground(new Color(80, 80, 80));
		GridBagConstraints checkOutAreaC = new GridBagConstraints();
		checkOutAreaC.gridy=1;
		GridBagConstraints reviewC = new GridBagConstraints();
		reviewC.gridy=2;
		reviewC.gridx=0;
		reviewC.anchor=GridBagConstraints.EAST;
		
		JPanel review = new JPanel();
		review.setAlignmentX(Component.RIGHT_ALIGNMENT);
		review.setPreferredSize(new Dimension(200, 100));
		review.setLayout(new BoxLayout(review, BoxLayout.X_AXIS));
		review.setBackground(new Color(180, 180, 180));
		
		JPanel price=new JPanel();
		price.setBackground(Color.DARK_GRAY);
		price.add(new JLabel("Price"));
		price.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		review.add(price);
		
		
		mainPanel.add(shoppingTitle);
		mainPanel.add(checkOutArea, checkOutAreaC);
		mainPanel.add(review, reviewC);
		
		
		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setPreferredSize(new Dimension(1200, 670));
		



		
		mainPanel.repaint();
		frame.add(scrollPane);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	public static void main(String args[]){
		new CartPage();
	}
}
