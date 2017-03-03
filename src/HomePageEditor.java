import javax.swing.*;
import java.util.*;
import java.awt.*;
public class HomePageEditor extends HomePage {
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
		
	}
}