package game;
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
public class Map extends JLabel {
	int round = 0;
	
	
	public Map() {

	}
	public void drawMap(Graphics2D g2d,int n) {
		Image img;
		switch (n) {
		case 0:
			img= new ImageIcon(getClass().getResource("/Images/map0.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			break;
		case 1: {
			img= new ImageIcon(getClass().getResource("/Images/map1.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			break;
		}
		case 2: {
			img= new ImageIcon(getClass().getResource("/Images/map2.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			break;
		}
		case 3: {
			img= new ImageIcon(getClass().getResource("/Images/map3.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			break;
		}
		case 4: {
			img= new ImageIcon(getClass().getResource("/Images/map4.png")).getImage();	
			g2d.drawImage(img, 0, 0, null);
			break;
		}
		default:
			break;
		}
	}
}
