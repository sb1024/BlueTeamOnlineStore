import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow {
	private boolean editor = false;
	private XMLReaderWriter xmlReaderWriter;
	private Store store;
	private NavBar navBar;
	private JFrame frame; 
	private JPanel currentContentPane; //Holds the content pane
	private ShoppingCart currentShoppingcart;
	
	MainWindow(boolean editMode){		
		xmlReaderWriter = new XMLReaderWriter();
		currentShoppingCart = new ShoppingCart();
		try{
			store=xmlReaderWriter.loadStore();
		}catch(Exception ex){ //If a store does not exist, a generic store will be created
			System.out.println("The store file could not be loaded. A default store will be created.");
			
			String storeName = "Generic Store";
			ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
			String storeDescription = "A generic store. All values should be changed";
			
			
			ArrayList<Department> departments = new ArrayList();
			Department genericDepartment = new Department("Electronics");
			ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericProduct.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			ArrayList<Order> orders = new ArrayList();
			Order order = new Order()

			
			store = new Store(storeName, storeLogo, storeDescription, departments, orders);
			
			xmlReaderWriter.createStore(store);

		}
		
		editor = editMode;
		navBar = new NavBar(this);
		
		HomePage homePage = new HomePage(this);
		currentContentPane=homePage;
		
		frame = new JFrame("Store");
		
		JPanel mainPanel = new JPanel(); //Holds the navBar and the currentContentPane
		mainPanel.setPreferredSize(new Dimension(1200, 720));
		mainPanel.add(navBar);
		mainPanel.add(currentContentPane);
	}
	
	public Store getStore(){
		return store;
	}
	public ShoppingCart getShoppingCart(){
		return currentShoppingCart;
	}
	public void setContentArea(Product product){
		JPanel newContentPane;
		if(editor){
			newContentPane = new ProductPageEditor(product);
		}else{
			newContentPane = new ProductPage(product);
		}
		mainPanel.remove(currentContentPane); //Removes the old pane. 
		mainPanel.add(newContentPane); //Places the new content pane
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	}
	
}
