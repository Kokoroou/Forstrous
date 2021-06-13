package object;

import java.awt.Graphics2D;
import java.util.Random;

import effect.CacheDataLoader;

public class Monster extends Character {
	
	private int beginX, beginY;
	private int currX, currY;
	private int round;
	private boolean firstWander;
	
	public Monster() {}

	public Monster(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed, GameWorld gameWorld, int round) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
		this.round = round;
		this.setDirection(Character.DOWN_DIR);
		currX = mapX;
		currY = mapY;
		beginX = mapX;
		beginY = mapY;
		firstWander = false;
		fullBody = CacheDataLoader.getCachedData().getFrameImage(name + "FullBody");
	}

	private int Random(int a[]) {
		Random rand = new Random();
		int dir = rand.nextInt(a.length);
		return a[dir];
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
				//System.out.println("Downing");
				break;
			case LEFT_DIR:
				setDirection(LEFT_DIR);
				this.setMovementSpeed(-1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				//System.out.println("Lefting");
				break;
			case RIGHT_DIR:
				setDirection(RIGHT_DIR);
				this.setMovementSpeed(1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				//System.out.println("Righting");
				break;
			case UP_DIR:
				setDirection(UP_DIR);
				this.setMovementSpeed(-1);
				this.setMapX(this.getMapX());
				this.setMapY(this.getMapY() + this.getMovementSpeed());
				//System.out.println("Uping");
				break;
			default: break;
		}
	}
	
	public void draw(Graphics2D g2, int round) {
		if(getGameWorld().getRound() == round)
			this.draw(g2);
	}
	
	@Override
	public void update() {
		if(getGameWorld().getRound() == round && this.isAlive()) {
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
				gameWorld.getGamePanel().getBattle().setMonster(this);
				gameWorld.getGamePanel().getBattle().setBattling(true);
				gameWorld.hero.inBattle = true;
				gameWorld.getGamePanel().getControl().showGamePanel();
				gameWorld.getGamePanel().showBattle();
				
			}	
		}
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
	
}
