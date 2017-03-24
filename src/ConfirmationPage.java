import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmationPage extends JPanel{
	public ConfirmationPage(Order order){
		String orderNumberValue = "" + order.getOrderNumber();
		this.setLayout(new BorderLayout()); //Lets the holder fill the contianer
		this.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

		JPanel holder = new JPanel();
		holder.setLayout(new GridBagLayout());
		holder.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		
		GridBagConstraints mainTextConstraints = new GridBagConstraints();
		mainTextConstraints.fill=GridBagConstraints.HORIZONTAL;
		mainTextConstraints.weightx=1;
		mainTextConstraints.weighty=.35;
		mainTextConstraints.anchor=GridBagConstraints.NORTH;
		mainTextConstraints.insets=new Insets(30, 30, 30, 30);
		JLabel mainText = new JLabel("Thank you for your purchase!");
		mainText.setFont(new Font("Arial", Font.PLAIN, 50));
		holder.add(mainText, mainTextConstraints);
		
		GridBagConstraints orderTextConstraints = new GridBagConstraints();
		orderTextConstraints.weightx=1;
		orderTextConstraints.gridy=1;
		orderTextConstraints.anchor=GridBagConstraints.NORTHWEST;
		orderTextConstraints.insets=new Insets(0, 90, 0, 0);
		JLabel orderText = new JLabel("Please write down your order number:");
		orderText.setFont(new Font("Arial", Font.PLAIN, 25));
		holder.add(orderText, orderTextConstraints);
		
		GridBagConstraints orderNumberConstraints = new GridBagConstraints();
		orderNumberConstraints.weighty=.65;
		orderNumberConstraints.weightx=1;
		orderNumberConstraints.gridy=2;
		orderNumberConstraints.anchor=GridBagConstraints.NORTHWEST;
		orderNumberConstraints.insets=new Insets(0, 180, 0, 0);
		JLabel orderNumber = new JLabel(orderNumberValue.substring(0,3) + "-" + orderNumberValue.substring(3,6) + "-" + orderNumberValue.substring(6, 9));
		orderNumber.setFont(new Font("Arial", Font.PLAIN, 40));
		holder.add(orderNumber, orderNumberConstraints);
		
		this.add(holder, BorderLayout.CENTER);
	}
	
	/*public static void main(String args[]){
		JFrame frame = new JFrame("Test"); 
		frame.setPreferredSize(new Dimension(1200, 670));
		Order order = new Order(111222333, null, null, null,  null,  null, 21042, 34234, 
				 222, 444, 44.0, null);
		frame.add(new ConfirmationPage(order));
		frame.setVisible(true);
		frame.pack();
	}*/

}
