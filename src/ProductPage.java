import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.*;


public class ProductPage extends JPanel {
	protected MainWindow window;
	protected Product product;
	protected ProductPage page;
	
	protected JButton addToCart;
	//protected JPanel mainJPanel;
	protected JLabel name, description, image, price, number, total, dept, sale;
	protected JPanel quantity;
	private int num = 1;
	
	protected GridBagConstraints gbc;
	
	final protected NumberFormat USD = NumberFormat.getCurrencyInstance();
	
	public ProductPage(MainWindow window, Product sentProduct) {
		
		page = this;
		this.window = window;
		this.product = sentProduct;
		/*product = new Product(0, null, null, false, null, null);
		product.setName("Black Leather Boots");
		product.setDesc("These boots are offered with fast two-day shipping!");
		product.setImage(new ParsedImageIcon("noImage.jpg", 350, 350));
		product.setPrice(12.30);
		product.setSale(false);
		product.setDepartment(new Department("Shoes"));*/
		
		//mainJPanel = new JPanel();
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		addProductInfo();
		
		this.setPreferredSize(new Dimension(1200, 670));
	}
	
	private void addProductInfo() {
		name = new JLabel(product.getName()); 
		name.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		name.setFont(new Font("Arial", Font.PLAIN, 48));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(name, gbc);
		
		if(product.getImage() == null) {
			image = new JLabel();
			image.setIcon(new ParsedImageIcon("noImage.jpg", 350, 350));
		} else {
			image = new JLabel(product.getImage());
		}
		image.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		this.add(image, gbc);
		
		
		
		price = new JLabel("Price: " + USD.format(product.getPrice()));
		price.setFont(new Font("Arial", Font.PLAIN, 32));
		price.setAlignmentX(Component.LEFT_ALIGNMENT);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		this.add(price, gbc);

		quantity = new JPanel();
		quantity.setBackground(Color.white);
		quantity.setLayout(new BoxLayout(quantity, BoxLayout.LINE_AXIS));
		quantity.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel quantityPrompt = new JLabel("Quantity: ");
		quantityPrompt.setFont(new Font("Arial", Font.PLAIN, 32));
		quantity.add(quantityPrompt);
		
		JLabel minus = new JLabel("\u2014");
		minus.setFont(new Font("Arial", Font.BOLD, 20));
		minus.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		minus.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(num > 1) {
					num-=1;
					number.setText(" "+num+" ");
					total.setText("Total Price: " + USD.format(product.getPrice()*num));
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}

			@Override
			public void mousePressed(MouseEvent arg0) {	}

			@Override
			public void mouseReleased(MouseEvent arg0) {	}
			
		});
		quantity.add(minus);
		number = new JLabel(" "+ num+ " ");
		number.setFont(new Font("Arial", Font.PLAIN, 32));
		number.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		quantity.add(number);
		JLabel plus = new JLabel("+");
		plus.setFont(new Font("Arial", Font.PLAIN, 36));
		plus.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		plus.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				num+=1;
				number.setText(" "+num+" ");
				total.setText("Total Price: " + USD.format(product.getPrice()*num));
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent arg0) {	}

			@Override
			public void mouseReleased(MouseEvent arg0) {	}
			
		});
		quantity.add(plus);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(quantity, gbc);
		
		total = new JLabel("Total Price: " + USD.format(product.getPrice()));
		total.setFont(new Font("Arial", Font.PLAIN, 32));
		total.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		total.setAlignmentX(Component.LEFT_ALIGNMENT);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(total, gbc);
		
		addToCart = new JButton("Add to Shopping Cart");
		addToCart.setFont(new Font("Arial", Font.PLAIN, 32));
		addToCart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		addToCart.setAlignmentX(Component.LEFT_ALIGNMENT);
		/*addToCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});*/
		addToCart.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				addProductToCart(num);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {	
				page.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent arg0) {	}

			@Override
			public void mouseReleased(MouseEvent arg0) {	}
		});
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(addToCart, gbc);
		
		description = new JLabel(product.getDesc());
		description.setFont(new Font("Arial", Font.PLAIN, 20));
		description.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		this.add(description, gbc);
		
		dept = new JLabel("Department: " + product.getDepartment().getName());
		dept.setFont(new Font("Arial", Font.PLAIN, 24));
		dept.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(dept, gbc);
		
		sale = new JLabel("On Sale");
		sale.setForeground(Color.red);
		sale.setFont(new Font("Arial", Font.PLAIN, 24));
		sale.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(sale, gbc);
		sale.setVisible(product.getSale());
	}
	
	private void addProductToCart(int num) {
		window.getShoppingCart().addProductOrder(product, num);
		//window.getStore().get
		//System.out.println(num);
		for(ProductOrder order : window.getShoppingCart().getProductOrders()) {

			System.out.println(order.getProduct().getName());
			System.out.println(order.getQuantity());
		}
		
		window.setContentArea(new CartPage(window));
	}
	
	public Product getProduct() {
		return product;
	}
	
	/*public static void main(String args[]){
		ProductPage page = new ProductPage();
	}*/
	//
	//change mouse cursors & work with cart page & change departments in xml
}
