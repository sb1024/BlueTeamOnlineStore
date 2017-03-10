import javax.swing.*;

import java.util.*;
import java.awt.*;
public class DepartmentPage{
	private ArrayList<Product> products;
	private ArrayList<JPanel> productButtons;
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
		
		JComponent departmentNameSpacer1 = (JComponent)Box.createRigidArea(new Dimension((int)mainPanel.getPreferredSize().getWidth()/20, 50));
		JComponent departmentNameSpacer2 = (JComponent)Box.createRigidArea(new Dimension((int)mainPanel.getPreferredSize().getWidth()/20, 50));
		JLabel departmentName = new JLabel("<HTML><u>" + department.getName() + "</u></HTML>");
		departmentName.setFont(new Font("Arial", Font.PLAIN, 50));
		mainPanel.add(departmentNameSpacer1);
		mainPanel.add(departmentName);
		mainPanel.add(departmentNameSpacer2);
		
		JPanel products = new JPanel();
		products.setLayout(new GridLayout(numberOfRows, 4, 5, 5));
		



		
		mainPanel.repaint();
		frame.add(scrollPane);
		frame.setVisible(true);
		frame.pack();
		
	}
	public void createDecorationForPanel() {
		
	}
	public void createProductPanels() {
		for (int i = 0; i < products.size(); i++) {

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
		
		departments.add(genericDepartment);
		
		ArrayList<Order> orders = new ArrayList();
		
		return new Store(storeName, storeDescription, departments, orders, storeLogo);


	}
}