package object;

import java.awt.*;

import effect.CacheDataLoader;
import effect.FrameImage;
import ui.GameWorld;

/**
 * The Item is the class that used to make an Item object.
 *
 */
public class Item {
	public static final int POTION = 0;
	public static final int SWORD = 2;
	public static final int ARMOR = 3;
	public static final int NECKLACE = 4;
	
	private String name;
    private FrameImage img;
    private boolean isBeingUsed, firstPick;
    private GameWorld gameWorld;
    private int itemType;
    private Monster monster;
    private int attack, hp, luck;
    
	public Item(String name, Monster monster, int itemType, int attack, int hp, int luck) {
		this.name = name;
		this.monster = monster;
		this.itemType = itemType;
		this.attack = attack;
		this.hp = hp;
		this.luck = luck;
		isBeingUsed = false;
		firstPick = true;
		img = CacheDataLoader.getCachedData().getFrameImage(name);
	}

	public boolean getIsBeingUsed() {
		return isBeingUsed;
	}

	public void setIsBeingUsed(boolean isBeingUsed) {
		this.isBeingUsed = isBeingUsed;
	}

	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	public boolean isFirstPick() {
		return firstPick;
	}

	public void setFirstPick(boolean firstPick) {
		this.firstPick = firstPick;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public void draw (Graphics2D g2, int x, int y) {
		img.draw(g2, x+4, y+4);
	}
    
	public void update() {
		if (monster.getCurrentHp()<=0 && getIsBeingUsed() == false) {
			if (itemType != POTION) {
				gameWorld.hero.setAttack(gameWorld.hero.getAttack() + attack);
				gameWorld.hero.setMaxHp(gameWorld.hero.getMaxHp() + hp);
				gameWorld.hero.updateCurrentHp(gameWorld.hero.getCurrentHp() + hp);
				gameWorld.hero.setLuck(gameWorld.hero.getLuck() + luck);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
}
