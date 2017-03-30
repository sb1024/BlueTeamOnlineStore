
public class Product {
	
	// variables
	private double price;
	private String name;
	private String desc;
	private boolean sale;
	private Department department;
	private String filePath;
	
	// constructor
	Product(double inputPrice, String inputName, String inputDesc, boolean inputSale, Department inputDepartment, ParsedImageIcon inputImage){
		price = inputPrice;
		name = inputName;
		desc = inputDesc;
		sale = inputSale;
		department = inputDepartment;
		filePath = inputImage.getFilePath();
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
		return new ParsedImageIcon(filePath);
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
		filePath = inputImage.getFilePath();
	}
}
