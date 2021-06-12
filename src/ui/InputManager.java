package com.kdat.ui;

import java.awt.event.KeyEvent;

import com.kdat.object.*;

public class InputManager {
	private GameWorld gameWorld;
	
	public InputManager(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	
	public void processKeyPressed(int keyCode) {
		switch(keyCode) {
			case KeyEvent.VK_UP:
				gameWorld.hero.setDirection(Hero.UP_DIR);
				gameWorld.hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_DOWN:
				gameWorld.hero.setDirection(Hero.DOWN_DIR);
				gameWorld.hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_LEFT:
				gameWorld.hero.setDirection(Hero.LEFT_DIR);
				gameWorld.hero.setMovementSpeed(-4);
				break;
			case KeyEvent.VK_RIGHT:
				gameWorld.hero.setDirection(Hero.RIGHT_DIR);
				gameWorld.hero.setMovementSpeed(4);
				break;
			case KeyEvent.VK_3:
				if(gameWorld.b1.isInBattle())
				gameWorld.b1.setHeroChoice(3);
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
				gameWorld.hero.setMovementSpeed(0);
				break;
			default: break;
			case KeyEvent.VK_3:
				gameWorld.b1.setHeroChoice(0);
				break;
		}
	}
}