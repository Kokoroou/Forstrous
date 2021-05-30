package game;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Map1 extends JPanel{
	
	public void Map1() {
	}
	public void paint(Graphics g) {
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
					g.drawImage(img, 32*i, 32*j, null);
					break;
			    case 1:
				    img= new ImageIcon(getClass().getResource("/Images/nuoc1.png")).getImage();	
				    g.drawImage(img, 32*i, 32*j, null);
				break;
			    case 2:
					img= new ImageIcon(getClass().getResource("/Images/co2.png")).getImage();	
					g.drawImage(img, 32*i, 32*j, null);
					break;
			    case 3:
					img= new ImageIcon(getClass().getResource("/Images/cay3.png")).getImage();	
					g.drawImage(img, 32*i, 32*j, null);
					break;
			    case 4:
					img= new ImageIcon(getClass().getResource("/Images/cay4.png")).getImage();	
					g.drawImage(img, 32*i, 32*j, null);
					break;
			    case 5:
					img= new ImageIcon(getClass().getResource("/Images/ao5.png")).getImage();	
					g.drawImage(img, 32*i, 32*j, null);
					break;
			    case 6:
					img= new ImageIcon(getClass().getResource("/Images/cua6.png")).getImage();	
					g.drawImage(img, 32*i, 32*j, null);
					break;
				}}}}
}