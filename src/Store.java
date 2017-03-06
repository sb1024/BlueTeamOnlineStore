import java.util.ArrayList;


public class Store {

	// variables
	private String storeName;
	private ArrayList<Department> departments;
	private ArrayList<Order> orders;
	private ParsedImageIcon storeLogo;
	
	// constructors
	Store(String inputStoreName, ParsedImageIcon inputImageIcon){
		storeName = inputStoreName;
		storeLogo = inputImageIcon;
		departments = new ArrayList<Department>();
		orders = new ArrayList<Order>();
	}
	Store(){
		departments = new ArrayList<Department>();
		orders = new ArrayList<Order>();
	}
	
	// get methods
	public String getStoreName(){
		return storeName;
	}
	public ParsedImageIcon getStoreLogo(){
		return storeLogo;
	}
	public ArrayList<Department> getDepartments(){
		return departments;
	}
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	// set methods
	public void setStoreName(String inputStoreName){
		storeName = inputStoreName;
	}
	public void setStoreLogo(ParsedImageIcon inputStoreLogo){
		storeLogo = inputStoreLogo;
	}
	public void setDepartments(ArrayList<Department> inputDepartments){
		departments = inputDepartments;
	}
	public void setOrders(ArrayList<Order> inputOrders){
		orders = inputOrders;
	}
	
	// other methods
	public void addDepartment(Department inputDepartment){
		departments.add(inputDepartment);
	}
	public void addOrder(Order inputOrder){
		orders.add(inputOrder);
	}
	public void removeDepartment(Department targetedDepartment){
		departments.remove(targetedDepartment);
	}
	public void removeOrder(Order targetedOrder){
		orders.remove(targetedOrder);
	}
}
