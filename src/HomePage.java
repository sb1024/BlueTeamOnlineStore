import javax.swing.*;
import java.util.*;
import java.awt.*;
public class HomePage extends JPanel {
	JScrollBar scrollBar;
	JLabel title;
	JPanel titlePanel;
	JLabel logo;
	JPanel logoPanel;
	JLabel description;
	JPanel descriptionPanel;
	ArrayList<JPanel> deparmentButtons;
	MainWindow window;
	HomePage(MainWindow window) {
		this.window = window;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		logoPanel = new JPanel();
		logo = new JLabel(getStoreLogo());
		logoPanel.add(logo);
		a.add(logoPanel);
		titlePanel = new JPanel();
		title = new JLabel(getStoreName());
		titlePanel.add(title);
		a.add(titlePanel);
		this.add(a);
		descriptionPanel = new JPanel();
		description = new JLabel(getStoreDescription());
		this.add(descriptionPanel);
		JPanel holdingButtons = new JPanel();
		holdingButtons.setLayout(new GridLayout());
		addDepartmentButtons(holdingButtons);
	}
	public void addDepartmentButtons(JPanel JPanelHoldingButtons) {
		
	}
	public ArrayList<Department> getDepartments() {
		
	}
	public String getStoreName() {
		
	}
	public ImageIcon getStoreLogo() {
		
	}
	public String getStoreDescription() {
		
	}
}