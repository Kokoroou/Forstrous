package ui;

import java.awt.event.KeyEvent;

import object.*;

public class InputManager {
	private GamePanel gamePanel;
	
	public InputManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void processKeyPressed(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
				gamePanel.getGameWorld().hero.setDirection(Hero.UP_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_DOWN:
				gamePanel.getGameWorld().hero.setDirection(Hero.DOWN_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_LEFT:
				gamePanel.getGameWorld().hero.setDirection(Hero.LEFT_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_RIGHT:
				gamePanel.getGameWorld().hero.setDirection(Hero.RIGHT_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_3:
				System.out.println(1);
				if(gamePanel.getGameWorld().hero.battle)
					gamePanel.getBattle().setHeroChoice(3);
					
				break;
			default: break;
		
		}
	}
	
	public void processKeyReleaseed(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				gamePanel.getGameWorld().hero.setMovementSpeed(0);
				break;
			case KeyEvent.VK_3:
				if(gamePanel.getGameWorld().hero.battle) {
					gamePanel.getBattle().setHeroChoice(0);
				}
				break;
			default: break;
		}
	}
}
