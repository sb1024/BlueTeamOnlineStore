import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;



public class CartPage extends JPanel{
	private JFrame frame;
	private JPanel mainPanel=this;
	private ArrayList<JPanel> orderPanels= new ArrayList(); //Indexes should reflect indexes of productOrders arraylist in shoppingCart
	private MainWindow window;
	private ShoppingCart cart;
	private JLabel priceText;
	private JScrollPane checkOutArea;
	private ArrayList<ProductOrder> productOrders;
	private JPanel productsGrid; //Stored so product orders can be deleted
	CartPage(MainWindow mainWindow){
		window = mainWindow;
		cart=mainWindow.getShoppingCart();

		productOrders=cart.getProductOrders(); //Sets product orders private variable. Used for creating product order panels and deleting orders
		this.setBackground(Color.white);
		this.setLayout(new GridBagLayout());
		
		JLabel shoppingTitle = new JLabel("<HTML><u>Shopping Cart</u></HTML>");
		shoppingTitle.setFont(new Font("Arial", Font.PLAIN, 50));
		
		checkOutArea=new JScrollPane();
		checkOutArea.setPreferredSize(new Dimension(900, 470));
		checkOutArea.setBackground(new Color(180, 180, 180));
		GridBagConstraints checkOutAreaC = new GridBagConstraints();
		checkOutAreaC.gridy=1;
		GridBagConstraints reviewC = new GridBagConstraints();
		reviewC.gridy=2;
		reviewC.gridx=0;
		reviewC.anchor=GridBagConstraints.EAST;
		
		JPanel review = new JPanel();
		review.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		review.setAlignmentX(Component.RIGHT_ALIGNMENT);
		review.setLayout(new BoxLayout(review, BoxLayout.X_AXIS));
		review.setBackground(new Color(180, 180, 180));
		
		JPanel price=new JPanel();
		priceText = new JLabel("Total: $" + cart.getPrice());
		priceText.setFont(new Font("Arial", Font.PLAIN, 18));
		price.add(priceText);
		
		review.add(price);
		
		price.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel makePurchase = new JLabel("Check Out");
		JPanel makePurchasePanel = new JPanel();
		makePurchasePanel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				window.setContentArea(new PurchasePage());
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		makePurchase.setFont(new Font("Arial", Font.PLAIN, 18));
		makePurchasePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		makePurchasePanel.add(makePurchase);
		
		review.add(Box.createRigidArea(new Dimension(10, 10)));
		review.add(makePurchasePanel);

		
		
		this.add(shoppingTitle);
		this.add(checkOutArea, checkOutAreaC);
		this.add(review, reviewC);
		
		

		
		productsGrid=new JPanel();
		productsGrid.setBackground(new Color(180, 180, 180));
		productsGrid.setLayout(new GridLayout(0, 1, 0, 25));
		addItemsToGrid();
		productsGrid.setSize(new Dimension(900, (int)productsGrid.getPreferredSize().getHeight()));


		
		checkOutArea.setViewportView(productsGrid); //Sets the productsgrid in the scroll pane of the check out area. Does not use mainwindow scroll pane.
		
		this.repaint();
		
	}
	
	public static void main(String args[]){
		new CartPage();
	}
	public ShoppingCart createCart(){
		ShoppingCart shoppingCart = new ShoppingCart();
		String storeName = "Generic Store";
		ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
		String storeDescription = "A generic store. All values should be changed";
		
		
		ArrayList<Department> departments = new ArrayList();
		Department genericDepartment = new Department("Electronics");
		ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
		genericDepartment.setImage(departmentLogo);
		Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		shoppingCart.addProductOrder(genericProduct, 1);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		genericProduct = new Product(15.0, "Computer", "A lovely new computer", true, genericDepartment, new ParsedImageIcon("computer.jpg"));
		genericDepartment.addProduct(genericProduct);
		shoppingCart.addProductOrder(genericProduct, 5);
		
		return shoppingCart;

	}
	public void addItemsToGrid(){
		for(int orderCounter=0; orderCounter<productOrders.size(); orderCounter++){
			final ProductOrder order = productOrders.get(orderCounter);
			JPanel orderPanel = new JPanel();
			orderPanel.setLayout(new GridBagLayout());
			Product product = order.getProduct();
			ParsedImageIcon productIcon = product.getImage();
			if(productIcon==null){
				productIcon = new ParsedImageIcon("noImage.jpg");
			}
			productIcon.setWidth (150);
			productIcon.setHeight(150);
			JLabel productImage = new JLabel(productIcon);
			GridBagConstraints imageConstraints = new GridBagConstraints();
			imageConstraints.gridx=0;
			imageConstraints.weightx=0;
			imageConstraints.weighty=0;
			orderPanel.add(productImage, imageConstraints);
			
			JLabel productTitle = new JLabel(product.getName());
			productTitle.setFont(new Font("Arial", Font.PLAIN, 18));
			GridBagConstraints productTitleConstraints = new GridBagConstraints();
			productTitleConstraints.gridx=1;
			productTitleConstraints.weightx=0;
			productTitleConstraints.insets=new Insets(0, 30, 0, 0);
			productTitleConstraints.weighty=1;
			orderPanel.add(productTitle, productTitleConstraints);
			
			JPanel pricePanel = new JPanel(); //Price panel concerns everything on the right side of an "order panel"
			pricePanel.setLayout(new GridBagLayout());
			GridBagConstraints pricePanelConstraints = new GridBagConstraints();
			pricePanelConstraints.weighty=1;
			pricePanelConstraints.fill=GridBagConstraints.VERTICAL;
			pricePanelConstraints.weightx=1;
			pricePanelConstraints.anchor=GridBagConstraints.EAST;
			orderPanel.add(pricePanel, pricePanelConstraints);
			
			final JLabel costOfItem = new JLabel("$" + product.getPrice()*order.getQuantity());
			GridBagConstraints pricePanelBottomConstraints = new GridBagConstraints();  //Puts everything in the bottom, right
			pricePanelBottomConstraints.gridx=0;
			pricePanelBottomConstraints.gridy=1;
			pricePanelBottomConstraints.weightx=1;
			pricePanelBottomConstraints.weighty=.5;
			pricePanelBottomConstraints.anchor=GridBagConstraints.SOUTHEAST;
			pricePanel.add(costOfItem, pricePanelBottomConstraints);
			costOfItem.setFont(new Font("Arial", Font.PLAIN, 24));
			
			JPanel quantity = new JPanel(); //Holds quantity counter and delete option
			quantity.setLayout(new BoxLayout(quantity, BoxLayout.X_AXIS));
			JLabel plus = new JLabel("+");
			plus.setFont(new Font("Arial", Font.PLAIN, 24));
			final JLabel counter = new JLabel(" "+order.getQuantity() + " ");
			counter.setOpaque(true);
			counter.setFont(new Font("Arial", Font.PLAIN, 24));
			counter.setBackground(Color.white);
			JLabel minus = new JLabel("-");
			minus.setFont(new Font("Arial", Font.PLAIN, 24));
			JLabel delete = new JLabel(new ParsedImageIcon("trashBin.png", 35, 35));
			plus.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					int quantity = order.getQuantity();
					quantity++;
					order.setQuantity(quantity); //Updates actual quantity in order object which in turn is stored in the shopping cart in an arraylist
					counter.setText(""+ quantity); //Updates displayed quantity
					costOfItem.setText("$" + quantity * order.getProduct().getPrice()); //Updates the displayed price of the item
					priceText.setText("$" + cart.getPrice()); //Updates the displayed price of the shopping cart
					
					
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			minus.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					int quantity = order.getQuantity();
					if(quantity>1){
						quantity--;
					}
					order.setQuantity(quantity); //Updates actual quantity in order object which in turn is stored in the shopping cart in an arraylist
					counter.setText(" "+ quantity + " "); //Updates displayed quantity
					costOfItem.setText("$" + quantity * order.getProduct().getPrice()); //Updates the displayed price of the item
					priceText.setText("Total: $" + cart.getPrice()); //Updates the displayed price of the shopping cart
					
					
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			plus.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					int quantity = order.getQuantity();
					quantity++;
					order.setQuantity(quantity); //Updates actual quantity in order object which in turn is stored in the shopping cart in an arraylist
					counter.setText(" "+ quantity + " "); //Updates displayed quantity
					costOfItem.setText("$" + quantity * order.getProduct().getPrice()); //Updates the displayed price of the item
					priceText.setText("Total: $" + cart.getPrice()); //Updates the displayed price of the shopping cart
					
					
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			delete.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					int delete = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to remove the " + order.getProduct().getName() + "(s) from your cart?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
					if(delete==0){
						int orderIndex=-1;
						for(int orderCounter=0; orderIndex<productOrders.size() && orderIndex==-1; orderCounter++){
							if(productOrders.get(orderCounter)==order){
								orderIndex=orderCounter; //Finds index of product order for deleting product panel and product order
							}
						}
						productOrders.remove(orderIndex);
						productsGrid.remove(orderPanels.remove(orderIndex)); //Removes productorder panel
						priceText.setText("Total: $" + cart.getPrice()); //Recalculates cart price
						window.updateFrame();
						//ADDS METHOD CALL TO MAINWINDOW THAT REPAINTS ENTIRE FRAME
					}

					
					
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			quantity.add(minus);
			quantity.add(Box.createRigidArea(new Dimension(5, 10)));
			counter.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			quantity.add(counter);
			quantity.add(Box.createRigidArea(new Dimension(5, 10)));
			quantity.add(plus);
			quantity.add(Box.createRigidArea(new Dimension(10, 10)));
			quantity.add(delete);
			
			GridBagConstraints pricePanelTopConstraints = new GridBagConstraints();//Puts everything in the top, right
			pricePanelTopConstraints.gridx=0;
			pricePanelTopConstraints.gridy=0;
			pricePanelTopConstraints.weightx=1;
			pricePanelTopConstraints.weighty=.5;
			pricePanelTopConstraints.anchor=GridBagConstraints.NORTHEAST;
			pricePanel.add(quantity, pricePanelTopConstraints);
			

			
			
			orderPanels.add(orderPanel);
			productsGrid.add(orderPanel);
		}
	}
}
