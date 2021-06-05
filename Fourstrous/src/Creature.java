package GameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Creature{
	
	protected int mapX;
	protected int mapY;

	protected int HP;
	
	public int maxHP;
	
	public boolean alive;
	
	protected double SPEED;
	
	protected int luck;
	
	protected int attack;
	
	GameWorld gameWorld;
	
	public Creature(int mapX, int mapY, int maxHP, double speed, int luck, int attack, GameWorld gameWorld) {
		this.maxHP = maxHP;
		this.HP = maxHP;
		this.SPEED = speed;
		this.luck = luck;
		this.attack = attack;
		this.mapX = mapX;
		this.mapY = mapY;
		this.gameWorld = gameWorld;
		this.alive = true;
	}
	
	public boolean isAlive(Creature C) {
		return this.alive;
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

	public double getSPEED() {
		return SPEED;
	}

	public void setSPEED(double sPEED) {
		SPEED = sPEED;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}
	
}
