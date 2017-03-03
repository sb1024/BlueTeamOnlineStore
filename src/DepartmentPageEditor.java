import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class DepartmentPageEditor extends DepartmentPage implements ActionListener {
	MainWindow window;
	ArrayList<JPanel> productButtons;
	DepartmentPageEditor(MainWindow window, Department department) {
		super(window, department);
		JPanel addDepartment = new JPanel();
		addDepartment.setLayout(new BoxLayout(addDepartment, BoxLayout.Y_AXIS));
		addDepartment.add(new JLabel(PLUS SIGN IMG));
		addDepartment.add(new JLabel("Add Product"));
		//addDepartment.addActionListener(this);
		J a;
	}
	public void addEditingButtons() {
		for (int i = 0; i < productButtons.size(); i++) {
			Product product = products.get(i);
			JPanel productPanel = new JPanel();
			productPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			//JLabel editIcon = new JLabel(PENCIL ICON);
			JButton editIcon = new JButton();
			editIcon.addActionListener(this);
			editIcon.setActionCommand("edit" + i);
			//JLabel deleteIcon = new JLabel();
			JButton deleteIcon = new JButton();
			deleteIcon.addActionListener(this);
			deleteIcon.setActionCommand("delete" + i);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().startsWith("edit"))
			;
		else if (e.getActionCommand().startsWith("delete"))
			;
	}
}