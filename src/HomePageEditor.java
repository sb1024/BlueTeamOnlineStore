import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class HomePageEditor extends HomePage {
	ArrayList<JPanel> departmentButtons;
	MainWindow window;
	JPanel mainPanel;
	ArrayList<Department> departments;
	JPanel departmentsGrid;
	JLabel nameLabel, descriptionLabel;
	
	HomePageEditor() {
		super();
		departmentButtons = getDepartmentButtons();
		departments = getDepartments();
		departmentsGrid = getDepartmentsGrid();
		mainPanel = getMainPanel();
		addEditingButtons();
	}
	public void setStoreName(String name) {
		store.setStoreName(name);
		storeName.setText(name);
	}
	public void setDescription(String description) {
		store.setStoreDescription(description);
		storeDescription.setText(description);
	}
	public void setStoreLogo() {
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				ParsedImageIcon logo = new ParsedImageIcon(file.getPath());
				resizeLogo(logo);
				store.setStoreLogo(logo);
				storeLogo.setIcon(logo);
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
		titlePanel.add(editingButtons);
		
		editingButtons = new JPanel();
		editingButtons.setBackground(Color.WHITE);
		pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
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
		logoPanel.add(editingButtons);
		
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
		descriptionPanel.add(editingButtons);
		
		for (int i = 0; i < departmentButtons.size(); i++) {
			final Department currentDepartment = departments.get(i);
			JPanel departmentButton = departmentButtons.get(i);
			
			editingButtons = new JPanel();
			editingButtons.setBackground(Color.WHITE);
			editingButtons.setLayout(new BoxLayout(editingButtons, BoxLayout.Y_AXIS));
			
			pencilIcon = new JLabel(new ParsedImageIcon("pencil.png", 25, 25));
			pencilIcon.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					window.setContentArea(currentDepartment);
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
								departments.remove(currentDepartment);
								departmentsGrid.remove(departmentButtons.remove(i));
								deleted = true;
								frameUpdate();
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
			
			editingButtons.add(pencilIcon);
			editingButtons.add(Box.createRigidArea(new Dimension(10, 50)));
			editingButtons.add(deleteIcon);
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
					addDepartment(departmentName);
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
		frameUpdate();
	}
	public void addDepartment(String departmentName) {
		Department newDepartment = new Department(departmentName);
		JPanel newDepartmentPanel = new JPanel();
		newDepartmentPanel.setBackground(Color.WHITE);
		departmentList.add(newDepartment);
		departmentButtons.add(newDepartmentPanel);
		departmentsGrid.add(newDepartmentPanel);
		window.setContentArea(newDepartment);
	}
	public static void main(String[] args) {
		new HomePageEditor();
	}
}