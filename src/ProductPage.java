import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ProductPage extends JPanel {
	private MainWindow window;
	private Product product;
	
	//private JPanel mainJPanel;
	private JLabel nameLabel, quantityJLabel;
	private JPanel[][] panels = new JPanel[4][3];
	
	public ProductPage(MainWindow window, Product product) {
		this.window = window;
		this.product = product;
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		for(JPanel[] rows : panels) {
			for(JPanel panel : rows) {
				panel = new JPanel();
			}
		}
	}
	
	private void addProductInfo() {
		nameLabel = new JLabel(); //product.getName();
		panels[0][0].add(nameLabel);
		
		
	}
}
