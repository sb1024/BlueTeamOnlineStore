
public class Product {
	
	// variables
	private double price;
	private String name;
	private String desc;
	private boolean sale;
	private Department department;
	private ParsedImageIcon image;
	
	// constructor
	Product(double inputPrice, String inputName, String inputDesc, boolean inputSale, Department inputDepartment, ParsedImageIcon inputImage){
		price = inputPrice;
		name = inputName;
		desc = inputDesc;
		sale = inputSale;
		department = inputDepartment;
		image = inputImage;
	}
	Product(){
		price = 0;
		name = null;
		desc = null;
		sale = false;
		department = null;
		image = null;
	}
	
	// get methods
	public double getPrice(){
		return price;
	}
	public String getName(){
		return name;
	}
	public String getDesc(){
		return desc;
	}
	public boolean getSale(){
		return sale;
	}
	public Department getDepartment(){
		return department;
	}
	public ParsedImageIcon getImage(){
		return image;
	}
	
	// set methods
	public void setPrice(double inputPrice){
		price = inputPrice;
	}
	public void setName(String inputName){
		name = inputName;
	}
	public void setDesc(String inputDesc){
		desc = inputDesc;
	}
	public void setSale(boolean inputSale){
		sale = inputSale;
	}
	public void setDepartment(Department inputDepartment){
		department = inputDepartment;
	}
	public void setImage(ParsedImageIcon inputImage){
		image = inputImage;
	}
}
