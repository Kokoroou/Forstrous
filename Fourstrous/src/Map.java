package GameObject;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
public class Map extends JLabel {
	
	public static final int arr1[][]= {{0,0,0,1,1,1,1,1,1,1,1,1,1,1},//1
										{0,0,0,1,0,0,0,0,0,0,0,0,1,1},//2
										{0,0,0,1,0,0,0,0,0,0,0,0,1,1},//3
										{1,0,0,0,0,0,0,0,0,0,0,0,1,1},//4
										{1,1,0,0,0,0,0,0,0,0,0,0,1,1},//5
										{0,0,0,0,0,0,0,0,0,0,0,0,1,1},//6
										{1,1,1,1,0,0,0,0,0,0,0,0,1,1},//7
										{1,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
										{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//9
										{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//10
										{1,0,0,0,0,0,0,1,1,0,0,0,0,1},//11
										{0,0,0,0,0,0,0,0,1,0,0,0,0,1},//12
										{0,0,0,0,0,0,0,0,0,0,1,1,1,1},//13
										{0,1,0,0,0,0,0,0,0,0,0,0,1,1},//14
										{0,1,0,0,0,0,0,0,0,0,0,0,0,1},//15
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//17
									   	{0,1,1,0,0,0,0,0,0,0,0,0,0,2}};//18
	
	public static final int  arr2[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0,3},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,1,0,0,0,0,0,0,0,0,1,1},
										{1,0,0,1,1,1,0,0,0,0,0,0,1,1},
										{1,0,0,1,1,1,1,0,0,0,0,0,0,1},
										{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
										{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
										{1,0,0,1,1,1,0,0,0,0,0,0,0,1},
										{1,0,0,1,1,0,0,0,0,0,0,0,0,1},
										{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,1},
										{1,1,0,0,0,0,0,0,0,0,0,0,1,1},
									   	{1,1,2,1,1,1,1,1,1,1,1,1,1,1}};
	
	public static final int arr3[][]= {{0,0,3,0,0,0,0,0,1,1,1,1,1,1},
										{0,0,0,0,0,0,1,1,1,1,1,1,1,1},
										{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,1},
										{1,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
										{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
										{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
									   	{0,0,0,0,0,0,2,0,0,0,0,0,0,0}};
	
	public static final int arr4[][]= {{0,0,0,0,0,0,3,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
									   	{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	private int round;
	
	private int arr[][];
	
	public int[][] getArr() {
		return this.arr;
	}

	public void setArr(int round) {
		switch (this.round) {
		case 1: 
			this.arr = arr1;
			break;
		case 2:
			this.arr = arr2;
			break;
		case 3:
			this.arr = arr3;
			break;
		case 4:
			this.arr = arr4;
			break;
		default: 
				break;
		}
	}

	public Map() {
		this.round = 1;
		setArr(1);
	}
	
	public int getTile(int tileX, int tileY) {
		return this.arr[tileX][tileY];
	}
	
	public boolean isEndTile(int tileX, int tileY){
		return (arr[tileX][tileY]==2);
	}
	
	public boolean isBeginTile(int tileX, int tileY){
		return (arr[tileX][tileY]==3);
	}
	
	public void drawMap(Graphics2D g2d, int round) {
		BufferedImage img;
		switch (round) {
		case 1: {
			try {
				img = ImageIO.read(new File("data/map1.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		case 2: {
			try {
				img = ImageIO.read(new File("data/map2.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		case 3: {
			try {
				img = ImageIO.read(new File("data/map3.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		case 4: {
			try {
				img = ImageIO.read(new File("data/map4.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		
		default:
			break;
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

	public void nextMap() {
		if(this.getRound() < 4) {
			this.setRound(getRound()+1);
			this.setArr(getRound());
		}
	}
	
	public void backMap() {
		if(this.getRound() > 1) {
			this.setRound(getRound()-1);
			this.setArr(getRound());
		}
	}
}