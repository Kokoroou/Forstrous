package UI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import Effect.CacheDataLoader;

public class GameFrame extends JFrame {

	public static final int SCREEN_HEIGHT = 485;
	public static final int SCREEN_WIDTH = 720;
	GamePanel gamePanel;
	
	public GameFrame() {
		Toolkit toolkit = this.getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		
		try {
			CacheDataLoader.getInstance().LoadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setBounds((dimension.width - SCREEN_WIDTH)/2,(dimension.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gamePanel = new GamePanel(); 
		add(gamePanel);
		this.addKeyListener(gamePanel);
	}
	public void startGame(){

        gamePanel.startGame();
        this.setVisible(true);

	}

}
