import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ParsedImageIcon extends ImageIcon{
	
	private String filePath;
	
	ParsedImageIcon(String pathOfFile, int width, int height){
		filePath=pathOfFile;
		Image image;
		try {
			image = ImageIO.read(new File(filePath));
			image=image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			this.setImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Image file could not be found");
		}
		
	}
	ParsedImageIcon(String pathOfFile){
		filePath=pathOfFile;
		Image image;
		try {
			this.setImage(ImageIO.read(new File(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Image file could not be found");
		}
		
	}
	public void setWidth(int width){
		Image image = this.getImage();
		image=image.getScaledInstance(width, this.getIconHeight(), Image.SCALE_SMOOTH);
		this.setImage(image);
	}
	public void setHeight(int height){
		Image image = this.getImage();
		image=image.getScaledInstance(this.getIconWidth(), height, Image.SCALE_SMOOTH);
		this.setImage(image);
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	public void fitImage(int maxWidth, int maxHeight){
		Image image = this.getImage();
		int originalWidth = image.getWidth(getImageObserver());
		int originalHeight = image.getHeight(getImageObserver());
		double widthRatio = (maxWidth / originalWidth);
		double heightRatio = (maxHeight / originalHeight);
		int newWidth = (int)(originalWidth * widthRatio);
		int newHeight = (int)(originalHeight * heightRatio);
		if (newWidth <= newHeight){
			newHeight = (int)(originalHeight * widthRatio);
		}
		else{
			newWidth = (int)(originalWidth * heightRatio);
		}
		setWidth(newWidth);
		setHeight(newHeight);
	}
}
