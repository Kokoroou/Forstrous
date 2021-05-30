package enemy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Character {
	protected Point point;
	protected FrameImage frame;
	protected int attack, hp, luck;
	protected float movementSpeed;
	protected boolean alive = true;
	protected String name;
	
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public Character(int attack, int hp, float movementSpeed, int luck, boolean alive, String name) {
		this.attack = attack;
		this.hp = hp;
		this.movementSpeed = movementSpeed;
		this.luck = luck;
		this.alive = alive;
		this.name = name;
	}

	public FrameImage getFrame() {
		return frame;
	}

	public void setFrame(FrameImage frame) {
		this.frame = frame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getAttack() {
		return attack;
	}

	public int getHp() {
		return hp;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public int getLuck() {
		return luck;
	}

	public boolean isAlive() {
		if(hp <= 0) alive = false;
		return alive;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}
	
	protected boolean onHit() {
		
		Random rand = new Random();
		int lucky = rand.nextInt(100) + 1;
		if(lucky < luck)
			return true;
		return false;
	}
	public void moveUp() {
		this.point.setY(point.getY() +(int) movementSpeed);
	}
	public void moveRight() {
		this.point.setX(point.getX() +(int) movementSpeed);
	}
	public void moveDown() {
		this.point.setY(point.getY() -(int) movementSpeed);
	}
	public void moveLeft() {
		this.point.setX(point.getX() -(int) movementSpeed);
	}
}
