import java.util.ArrayList;

public class Department {
	
	// variables
	private String name;
	private String filePath;
	private ArrayList<Product> productList;
	
	// constructor
	Department(String inputName){
		productList = new ArrayList<Product>();
		name = inputName;
	}
	Department(){
		productList = new ArrayList<Product>();
	}
	
	// get methods
	public String getName(){
		return name;
	}
	public ParsedImageIcon getImage(){
		return new ParsedImageIcon(filePath);
	}
	public ArrayList<Product> getProductList(){
		return productList;
	}
	
	// set methods
	public void setName(String inputName){
		name = inputName;
	}
	public void setImage(ParsedImageIcon inputImage){
		filePath = inputImage.getFilePath();
	}
	
	// other methods
	public void addProduct(Product inputProduct){
		productList.add(inputProduct);
	}
	public void deleteProduct(Product targetedProduct){
		productList.remove(targetedProduct);
	}
}
