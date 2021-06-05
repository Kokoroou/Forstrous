package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import GameObject.GameWorld;
import GameObject.Hero;
import GameObject.Map;

public class GamePanel extends JPanel implements Runnable, KeyListener {
	
	Thread thread;
	
	private GameInput gameInput;
	
	public boolean isRunning = true;
	
	private BufferedImage bufImage;
	private Graphics2D bufG2D;
	
	GameWorld gameWorld = new GameWorld();
	
	public GamePanel() {
		
		gameInput = new GameInput(this); 
		bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bufImage, 0, 0, this);
		
	}
	
	public void UpdateGame() {
		
	}
	
	public void RenderGame() {
		if (bufImage == null)
			bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		
		if (bufImage != null)
			bufG2D = (Graphics2D)(bufImage.getGraphics());
		
		if (bufG2D != null) {
			
			bufG2D.setColor(Color.WHITE);
			bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
			
			gameWorld.drawGameWorld(bufG2D);
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		gameInput.processKeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		gameInput.processKeyReleased(e.getKeyCode());
	}

	public void startGame() {
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		long beginTime = System.nanoTime();;
		long sleepTime;
		long deltaTime;
		
		long period = 1000*1000000/30;
		
		while (isRunning) {
			
			UpdateGame();
			RenderGame();

			repaint();
			
			
			deltaTime = System.nanoTime() - beginTime;
			sleepTime = period - deltaTime;
			
			try {
				if (sleepTime > 0)
					Thread.sleep(sleepTime/1000000);
				else Thread.sleep(period/2000000);
			} catch (InterruptedException ex) {}
			
			beginTime = System.nanoTime();
		}
	}

}
