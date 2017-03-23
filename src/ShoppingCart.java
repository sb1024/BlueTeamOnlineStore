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
		for(int productCounter=0; productCounter<productOrders.size(); productCounter++){
			ProductOrder activeProductOrder = productOrders.get(productCounter);
			if(activeProductOrder.getProduct() == inputProduct){
				duplicateIndex = productCounter;
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
	public void addProductOrder(ProductOrder inputProductOrder){
		boolean duplicate = false;
		int duplicateIndex = 0;
		for(ProductOrder activeProductOrder : productOrders){
			if(activeProductOrder.getProduct() == inputProductOrder.getProduct()){
				duplicateIndex = productOrders.indexOf(this);
				duplicate = true;
			}
		}
		if(duplicate){
			ProductOrder activeProductOrder = productOrders.get(duplicateIndex);
			productOrders.remove(duplicateIndex);
			activeProductOrder.setQuantity(activeProductOrder.getQuantity() + inputProductOrder.getQuantity());
			productOrders.add(duplicateIndex, activeProductOrder);
		}
		else{
			productOrders.add(inputProductOrder);
		}
	}
	
	public double getPrice(){
		double price=0;
		for(ProductOrder productOrder: productOrders){
			double productPrice = productOrder.getProduct().getPrice();
			price+=productPrice*(int)productOrder.getQuantity();
		}
		return price;
	}
}
