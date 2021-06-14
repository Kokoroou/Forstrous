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
				System.out.println("Pressed UP");
				gamePanel.getGameWorld().hero.setDirection(Hero.UP_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Pressed DOWN");
				gamePanel.getGameWorld().hero.setDirection(Hero.DOWN_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("Pressed LEFT");
				gamePanel.getGameWorld().hero.setDirection(Hero.LEFT_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("Pressed RIGHT");
				gamePanel.getGameWorld().hero.setDirection(Hero.RIGHT_DIR);
				gamePanel.getGameWorld().hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_1:
				System.out.println("Pressed 1");
				if(gamePanel.getGameWorld().hero.inBattle) {
					gamePanel.getBattle().setHeroChoice(1);
					gamePanel.getControl().showGamePanel();
				}
				break;
			case KeyEvent.VK_2:
				System.out.println("Pressed 2");
				if(gamePanel.getGameWorld().hero.inBattle)
					gamePanel.getBattle().setHeroChoice(2);
					
				break;
			case KeyEvent.VK_3:
				System.out.println("Pressed 3");
				if(gamePanel.getGameWorld().hero.inBattle)
					gamePanel.getBattle().setHeroChoice(3);
					
				break;
			default: break;
		
		}
		if(gamePanel.getBattle().isBattling()) {
			gamePanel.getBattle().update();
		}
	}
	
	public void processKeyReleased(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				gamePanel.getGameWorld().hero.setMovementSpeed(0);
				break;
				
			case KeyEvent.VK_1:
				if(gamePanel.getBattle().isBattling()) {
					gamePanel.getBattle().update();
				}
				break;
			case KeyEvent.VK_2:
				if(gamePanel.getBattle().isBattling()) {
					gamePanel.getBattle().update();
				}
				break;
			case KeyEvent.VK_3:
				if(gamePanel.getGameWorld().hero.inBattle) {
					gamePanel.getBattle().setHeroChoice(0);
				}
				break;
			case KeyEvent.VK_4:
				if(gamePanel.getGameWorld().hero.inBattle) {
					gamePanel.getBattle().update();
				}
				break;
			default: break;
		}
	}
}
