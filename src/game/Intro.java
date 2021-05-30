package game;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Intro extends JPanel {
	Image img;
	JButton playicon = new JButton();
	ImageIcon playIcon;
	public void Intro() {
	}
	public void paint(Graphics g) {
		img= new ImageIcon(getClass().getResource("/Images/Forstrous.png")).getImage();	
		g.drawImage(img, 0, 0, null);
	    playIcon = new ImageIcon(getClass().getResource("/Images/Play.png"));
	    playicon.setButton(playIcon);
	    add(playicon);
	}
}
