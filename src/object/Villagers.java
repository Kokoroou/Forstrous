package object;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Villagers {
	private Image fullBody;
	private Image face;
	private String name;
	private String sentence;
	private int timer;
	private int mapX;
	private int mapY;
	private BufferedImage moves;
	private Image[] moveDown = new Image[3];
	private Image[] moveLeft = new Image[3];
	private Image[] moveRight = new Image[3];
	private Image[] moveUp = new Image[3];
	private boolean talk;
	
	public Villagers() {
		this.name = "Villager";
		this.mapX = 0;
		this.mapY = 0;
	}
	public Villagers(int mapX, int mapY) {
		this.name = "Villager";
		this.mapX = mapX;
		this.mapY = mapY;
	}
	public Villagers(String name, int mapX, int mapY) {
		this.name = name;
		this.mapX = mapX;
		this.mapY = mapY;
	}
	
	public Image getFullBody() {
		return this.fullBody;
	}
	public void setFullBody(Image fullBody) {
		this.fullBody = fullBody;
	}
	public Image getFace() {
		return this.face;
	}
	public void setFace(Image face) {
		this.face = face;
	}
	
	public int getmapX() {
		return mapX;
	}
	public int getmapY() {
		return mapY;
	}
	public void setmapX(int mapX) {
		this.mapX = mapX;
	}
	public void setmapY(int mapY) {
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
	
	public void talk(Player player, int delta) {}
}
