package game;

import java.awt.Image;
import java.util.Random;

public class Character {
	private String name;
	int mapX, mapY;
	int maxHp, currentHp;
	Image fullBody;
	Image face;
	int attack, luck;
	float movementSpeed;
	boolean alive;
	boolean talk;
	String[] sentences;

	public Character() {
		this.name = "Character";
		this.mapX = 0;
		this.mapY = 0;
		this.alive = true;
	}
	public Character(String name, int mapX, int mapY) {
		this.name = name;
		this.mapX = mapX;
		this.mapY = mapY;
		this.alive = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public Image getFullBody() {
		return fullBody;
	}

	public void setFullBody(Image fullBody) {
		this.fullBody = fullBody;
	}

	public Image getFace() {
		return face;
	}

	public void setFace(Image face) {
		this.face = face;
	}

	public boolean isTalk() {
		return talk;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getLuck() {
		return luck;
	}
	
	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	public float getMovementSpeed() {
		return movementSpeed;
	}
	
	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public void setTalk(boolean talk) {
		this.talk = talk;
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}

	public boolean isAlive() {
		if(this.currentHp <= 0) alive = false;
		return alive;
	}

	public boolean onHit() {
		
		Random rand = new Random();
		int lucky = rand.nextInt(100) + 1;
		if(lucky < this.luck)
			return true;
		return false;
	}
	
}
