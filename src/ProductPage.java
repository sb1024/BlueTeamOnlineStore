import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ProductPage {
	private MainWindow window;
	private Product product;
	
	private JPanel mainJPanel;
	private JLabel name, description, image, number;
	private JPanel priceAndQuantity, quantity, totalAndCart;
	//private JPanel[][] panels = new JPanel[4][3];
	
	private GridBagConstraints gbc;
	
	//public ProductPage(MainWindow window, Product product) {
	public ProductPage() {
		JFrame frame = new JFrame();
		
		//this.window = window;
		//this.product = product;
		product = new Product(0, null, null, false, null, null);
		product.setName("New shoes");
		product.setDesc("i am a cool product. buy me!");
		product.setImage(new ParsedImageIcon("noImage.jpg", 250, 250));
		product.setPrice(12.30);
		product.setSale(false);
		
		mainJPanel = new JPanel();
		mainJPanel.setBackground(Color.white);
		mainJPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainJPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		/*for(JPanel[] rows : panels) {
			for(JPanel panel : rows) {
				panel = new JPanel();
			}
		}*/
		
		addProductInfo();
		
		frame.setPreferredSize(new Dimension(1200, 720));
		frame.setTitle("Test");
		frame.setContentPane(mainJPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addProductInfo() {
		name = new JLabel(product.getName()); 
		name.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		name.setFont(new Font("Arial", Font.PLAIN, 48));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainJPanel.add(name, gbc);
		//panels[0][0].add(name);
		
		image = new JLabel(product.getImage());
		image.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		mainJPanel.add(image, gbc);
		
		priceAndQuantity = new JPanel();
		priceAndQuantity.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		priceAndQuantity.setBackground(Color.white);
		priceAndQuantity.setLayout(new BoxLayout(priceAndQuantity, BoxLayout.PAGE_AXIS));
		NumberFormat USD = NumberFormat.getCurrencyInstance();
		
		JLabel price = new JLabel("Price: " + USD.format(product.getPrice()));
		price.setFont(new Font("Arial", Font.PLAIN, 24));
		price.setAlignmentX(Component.LEFT_ALIGNMENT);
		priceAndQuantity.add(price);

		quantity = new JPanel();
		quantity.setBackground(Color.white);
		quantity.setLayout(new BoxLayout(quantity, BoxLayout.LINE_AXIS));
		quantity.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel quantityPrompt = new JLabel("Quantity: ");
		quantityPrompt.setFont(new Font("Arial", Font.PLAIN, 24));
		quantity.add(quantityPrompt);
		
		JLabel plus = new JLabel("+");
		plus.setFont(new Font("Arial", Font.PLAIN, 24));
		plus.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		quantity.add(plus);
		number = new JLabel("0");
		number.setFont(new Font("Arial", Font.PLAIN, 24));
		number.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		quantity.add(number);
		JLabel minus = new JLabel("–");
		minus.setFont(new Font("Arial", Font.PLAIN, 24));
		plus.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		quantity.add(minus);
		

		priceAndQuantity.setAlignmentX(Component.LEFT_ALIGNMENT);
		priceAndQuantity.add(quantity);
		
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		mainJPanel.add(priceAndQuantity, gbc);
		
		description = new JLabel(product.getDesc());
		description.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		mainJPanel.add(description, gbc);
		//panels[3][0].add(description);
		
		
	}
	
	
	private class PriceQuantityJLabel extends JPanel {
		JLabel price, quantityPrompt;
		
		public PriceQuantityJLabel() {
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			
		}
	}
	
	public static void main(String args[]){
		ProductPage page = new ProductPage();
	}
	
}
