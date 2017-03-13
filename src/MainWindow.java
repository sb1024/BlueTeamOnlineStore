import java.awt.Dimension;
import java.util.ArrayList;

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
	private JScrollPane mainPanel;
	
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
			genericDepartment.addProduct(genericProduct);
			
			departments.add(genericDepartment);
			
			ArrayList<Order> orders = new ArrayList();

			
			store = new Store(storeName, storeDescription, departments, orders, storeLogo);
			
			xmlReaderWriter.createStore(store);

		}
		
		editor = editMode;
		navBar = new NavBar(this);
		
		HomePage homePage = new HomePage(this);
		currentContentPane=homePage;  //Stores the homepage as the current content page. The home page will open by default when the store is started
		
		frame = new JFrame("Store");
		
		mainPanel = new JScrollPane(); //Holds the navBar and the currentContentPane
		mainPanel.setPreferredSize(new Dimension(1200, 720));
		mainPanel.add(navBar);
		mainPanel.setViewportView(currentContentPane);
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
		mainPanel.add(newContentPane); //Places the new content pane
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
		mainPanel.setViewportView(newContentPane); //Places the new content pane
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	}
	public void setContentArea(JPanel newPage){
		JPanel newContentPane=newPage;
		mainPanel.remove(currentContentPane); //Removes the old pane. 
		mainPanel.setViewportView(newContentPane); //Places the new content pane
		currentContentPane = newContentPane; //Stores the newContentPane in the currentContentPane becausae it is now the the current content pane being displayed
	}
	public boolean isEditor(){
		return editor;
	}
	public static void main(String args[]){
		boolean editor=false;
		new MainWindow(false);
	}
	public void updateFrame(){
		frame.repaint();
		frame.pack();
	}
	
}
