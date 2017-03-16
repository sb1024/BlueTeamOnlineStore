import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class HomePageEditor extends HomePage {
	/**
	JLabel descriptionLabel;
	JLabel nameLabel;
	ImageIcon logo;
	MainWindow window;
	ArrayList<JButton> editButtons, deleteButtons;
	*/
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
		nameLabel = new JLabel(name);
	}
	public void setDescription(String description) {
		descriptionLabel = new JLabel(description);
	}
	/**
	public void setStoreLogo() {
		JFileChooser fileChooser = new JFileChooser();
		//DO JFILECHOOSER PART
		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				// What to do with the file, e.g. display it in a TextArea
				textarea.read( new FileReader( file.getAbsolutePath() ), null );
			} catch (IOException ex) {
				System.out.println("problem accessing file"+file.getAbsolutePath());
			}
		} else {
			System.out.println("File access cancelled by user.");
		}
	}
	*/
	public void addEditingButtons() {
		JPanel editingButtons, logoPanel, titlePanel, descriptionPanel;
		JLabel pencilIcon, deleteIcon;
		
		logoPanel = 
		
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
					Department newDepartment = new Department(departmentName);
					//window.setContentArea(newDepartment);
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
	public static void main(String[] args) {
		new HomePageEditor();
	}
}