import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NavBar extends JPanel{
	private JPanel mainPanel = this;
	private JLabel logo;
	private MainWindow mainWindow;
	private boolean editor;
	private Store store;
	public NavBar(MainWindow window){
		mainWindow=window;
		editor=window.isEditor();
		store = window.getStore();
		ParsedImageIcon storeLogo = new ParsedImageIcon(store.getStoreLogo().getFilePath());
		storeLogo.fitImage(300, 50);
		String storeTitle = store.getStoreName();
		MouseListener homeButton = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Home");
				if(editor){
					mainWindow.setContentArea(new HomePageEditor(mainWindow));
				}else{
					mainWindow.setContentArea(new HomePage(mainWindow));
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
		};
		MouseListener backButtonListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainWindow.back();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
		};
		MouseListener reviewCartListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainWindow.setContentArea(new CartPage(mainWindow));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
		};
		MouseListener makePurchaseListener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Make Purchase");
				mainWindow.setContentArea(new PurchasePage(mainWindow));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
		};
		


		this.setPreferredSize(new Dimension(1200, 50));
		this.setMaximumSize(new Dimension(1200, 50));
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(220, 220, 220));
		
		JLabel backButton = new JLabel(new ParsedImageIcon("back.png", 60, 50));
		backButton.addMouseListener(backButtonListener);
		
		JComponent backSpacer1 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/20, 50));
		backSpacer1.addMouseListener(backButtonListener);
		JComponent backSpacer2 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/20, 50));
		backSpacer2.addMouseListener(backButtonListener);
		JComponent logoSpacer = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50));
		JComponent logoSpacer2 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50));
		logoSpacer2.addMouseListener(homeButton);
		JComponent buttonSpacer1 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50));
		buttonSpacer1.addMouseListener(reviewCartListener);
		JComponent buttonSpacer2 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50));
		buttonSpacer2.addMouseListener(reviewCartListener);
		JComponent buttonSpacer3 = (JComponent)Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50));
		buttonSpacer3.addMouseListener(makePurchaseListener);




		logo = new JLabel(storeLogo);
		logo.addMouseListener(homeButton);
		JLabel storeName = new JLabel(storeTitle);
		storeName.setFont(new Font("Arial", Font.PLAIN, 50));
		storeName.addMouseListener(homeButton);
		
		JLabel reviewCart = new JLabel(new ParsedImageIcon("reviewCart.png", 50, 50));
		reviewCart.addMouseListener(reviewCartListener);
		JLabel makePurchase = new JLabel("Make Purchase");
		makePurchase.setFont(new Font("Arial", Font.PLAIN, 18));
		makePurchase.addMouseListener(makePurchaseListener);

		
		backSpacer2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));
		buttonSpacer1.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.black));
		buttonSpacer2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));
		
		JPanel rightSide = new JPanel();
		rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.X_AXIS));
		rightSide.setBackground(new Color(220, 220, 220));
		GridBagConstraints rightSideConstraints = new GridBagConstraints();
		rightSideConstraints.weightx=1;
		rightSideConstraints.weighty=1;
		rightSideConstraints.anchor=GridBagConstraints.EAST;
		rightSideConstraints.fill=GridBagConstraints.VERTICAL;
		
		rightSide.add(buttonSpacer1);
		rightSide.add(reviewCart);
		rightSide.add(buttonSpacer2);
		rightSide.add(buttonSpacer3);
		rightSide.add(makePurchase);
		rightSide.add(Box.createRigidArea(new Dimension((int)this.getPreferredSize().getWidth()/60, 50)));
		
		this.add(backSpacer1); //Creates gap between side and back back button
		this.add(backButton);
		this.add(backSpacer2);
		this.add(logoSpacer);
		this.add(logo);
		this.add(logoSpacer2);
		this.add(storeName);
		this.add(rightSide, rightSideConstraints);
		
	}
	public void refreshLogo(){
		ParsedImageIcon logoImage = new ParsedImageIcon(store.getStoreLogo().getFilePath());
		logoImage.fitImage(300, 50);
		logo.setIcon(logoImage);
	}
	


}


