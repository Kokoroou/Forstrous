import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
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
public class Manager extends JLabel {
	int round = 0;
	Graphics2D g2d;
	JLabel hero,it;
	ImageIcon Hero_down;
	public Manager() {
		//innitManager(g2d);
		//initbackground();
	}
	
		
		public void drawMap1(Graphics2D g2d) {
			Image img;
			img= new ImageIcon(getClass().getResource("/Images/map1.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			}
			
		public void drawMap2(Graphics2D g2d) {
			int arr[][]= {{2,3,0,1,3,4,0,5,1,2,3,0,0,1},
				     {1,0,5,0,2,2,0,0,2,2,0,0,6,5},
				     {0,0,5,0,2,2,4,0,2,2,0,4,5,0},
				     {2,1,1,1,0,3,2,0,5,0,0,3,0,1},
				     {0,2,2,1,0,3,0,4,3,0,5,0,1,1},
				     {2,0,0,1,1,0,0,0,3,4,0,1,1,5},
				     {2,3,0,2,1,1,1,0,3,2,0,1,5,0},
				     {2,0,2,0,2,1,1,1,3,2,1,1,0,3},
				     {0,2,2,3,0,2,0,1,0,0,1,0,2,0},
				     {5,1,1,1,3,3,0,3,0,2,2,4,0,0},
				     {2,2,0,5,0,0,1,1,0,1,1,2,2,2},
				     {1,1,1,2,0,2,0,2,2,4,3,0,0,0},
				     {2,0,0,3,2,1,1,1,1,1,3,0,0,0},
				     {0,3,0,1,1,1,0,5,0,0,5,3,0,5},
				     {0,0,2,1,0,5,0,4,0,2,2,2,3,0},
				     {0,1,0,2,2,0,2,2,2,3,2,2,0,2},
				     {6,1,1,1,5,0,0,2,0,2,0,4,6,2},
			       	{3,4,2,1,1,1,0,0,0,2,3,0,4,0}};
			Image img;
			img= new ImageIcon(getClass().getResource("/Images/map2.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			}
		public void drawMap3(Graphics2D g2d) {
			int arr[][]= {{4,3,0,3,0,1,1,1,1,3,2,0,3,4},
				     {0,0,5,0,2,2,4,0,2,2,0,4,6,0},
				     {1,0,5,0,2,2,0,0,2,2,0,0,5,5},
				     {5,1,1,1,5,0,0,2,0,2,0,4,2,2},
				     {2,1,1,1,0,3,2,0,5,0,0,3,0,1},
				     {0,2,2,1,0,3,0,4,3,0,5,0,1,1},
				     {0,2,2,3,0,2,0,1,0,0,1,0,2,0},
				     {2,2,0,5,0,0,1,1,0,1,1,2,2,2},
				     {2,0,0,3,2,1,1,1,1,1,3,0,0,0},
				     {0,3,0,1,1,1,0,5,0,0,5,3,0,5},
				     {0,0,2,1,0,5,0,4,0,2,2,2,3,0},
				     {2,0,0,1,1,0,0,0,3,4,0,1,1,5},
				     {2,3,0,2,1,1,1,0,3,2,0,1,5,0},
				     {2,0,2,0,2,1,1,1,3,2,1,1,0,3},
				     {5,1,1,1,3,3,0,3,0,2,2,4,0,0},
				     {1,1,1,2,0,2,0,2,2,4,3,0,0,0},
				     {6,1,0,2,2,0,2,2,2,3,2,2,6,2},
			       	{3,4,2,1,1,1,0,0,0,2,3,0,4,0}};
			Image img;
			img= new ImageIcon(getClass().getResource("/Images/map3.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			}
	public void drawMap4(Graphics2D g2d) {
		Image img;
		img= new ImageIcon(getClass().getResource("/Images/map4.png")).getImage();	
		g2d.drawImage(img, 0,0 , null);
		
	}
}
