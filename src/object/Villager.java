package object;

import java.awt.Graphics2D;
import java.util.Random;

import ui.GameWorld;

/**
 * The Villager is the class that used to make a Villager object.
 *
 */
public class Villager extends Character {
	private int beginX, beginY;
	private int currX, currY;
	private int round;
	private boolean firstWander;
	
	public Villager() {}
	
	public Villager(String name, GameWorld gameWorld) {
		super(name, gameWorld);
	}

	public Villager(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed, GameWorld gameWorld, int round) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
		this.round = round;
		beginX = mapX;
		beginY = mapY;
		currX = mapX;
		currY = mapY;
		firstWander = false;
		this.setDirection(Character.DOWN_DIR);
	}

	/**
	 * This function is used to random pick a direction for villager to move
	 * 
	 */
	private int Random(int a[]) {
		Random rand = new Random();
		if (a.length != 0) {
			int dir = rand.nextInt(a.length);
			return a[dir];
		}
		else {
			return -1;
		}
	}
	
	private void wander() {
		this.setMovementSpeed(0);
		int tileX = (int) this.getMapX() / 32;
		int tileY = (int) this.getMapY() / 32; 
		int dir = Random(canDir[getGameWorld().map.get(gameWorld.getRound()).getTile(tileX, tileY)]);
		switch(dir) {
			case DOWN_DIR:
				setDirection(DOWN_DIR);
				this.setMovementSpeed(1);
				this.setMapX(this.getMapX());
				this.setMapY(this.getMapY() + this.getMovementSpeed());
				break;
			case LEFT_DIR:
				setDirection(LEFT_DIR);
				this.setMovementSpeed(-1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				break;
			case RIGHT_DIR:
				setDirection(RIGHT_DIR);
				this.setMovementSpeed(1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				break;
			case UP_DIR:
				setDirection(UP_DIR);
				this.setMovementSpeed(-1);
				this.setMapX(this.getMapX());
				this.setMapY(this.getMapY() + this.getMovementSpeed());
				break;
			default: break;
		}
	}
	
	public void draw(Graphics2D g2, int round) {
		if(getGameWorld().getRound() == round)
			this.draw(g2);
	}
	
	public int getBeginX() {
		return beginX;
	}

	public int getBeginY() {
		return beginY;
	}

	public void setCurrX(int currX) {
		this.currX = currX;
	}

	public void setCurrY(int currY) {
		this.currY = currY;
	}

	public int getRound() {
		return round;
	}

	public void setFirstWonder(boolean firstWonder) {
		this.firstWander = firstWonder;
	}

	@Override
	public void update() {
		if(getGameWorld().getRound() == round) {
			if(!onInteract(getGameWorld().hero)){
				if(!firstWander) {
					wander();
					firstWander = true;
				}
				
				else if (Math.abs(getMapX() - currX) >= 32 || Math.abs(getMapY() - currY) >= 32){
					switch(getDirection()) {
						case LEFT_DIR:
							setMapX(currX - 32);
							break;
						case RIGHT_DIR:
							setMapX(currX + 32);
							break;
						case UP_DIR:
							setMapY(currY - 32);
							break;
						case DOWN_DIR:
							setMapY(currY + 32);
							break;
					}
					currX = getMapX();
					currY = getMapY();
					wander();
				}
				else {
					switch(getDirection()) {
						case LEFT_DIR:
						case RIGHT_DIR:
							setMapX(getMapX() + getMovementSpeed());
							break;
						case UP_DIR:
						case DOWN_DIR:
							setMapY(getMapY() + getMovementSpeed());
							break;
					}
				}
			}
		
			else {
				//Interact with hero				
			}
		}
	}
}
