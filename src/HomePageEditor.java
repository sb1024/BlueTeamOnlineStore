import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class HomePageEditor extends HomePage implements ActionListener {
	JLabel descriptionLabel;
	JLabel nameLabel;
	ImageIcon logo;
	MainWindow window;
	HomePageEditor(MainWindow window) {
		super(window);
		addEditingButtons();
	}
	public void setStoreName(String name) {
		nameLabel = new JLabel(name);
	}
	public void setDescription(String description) {
		descriptionLabel = new JLabel(description);
	}
	public void setStoreLogo() {
		
	}
	public void addEditingButtons() {
		for (int i = 0; i < departmentButtons.size(); i++) {
			Department department = departments.get(i);
			JPanel departmentPanel = new JPanel();
			departmentPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			//JLabel editIcon = new JLabel(PENCIL ICON);
			JButton editIcon = new JButton(PENCIL ICON);
			editIcon.addActionListener(this);
			editIcon.setActionCommand("edit" + i);
			//JLabel deleteIcon = new JLabel();
			JButton deleteIcon = new JButton(TRASH CAN ICON);
			deleteIcon.addActionListener(this);
			deleteIcon.setActionCommand("delete" + i);
		}
		/**
		JButton editIcon = new JButton(PENCIL ICON);
		editIcon.addActionListener(this);
		editIcon.setActionCommand("edit logo");
		*/
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}