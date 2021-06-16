package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import effect.CacheDataLoader;
import effect.FrameImage;
import ui.GameWorld;

/**
 * The ObjectManager is the class that store information about monsters and items
 *
 */
public class ObjectManager {
	protected int numOfPotions;
	protected List<Item> items;
	private List<Item> equippedItems;
	private FrameImage potion;
	
	protected List<Monster> monsters;
	
	private GameWorld gameWorld;

	public ObjectManager(GameWorld gameWorld) {
		items = Collections.synchronizedList(new LinkedList<Item>());
		monsters = Collections.synchronizedList(new LinkedList<Monster>());
		equippedItems = Collections.synchronizedList(new LinkedList<Item>());
		this.gameWorld = gameWorld;
		potion = CacheDataLoader.getCachedData().getFrameImage("Potion");
		numOfPotions = 0;
	}
	
	public void addItem (Item item) {
			synchronized (items) {
				items.add(item);
				item.setGameWorld(gameWorld);
			}
	}
	
	public void addEquippedItem (Item item) {
		if (item.getItemType() == Item.POTION)
				numOfPotions++;

		else 
			synchronized (equippedItems) {
				equippedItems.add(item);
			}
	}
	
	public void removeEquippedItem (Item item) {
		synchronized(equippedItems){
			if (item.getItemType() == Item.POTION) {
				numOfPotions--;
				if (numOfPotions <= 0) numOfPotions = 0;
			}
			else {
				for(int id = 0; id < equippedItems.size(); id++){
					if(equippedItems.get(id) == item)
						equippedItems.remove(id);
				}
			}
		}
	}
	
	public void addMonster (Monster monster) {
		synchronized (monsters) {
			monsters.add(monster);
		}
	}
	
	public void removeMonster (Monster monster) {
		synchronized(monsters){
			for(int id = 0; id < monsters.size(); id++){
				if(monsters.get(id) == monster)
					monsters.remove(id);
			}
		}
	}
	
	public void update() {
		
		synchronized(equippedItems) {
			for(int id = 0; id < items.size(); id++) {
				Item tmp = items.get(id);
				tmp.update();
				if (tmp.isFirstPick() && tmp.getMonster().getCurrentHp()<=0) {                   
					for(int i = 0; i < equippedItems.size(); i++) {
						if(equippedItems.get(i).getItemType() == tmp.getItemType())
							removeEquippedItem(equippedItems.get(i));
					}
					addEquippedItem(tmp);
                    tmp.setFirstPick(false);
                    tmp.setIsBeingUsed(true);
                }
			}
		}
		
		synchronized(monsters) {
			for(int id = 0; id < monsters.size(); id++) {
				Monster tmp = monsters.get(id);
				tmp.update();
				if (!tmp.isAlive()) removeMonster(tmp);
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		if (numOfPotions >= 0) {
			potion.draw(g2, 580, 35);
			g2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			g2.setColor(Color.BLUE);
			g2.drawString(Integer.toString(numOfPotions), 602, 51);
		}
		
		synchronized (equippedItems) {
			for(int id = 0; id < equippedItems.size(); id++)
				equippedItems.get(id).draw(g2, 580 + (id % 3) * 32, id / 3 * 32 + 67);
		}
		
		synchronized (monsters) {
			for (Monster monster : monsters)
				monster.draw(g2, monster.getRound());
		}
	}
	
	public void drawItems(Graphics2D g2) {
		if (numOfPotions >= 0) {
			potion.draw(g2, 580, 35);
			g2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			g2.setColor(Color.BLUE);
			g2.drawString(Integer.toString(numOfPotions), 602, 51);
		}
		
		synchronized (equippedItems) {
			for(int id = 0; id < equippedItems.size(); id++)
				equippedItems.get(id).draw(g2, 580 + (id % 3) * 32, id / 3 * 32 + 67);
		}
	}
}
