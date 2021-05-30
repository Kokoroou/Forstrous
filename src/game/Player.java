package game;

import java.awt.*;

public class Player {
	public int max_health;
	private Image player;
	private double mapX;
	private double mapY;
	private double screenX;
	private double screenY;
	private double speed;
	private int health;
	private int damage;
	private int coolDown;
	private int item_num;
	private int timer;
	private boolean flip;
	private boolean interact;
	private boolean attack;
	
	public double getmapX() {
		return this.mapX;
	}
	public double getmapY() {
		return this.mapY;
	}
	public void setmapX(double mapX) {}
	public void setmapY(double mapY) {}
	public double getscreenX() {
		return this.screenX;
	}
	public double getscreenY() {
		return this.screenY;
	}
	public void setscreenX(double screenX) {}
	public void setscreenY(double screenY) {}
	public int getHealth() {
		return this.health;
	}
	public void updateHealth(int health) {}
	public void setHealth(int health) {}
	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int bonus) {}
	public int getCooldown() {
		return this.coolDown;
	}
	public void setCooldown(int reduce) {}
	public void addItem(Item item) {}
//	public Items[] getItem() {
//		return;
//	}
	public boolean getInteract() {
		return this.interact;
	}
	public boolean setInteract() {
		return this.interact;
	}
	public boolean getAttack() {
		return this.attack;
	}
	public boolean setAttack(boolean hit) {
		return hit;
	}
	public int getHit(int delta) {
		return delta;
	}
	
	public void render() {}
}
