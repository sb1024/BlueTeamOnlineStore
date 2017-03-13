import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Arrays;

import javax.swing.*;

public class PurchasePage extends JPanel{
	
	// variables
	private MainWindow window;
	private ShoppingCart cart;
	private JPanel mainJPanel;
	private JLabel title;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel addressLabel;
	private JTextField addressField;
	private JLabel cityLabel;
	private JTextField cityField;
	private JLabel stateLabel;
	private JComboBox stateDrop;
	private JLabel zipLabel;
	private JTextField zipField;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JLabel ccLabel;
	private JTextField ccField;
	private JLabel expLabel;
	private JTextField expField;
	private JLabel totalLabel;
	private double orderTotal;
	
	// constructor
	PurchasePage(MainWindow window){
		orderTotal = calculateTotal();
		mainJPanel = new JPanel();
		title = new JLabel("Make Purchase");
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		addressLabel = new JLabel("Address:");
		cityLabel = new JLabel("City:");
		stateLabel = new JLabel("State:");
		zipLabel = new JLabel("ZIP Code:");
		phoneLabel = new JLabel("Phone Number:");
		ccLabel = new JLabel("Credit Card Number:");
		expLabel = new JLabel("Expiration Date:");
		NumberFormat USD = NumberFormat.getCurrencyInstance();
		totalLabel = new JLabel("Total - " + USD.format(orderTotal));
	}
	PurchasePage(){
		this.setPreferredSize(new Dimension(1500, 800));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));
		this.setBackground(Color.WHITE);
		orderTotal = calculateTotal();
		mainJPanel = new JPanel();
		mainJPanel.setBackground(Color.WHITE);
		title = new JLabel("Make Purchase");
		firstNameLabel = new JLabel("First Name:");firstNameField = new JTextField();
		lastNameLabel = new JLabel("Last Name:");lastNameField = new JTextField();
		addressLabel = new JLabel("Address:");addressField = new JTextField();
		cityLabel = new JLabel("City:");cityField = new JTextField();
		String[] stateArray = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois"
				,"Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska"
				,"Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island"
				,"South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming","District of Columbia"
				,"Puerto Rico","Guam","American Samoa","U.S. Virgin Islands","Northern Mariana Islands"};
		stateLabel = new JLabel("State:");stateDrop = new JComboBox(stateArray);
		zipLabel = new JLabel("ZIP Code:");zipField = new JTextField();
		phoneLabel = new JLabel("Phone Number:");phoneField = new JTextField();
		ccLabel = new JLabel("Credit Card Number:");ccField = new JTextField();
		expLabel = new JLabel("Expiration Date:");expField = new JTextField();
		NumberFormat USD = NumberFormat.getCurrencyInstance();
		totalLabel = new JLabel("Total - " + USD.format(orderTotal));
		
		title.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		title.setBorder(BorderFactory.createEmptyBorder(20,50,200,50));
		this.add(title);
		mainJPanel.setLayout(new GridLayout(0, 2));
		this.add(mainJPanel);
		mainJPanel.add(firstNameLabel);
		mainJPanel.add(firstNameField);
		mainJPanel.add(lastNameLabel);mainJPanel.add(lastNameField);
		mainJPanel.add(addressLabel);mainJPanel.add(addressField);
		mainJPanel.add(cityLabel);mainJPanel.add(cityField);
		mainJPanel.add(stateLabel);mainJPanel.add(stateDrop);
		mainJPanel.add(zipLabel);mainJPanel.add(zipField);
		mainJPanel.add(phoneLabel);mainJPanel.add(phoneField);
		mainJPanel.add(ccLabel);mainJPanel.add(ccField);
		mainJPanel.add(expLabel);mainJPanel.add(expField);
		mainJPanel.add(totalLabel);
	}
	
	private void makeOrder(){
		// if all fields are completed
		//Order createdOrder = new Order(/* generate an order number */, firstNameField.getText(),)
	}
	
	// loops through all productorders in the cart.
	// gets the price of the productorder product, multiplies it by the productorder's quantity, adds to the total
	private double calculateTotal(){
		/*double total = 0;
		for(ProductOrder product : cart.getProductOrders()){
			total+=((product.getProduct().getPrice())*product.getQuantity());
		}
		return total;*/
		return 10.5;
	}
}
