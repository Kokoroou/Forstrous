package object;

import java.awt.*;

import com.kdat.effect.CacheDataLoader;
import com.kdat.effect.FrameImage;


public class Item {
	public static final int POTION = 0;
	public static final int EQUIPMENT = 1;
	private String name;
    private FrameImage img;
    private boolean pickUp, isBeingUsed, firstPick;
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
		pickUp = false;
		isBeingUsed = false;
		firstPick = true;
		img = CacheDataLoader.getInstance().getFrameImage(name);
	}
	

	public boolean getIsPickUp() {
		return pickUp;
	}


	public void setPickUp(boolean pickUp) {
		this.pickUp = pickUp;
	}


	public boolean getIsBeingUsed() {
		return isBeingUsed;
	}


	public void setIsBeingUsed(boolean isBeingUsed) {
		this.isBeingUsed = isBeingUsed;
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
		if (!monster.isAlive()) pickUp = true;
		
		if (pickUp && isBeingUsed) {
			if (itemType == EQUIPMENT) {
				gameWorld.hero.setAttack(gameWorld.hero.getAttack() + attack);
				gameWorld.hero.setMaxHp(gameWorld.hero.getMaxHp() + hp);
				gameWorld.hero.updateCurrentHp(gameWorld.hero.getCurrentHp() + hp);
				gameWorld.hero.setLuck(gameWorld.hero.getLuck() + luck);
				pickUp = false;
			}
			
			else {
				gameWorld.hero.updateCurrentHp(gameWorld.hero.getCurrentHp() + hp);
				isBeingUsed = false;
			}
		}
	}
}
