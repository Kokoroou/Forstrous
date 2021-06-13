package ui;

import object.*;

import java.io.*;
import java.net.URL;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Play{
	
	public static JFrame gameScreen = new JFrame();
	
	public Play() {
		Dimension reqSize = new Dimension(580, 444);
		
		gameScreen.getContentPane().setPreferredSize(reqSize);
		gameScreen.pack();
		
		gameScreen.setTitle("Forstrous");
//		gameScreen.setLayout(null);
//		gameScreen.setResizable(true);
		gameScreen.setLocationRelativeTo(null);
		gameScreen.setDefaultCloseOperation(gameScreen.EXIT_ON_CLOSE);
//		gameScreen.setUndecorated(true);
	}

	public static void main(String[] args) throws IOException {
		
		//Initialize a boss named Demon
		Boss demon = new Boss("Demon", 3, 10);
		Image demonImage = ImageIO.read(new File("src/game/Demon.png"));
		BufferedImage demonMoves = ImageIO.read(new File("src/game/Hero_Character.png")).getSubimage(0, 0, 96, 128);
		demon.setFullBody(demonImage);
		demon.setMoves(demonMoves);
		demon.setHealth(100);
		
		Villagers villager1 = new Villagers("Jasmine", 0, 0);
		Image villager1Face = ImageIO.read(new File("src/game/Jasmine_Face.png"));
		BufferedImage villager1Moves = ImageIO.read(new File("src/game/Jasmine_Character.png")).getSubimage(0, 0, 96, 128);
		villager1.setFace(villager1Face);
		villager1.setMoves(villager1Moves);
		
		Villagers villager2 = new Villagers("Cindy", 0, 0);
		Image villager2Face = ImageIO.read(new File("src/game/Cindy_Face.png"));
		BufferedImage villager2Moves = ImageIO.read(new File("src/game/Cindy_Character.png")).getSubimage(0, 0, 96, 128);
		villager1.setFace(villager2Face);
		villager1.setMoves(villager2Moves);
		
		
		//Start game
		new Play();

//		//Add demon into battle 
//		JLabel img3 = new JLabel(new ImageIcon(heroMoves));
//		img3.setSize(397, 281);
//		img3.setLocation((540 - img3.getWidth()) / 2, (444 - img3.getHeight()) / 2);
//		gameScreen.add(img3);
//		
//		//Add battleback into battle
//		JLabel img1 = new JLabel(new ImageIcon("src/game/RockCave.png"));
//		img1.setSize(580, 444);
//		img1.setLocation(0, 0);
////		img1.setLocation((gameScreen.getWidth() - img1.getWidth()) / 2, (gameScreen.getHeight() - img1.getHeight()) / 2);
//		gameScreen.add(img1);
//		
		JLabel img2 = new JLabel(new ImageIcon("src/game/RockCave1.png")); 
		img2.setSize(580, 444);
		img2.setLocation(0, 0);
//		img2.setLocation((gameScreen.getWidth() - img2.getWidth()) / 2, (gameScreen.getHeight() - img2.getHeight()) / 2);
		gameScreen.add(img2);
		
		
		 
		
		gameScreen.setVisible(true);
		gameScreen.validate();
	}

}
