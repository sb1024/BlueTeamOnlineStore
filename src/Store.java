
import java.util.ArrayList;

public class Store {

	// variables
	private String storeName;
	private String storeDescription;
	private ArrayList<Department> departments;
	private ArrayList<Order> orders;
	private ParsedImageIcon storeLogo;
	
	// constructors
	Store(String inputStoreName, String inputStoreDescription, ArrayList<Department> inputDepartments, ArrayList<Order> inputOrders, ParsedImageIcon inputImageIcon){
		storeName = inputStoreName;
		storeDescription = inputStoreDescription;
		storeLogo = inputImageIcon;
		departments = inputDepartments;
		orders = inputOrders;
	}
	Store(){
		departments = new ArrayList<Department>();
		orders = new ArrayList<Order>();
	}
	
	// get methods
	public String getStoreName(){
		return storeName;
	}
	public String getStoreDescription(){
		return storeDescription;
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
	public void setStoreDescription(String inputStoreDescription){
		storeDescription = inputStoreDescription;
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
