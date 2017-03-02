import java.util.ArrayList;

public class Department {
	
	// variables
	private String name;
	private ParsedImageIcon image;
	private ArrayList<Product> productList;
	
	// constructor
	Department(String inputName){
		productList = new ArrayList<Product>();
		name = inputName;
	}
	
	// get methods
	public String getName(){
		return name;
	}
	public ParsedImageIcon getImage(){
		return image;
	}
	public ArrayList<Product> getProductList(){
		return productList;
	}
	
	// set methods
	public void setName(String inputName){
		name = inputName;
	}
	public void setImage(ParsedImageIcon inputImage){
		image = inputImage;
	}
	
	// other methods
	public void addProduct(Product inputProduct){
		productList.add(inputProduct);
	}
	public void deleteProduct(Product targetedProduct){
		productList.remove(targetedProduct);
	}
}
