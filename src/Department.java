import java.util.ArrayList;

public class Department {
	
	private String name;
	private ParsedImageIcon image;
	private ArrayList<Product> productList;
	
	Department(MainWindow window, String inputName){
		productList = new ArrayList<Product>();
		name = inputName;
	}
	
	public String getName(){
		return name;
	}
	public ParsedImageIcon getImage(){
		return image;
	}
	public ArrayList<Product> getProductList(){
		return productList;
	}
	
	public void setName(String inputName){
		name = inputName;
	}
	public void setImage(ParsedImageIcon inputImage){
		image = inputImage;
	}
	public void addProduct(Product inputProduct){
		productList.add(inputProduct);
	}
	public void deleteProduct(Product targetedProduct){
		productList.remove(targetedProduct);
	}
}
