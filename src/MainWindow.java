import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow {
	private boolean editor = false;
	private XMLReaderWriter xmlReaderWriter;
	private Store store;
	private NavBar navBar;
	private JFrame frame; 
	private JPanel currentContentPane;
	
	MainWindow(boolean editMode){		
		xmlReaderWriter = new XMLReaderWriter();
		try{
			store=xmlReaderWriter.loadStore();
		}catch(Exception ex){
			System.out.println("The store file could not be loaded. A default store will be created.");
			
			String storeName = "Generic Store";
			ParsedImageIcon 
		}
		
		editor = editMode;
		navBar = new NavBar(this);
		
		HomePage homePage = new HomePage(this);
		currentContentPane=homePage;
		
		frame = new JFrame("Store");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1200, 720));
		mainPanel.add(navBar);
		mainPanel.add(currentContentPane);
	}
	
}
