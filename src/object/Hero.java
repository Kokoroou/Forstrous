package object;

import effect.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Hero extends Character{

	public static final int beginY[] = {0, 416, 64, 192};
	public static final int endY[] = {416, 64, 192, 416};
	public boolean battle = false;
	
	public Hero() {}
	
	public Hero(String name, GameWorld gameWorld) {
		super(name, gameWorld);
		face = CacheDataLoader.getCachedData().getFrameImage(name + "Face");
	}

	public Hero(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed, GameWorld gameWorld) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
		face = CacheDataLoader.getCachedData().getFrameImage(name + "Face");
	}
	public void equip(Item item) {
		
	}
	
	public void addItem(Item item) {
		
	}
	
	public void useItem(Item item) {
		
	}
	
	@Override
	public void update() {
		boolean canMove[] = {true, true, true, true};
		
		int tileX = (int) getMapX() / 32;
		int tileY = (int) getMapY() / 32;
		
		if (getMapX() % 32 == 0 || getMapY() % 32 == 0)
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX, tileY)])
				canMove[i] = false;
		
		if (getMapX() % 32 == 0 && getMapY() % 32 != 0) {
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX, tileY+1)])
				
				canMove[i] = false;
			canMove[UP_DIR] = true;
			canMove[DOWN_DIR] = true;
		}
		
		if (getMapX() % 32 != 0 && getMapY() % 32 == 0) {
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX+1, tileY)])
				canMove[i] = false;
			canMove[LEFT_DIR] = true;
			canMove[RIGHT_DIR] = true;
		}
		if(getMapX()==0 && getMapY()==beginY[getGameWorld().getRound()-1]) {
			canMove[LEFT_DIR] = true;
		}
		if(getMapX()==544 && getMapY()==endY[getGameWorld().getRound()-1]) {
			canMove[RIGHT_DIR] = true;
		}
		if(canMove[getDirection()])
			switch(getDirection()) {
			case LEFT_DIR:
				if(getMapX()==0 && getMapY()==beginY[getGameWorld().getRound()-1]) {
					getGameWorld().backMap();
					setMapX(544);
				}
				else setMapX(getMapX() + getMovementSpeed());
				break;
			case RIGHT_DIR:
				if(getMapX()==544 && getMapY()==endY[getGameWorld().getRound()-1]) {
					getGameWorld().nextMap();
					setMapX(0);
				}
				else setMapX(getMapX() + getMovementSpeed());
				break;
			case UP_DIR:
			case DOWN_DIR:
				setMapY(getMapY() + getMovementSpeed());
				break;
			}
		else {
			setMapX(getMapX());
			setMapY(getMapY());
			setMovementSpeed(0);
		}
	}
}

