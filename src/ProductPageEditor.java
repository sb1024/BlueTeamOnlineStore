import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
				String input = JOptionPane.showInputDialog("Edit Product Name:", product.getName());
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
		editImage.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
				fc.setFileFilter(filter);
				
				int returnVal = fc.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		       
					System.out.println("Image: " + file.getName());
					System.out.println("Path: " + file.getPath());
					System.out.println("dir: " + System.getProperty("user.dir"));
					String currentDir = System.getProperty("user.dir");
					
	            	
		            if(!file.getPath().contains("BlueTeamOnlineStore")) { //copy file
		            	File source = new File(file.getPath());
		            	File dest = new File(currentDir, file.getName());
						File checker = new File(dest.getPath());
						System.out.println("exists? " + checker.exists());
						int num = 1;
						while(checker.exists()) {
							int lastPd = file.getName().lastIndexOf(".");
							String newFileName = file.getName().substring(0, lastPd) + "(" + num + ")" + file.getName().substring(lastPd);
							System.out.println(newFileName);
							dest = new File(currentDir, newFileName);
							checker = new File(dest.getPath());
							num++;
						}
						
		            	System.out.println("source: " + source);
		            	System.out.println("destination: " + dest);
		            	
		            	try {
							Files.copy(file.toPath(), dest.toPath());

							file = dest;
							System.out.println("New Path: " + dest.getPath());
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		            ParsedImageIcon newImage = new ParsedImageIcon(file.getName(), 350, 350);

					product.setImage(newImage);
					image.setIcon(product.getImage());
		            
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
		editPrice.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		editPrice.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		editPrice.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String input = JOptionPane.showInputDialog("Edit Product Price:", product.getPrice());
				boolean error = true;
				double newPrice = 0;
				System.out.println(input);
				while(error) {
					try {
						if(input == null) {
							newPrice = product.getPrice();
						} else {
							newPrice = Double.parseDouble(input);
						}
						
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
		editDesc.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s = "hello world\n\n\n";
		        JScrollPane scrollPane = new JScrollPane(new JLabel(s));
		        scrollPane.setPreferredSize(new Dimension(200,100));
		        Object message = scrollPane;
		  
		        JTextArea textArea = new JTextArea(s);
		        textArea.setLineWrap(true);
		        textArea.setWrapStyleWord(true);
		        textArea.setMargin(new Insets(5,5,5,5));
		        scrollPane.getViewport().setView(textArea);
		  
		        String input = JOptionPane.showInputDialog(frame, "Edit Product Description:", product.getDesc());
		        //String input = JOptionPane.showInputDialog(frame, message);
		        
		        System.out.println(input);
		        if(input!=null && !input.equals("")){
					product.setDesc(input);
					System.out.println(product.getDesc());
					description.setText(product.getDesc());	
	
				}
		        /*String input = JOptionPane.showInputDialog("Edit Product Description:", product.getDesc());
				if(input!=null && !input.equals("")){
					product.setDesc(input);
					System.out.println(product.getDesc());
					description.setText(product.getDesc());	
	
				}*/
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
				String[] deptList = {"Shoes", "Electronics"}; //get from Store obj
				int pos=0;
				for(int i = 0; i < deptList.length; i++) {
					if(deptList[i].equals(product.getDepartment().getName())) {
						pos = i;
					}
				}
				String input = (String) JOptionPane.showInputDialog(frame, 
						"Select Department:", "Department", JOptionPane.QUESTION_MESSAGE, 
						null, deptList, deptList[pos]);
	
				if(input!=null && !input.equals("")){
					for(int i = 0; i < deptList.length; i++) {
						if(deptList[i].equals(product.getDepartment().getName())) {
							pos = i;
						}
					}
					
					product.setDepartment(new Department(input)); //store.getDepts().get(pos);
					System.out.println(product.getDepartment().getName());
					dept.setText("Department: " + product.getDepartment().getName());	
	
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
