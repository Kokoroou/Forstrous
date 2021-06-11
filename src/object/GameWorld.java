package object;

import java.awt.Graphics2D;

public class GameWorld {
	
	public Map map;
	public Monster slime, gayzer, bat, skeleton;
	public Hero hero;
	public BattleMap b1;
	
	public GameWorld() {
		map = new Map();
		slime = new Monster("slime", 32, 352, 100, 20, 30, 0, this, 1);
		gayzer = new Monster("gayzer", 544, 64, 100, 20, 30, 0, this, 2);
		bat = new Monster("bat", 352, 0, 100, 20, 30, 0, this, 1);
		skeleton = new Monster("skeleton", 32, 352, 100, 20, 30, 0, this, 2);
		hero = new Hero("hero", 0, 0, 500, 30, 50, 0, this);
		b1 = new BattleMap(hero);
	}
	
	public void drawGameWorld(Graphics2D g2){
		if(hero.battle == false) {
			map.drawMap(g2);
			slime.draw(g2, 1);
			bat.draw(g2, 1);
			gayzer.draw(g2, 2);
			skeleton.draw(g2, 2);
			hero.draw(g2);
		}
		else b1.draw(g2);
	}
	
	public void update() {
		map.update();
		slime.update();
		gayzer.update();
		bat.update();
		skeleton.update();
		hero.update();
		b1.update();
	}
	
}
