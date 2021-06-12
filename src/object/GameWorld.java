package object;

import java.awt.Graphics2D;

public class GameWorld {
	
	public Map map;
	public Hero hero;
	public Battle b1;
	public ObjectManager objectManager;
	
	public GameWorld() {
		map = new Map();
		hero = new Hero("hero", 0, 0, 500, 30, 50, 0, this);
		b1 = new Battle(hero);
		objectManager = new ObjectManager(this);
		initMonsterAndItem();
		
	}
	
	private void initMonsterAndItem() {
		Monster slime = new Monster("slime", 32, 352, 60, 15, 25, 0, this, 1);
		objectManager.addMonster(slime);
		
		Monster bat = new Monster("bat", 352, 0, 80, 20, 30, 0, this, 1);
		objectManager.addMonster(bat);
		
		Monster plant = new Monster("plant", 512, 416, 100, 25, 35, 0, this, 1);
		objectManager.addMonster(plant);
		
		Monster gayzer = new Monster("gayzer", 544, 64, 175, 50, 50, 0, this, 2);
		objectManager.addMonster(gayzer);
		
		Monster skeleton = new Monster("skeleton", 32, 352, 150, 55, 52, 0, this, 2);
		objectManager.addMonster(skeleton);
		
		Monster ghost = new Monster("ghost", 288, 224, 200, 60, 55, 0, this, 2);
		objectManager.addMonster(ghost);
		
		Monster scorpion = new Monster("scorpion", 256, 0, 400, 85, 67, 0, this, 3);
		objectManager.addMonster(scorpion);
		
		Monster ifrit = new Monster("ifrit", 544, 64, 450, 90, 70, 0, this, 3);
		objectManager.addMonster(ifrit);
		
		Monster gayzer1 = new Monster("gayzer", 64, 352, 350, 80, 60, 0, this, 3);
		objectManager.addMonster(gayzer1);
		
		Monster skeleton1 = new Monster("skeleton", 320, 320, 300, 75, 63, 0, this, 3);
		objectManager.addMonster(skeleton1);
		
		Item potion = new Item("potion", slime, Item.POTION, 0, 50, 0);
		objectManager.items.add(potion);
		
		Item sword = new Item("sword", slime, Item.EQUIPMENT, 0, 50, 0);
		objectManager.addItem(sword);
		
	}
	
	public void drawGameWorld(Graphics2D g2){
		map.drawMap(g2);
		b1.draw(g2);
		hero.draw(g2);
		objectManager.draw(g2);
		
	}
	
	public void update() {
		map.update();
		hero.update();
		b1.update();
		objectManager.update();
		
	}
	
}
