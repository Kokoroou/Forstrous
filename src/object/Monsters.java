package object;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monsters {
	public boolean alive;
	private Image fullBody;
	private int mapX;
	private int mapY;
	private BufferedImage moves;
	private Image[] moveDown = new Image[3];
	private Image[] moveLeft = new Image[3];
	private Image[] moveRight = new Image[3];
	private Image[] moveUp = new Image[3];
	private Image currentStand;
	private int health;
	private int current_health;
	private String name;
	
	public Monsters() {
		this.alive = true;
		this.mapX = 0;
		this.mapY = 0;
		this.name = "Monster";
	}
	public Monsters(int mapX, int mapY) {
		this.alive = true;
		this.mapX = mapX;
		this.mapY = mapY;
		this.name = "Monster";
	}
	public Monsters(String name, int mapX, int mapY) {
		this.alive = true;
		this.mapX = mapX;
		this.mapY = mapY;
		this.name = name;
	}
	
	public void setAlive() {
		this.alive = true;
	}
	public void setDead() {
		this.alive = false;
	}
	
	public Image getFullBody() {
		return this.fullBody;
	}
	public void setFullBody(Image fullBody) {
		this.fullBody = fullBody;
	}
	
	public int getMapX() {
		return this.mapX;
	}
	public int getMapY() {
		return this.mapY;
	}
	public void setMapX(int mapX) {
		this.mapX = mapX;
	}
	public void setMapY(int mapY) {
		this.mapY = mapY;
	}
	
	public BufferedImage getMoves() {
		return this.moves;
	}
	public void setMoves(BufferedImage moves) {
		this.moves = moves;
		this.moveDown[0] = moves.getSubimage(0, 0, 32, 32);
		this.moveDown[1] = moves.getSubimage(32, 0, 32, 32);
		this.moveDown[2] = moves.getSubimage(64, 0, 32, 32);
		this.moveLeft[0] = moves.getSubimage(0, 32, 32, 32);
		this.moveLeft[1] = moves.getSubimage(32, 32, 32, 32);
		this.moveLeft[2] = moves.getSubimage(64, 32, 32, 32);
		this.moveRight[0] = moves.getSubimage(0, 64, 32, 32);
		this.moveRight[1] = moves.getSubimage(32, 64, 32, 32);
		this.moveRight[2] = moves.getSubimage(64, 64, 32, 32);
		this.moveUp[0] = moves.getSubimage(0, 96, 32, 32);
		this.moveUp[1] = moves.getSubimage(32, 96, 32, 32);
		this.moveUp[2] = moves.getSubimage(64, 96, 32, 32);
	}
	public void moveDown() {
		
	}
	public void moveLeft() {
		
	}
	public void moveRight() {
		
	}
	public void moveUp() {
		
	}
	public Image display() {
		try
		{
			return this.currentStand;
		}
		catch(Exception e)
		{
			this.currentStand = this.moveDown[0];
			return this.currentStand;
		}
		
	}
	
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
		this.current_health = health;
	}
	
	public int getCurrentHealth() {
		return this.current_health;
	}
	public void updateHealth(int delta) {
		this.current_health -= delta;
	}	
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void hit(int hit) {}
	
	
	
}
