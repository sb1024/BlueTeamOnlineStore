import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class HomePage extends JPanel {
	/**
	//JScrollPane scrollPane;
	//JPanel contentPane;
	Store store;
	JLabel title, logo, description;
	JPanel titlePanel, logoPanel, descriptionPanel;
	ArrayList<JPanel> departmentButtons;
	MainWindow window;
	*/
	Store store;
	ArrayList<Department> departments;
	ArrayList<JPanel> departmentButtons=new ArrayList();
	//JScrollBar mainJPanel;
	MainWindow mainWindow;
	JPanel mainPanel;
	//Department mainDepartment;
	boolean editor;
	JPanel headerPanel, departmentsGrid;
	JFrame frame;
	ArrayList<Department> departmentList;
	
	HomePage() {
		JScrollPane scrollPane;
		JComponent navbarLogoTitleSpacer, logoTitleSpacer, logoTitleDescriptionSpacer, descriptionDepartmentsSpacer;
		JPanel logoTitlePanel, gridHolder;
		JLabel storeName, storeLogo, storeDescription;
		ParsedImageIcon logoImage;
		
		store = createStore();
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		departments = getDepartments();
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setPreferredSize(new Dimension(1200, 670));
		departmentList = getDepartments();
		editor = false;
		/**
		//needs navbar
		navbarLogoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		logoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(50, 150));
		logoTitleDescriptionSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 10));
		descriptionDepartmentsSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 20));
		
		logoTitlePanel = new JPanel();
		logoTitlePanel.setBackground(Color.WHITE);
		logoTitlePanel.setLayout(new BoxLayout(logoTitlePanel, BoxLayout.X_AXIS));
		
		storeName = new JLabel(getStoreName());
		storeName.setFont(new Font("Arial", Font.BOLD, 100));
		
		logoImage = getStoreLogo();
		logoImage.setWidth(150);
		logoImage.setHeight(logoImage.getIconWidth());
		storeLogo = new JLabel(logoImage);
		
		logoTitlePanel.add(storeLogo);
		logoTitlePanel.add(logoTitleSpacer);
		logoTitlePanel.add(storeName);
		logoTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(navbarLogoTitleSpacer);
		mainPanel.add(logoTitlePanel);
		mainPanel.add(logoTitleDescriptionSpacer);
		
		storeDescription = new JLabel(getStoreDescription());
		storeDescription.setFont(new Font("Arial", Font.PLAIN, 30));
		storeDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(storeDescription);
		mainPanel.add(descriptionDepartmentsSpacer);
		*/
		addHeader();
		departmentsGrid = new JPanel();
		departmentsGrid.setBackground(Color.WHITE);
		departmentsGrid.setLayout(new GridLayout(0, 4, 5, 5));
		addDepartmentButtons();
		for (JPanel panel: departmentButtons)
			departmentsGrid.add(panel);
		
		gridHolder = new JPanel();
		gridHolder.setBackground(Color.WHITE);
		gridHolder.setLayout(new BoxLayout(gridHolder, BoxLayout.X_AXIS));
		gridHolder.add(Box.createRigidArea(new Dimension(70, 100)));
		gridHolder.add(departmentsGrid);
		mainPanel.add(gridHolder);
		
		mainPanel.repaint();
		frame.add(scrollPane);
		frame.setVisible(true);
		frame.pack();
	}
	public void addHeader() {
		JComponent navbarLogoTitleSpacer, logoTitleSpacer, logoTitleDescriptionSpacer, descriptionDepartmentsSpacer;
		JPanel logoTitlePanel, logoPanel, titlePanel, descriptionPanel;
		JLabel storeName, storeLogo, storeDescription;
		ParsedImageIcon logoImage;
		
		//needs navbar
		navbarLogoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		logoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(50, 150));
		logoTitleDescriptionSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 10));
		descriptionDepartmentsSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 20));

		logoTitlePanel = new JPanel();
		logoTitlePanel.setBackground(Color.WHITE);
		logoTitlePanel.setLayout(new BoxLayout(logoTitlePanel, BoxLayout.X_AXIS));

		storeName = new JLabel(getStoreName());
		storeName.setFont(new Font("Arial", Font.BOLD, 100));

		logoImage = getStoreLogo();
		logoImage.setWidth(150);
		logoImage.setHeight(logoImage.getIconWidth());
		storeLogo = new JLabel(logoImage);

		logoTitlePanel.add(storeLogo);
		logoTitlePanel.add(logoTitleSpacer);
		logoTitlePanel.add(storeName);
		logoTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(navbarLogoTitleSpacer);
		mainPanel.add(logoTitlePanel);
		mainPanel.add(logoTitleDescriptionSpacer);

		storeDescription = new JLabel(getStoreDescription());
		storeDescription.setFont(new Font("Arial", Font.PLAIN, 30));
		storeDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(storeDescription);
		mainPanel.add(descriptionDepartmentsSpacer);
		
		mainPanel.add(headerPanel);
	}
	public void addDepartmentButtons() {//JPanel JPanelHoldingButtons) {
		for (int i = 0; i < departments.size(); i++) {
			final Department department = departments.get(i);
			JPanel departmentButtonPanel, departmentButtonSubPanel;
			ParsedImageIcon departmentLogo;
			JLabel departmentLogoLabel, departmentName;
			
			departmentButtonPanel = new JPanel();
			departmentButtonPanel.setLayout(new BoxLayout(departmentButtonPanel, BoxLayout.X_AXIS));
			departmentButtonPanel.setBackground(Color.WHITE);
			
			departmentButtonSubPanel = new JPanel();
			departmentButtonPanel.add(departmentButtonSubPanel);
			departmentButtonSubPanel.setBackground(Color.WHITE);
			departmentButtonSubPanel.setLayout(new BoxLayout(departmentButtonSubPanel, BoxLayout.Y_AXIS));
			
			departmentLogo = department.getImage();
			if (departmentLogo == null)
				departmentLogo = new ParsedImageIcon("noImage.jpg");
			departmentLogo.setWidth(200);
			departmentLogo.setHeight(200);
			departmentLogoLabel = new JLabel(departmentLogo);
			departmentLogoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			departmentButtonSubPanel.add(departmentLogoLabel);
			
			departmentName = new JLabel(department.getName());
			departmentName.setAlignmentX(Component.CENTER_ALIGNMENT);
			departmentButtonSubPanel.add(departmentName);
			
			MouseListener departmentListener = new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					mainWindow.setContentArea(department);
				}
				public void mouseEntered(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
			};
			departmentButtonSubPanel.addMouseListener(departmentListener);
			departmentButtons.add(departmentButtonPanel);
		}
	}
	public ArrayList<Department> getDepartments() {
		return store.getDepartments();
	}
	public String getStoreName() {
		return store.getStoreName();
	}
	public ParsedImageIcon getStoreLogo() {
		return store.getStoreLogo();
	}
	public String getStoreDescription() {
		return store.getStoreDescription();
	}
	public ArrayList<JPanel> getDepartmentButtons() {
		return departmentButtons;
	}
	public ArrayList<Department> getDepartmentList() {
		return departments;
	}
	public JPanel getDepartmentsGrid() {
		return departmentsGrid;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void frameUpdate() {
		frame.pack();
		frame.repaint();
	}
	public Store createStore(){
		String storeName = "Generic Store";
		ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
		String storeDescription = "A generic store. All values should be changed";
		
		ArrayList<Department> departments = new ArrayList();
		Department genericDepartment = new Department("Electronics");
		ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
		genericDepartment.setImage(departmentLogo);
		Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		
		departments.add(genericDepartment);
		departments.add(new Department("Other Stuff"));
		departments.add(new Department("Other Stuff"));
		departments.add(new Department("Other Stuff"));
		departments.add(new Department("Other Stuff"));
		
		ArrayList<Order> orders = new ArrayList();
		
		return new Store(storeName, storeDescription, departments, orders, storeLogo);
	}
	public static void main(String[] args) {
		new HomePage();
	}
}