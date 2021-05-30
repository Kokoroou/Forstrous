package game;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class FrameScreen extends JFrame{
	GameScreen gameScreen;
	Intro intro;
	public FrameScreen() {
		intro = new Intro();
		add(intro);
		//gameScreen = new GameScreen(); 	
		//add(gameScreen);
	}
}