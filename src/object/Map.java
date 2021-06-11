package object;

import java.awt.Color;

import javax.imageio.ImageIO;
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
	
	public static final int arr1[][]= {{6,14,10,0,0,0,0,0,0,0,0,0,0,0},
									{7,15,11,0,6,14,14,14,14,14,14,10,0,0},
									{5,15,11,0,7,15,15,15,15,15,15,11,0,0},
									{0,5,15,14,15,15,15,15,15,15,15,11,0,0},
									{0,0,7,15,15,15,15,15,15,15,15,11,0,0},
									{4,12,13,13,15,15,15,15,15,15,15,11,0,0},
									{0,0,0,0,7,15,15,15,15,15,15,11,0,0},
									{0,6,14,14,15,15,15,13,13,15,15,15,14,10},
									{0,7,15,15,15,15,11,0,0,7,15,15,15,11},
									{0,7,15,15,15,15,11,0,0,7,15,15,15,9},
									{0,7,15,15,15,15,11,0,0,7,15,15,11,0},
									{6,15,15,15,15,15,15,10,0,7,13,13,9,0},
									{5,13,15,15,15,15,15,15,14,11,0,0,0,0},
									{1,0,7,15,15,15,15,15,15,15,14,10,0,0},
									{2,0,7,15,15,15,15,15,15,15,15,15,10,0},
									{6,14,15,15,15,15,15,15,15,15,15,15,15,10},
									{7,13,13,15,15,15,15,15,15,15,15,15,15,11},
									{1,0,0,5,13,13,13,13,13,13,13,13,13,11}}
;
	
	public static final int  arr2[][]= {{6,14,14,14,14,14,14,14,14,14,14,14,14,11},
										{7,15,15,15,13,13,15,15,15,15,15,15,15,9},
										{7,15,15,11,0,0,7,15,15,15,15,15,11,0},
										{7,15,15,15,14,14,15,15,15,15,15,15,11,0},
										{7,15,15,15,15,15,15,15,15,15,15,15,11,0},
										{7,15,15,15,15,15,15,15,15,15,15,15,9,0},
										{7,15,15,13,15,15,15,15,15,15,15,9,0,0},
										{5,15,11,0,5,13,15,15,15,15,11,0,0,0},
										{0,7,11,0,0,0,5,15,15,15,11,0,0,0},
										{0,7,11,0,0,0,0,5,15,15,15,10,0,0},
										{0,7,11,0,0,0,0,0,7,15,15,15,10,0},
										{0,7,11,0,0,0,0,0,7,15,15,15,11,0},
										{0,7,11,0,0,0,6,14,15,15,15,15,11,0},
										{0,7,11,0,0,6,15,15,15,15,15,15,9,0},
										{0,5,15,14,14,15,15,15,15,15,15,11,0,0},
										{0,0,7,15,15,15,15,15,15,15,15,11,0,0},
										{0,0,7,13,13,13,13,13,13,13,13,9,0,0},
										{0,0,3,0,0,0,0,0,0,0,0,0,0,0}};
	
	public static final int arr3[][]= {{6,14,15,14,14,14,12,8,0,0,0,0,0,0},
										{5,15,15,15,15,11,0,0,0,0,0,0,0,0},
										{0,5,15,15,15,15,14,14,14,14,14,14,10,0},
										{0,0,7,15,15,15,15,15,15,15,15,15,11,0},
										{0,4,15,15,15,15,15,15,15,15,15,15,15,10},
										{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
										{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
										{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
										{4,12,15,15,15,15,15,15,15,15,15,15,15,11},
										{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
										{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
										{6,14,15,15,15,15,15,15,15,15,15,15,15,9},
										{7,15,15,15,15,15,15,15,15,15,15,15,9,0},
										{7,15,15,15,15,15,15,15,15,15,15,11,0,0},
										{7,15,15,13,13,15,15,15,15,15,15,11,0,0},
										{7,15,11,0,0,5,15,15,15,15,15,11,0,0},
										{7,15,11,0,0,0,7,15,15,15,15,11,0,0},
										{5,13,13,12,12,12,15,13,13,13,13,13,12,8}};
	
	public static final int arr4[][]= {{6,14,14,14,14,14,15,14,14,14,14,14,14,10},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
										{5,13,13,13,13,13,13,13,13,13,13,13,13,9}};
	
	private int round;
//	private int hold[][];
	private int arr[][];

	public Map() {
		
		this.round = 1;
		setArr(1);
	}
	
	public int getTile(int tileX, int tileY) {
		return this.arr[tileX][tileY];
	}
	
	public void drawMap(Graphics2D g2d, int round2) {
		BufferedImage img;
		switch (getRound()) {
		case 1: {
			try {
				img = ImageIO.read(new File("image/map1.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}			
			break;
		}
		case 2: {
			try {
				img = ImageIO.read(new File("image/map2.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		case 3: {
			try {
				img = ImageIO.read(new File("image/map3.png"));
				g2d.drawImage(img, 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			break;
		}
		case 4: {
			try {
				img = ImageIO.read(new File("image/map4.png"));
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
	

	public int[][] getArr() {
		return this.arr;
	}

	public void setArr(int round) {
		switch (round) {
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
