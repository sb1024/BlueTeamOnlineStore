<<<<<<< HEAD
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
	JPanel mainPanel = this;
	//Department mainDepartment;
	boolean editor;
	private JLabel storeName, storeLogo, storeDescription;
	private JPanel headerPanel, logoPanel, titlePanel, descriptionPanel, departmentsGrid;
	private ArrayList<JLabel> departmentNameLabels = new ArrayList();
	private ArrayList<JLabel> departmentLogoLabels = new ArrayList();
	JFrame frame;
	ArrayList<Department> departmentList;
	
	HomePage(MainWindow window) {
		mainWindow=window;
		
		JScrollPane scrollPane;
		JPanel gridHolder;

		
		store = window.getStore();
		departments = store.getDepartments();
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		departmentList = getDepartments();
		editor = false;
		
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
		this.add(gridHolder);
		mainWindow.updateFrame();

		
	}
	public void addHeader() {
		JComponent navbarLogoTitleSpacer, logoTitleSpacer, logoTitleDescriptionSpacer, descriptionDepartmentsSpacer;
		JPanel logoTitlePanel;//, logoPanel, titlePanel, descriptionPanel;

		ParsedImageIcon logoImage;
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setLayout(new GridBagLayout());
		

		logoTitlePanel = new JPanel();
		logoTitlePanel.setBackground(Color.WHITE);
		logoTitlePanel.setLayout(new BoxLayout(logoTitlePanel, BoxLayout.X_AXIS));
		
		logoImage = getStoreLogo();
		logoImage.setWidth(150);
		logoImage.setHeight(logoImage.getIconWidth());
		storeLogo = new JLabel(logoImage);


		storeName = new JLabel(getStoreName());
		storeName.setFont(new Font("Arial", Font.BOLD, 100));
		
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.add(storeLogo);
		logoTitlePanel.add(logoPanel);
		
		titlePanel = new JPanel();
		titlePanel.add(storeName);
		titlePanel.setBackground(Color.WHITE);
		logoTitlePanel.add(titlePanel);


		logoTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		headerPanel.add(logoTitlePanel);

		
		GridBagConstraints descriptionConstraints = new GridBagConstraints();
		descriptionConstraints.gridy=1;
		descriptionPanel = new JPanel();
		descriptionPanel.setBackground(Color.WHITE);
		storeDescription = new JLabel(getStoreDescription());
		storeDescription.setFont(new Font("Arial", Font.PLAIN, 30));
		storeDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptionPanel.add(storeDescription);
		headerPanel.add(descriptionPanel, descriptionConstraints);
		
		this.add(headerPanel);
		
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
			departmentLogoLabels.add(departmentLogoLabel); //Adds to the arraylist that will be accessed by editor
			departmentButtonSubPanel.add(departmentLogoLabel);
			
			departmentName = new JLabel(department.getName());
			departmentNameLabels.add(departmentName);
			departmentName.setAlignmentX(Component.CENTER_ALIGNMENT);
			departmentButtonSubPanel.add(departmentName);
			
			MouseListener departmentListener = new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					System.out.println(department.getName());

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
		return this;
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
	public JLabel getStoreNameLabel(){
		return storeName;
	}
	public JLabel getStoreDescriptionLabel(){
		return storeDescription;
	}
	public JLabel getStoreLogoLabel(){
		return storeLogo;
	}
	public JPanel getStoreTitlePanel(){
		return titlePanel;
	}
	public JPanel getStoreLogoPanel(){
		return logoPanel;
	}
	public JPanel getStoreDescriptionPanel(){
		return descriptionPanel;
	}
	public ArrayList<JLabel> getDepartmentNameLabels(){
		return departmentNameLabels;
	}
	public ArrayList<JLabel> getDepartmentLogoLabels(){
		return departmentLogoLabels;
	}

=======
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
	JPanel headerPanel, logoPanel, titlePanel, descriptionPanel, departmentsGrid;
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
		JPanel logoTitlePanel;//, logoPanel, titlePanel, descriptionPanel;
		JLabel storeName, storeLogo, storeDescription;
		ParsedImageIcon logoImage;
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		
		//needs navbar
		navbarLogoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 50));
		//logoTitleSpacer = (JComponent)Box.createRigidArea(new Dimension(50, 150));
		logoTitleDescriptionSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 10));
		descriptionDepartmentsSpacer = (JComponent)Box.createRigidArea(new Dimension(1200, 20));

		logoTitlePanel = new JPanel();
		logoTitlePanel.setBackground(Color.WHITE);
		logoTitlePanel.setLayout(new BoxLayout(logoTitlePanel, BoxLayout.X_AXIS));

		titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		storeName = new JLabel(getStoreName());
		storeName.setFont(new Font("Arial", Font.BOLD, 100));
		titlePanel.add(storeName);

		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoImage = getStoreLogo();
		logoImage.setWidth(150);
		logoImage.setHeight(logoImage.getIconWidth());
		storeLogo = new JLabel(logoImage);
		logoPanel.add(storeLogo);

		logoTitlePanel.add(logoPanel);
		//logoTitlePanel.add(logoTitleSpacer);
		logoTitlePanel.add(titlePanel);
		logoTitlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		headerPanel.add(navbarLogoTitleSpacer);
		headerPanel.add(logoTitlePanel);
		headerPanel.add(logoTitleDescriptionSpacer);

		descriptionPanel = new JPanel();
		descriptionPanel.setBackground(Color.WHITE);
		storeDescription = new JLabel(getStoreDescription());
		storeDescription.setFont(new Font("Arial", Font.PLAIN, 30));
		storeDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptionPanel.add(storeDescription);
		headerPanel.add(descriptionPanel);
		headerPanel.add(descriptionDepartmentsSpacer);
		
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
