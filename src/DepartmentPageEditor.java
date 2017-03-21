import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class DepartmentPageEditor extends DepartmentPage{
	private ArrayList<JPanel> productButtons;
	private MainWindow window;
	private JPanel mainPanel;
	private ArrayList<Product> products;
	private JPanel productsGrid;
	private Department department;
	
	DepartmentPageEditor(MainWindow mainWindow, Department department) {
		super(mainWindow, department);
		window=mainWindow;
		productButtons = getProductButtons();
		products = getProductList();
		productsGrid = getProductsGrid();
		mainPanel = getMainPanel();
		addEditingButtons();

	}
	
	public void addEditingButtons(){
		for(int buttonCounter=0; buttonCounter<productButtons.size(); buttonCounter++){
			final Product currentProduct = products.get(buttonCounter);
			JPanel productButton = productButtons.get(buttonCounter);
			
	
			JPanel editingButtons = new JPanel();
			editingButtons.setBackground(Color.white);
			editingButtons.setLayout(new BoxLayout(editingButtons, BoxLayout.Y_AXIS));
			
			JLabel pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
			pencilIcon.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					window.setContentArea(currentProduct);
					
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
			JLabel deleteIcon = new JLabel(new ParsedImageIcon("trashBin.png", 25, 25));
			deleteIcon.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int delete = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to delete " + currentProduct.getName() + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
					if(delete==0){ //When delete is clicked
						boolean deleted=false;
						for(int productCounter=0; productCounter<products.size() && !deleted; productCounter++){
							Product product = products.get(productCounter);
							if(product==currentProduct){
								products.remove(productCounter); //Will completely remove it from store. This list is stored in the store object which is used by every other page. ONLY needs to be called once.
								productsGrid.remove(productButtons.remove(productCounter)); //Also need to remove from product buttons, otherwise multiple deletions will mess up indexing
								
								deleted=true;
								
							}
						}
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			editingButtons.add(pencilIcon);
			editingButtons.add(Box.createRigidArea(new Dimension(10, 50)));
			editingButtons.add(deleteIcon);
			productButton.add(editingButtons);
			productButton.setVisible(true);
			productButton.repaint();
			
		}
		JPanel addProductButton = new JPanel();
		addProductButton.setBackground(Color.white);
		addProductButton.setLayout(new BoxLayout(addProductButton, BoxLayout.Y_AXIS));
		JLabel plusImage = new JLabel("+");
		plusImage.setFont(new Font("Arial", Font.PLAIN, 100));

		plusImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel plusText = new JLabel("Add Product");
		plusText.setAlignmentX(Component.CENTER_ALIGNMENT);
		plusText.setFont(new Font("Arial", Font.PLAIN, 25));
		addProductButton.add(Box.createRigidArea(new Dimension(10, 100)));
		addProductButton.add(plusImage);
		addProductButton.add(plusText);
		addProductButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String productName = JOptionPane.showInputDialog("Please enter the new product's name:", "Product name");
				if(productName!=null && !productName.equals("")){
					Product newProduct = new Product(0.0, productName, null, false, department, null);
					department.addProduct(newProduct);
					window.setContentArea(newProduct);
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
		
		productsGrid.add(addProductButton);
		
		window.updateFrame();
	}
	public static void main(String args[]){
	}

}
