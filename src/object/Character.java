package object;

import java.awt.Graphics2D;
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
	public int mapX, mapY;
	private int maxHp, currentHp;
	protected FrameImage fullBody, face;
	private int attack, luck;
	private int movementSpeed;
	private boolean alive;
	private boolean talk;
	private String[] sentences;
	private int direction;
	private Animation upAnim, downAnim, leftAnim, rightAnim;
	protected GameWorld gameWorld;
	
	public Character(String name, GameWorld gameWorld) {
		this.name = name;
		this.alive = true;
		this.gameWorld = gameWorld;
		this.fullBody = CacheDataLoader.getCachedData().getFrameImage(name + "FullBody");
		this.face = CacheDataLoader.getCachedData().getFrameImage(name + "Face");
		
		upAnim = CacheDataLoader.getCachedData().getAnimation(name + "Up");
		downAnim = CacheDataLoader.getCachedData().getAnimation(name + "Down");
		leftAnim = CacheDataLoader.getCachedData().getAnimation(name + "Left");
		rightAnim = CacheDataLoader.getCachedData().getAnimation(name + "Right");
	}
	
	public Character(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed, GameWorld gameWorld) {
		this.name = name;
		this.mapX = mapX;
		this.mapY = mapY;
		this.currentHp = maxHp;
		this.maxHp = maxHp;
		this.attack = attack;
		this.luck = luck;
		this.movementSpeed = movementSpeed;
		this.alive = true;
		this.gameWorld = gameWorld;
		this.fullBody = CacheDataLoader.getCachedData().getFrameImage(name + "FullBody");
		this.face = CacheDataLoader.getCachedData().getFrameImage(name + "Face");
		
		upAnim = CacheDataLoader.getCachedData().getAnimation(name + "Up");
		downAnim = CacheDataLoader.getCachedData().getAnimation(name + "Down");
		leftAnim = CacheDataLoader.getCachedData().getAnimation(name + "Left");
		rightAnim = CacheDataLoader.getCachedData().getAnimation(name + "Right");
	}

	public Character() {}

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

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
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
		return this.gameWorld;
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
		switch(this.getDirection()) {
			case DOWN_DIR:
				downAnim.Update(System.nanoTime());
				downAnim.draw(getMapX(), getMapY(), gameWorld.getG2d());
				break;
	
			case LEFT_DIR:
				leftAnim.Update(System.nanoTime());
				leftAnim.draw(getMapX(), getMapY(), g2);
				break;
	
			case RIGHT_DIR:
				rightAnim.Update(System.nanoTime());
				rightAnim.draw(getMapX(), getMapY(), g2);
				break;
	
			case UP_DIR:
				upAnim.Update(System.nanoTime());
				upAnim.draw(getMapX(), getMapY(), g2);
				break;
		}
	}
}
