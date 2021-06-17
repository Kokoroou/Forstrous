package object;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ui.GameWorld;

/**
 * The Map is the class that used to make a Map object.
 *
 */
public class Map extends JLabel {
	private GameWorld gameworld;
	private int round;
	private int arr[][];
	private Image mapImage;	

	public Map(GameWorld gameworld) {
		this.gameworld = gameworld;
		this.round = 0;
	}
	
	public Map(GameWorld gameworld, int round) {
		this.gameworld = gameworld;
		this.round = round;
	}
	
	public int getTile(int tileX, int tileY) {
		return this.arr[tileX][tileY];
	}

	public void drawMap(Graphics2D g2d) {
		BufferedImage img;
		try {
			img = ImageIO.read(new File("image/map" + Integer.toString(this.getRound()) + ".png"));
			g2d.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public void update() {
	}
	
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int[][] getArr() {
		return this.arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}
	
	public Image getMapImage() {
		return mapImage;
	}

	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}

	public void nextMap() {
		if(this.getRound() < 4) {
			this.setRound(this.getRound() + 1);
		}
	}
	
	public void backMap() {
		if(this.getRound() > 1) {
			this.setRound(getRound()-1);
		}
	}
}
