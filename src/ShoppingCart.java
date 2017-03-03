import java.util.ArrayList;

public class ShoppingCart {
	
	// variables
	private ArrayList<ProductOrder> productOrders;
	
	// constructors
	ShoppingCart(){
		productOrders = new ArrayList<ProductOrder>();
	}
	ShoppingCart(ProductOrder firstProductOrder){
		productOrders = new ArrayList<ProductOrder>();
		productOrders.add(firstProductOrder);
	}
	ShoppingCart(ArrayList<ProductOrder> inputProductOrders){
		productOrders = inputProductOrders;
	}
	
	// get method
	public ArrayList<ProductOrder> getProductOrders(){
		return productOrders;
	}
	
	// other methods
	public void addProductOrder(Product inputProduct, int inputQuantity){
		boolean duplicate = false;
		int duplicateIndex = 0;
		for(ProductOrder activeProductOrder : productOrders){
			if(activeProductOrder.getProduct() == inputProduct){
				duplicateIndex = productOrders.indexOf(this);
				duplicate = true;
			}
		}
		if(duplicate){
			ProductOrder activeProductOrder = productOrders.get(duplicateIndex);
			productOrders.remove(duplicateIndex);
			activeProductOrder.setQuantity(activeProductOrder.getQuantity() + inputQuantity);
			productOrders.add(duplicateIndex, activeProductOrder);
		}
		else{
			productOrders.add(new ProductOrder(inputProduct, inputQuantity));
		}
	}
}
