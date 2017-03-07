import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ProductPage {
	private MainWindow window;
	private Product product;
	
	private JPanel mainJPanel;
	private JLabel name, description, quantity, image;
	private JPanel priceAndQuantity, totalAndCart;
	//private JPanel[][] panels = new JPanel[4][3];
	
	private GridBagConstraints gbc;
	
	//public ProductPage(MainWindow window, Product product) {
	public ProductPage() {
		JFrame frame = new JFrame();
		
		//this.window = window;
		//this.product = product;
		
		product.setName("product1");
		product.setDesc("i am a cool product\nbuy me!");
		product.setImage(new ParsedImageIcon("noImage.jpg"));
		product.setPrice(12.30);
		product.setSale(false);
		
		mainJPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainJPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
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
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainJPanel.add(name, gbc);
		//panels[0][0].add(name);
		
		image = new JLabel(product.getImage());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		mainJPanel.add(image, gbc);
		
		priceAndQuantity = new JPanel();
		priceAndQuantity.setLayout(new BoxLayout(priceAndQuantity, BoxLayout.PAGE_AXIS));
		JLabel price = new JLabel("Price: $" + product.getPrice());


		quantity = new JLabel("0");
		
		description = new JLabel(product.getDesc());
		gbc.gridx = 3;
		gbc.gridy = 0;
		mainJPanel.add(name, gbc);
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
