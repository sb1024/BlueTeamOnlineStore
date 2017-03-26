import javax.swing.*;

import java.text.NumberFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class DepartmentPage extends JPanel{
	private ArrayList<Product> products;
	private ArrayList<JPanel> productButtons=new ArrayList();
	private JScrollBar mainJPanel;
	private MainWindow mainWindow;
	private JPanel mainPanel=this;
	private Department mainDepartment;
	private boolean editor;
	private JPanel productsGrid;
	private JFrame frame;

	private ArrayList<Product> productList;

	final protected NumberFormat USD = NumberFormat.getCurrencyInstance();
	DepartmentPage(MainWindow window, Department department) {
		mainWindow = window;
		
		Store store = mainWindow.getStore();
		
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		
		//Change to mainDepartment.getProducts()
		products = department.getProductList();

		JComponent departmentNameSpacer1 = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		JComponent departmentNameSpacer2 = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		JLabel departmentName = new JLabel("<HTML><u><b>" + department.getName() + "</u></b></HTML>");
		departmentName.setAlignmentX(Component.CENTER_ALIGNMENT); //I have no idea why without this,it aligns to the right.
		departmentName.setFont(new Font("Arial", Font.PLAIN, 50));
		this.add(departmentNameSpacer1);
		this.add(departmentName);
		this.add(departmentNameSpacer2);
		

		productsGrid = new JPanel();
		productsGrid.setBackground(Color.white);
		
		productsGrid.setLayout(new GridLayout(0, 4, 5, 5));

		createProductPanels();
		for(JPanel panel: productButtons){
			productsGrid.add(panel); //Gridlayout automatically expands panel to fit cell
		}
		JPanel gridHolder = new JPanel(); //Has margins for products grid
		gridHolder.setBackground(Color.white);
		gridHolder.setLayout(new BoxLayout(gridHolder, BoxLayout.X_AXIS));
		gridHolder.add(Box.createRigidArea(new Dimension(70, 100)));
		gridHolder.add(productsGrid);
		
		this.add(gridHolder);
		



		
		this.repaint();

		
	}
	public void createDecorationForPanel() {
		
	}
	public void createProductPanels() {
		for(int elementCounter=0; elementCounter<products.size(); elementCounter++){
			final Product product = products.get(elementCounter); //Final so action listeners can access it
			JPanel productButtonPanel=new JPanel();
			productButtonPanel.setLayout(new BoxLayout(productButtonPanel, BoxLayout.X_AXIS));
			productButtonPanel.setBackground(Color.white);
			
			JPanel productButtonSubPanel = new JPanel(); //Holds the actual product image, price, img. The reason for dividing it into two panels is to allow the ability to add editing icons in DepartmentPageEditor.
			productButtonPanel.add(productButtonSubPanel);
			productButtonSubPanel.setBackground(Color.white);
			productButtonSubPanel.setLayout(new BoxLayout(productButtonSubPanel, BoxLayout.Y_AXIS));
			
			ParsedImageIcon productLogo = product.getImage();
			if(productLogo==null){ //If the product doesn't have an image
				productLogo = new ParsedImageIcon("NoImage.jpg");
			}
			productLogo.fitImage(200, 200);
			JLabel productLogoLabel = new JLabel(productLogo);
			productLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);//Aligns horizontally in cell
			productButtonSubPanel.add(productLogoLabel);
			JLabel productName = new JLabel(product.getName());
			productName.setAlignmentX(Component.CENTER_ALIGNMENT);//Aligns horizontally in cell
			productButtonSubPanel.add(productName);
			JLabel price = new JLabel(USD.format(product.getPrice()));//Aligns horizontally in cell
			price.setAlignmentX(Component.CENTER_ALIGNMENT);
			if(product.getSale()){ //If it is a sale
				price.setText("Sale -- " + price.getText());
				price.setForeground(Color.red);
			}
			productButtonSubPanel.add(price);

			MouseListener productListener = new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					mainWindow.setContentArea(product);
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			};
			productButtonSubPanel.addMouseListener(productListener);


			productButtons.add(productButtonPanel);

				
			

		}
	}

	public Store createStore(){
		String storeName = "Generic Store";
		ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
		String storeDescription = "A generic store. All values should be changed";
		
		
		ArrayList<Department> departments = new ArrayList();
		Department genericDepartment = new Department("Electronics");
		ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
		genericDepartment.setImage(departmentLogo);
		Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		
		
		departments.add(genericDepartment);
		
		ArrayList<Order> orders = new ArrayList();
		
		return new Store(storeName, storeDescription, departments, orders, storeLogo);


	}
	public ArrayList<JPanel> getProductButtons(){
		return productButtons;
	}
	public ArrayList<Product> getProductList(){
		return products;
	}


	public JPanel getProductsGrid(){ //Used when deleting items
		return productsGrid;
	}
	public JPanel getMainPanel(){
		return mainPanel;
	}
	
}
