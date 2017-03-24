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
		double originalWidth = this.getIconWidth();
		double originalHeight = this.getIconHeight();
		double widthRatio = (originalWidth / originalHeight);
		double heightRatio = (originalHeight / originalWidth);
		int newWidth = (int)(maxHeight * widthRatio);
		int newHeight = (int)(maxWidth * heightRatio);
		if (newWidth <= newHeight){
			newHeight = maxHeight;
		}
		else{
			newWidth = maxWidth;
		}
		setWidth(newWidth);
		setHeight(newHeight);
	}
}
