package object;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import effect.Animation;
import effect.CacheDataLoader;
import effect.FrameImage;

public abstract class Character {
    public static final int DOWN_DIR = 0;
	public static final int LEFT_DIR = 1;
    public static final int RIGHT_DIR = 2;
    public static final int UP_DIR = 3;
    public static final int[][] canDir = {
    		{}, 									//0
    		{LEFT_DIR}, 							//1
    		{RIGHT_DIR}, 							//2
    		{LEFT_DIR, RIGHT_DIR}, 					//3
    		{DOWN_DIR}, 							//4
    		{DOWN_DIR, LEFT_DIR},					//5
    		{DOWN_DIR, RIGHT_DIR}, 					//6
    		{DOWN_DIR, LEFT_DIR, RIGHT_DIR}, 		//7
    		{UP_DIR}, 								//8
    		{UP_DIR, LEFT_DIR}, 					//9
    		{UP_DIR, RIGHT_DIR}, 					//10
    		{UP_DIR, LEFT_DIR, RIGHT_DIR}, 			//11
    		{UP_DIR, DOWN_DIR}, 					//12
    		{UP_DIR, DOWN_DIR, LEFT_DIR}, 			//13
    		{UP_DIR, DOWN_DIR, RIGHT_DIR}, 			//14
    		{UP_DIR, DOWN_DIR, RIGHT_DIR, LEFT_DIR},//15
    	};
	
	private String name;
	private float mapX, mapY;
	private int maxHp, currentHp;
	private FrameImage fullBody, face;
	private int attack, luck;
	private float movementSpeed;
	private boolean alive;
	private boolean talk;
	private String[] sentences;
	private int direction;
	private Animation upAnim, downAnim, leftAnim, rightAnim;
	private GameWorld gameWorld;
	
	public Character(String name, float mapX, float mapY, int maxHp, int attack, int luck, float movementSpeed, GameWorld gameWorld) {
		this.name = name;
		this.mapX = mapX;
		this.mapY = mapY;
		this.maxHp = maxHp;
		this.attack = attack;
		this.luck = luck;
		this.movementSpeed = movementSpeed;
		this.alive = true;
		this.gameWorld = gameWorld;
		fullBody = CacheDataLoader.getInstance().getFrameImage(name + "FullBody");
		face = CacheDataLoader.getInstance().getFrameImage(name + "Face");
		upAnim = CacheDataLoader.getInstance().getAnimation(name + "Up");
		downAnim = CacheDataLoader.getInstance().getAnimation(name + "Down");
		leftAnim = CacheDataLoader.getInstance().getAnimation(name + "Left");
		rightAnim = CacheDataLoader.getInstance().getAnimation(name + "Right");
	}

	public Character() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMapX() {
		return mapX;
	}

	public void setMapX(float mapX) {
		this.mapX = mapX;
	}

	public float getMapY() {
		return mapY;
	}

	public void setMapY(float mapY) {
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

	public void updateCurrentHp(int currentHp) {
		if (currentHp <= 0) currentHp = 0;
		if (currentHp >= maxHp) currentHp = maxHp;
		this.currentHp = currentHp;
	}

	public FrameImage getFullBody() {
		return fullBody;
	}

	public void setFullBody(FrameImage fullBody) {
		this.fullBody = fullBody;
	}

	public FrameImage getFace() {
		return face;
	}

	public void setFace(FrameImage face) {
		this.face = face;
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isTalk() {
		return talk;
	}

	public void setTalk(boolean talk) {
		this.talk = talk;
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	};
	
	public void setDirection(int dir){
        direction = dir;
    }
    
    public int getDirection(){
        return direction;
    }
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	protected boolean onHit() {
		Random rand = new Random();
		int lucky = rand.nextInt(100) + 1;
		if(lucky < luck)
			return true;
		return false;
	}
	
	protected boolean onInteract(Character character) {
		if(Math.abs(mapX - character.mapX) <= 32 && Math.abs(mapY - character.mapY) <= 32)
			return true;
		return false;
	}
	
	public abstract void update();
	
	public void draw (Graphics2D g2) {
		if(!getGameWorld().b1.isInBattle())
		switch(this.getDirection()) {
		case DOWN_DIR:
			downAnim.Update(System.nanoTime());
			downAnim.draw((int)getMapX(), (int)getMapY(), g2);
			break;

		case LEFT_DIR:
			leftAnim.Update(System.nanoTime());
			leftAnim.draw((int)getMapX(), (int)getMapY(), g2);
			break;

		case RIGHT_DIR:
			rightAnim.Update(System.nanoTime());
			rightAnim.draw((int)getMapX(), (int)getMapY(), g2);
			break;

		case UP_DIR:
			upAnim.Update(System.nanoTime());
			upAnim.draw((int)getMapX(), (int)getMapY(), g2);
			break;
		}
	}
}
