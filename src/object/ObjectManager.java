package object;

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
	private List<Item> currItems;
	protected List<Monster> monsters;
	
	private GameWorld gameWorld;

	public ObjectManager(GameWorld gameWorld) {
		items = Collections.synchronizedList(new LinkedList<Item>());
		monsters = Collections.synchronizedList(new LinkedList<Monster>());
		currItems = Collections.synchronizedList(new LinkedList<Item>());
		this.gameWorld = gameWorld;
		numOfPotions = -1;
	}
	
	public void addItem (Item item) {
			synchronized (items) {
				items.add(item);
			}
	}
	
	public void addCurrItem (Item item) {
		if (item.getItemType() == Item.EQUIPMENT)
			synchronized (currItems) {
				currItems.add(item);
			}
		
//		else if (numOfPotions < 0) {
//			currItems.add(item);
//			numOfPotions = numOfPotions + 2;
//		}
		else numOfPotions++;
	}
	
	public void removeItem (Item item) {
		synchronized(currItems){
			if (item.getItemType() == Item.EQUIPMENT)
				for(int id = 1; id < currItems.size(); id++){
					if(currItems.get(id) == item)
						currItems.remove(id);
				}
			else {
				numOfPotions--;
				if (numOfPotions <= 0) numOfPotions = 0;
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
		synchronized (currItems) {
			if (numOfPotions == -1) {
				currItems.add(items.get(0));
				numOfPotions++;
			}
			for(int id = 0; id < items.size(); id++) {
				Item tmp = items.get(id);
				tmp.update();
				if (tmp.getIsPickUp() && tmp.isFirstPick()) {
					addCurrItem(tmp);
					tmp.setFirstPick(false);
				}
				if (tmp.getIsBeingUsed()) removeItem(tmp);
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
			items.get(0).draw(g2, 576, 0);
			g2.drawString(Integer.toString(numOfPotions), 592, 16);
		}
		
		synchronized (currItems) {
			for(int id = 1; id < currItems.size(); id++)
				currItems.get(id).draw(g2, 576 + ((id - 1) % 3) * 32, (id - 1) / 3 * 32 + 32);
		}
		
		synchronized (monsters) {
			for (Monster monster : monsters)
				monster.draw(g2, monster.getRound());
		}
	}
}
