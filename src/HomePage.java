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
		JPanel logoNamePanel = new JPanel();
		logoNamePanel.setLayout(new BoxLayout(logoNamePanel, BoxLayout.X_AXIS));
		logoPanel = new JPanel();
		logo = new JLabel(getStoreLogo());
		logoPanel.add(logo);
		logoNamePanel.add(logoPanel);
		titlePanel = new JPanel();
		title = new JLabel(getStoreName());
		titlePanel.add(title);
		logoNamePanel.add(titlePanel);
		this.add(logoNamePanel);
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
		return ;
	}
	public String getStoreName() {
		return ;
	}
	public ImageIcon getStoreLogo() {
		return ;
	}
	public String getStoreDescription() {
		return ;
	}
}