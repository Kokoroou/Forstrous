package object;

import java.awt.Graphics2D;
import java.util.Random;

public class Monster extends Character {
	
	private float beginX, beginY;
	private float currX, currY;
	private int round;
	private boolean firstWonder;
	
	public Monster() {}

	public Monster(String name, float mapX, float mapY, int maxHp, int attack, int luck, float movementSpeed, GameWorld gameWorld, int round) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
		this.round = round;
		this.setDirection(Character.DOWN_DIR);
		currX = mapX;
		currY = mapY;
		beginX = mapX;
		beginY = mapY;
		firstWonder = false;
//		fullBody = CacheDataLoader.getInstance().getFrameImage(name + "FullBody");
	}

	private int Random(int a[]) {
		Random rand = new Random();
		int dir = rand.nextInt(a.length);
		return a[dir];
	}
	
	private void Wonder() {
		this.setMovementSpeed(0);
		int tileX = (int) this.getMapX() / 32;
		int tileY = (int) this.getMapY() / 32; 
		int dir = Random(canDir[getGameWorld().map.getTile(tileX, tileY)]);
		System.out.println(getName() + ": " + Map.arr1[tileX][tileY] + "   " + getMapX() + "   " + getMapY());
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
		if(getGameWorld().map.getRound() == round)
			this.draw(g2);
	}
	
	@Override
	public void update() {
		if(getGameWorld().map.getRound() == round) {
			if(!onInteract(getGameWorld().hero)){
				if(!firstWonder) {
					Wonder();
					firstWonder = true;
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
					Wonder();
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
		
			else{
				getGameWorld().b1.setMonster(this);
				getGameWorld().b1.setInBattle(true);
			}	
		}
	}

	public float getBeginX() {
		return beginX;
	}

	public float getBeginY() {
		return beginY;
	}

	public void setCurrX(float currX) {
		this.currX = currX;
	}

	public void setCurrY(float currY) {
		this.currY = currY;
	}

	public int getRound() {
		return round;
	}

	public void setFirstWonder(boolean firstWonder) {
		this.firstWonder = firstWonder;
	}
	
}
