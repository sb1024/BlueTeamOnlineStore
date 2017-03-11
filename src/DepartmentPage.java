import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class DepartmentPage{
	private ArrayList<Product> products;
	private ArrayList<JPanel> productButtons=new ArrayList();
	private JScrollBar mainJPanel;
	private MainWindow mainWindow;
	private JPanel mainPanel;
	private Department mainDepartment;
	private boolean editor;
	private int numberOfRows;
	private ArrayList<Product> productList;

	
	DepartmentPage() {
		Store store = createStore();

		JFrame frame = new JFrame("Test");
		JScrollPane scrollPane = new JScrollPane();


		Department department = store.getDepartments().get(0);
		
		products= department.getProductList();
		
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		
		
		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setPreferredSize(new Dimension(1200, 670));
		
		//Change to mainDepartment.getProducts()
		productList = department.getProductList();
		
		
		//Determines the number of rows for the product layout
		editor = false;
		if(editor){
			numberOfRows = (int) Math.ceil(((double)productList.size() + 1.0)/4.0); //Rounds up. Double cast in there to ensure rounds properly.
		}else{
			numberOfRows = (int) Math.ceil(((double)productList.size())/4.0);
		}
		
		JComponent departmentNameSpacer1 = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		JComponent departmentNameSpacer2 = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		JLabel departmentName = new JLabel("<HTML><u>" + department.getName() + "</u></HTML>");
		departmentName.setAlignmentX(Component.CENTER_ALIGNMENT); //I have no idea why without this,it aligns to the right.
		departmentName.setFont(new Font("Arial", Font.PLAIN, 50));
		mainPanel.add(departmentNameSpacer1);
		mainPanel.add(departmentName);
		mainPanel.add(departmentNameSpacer2);
					
		JPanel productsGrid = new JPanel();
		productsGrid.setBackground(Color.white);
		
		productsGrid.setLayout(new GridLayout(numberOfRows, 4, 5, 5));

		createProductPanels();
		for(JPanel panel: productButtons){
			productsGrid.add(panel); //Gridlayout automatically expands panel to fit cell
		}
		
		mainPanel.add(productsGrid);
		



		
		mainPanel.repaint();
		frame.add(scrollPane);
		frame.setVisible(true);
		frame.pack();
		
	}
	public void createDecorationForPanel() {
		
	}
	public void createProductPanels() {
		for(int elementCounter=0; elementCounter<products.size(); elementCounter++){
			final Product product = products.get(elementCounter); //Final so action listeners can access it
			JPanel productButtonPanel=new JPanel();
			productButtonPanel.setBackground(Color.white);
			productButtonPanel.setLayout(new BoxLayout(productButtonPanel, BoxLayout.Y_AXIS));
			
			ParsedImageIcon productLogo = product.getImage();
			if(productLogo==null){ //If the product doesn't have an image
				productLogo = new ParsedImageIcon("NoImage.jpg");
			}
			productLogo.setWidth(200); //Might want to make this dynamic
			productLogo.setHeight(200);
			JLabel productLogoLabel = new JLabel(productLogo);
			productLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);//Aligns horizontally in cell
			productButtonPanel.add(productLogoLabel);
			JLabel productName = new JLabel(product.getName());
			productName.setAlignmentX(Component.CENTER_ALIGNMENT);//Aligns horizontally in cell
			productButtonPanel.add(productName);
			JLabel price = new JLabel("$" + product.getPrice());//Aligns horizontally in cell
			price.setAlignmentX(Component.CENTER_ALIGNMENT);
			if(product.getSale()){ //If it is a sale
				price.setText("Sale -- " + price.getText());
				price.setForeground(Color.red);
			}
			productButtonPanel.add(price);

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
			productButtonPanel.addMouseListener(productListener);


			productButtons.add(productButtonPanel);

				
			

		}
	}
	public static void main(String args[]){
		new DepartmentPage();
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
		
		
		departments.add(genericDepartment);
		
		ArrayList<Order> orders = new ArrayList();
		
		return new Store(storeName, storeDescription, departments, orders, storeLogo);


	}
}