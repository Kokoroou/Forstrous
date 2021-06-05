package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Effect.Animation;
import Effect.CacheDataLoader;
import Effect.FrameImage;
import UI.GameFrame;


public class Hero extends Creature{
	
	private FrameImage image1 = CacheDataLoader.getInstance().getFrameImage("up0");
	private BufferedImage up = image1.getImage();
	private FrameImage image2 = CacheDataLoader.getInstance().getFrameImage("down0");
	private BufferedImage down = image2.getImage();
	private FrameImage image3 = CacheDataLoader.getInstance().getFrameImage("left0");
	private BufferedImage left = image3.getImage();
	private FrameImage image4 = CacheDataLoader.getInstance().getFrameImage("right0");
	private BufferedImage right = image4.getImage();
	
	private int dir = 0;
	
	public boolean battle = false;
	
	//private Animation upAnim = CacheDataLoader.getInstance().getAnimation("up");
	//private Animation downAnim = CacheDataLoader.getInstance().getAnimation("down");
	//private Animation leftAnim = CacheDataLoader.getInstance().getAnimation("left");
	//private Animation rightAnim = CacheDataLoader.getInstance().getAnimation("right");
	
	//private Item[] Items = new Item[4];
	
	public Hero(int mapX, int mapY, int maxHP, double speed, int luck, int attack, GameWorld gameWorld) {
		super(mapX, mapY, maxHP, speed, luck, attack, gameWorld);
		
	}
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public void draw(Graphics2D g2, int dir) {
		switch(dir) {
		case 0:
			g2.drawImage(up, getMapX(), getMapY(), null);
			break;
		case 1:
			g2.drawImage(down, getMapX(), getMapY(), null);
			break;
		case 2:
			g2.drawImage(left, getMapX(), getMapY(), null);
			break;
		case 3:
			g2.drawImage(right, getMapX(), getMapY(), null);
			break;
		}
		
	}
	
	public void equip(Item item) {
		
	}
	
	public void addItem(Item item) {
		
	}
	
	public void useItem(Item item) {
		
	}
	
	public void update() {
		
	}
	
	public boolean canMove(int dir) {
		switch (dir) {
		case 0: 
			if(getMapY() <= 0) return false;
			if(gameWorld.map.getTile(getMapX()/32, getMapY()/32-1)==1) return false;
			break;
		case 1: 
			if((getMapY()+32) >= 448) return false;
				if(gameWorld.map.getTile(getMapX()/32, getMapY()/32+1)==1) return false;
			break;
		case 2:
			if(getMapX() <= 0)  return false;
			if(gameWorld.map.getTile(getMapX()/32-1, getMapY()/32)==1) return false;
			break;
		case 3:
			if((getMapX()+32) >= 576)  return false;
			if(gameWorld.map.getTile(getMapX()/32+1, getMapY()/32)==1) return false;
			break;
		default:
			break;
		}
		return true;
	}

	public void move(int dir) {
		setDir(dir);
		switch (dir) {
			case 0: 
				if (canMove(dir))
					setMapY(getMapY()-32);
				break;
			case 1:
				if (canMove(dir))
					setMapY(getMapY()+32);
				break;
			case 2:
				if (canMove(dir))
					setMapX(getMapX()-32);
				break;
			case 3:
				
				if (canMove(dir))
					setMapX(getMapX()+32);
				break;
			default: 
				break;
		}
	}
}

