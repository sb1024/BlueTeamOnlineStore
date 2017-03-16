import java.awt.*;

import javax.swing.*;

public class ProductPageEditor extends ProductPage {
	private MainWindow window;
	private Product product;
	
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
		deptEditor.add(dept);
		deptEditor.add(editDept);
		gbc.gridx = 2;
		gbc.gridy = 0;
		mainJPanel.add(deptEditor, gbc);
	}
	
	public static void main(String args[]){
		ProductPageEditor editor = new ProductPageEditor();
	}
}
