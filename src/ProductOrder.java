import java.util.ArrayList;

public class ProductOrder {
	
	// variables
	private Product product;
	private int quantity;
	protected Object getProduct;
	
	// constructor
	ProductOrder(Product inputProduct, int inputQuantity){
		product = inputProduct;
		quantity = inputQuantity;
	}
	
	// get methods
	public Product getProduct(){
		return product;
	}
	public int getQuantity(){
		return quantity;
	}
	
	// set methods
	public void setProduct(Product inputProduct){
		product = inputProduct;
	}
	public void setQuantity(int inputQuantity){
		quantity = inputQuantity;
	}
}
