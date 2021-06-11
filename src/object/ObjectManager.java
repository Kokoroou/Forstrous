package com.kdat.object;

import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.kdat.ui.GameFrame;

public class ObjectManager {
	protected int numOfPotions;
	protected List<Item> items;
	
	private GameWorld gameWorld;

	public ObjectManager(GameWorld gameWorld) {
		items = Collections.synchronizedList(new LinkedList<Item>());
		this.gameWorld = gameWorld;
		numOfPotions = 0;
	}
	
	public void addItem (Item item) {
		if (item.getItemType() == Item.EQUIPMENT)
			synchronized (items) {
				items.add(item);
			}
		
		else
			numOfPotions++;
	}
	
	public void removeItem (Item item) {
		synchronized(items){
			if (item.getItemType() == Item.EQUIPMENT)
				for(int id = 1; id < items.size(); id++){
					if(items.get(id) == item)
						items.remove(id);
				}
			else {
				numOfPotions--;
				if (numOfPotions <= 0) numOfPotions = 0;
			}
		}
	}
	
	public void update() {
		synchronized (items) {
			for(int id = 0; id < items.size(); id++) {
				Item tmp = items.get(id);
				tmp.update();
				if (tmp.getIsBeingUsed()) removeItem(tmp);
			}
		}
	}
	
	public void draw (Graphics2D g2) {
		if (numOfPotions >= 0)
			items.get(0).draw(g2, 576, 0);
		
		synchronized (items) {
			for(int id = 1; id < items.size(); id++)
				items.get(id).draw(g2, 576 + (id % 3 - 1) * 32, 32 + (id - 1) / 3);
		}
	}
}
