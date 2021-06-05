package UI;

import java.awt.event.KeyEvent;

public class GameInput {
	
	GamePanel gamePanel;
	public GameInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void processKeyPressed(int keyCode) {
		
		switch (keyCode) {
		case KeyEvent.VK_UP:

			gamePanel.gameWorld.update(0);
			break;
		case KeyEvent.VK_DOWN:

			gamePanel.gameWorld.update(1);
			break;
		case KeyEvent.VK_LEFT:

			gamePanel.gameWorld.update(2);
			break;
		case KeyEvent.VK_RIGHT:
			
			gamePanel.gameWorld.update(3);
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		case KeyEvent.VK_ENTER:
			
			break;
		}
	}
	public void processKeyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			
			break;
		case KeyEvent.VK_DOWN:
		
			break;
		case KeyEvent.VK_LEFT:
			
			break;
		case KeyEvent.VK_RIGHT:
			
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		case KeyEvent.VK_ENTER:
			
			break;
		}
	}
}
