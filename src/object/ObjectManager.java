package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The ObjectManager is the class that store information about monsters and items
 *
 */
public class ObjectManager {
	protected int numOfPotions;
	protected List<Item> items;
	private List<Item> unequipItems;
	private List<Item> equippedItems;
	
	protected List<Monster> monsters;
	
	private GameWorld gameWorld;

	public ObjectManager(GameWorld gameWorld) {
		items = Collections.synchronizedList(new LinkedList<Item>());
		monsters = Collections.synchronizedList(new LinkedList<Monster>());
		unequipItems = Collections.synchronizedList(new LinkedList<Item>());
		equippedItems = Collections.synchronizedList(new LinkedList<Item>());
		this.gameWorld = gameWorld;
		numOfPotions = -1;
	}
	
	public void addItem (Item item) {
			synchronized (items) {
				items.add(item);
			}
	}
	
	public void addCurrItem (Item item) {
		if (item.getItemType() == Item.POTION)
				numOfPotions++;
		
//		else if (numOfPotions < 0) {
//			currItems.add(item);
//			numOfPotions = numOfPotions + 2;
//		}
		else 
			synchronized (unequipItems) {
				unequipItems.add(item);
			}
	}
	
	public void removeUnequipItem (Item item) {
		synchronized(unequipItems){
			if (item.getItemType() == Item.POTION) {
				numOfPotions--;
				if (numOfPotions <= 0) numOfPotions = 0;
			}
			else {
				for(int id = 1; id < unequipItems.size(); id++){
					if(unequipItems.get(id) == item)
						unequipItems.remove(id);
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
		synchronized (unequipItems) {
			if (numOfPotions == -1) {
				unequipItems.add(items.get(0));
				numOfPotions++;
			}
			for(int id = 0; id < items.size(); id++) {
				Item tmp = items.get(id);
				tmp.update();
				if (tmp.getIsPickUp() && tmp.isFirstPick()) {
					addCurrItem(tmp);
					tmp.setFirstPick(false);
				}
				
				if (tmp.getIsBeingUsed()) {
					removeUnequipItem(tmp);
					if(tmp.getItemType() != Item.POTION) {
						for (int i=0; i<equippedItems.size(); i++)
							if (equippedItems.get(i).getItemType() == tmp.getItemType())
								equippedItems.remove(i);
						equippedItems.add(tmp);
					}
					else tmp.setIsBeingUsed(false);
				}
				
				if(!tmp.getIsPickUp() && !tmp.getIsBeingUsed() && !tmp.isFirstPick() && tmp.getItemType() != Item.POTION)
					addCurrItem(tmp);
			}
		}
		
		synchronized(monsters) {
			for(int id = 0; id < monsters.size(); id++) {
				Monster tmp = monsters.get(id);
				tmp.update();
				if (!tmp.isAlive()) removeMonster(tmp);
			}
		}
//		System.out.println("Potion: " + numOfPotions);
//		System.out.println("equipment: "+ currItems.size());
//		for (Item i : currItems)
//			System.out.println(i.getName());
	}
	
	public void draw (Graphics2D g2) {
		if (numOfPotions >= 0) {
			items.get(0).draw(g2, 580, 35);
			g2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			g2.setColor(Color.BLUE);
			g2.drawString(Integer.toString(numOfPotions), 602, 51);
		}
		
		synchronized (unequipItems) {
			for(int id = 1; id < unequipItems.size(); id++)
				unequipItems.get(id).draw(g2, 580 + ((id - 1) % 3) * 32, (id - 1) / 3 * 32 + 67);
		}
		
		synchronized (equippedItems) {
			for(int id = 1; id < equippedItems.size(); id++)
				equippedItems.get(id).draw(g2, 580 + ((id - 1) % 3) * 32, (id - 1) / 3 * 32 + 147);
		}
		
		synchronized (monsters) {
			for (Monster monster : monsters)
				monster.draw(g2, monster.getRound());
		}
	}
	
	public void drawItems(Graphics2D g2) {
		if (numOfPotions >= 0) {
			items.get(0).draw(g2, 580, 35);
			g2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			g2.setColor(Color.BLUE);
			g2.drawString(Integer.toString(numOfPotions), 602, 51);
		}
		
		synchronized (unequipItems) {
			for(int id = 1; id < unequipItems.size(); id++)
				unequipItems.get(id).draw(g2, 580 + ((id - 1) % 3) * 32, 35 + (id - 1) / 3 * 32 + 32);
		}
	}
}
