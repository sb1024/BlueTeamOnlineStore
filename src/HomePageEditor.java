
import javax.swing.*;
import javax.imageio.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class HomePageEditor extends HomePage {
	private ArrayList<JLabel> departmentNameLabels;
	private ArrayList<JLabel> departmentImageLabels;
	
	ArrayList<JPanel> departmentButtons;
	MainWindow window;
	JPanel mainPanel;
	ArrayList<Department> departments;
	JPanel departmentsGrid;
	JLabel nameLabel, descriptionLabel;
	
	HomePageEditor(MainWindow mainWindow) {
		super(mainWindow);
		window=mainWindow;
		departmentNameLabels = getDepartmentNameLabels();
		departmentImageLabels = getDepartmentLogoLabels();
		departmentButtons = getDepartmentButtons();
		departments = getDepartments();
		departmentsGrid = getDepartmentsGrid();
		mainPanel = getMainPanel();
		addEditingButtons();
	}
	public void setStoreName(String name) {
		store.setStoreName(name);
		getStoreNameLabel().setText(name);
	}
	public void setDescription(String description) {
		store.setStoreDescription(description);
		getStoreDescriptionLabel().setText(description);
	}
	public void setStoreLogo() {
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				ParsedImageIcon logo = new ParsedImageIcon(file.getPath());
				logo.fitImage(300, 150);
				store.setStoreLogo(logo);
				getStoreLogoLabel().setIcon(logo);
				window.getNavBar().refreshLogo(); //Used to update the logo on the NavBar
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void addEditingButtons() {
		JPanel editingButtons;
		JLabel pencilIcon, deleteIcon;
		
		editingButtons = new JPanel();
		editingButtons.setBackground(Color.WHITE);
		pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
		pencilIcon.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				setStoreName(JOptionPane.showInputDialog("Please enter the store's new name:", store.getStoreName()));
			}
			public void mouseEntered(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		editingButtons.add(pencilIcon);
		getStoreTitlePanel().add(editingButtons);
		
		editingButtons = new JPanel();
		editingButtons.setBackground(Color.WHITE);
		pencilIcon = new JLabel(new ParsedImageIcon("photo.png", 25, 25));
		pencilIcon.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				setStoreLogo();
			}
			public void mouseEntered(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		editingButtons.add(pencilIcon);
		getStoreLogoPanel().add(editingButtons);
		
		editingButtons = new JPanel();
		editingButtons.setBackground(Color.WHITE);
		pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
		pencilIcon.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				setDescription(JOptionPane.showInputDialog("Please enter the store's new description:", store.getStoreDescription()));
			}
			public void mouseEntered(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		editingButtons.add(pencilIcon);
		getStoreDescriptionPanel().add(editingButtons);
		
		for (int i = 0; i < departmentButtons.size(); i++) {
			final Department currentDepartment = departments.get(i);
			JPanel departmentButton = departmentButtons.get(i);
			
			editingButtons = new JPanel();
			editingButtons.setBackground(Color.WHITE);
			editingButtons.setLayout(new BoxLayout(editingButtons, BoxLayout.Y_AXIS));
			JLabel pictureIcon = new JLabel(new ParsedImageIcon("photo.png", 25, 25));
			pictureIcon.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int result = fc.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						try {
							ParsedImageIcon logo = new ParsedImageIcon(file.getPath(), 150, 150);
							boolean found=false;
							for (int i = 0; i < departments.size() && !found; i++) {
								Department department = departments.get(i);
								if (department == currentDepartment) {
									found=true;
									currentDepartment.setImage(logo);
									(departmentImageLabels.get(i)).setIcon(logo);

								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}

				public void mouseEntered(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
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
			pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
			pencilIcon.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					String newName = JOptionPane.showInputDialog("Please enter the department's new name", currentDepartment.getName());
					if(newName!=null && !newName.equals("")){
						boolean found=false;
						for (int i = 0; i < departments.size() && !found; i++) {
							Department department = departments.get(i);
							if (department == currentDepartment) {
								found=true;
								currentDepartment.setName(newName);
								departmentNameLabels.get(i).setText(newName);

							}
						}

						
					}
				}
				public void mouseEntered(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			});
			
			deleteIcon = new JLabel(new ParsedImageIcon("trashBin.png", 25, 25));
			deleteIcon.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					int delete = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to delete " + currentDepartment.getName() + "?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
					if (delete == 0) {
						boolean deleted = false;
						for (int i = 0; i < departments.size() && !deleted; i++) {
							Department department = departments.get(i);
							if (department == currentDepartment) {
								departments.remove(i);
								
								departmentsGrid.remove(departmentButtons.remove(i));
								deleted = true;
								mainWindow.updateFrame();

							}
						}
					}
				}
				public void mouseEntered(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			});
			
			editingButtons.add(deleteIcon);
			editingButtons.add(Box.createRigidArea(new Dimension(10, 50)));
			editingButtons.add(pictureIcon);
			editingButtons.add(Box.createRigidArea(new Dimension(10, 50)));
			editingButtons.add(pencilIcon);
			departmentButton.add(editingButtons);
			departmentButton.repaint();
			departmentButton.setVisible(true);
		}
		
		JPanel addDepartmentButton = new JPanel();
		addDepartmentButton.setBackground(Color.WHITE);
		addDepartmentButton.setLayout(new BoxLayout(addDepartmentButton, BoxLayout.Y_AXIS));
		JLabel plusImage = new JLabel("+");
		plusImage.setFont(new Font("Arial", Font.PLAIN, 100));
		
		plusImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel plusText = new JLabel("Add Department");
		plusText.setAlignmentX(Component.CENTER_ALIGNMENT);
		plusText.setFont(new Font("Arial", Font.PLAIN, 25));
		addDepartmentButton.add(plusImage);
		addDepartmentButton.add(plusText);
		addDepartmentButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				String departmentName = JOptionPane.showInputDialog("Please enter the new department's name:", "Department name");
				if (departmentName != null && !departmentName.equals("")) {
					JFileChooser fileChooser = new JFileChooser();
					int fileChooserState=fileChooser.showOpenDialog(frame);
					if(fileChooserState==JFileChooser.APPROVE_OPTION){
						File userFile = fileChooser.getSelectedFile();
						ParsedImageIcon newDepartmentImage = new ParsedImageIcon(userFile.getAbsolutePath(), 200, 200);
						
						Department newDepartment = new Department();
						newDepartment.setName(departmentName);
						newDepartment.setImage(newDepartmentImage);
						store.addDepartment(newDepartment);
						
						window.setContentArea(newDepartment);
						
					}
				}
			}
			public void mouseEntered(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		departmentsGrid.add(addDepartmentButton);
		mainWindow.updateFrame();
	}
	public static void main(String[] args) {
	}
}
