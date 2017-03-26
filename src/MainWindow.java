import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MainWindow {
	private boolean editor = false;
	private XMLReaderWriter xmlReaderWriter;
	private Store store;
	private NavBar navBar;
	private JFrame frame; 
	private JPanel currentContentPane; //Holds the content pane
	private ShoppingCart currentShoppingCart;
	private JPanel mainPanel;
	private JScrollPane mainContentScrollPanel = new JScrollPane();
	
	MainWindow(boolean editMode){		
		xmlReaderWriter = new XMLReaderWriter();
		currentShoppingCart = new ShoppingCart();
		try{
			store = xmlReaderWriter.loadStore();
			System.out.println("Load store");
		}catch(Exception ex){ //If a store does not exist, a generic store will be created
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
			
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			genericDepartment = new Department("Electronics");
			departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
			genericDepartment.setImage(departmentLogo);
			genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
			genericDepartment.addProduct(genericProduct);
			genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
			genericDepartment.addProduct(genericProduct);
			

			ArrayList <Order> orders = new ArrayList();
			
			
			store = new Store(storeName, storeDescription, departments, orders, storeLogo);
			
			currentShoppingCart = new ShoppingCart();
			
			xmlReaderWriter.createStore(store);
			System.out.println("Create store");


		}
		
		editor = editMode;
		navBar = new NavBar(this);
		
		frame = new JFrame(store.getStoreName());
		
		mainContentScrollPanel.setSize(new Dimension(1200, 670));
		mainContentScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
		HomePage homePage;
		if(editor){
			homePage = new HomePageEditor(this);
		}else{
			homePage = new HomePage(this);

		}
		currentContentPane=homePage;  //Stores the homepage as the current content page. The home page will open by default when the store is started
		mainContentScrollPanel.setViewportView(currentContentPane);
		
		mainPanel = new JPanel(); //Holds the navBar and the currentContentPane
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setPreferredSize(new Dimension(1200, 720));
		mainPanel.add(navBar);
		mainPanel.add(mainContentScrollPanel);
		//mainPanel.setViewportView(currentContentPane);
		frame.add(new JScrollPane(mainPanel));
		frame.pack();
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	            System.out.println("Save store");
	            xmlReaderWriter.saveStore(store);
	        	//Standard close operations
	            frame.dispose(); 
	            System.exit(0);

	            
	        }
	    });
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
			newContentPane = new ProductPageEditor(this, product);
		}else{
			newContentPane = new ProductPage(this, product);
		}
		mainPanel.remove(currentContentPane); //Removes the old pane. 
		mainContentScrollPanel.setViewportView(newContentPane);  //Places the new content pane
		updateFrame();
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	
	}
	public void setContentArea(Department department){
		JPanel newContentPane;
		if(editor){
			newContentPane = new DepartmentPageEditor(this, department);
		}else{
			newContentPane = new DepartmentPage(this, department);
		}
		mainPanel.remove(currentContentPane); //Removes the old pane. 
		
		mainContentScrollPanel.setViewportView(newContentPane);

		updateFrame();
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	}
	public void setContentArea(JPanel newPage){
		JPanel newContentPane=newPage;
		mainPanel.remove(currentContentPane); //Removes the old pane. 
		mainContentScrollPanel.setViewportView(newContentPane);  //Places the new content pane
		updateFrame();
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	}
	public boolean isEditor(){
		return editor;
	}
	public static void main(String args[]){
		new MainWindow(false);
	}
	public void updateFrame(){
		frame.repaint();
		frame.pack();
	}
	public ShoppingCart createCart(){
		ShoppingCart shoppingCart = new ShoppingCart();
		String storeName = "Generic Store";
		ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
		String storeDescription = "A generic store. All values should be changed";
		
		
		ArrayList<Department> departments = new ArrayList();
		Department genericDepartment = new Department("Electronics");
		ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
		genericDepartment.setImage(departmentLogo);
		Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		shoppingCart.addProductOrder(genericProduct, 1);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		
		return shoppingCart;

	}
	public NavBar getNavBar(){ //Used by HomePageEditor to update NavBar logo if changed
		return navBar;
	}
	public void back(){
		String className = currentContentPane.getClass().getSimpleName();
		
		if(className.indexOf("ProductPage")>=0){
			Product product = ((ProductPage)currentContentPane).getProduct();
			setContentArea(product.getDepartment()); //setContentArea method automatically checks for editor
		}else if(className.indexOf("PurchasePage")>=0){
			setContentArea(new CartPage(this));
		}else if(className.indexOf("HomePage")>=0){
			//Do nothing because you are already on the "highest" page
		}else{ //Fall back if not specified. A majority of pages, like department page, should return to the home page
			if(editor){
				setContentArea(new HomePageEditor(this));
			}else{
				setContentArea(new HomePage(this));
			}
		}
		
	}
}
