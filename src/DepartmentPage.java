import javax.swing.*;
import java.util.*;
import java.awt.*;
public class DepartmentPage extends JPanel {
	ArrayList<Product> products;
	ArrayList<JPanel> productButtons;
	JScrollBar mainJPanel;
	MainWindow window;
	Department department;
	DepartmentPage(MainWindow window, Department department) {
		this.window = window;
		this.department = department;
		mainJPanel = new JScrollBar();
		mainJPanel.setLayout(new GridLayout());
		products = getProductList();
		createDecorationForPanel();
		createProductPanels();
	}
	public void createDecorationForPanel() {
		
	}
	public void createProductPanels() {
		for (int i = 0; i < products.size(); i++) {
			JPanel product = new JPanel();
			product.setLayout(new BoxLayout(product, BoxLayout.Y_AXIS));
			product.add(products.get(i).getImageIcon());
			product.add(products.get(i).getName());
			product.add(products.get(i).getPrice());
			productButtons.add(product);
		}
	}
}