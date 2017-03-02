import javax.swing.*;
import java.util.*;
import java.awt.*;
public class DepartmentPageEditor extends DepartmentPage {
	MainWindow window;
	ArrayList<JPanel> productButtons;
	DepartmentPageEditor(MainWindow window, Department department) {
		super(window, department);
		JPanel addDepartment = new JPanel();
		addDepartment.setLayout(new BoxLayout(addDepartment, BoxLayout.Y_AXIS));
		addDepartment.add(new JLabel(PLUS SIGN THING));
		addDepartment.add(new JLabel("Add Product"));
		
	}
}