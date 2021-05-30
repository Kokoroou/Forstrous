package game;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
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
public class Manager {
	int round = 1;
	Map1 map1;
	public Manager() {
		innitManager();
		
	}
	public void innitManager() {
		
		switch (round) {
		case 1:
			map1 = new Map1();
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}

	}
	public void draWBackground(Graphics2D g2d) {
		int arr[][]= {{4,3,0,3,0,1,1,1,1,3,2,0,6,4},
			     {6,0,5,0,2,2,4,0,2,2,0,4,5,0},
			     {1,0,5,0,2,2,0,0,2,2,0,0,5,5},
			     {1,1,1,2,0,2,0,2,2,4,3,0,0,0},
			     {2,1,1,1,0,3,2,0,5,0,0,3,0,1},
			     {0,2,2,1,0,3,0,4,3,0,5,0,1,1},
			     {2,0,0,1,1,0,0,0,3,4,0,0,1,5},
			     {2,3,0,2,1,1,1,0,3,2,0,1,5,0},
			     {2,0,2,0,2,1,1,1,3,2,1,0,0,3},
			     {0,2,2,3,0,2,0,1,0,0,1,0,2,0},
			     {2,2,0,5,0,0,1,1,0,1,0,2,2,2},
			     {2,0,0,3,2,1,1,1,1,0,3,0,0,0},
			     {0,3,0,0,1,1,0,5,0,0,5,3,0,5},
			     {0,0,2,1,0,5,0,4,0,2,2,2,3,0},
			     {0,0,1,0,3,3,0,3,0,2,2,4,0,0},
			     {1,1,0,2,2,0,2,2,2,3,2,2,0,2},
			     {6,1,1,1,5,0,0,2,0,2,0,4,2,2},
		       	{1,4,2,0,1,1,0,0,0,2,3,0,4,0}};
	Image img, img1;
		int i, j, kt;
		for(i = 0; i<=17; i++) {
			for( j=0; j<=13; j++) {
				kt = arr[i][j];
				switch (kt) {
				case 0:
					img= new ImageIcon(getClass().getResource("/Images/dat0.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
			    case 1:
				    img= new ImageIcon(getClass().getResource("/Images/nuoc1.png")).getImage();	
				    g2d.drawImage(img, 32*i, 32*j, null);
				break;
			    case 2:
					img= new ImageIcon(getClass().getResource("/Images/co2.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
			    case 3:
					img= new ImageIcon(getClass().getResource("/Images/cay3.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
			    case 4:
					img= new ImageIcon(getClass().getResource("/Images/cay4.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
			    case 5:
					img= new ImageIcon(getClass().getResource("/Images/ao5.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
			    case 6:
					img= new ImageIcon(getClass().getResource("/Images/cua6.png")).getImage();	
					g2d.drawImage(img, 32*i, 32*j, null);
					break;
	}}}}
}
