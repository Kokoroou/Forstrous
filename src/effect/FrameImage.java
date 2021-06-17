package effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The FrameImage is the class that draws images of Characters.
 *
 */
public class FrameImage {
	private String name;
	private BufferedImage image;
	
	public FrameImage(String name, BufferedImage image) {
	   this.name = name;
	   this.image = image;
	}
	
	public FrameImage() {
		this.name = null;
		this.image = null;
	}

	public void draw (Graphics2D g2, int x, int y) {
		g2.drawImage(image, x, y, null);
	}
	
	public int getImageWidth() {
		return image.getWidth();
	}
	
	public int getImageHeight() {
		return image.getHeight();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
