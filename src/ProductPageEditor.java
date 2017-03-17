import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.*;

public class ProductPageEditor extends ProductPage {	
	private JPanel nameEditor, imageEditor, priceEditor, descEditor, deptEditor;
	//public ProductPageEditor(MainWindow window, Product product) {
	public ProductPageEditor() {
		super();

		addEditorButtons();
		
		frame.setTitle("EditorTest");
		frame.pack();
		frame.repaint();
	}

	private void addEditorButtons() {
		quantity.setVisible(false);
		total.setVisible(false);
		addToCart.setVisible(false);
		
		ParsedImageIcon pencil = new ParsedImageIcon("pencil.png",30, 30);
		
		nameEditor = new JPanel();
		nameEditor.setBackground(Color.white);
		nameEditor.setLayout(new BoxLayout(nameEditor, BoxLayout.LINE_AXIS));
		nameEditor.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel editName = new JLabel(pencil);
		editName.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String input = JOptionPane.showInputDialog("Edit Product Name:");
				if(input!=null && !input.equals("")){
					product.setName(input);
					System.out.println(product.getName());
					name.setText(product.getName());	
	
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		nameEditor.add(name);
		nameEditor.add(editName);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainJPanel.add(nameEditor, gbc);
		
		imageEditor = new JPanel();
		imageEditor.setBackground(Color.white);
		imageEditor.setLayout(new BoxLayout(imageEditor, BoxLayout.LINE_AXIS));
		imageEditor.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel editImage = new JLabel(pencil);
		editImage.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		editImage.setVerticalAlignment(JLabel.BOTTOM);
		imageEditor.add(image);
		imageEditor.add(editImage);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainJPanel.add(imageEditor, gbc);
		
		priceEditor = new JPanel();
		priceEditor.setBackground(Color.white);
		priceEditor.setLayout(new BoxLayout(priceEditor, BoxLayout.LINE_AXIS));
		priceEditor.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel editPrice = new JLabel(pencil);
		editPrice.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		editPrice.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String input = JOptionPane.showInputDialog("Edit Product Price:");
				boolean error = true;
				double newPrice = 0;
				while(error) {
					try {
						newPrice = Double.parseDouble(input);
						
						if(newPrice != 0) {
							error = false;
							newPrice = round(newPrice);
						}
			
					} catch (Exception e) {
						input = JOptionPane.showInputDialog("The input was not understood. Please enter a decimal number. \nEdit Product Price:");
					
					}
				}
				if(input!=null && !input.equals("")){
					product.setPrice(newPrice);
					System.out.println(product.getPrice());
					price.setText("Price: " + USD.format(product.getPrice()));	
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		priceEditor.add(price);
		priceEditor.add(editPrice);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainJPanel.add(priceEditor, gbc);
		
		descEditor = new JPanel();
		descEditor.setBackground(Color.white);
		descEditor.setLayout(new BoxLayout(descEditor, BoxLayout.LINE_AXIS));
		descEditor.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel editDesc = new JLabel(pencil);
		editDesc.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		descEditor.add(description);
		descEditor.add(editDesc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridheight = 2;
		mainJPanel.add(descEditor, gbc);
		
		deptEditor = new JPanel();
		deptEditor.setBackground(Color.white);
		deptEditor.setLayout(new BoxLayout(deptEditor, BoxLayout.LINE_AXIS));
		deptEditor.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel editDept = new JLabel(pencil);
		editDept.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		editDept.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] deptList = {"Shoes", "Computers"}; //get from Store obj
				String input = JOptionPane.showInputDialog(null, "Select Department:", "Input", JOptionPane.QUESTION_MESSAGE, null, deptList);
				
				if(input!=null && !input.equals("")){
					product.setName(input);
					System.out.println(product.getName());
					name.setText(product.getName());	
	
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		deptEditor.add(dept);
		deptEditor.add(editDept);
		gbc.gridx = 2;
		gbc.gridy = 0;
		mainJPanel.add(deptEditor, gbc);
	}
	
	private double round(double price) {
		BigDecimal bigVal = new BigDecimal(price);
		bigVal = bigVal.setScale(2, BigDecimal.ROUND_HALF_UP);
		price = bigVal.doubleValue();
		return price;
		
	}
	
	public static void main(String args[]){
		ProductPageEditor editor = new ProductPageEditor();
	}
}
