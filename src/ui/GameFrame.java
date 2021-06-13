package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import effect.*;

public class GameFrame extends JFrame{
	public static final int SCREEN_WIDTH = 776;
	public static final int SCREEN_HEIGHT = 480;
	
	GamePanel gamePanel;
	
	public GameFrame() {
		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		this.setBounds((dimension.width - SCREEN_WIDTH)/2, (dimension.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			CacheDataLoader.getInstance().LoadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		gamePanel = new GamePanel();
		add(gamePanel);
		
		this.addKeyListener(gamePanel);
	}
	
	public void startGame() {
		gamePanel.startGame();
	}
	
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
		gameFrame.setVisible(true);
		gameFrame.startGame();
	}
}
