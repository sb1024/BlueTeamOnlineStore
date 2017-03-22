import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class PurchasePage extends JPanel implements ActionListener{
	
	// variables
	private MainWindow window;
	private ShoppingCart cart;
	private JPanel mainJPanel;
	private JPanel orderInfoJPanel;
	private JPanel orderSummaryJPanel;
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
	private JButton confirm;
	private JButton cancel;
	private double orderTotal;
	private Order order;
	
	// constructor
	PurchasePage(MainWindow window){
		this.setPreferredSize(new Dimension(1200, 670));
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Color.WHITE);
		orderTotal = calculateTotal();
		mainJPanel = new JPanel();
		mainJPanel.setBackground(Color.WHITE);
		orderInfoJPanel = new JPanel();
		orderInfoJPanel.setBackground(Color.WHITE);
		orderSummaryJPanel = new JPanel();
		orderSummaryJPanel.setBackground(Color.WHITE);
		title = new JLabel("<html><b>Make Purchase</b></html>");
		firstNameLabel = new JLabel("First Name:");firstNameField = new JTextField();
		lastNameLabel = new JLabel("Last Name:");lastNameField = new JTextField();
		addressLabel = new JLabel("Address:");addressField = new JTextField();
		cityLabel = new JLabel("City:");cityField = new JTextField();
		String[] stateArray = {"","Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois"
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
		totalLabel = new JLabel("Order Total - " + USD.format(orderTotal));
		confirm = new JButton("Confirm");
		confirm.setActionCommand("confirm");
		confirm.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		
		mainJPanel.setLayout(new BoxLayout(mainJPanel,BoxLayout.PAGE_AXIS));
		this.add(title);
		this.add(mainJPanel);
		title.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		title.setBorder(BorderFactory.createEmptyBorder(20,30,20,10));
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		orderInfoJPanel.setLayout(new GridLayout(0, 2));
		orderInfoJPanel.setBorder(BorderFactory.createEmptyBorder(50,200,50,500));
		mainJPanel.add(orderInfoJPanel);
		mainJPanel.add(orderSummaryJPanel);
		orderInfoJPanel.add(firstNameLabel);
		orderInfoJPanel.add(firstNameField);
		orderInfoJPanel.add(lastNameLabel);orderInfoJPanel.add(lastNameField);
		orderInfoJPanel.add(addressLabel);orderInfoJPanel.add(addressField);
		orderInfoJPanel.add(cityLabel);orderInfoJPanel.add(cityField);
		orderInfoJPanel.add(stateLabel);orderInfoJPanel.add(stateDrop);
		orderInfoJPanel.add(zipLabel);orderInfoJPanel.add(zipField);
		orderInfoJPanel.add(phoneLabel);orderInfoJPanel.add(phoneField);
		orderInfoJPanel.add(ccLabel);orderInfoJPanel.add(ccField);
		orderInfoJPanel.add(expLabel);orderInfoJPanel.add(expField);
		orderSummaryJPanel.add(totalLabel);
		orderSummaryJPanel.add(confirm);
		orderSummaryJPanel.add(cancel);
	}
	
	private Order makeOrder(){
		if(checkCompletion()){
			Order createdOrder = new Order(generateOrderNumber(), firstNameField.getText(), lastNameField.getText(), addressField.getText(), cityField.getText(), (String)stateDrop.getSelectedItem(), Integer.parseInt(zipField.getText()), 
					Long.parseLong(phoneField.getText()), Long.parseLong(ccField.getText()), Integer.parseInt(expField.getText()), calculateTotal(), window.getShoppingCart());
			return createdOrder;
		}
		return null;
	}
	
	//TODO: integrate this
	private long generateOrderNumber(){
		boolean generating = true;
		long orderNumber = -1;
		while(generating = true){
			generating = false;
			orderNumber = (long)(Math.random()*1000000000);
			for(Order active : window.getStore().getOrders()){
				if(active.getOrderNumber() == orderNumber){
					generating = true;
				}
			}
		}
		return orderNumber;
	}
	
	private boolean checkCompletion(){
		ArrayList<Boolean> fields = new ArrayList<Boolean>();
		boolean firstName = false;
		boolean lastName = false;
		boolean address = false;
		boolean city = false;
		boolean state = false;
		boolean zip = false;
		boolean phone = false;
		boolean cc = false;
		boolean exp = false;
		
		if(!(firstNameField.getText().equals(""))){
			firstName = true;
		}
		if(!(lastNameField.getText().equals(""))){
			lastName = true;
		}
		if(!(addressField.getText().equals(""))){
			address = true;
		}
		if(!(cityField.getText().equals(""))){
			city = true;
		}
		if(!(stateDrop.getSelectedItem().equals(""))){
			state = true;
		}
		if(!(zipField.getText().equals(""))){
			zip = true;
		}
		if(!(phoneField.getText().equals(""))){
			phone = true;
		}
		if(!(ccField.getText().equals(""))){
			cc = true;
		}
		if(!(expField.getText().equals(""))){
			exp = true;
		}
		
		if(firstNameField.getText().equals("")){
			firstNameLabel.setText("<html><font color='red'>First Name:</font></html>");
		}
		else{
			firstNameLabel.setText("<html><font color='black'>First Name:</font></html>");
		}
		if(lastNameField.getText().equals("")){
			lastNameLabel.setText("<html><font color='red'>Last Name:</font></html>");
		}
		else{
			lastNameLabel.setText("<html><font color='black'>Last Name:</font></html>");
		}
		if(addressField.getText().equals("")){
			addressLabel.setText("<html><font color='red'>Address:</font></html>");
		}
		else{
			addressLabel.setText("<html><font color='black'>Address:</font></html>");
		}
		if(cityField.getText().equals("")){
			cityLabel.setText("<html><font color='red'>City:</font></html>");
		}
		else{
			cityLabel.setText("<html><font color='black'>City:</font></html>");
		}
		if(stateDrop.getSelectedItem().equals("")){
			stateLabel.setText("<html><font color='red'>State:</font></html>");
		}
		else{
			stateLabel.setText("<html><font color='black'>State:</font></html>");
		}
		if(zipField.getText().equals("")){
			zipLabel.setText("<html><font color='red'>ZIP Code:</font></html>");
		}
		else{
			zipLabel.setText("<html><font color='black'>ZIP Code:</font></html>");
		}
		if(phoneField.getText().equals("")){
			phoneLabel.setText("<html><font color='red'>Phone Number:</font></html>");
		}
		else{
			phoneLabel.setText("<html><font color='black'>Phone Number:</font></html>");
		}
		if(ccField.getText().equals("")){
			ccLabel.setText("<html><font color='red'>Credit Card Number:</font></html>");
		}
		else{
			ccLabel.setText("<html><font color='black'>Credit Card Number:</font></html>");
		}
		if(expField.getText().equals("")){
			expLabel.setText("<html><font color='red'>Expiration Date:</font></html>");
		}
		else{
			expLabel.setText("<html><font color='black'>Expiration Date:</font></html>");
		}
		
		fields.add(firstName);fields.add(lastName);fields.add(address);fields.add(city);fields.add(state);fields.add(zip);fields.add(phone);fields.add(cc);fields.add(exp);
		
		for(Boolean activeField : fields){
			if(!activeField){
				return false;
			}
		}
		return true;
	}
	
	//TODO: integrate this
	// loops through all productorders in the cart.
	// gets the price of the productorder product, multiplies it by the productorder's quantity, adds to the total
	private double calculateTotal(){
		double total = 0;
		for(ProductOrder product : cart.getProductOrders()){
			total+=((product.getProduct().getPrice())*product.getQuantity());
		}
		return total;
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if (eventName.equals("confirm")){
			if(checkCompletion()){
				int orderConfirm = JOptionPane.showConfirmDialog(mainJPanel, "Place your order?", "Confirm Order", JOptionPane.YES_NO_OPTION);
				if(orderConfirm == 1){
					System.out.println("DEBUG: confirm");
				}
				makeOrder();
				ConfirmationPage confirm = new ConfirmationPage(order);
				window.setContentArea(confirm);
			}

		}
		else if (eventName.equals("cancel")){
			// call back button
		}
	}
}
