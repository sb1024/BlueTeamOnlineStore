import java.text.NumberFormat;

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
	
	private void makeOrder(){
		// if all fields are completed
		Order createdOrder = new Order(/* generate an order number */, firstNameField.getText(),)
	}
	
	// loops through all productorders in the cart.
	// gets the price of the productorder product, multiplies it by the productorder's quantity, adds to the total
	private double calculateTotal(){
		double total = 0;
		for(ProductOrder product : cart.getProductOrders()){
			total+=((product.getProduct().getPrice())*product.getQuantity());
		}
		return total;
	}
}
