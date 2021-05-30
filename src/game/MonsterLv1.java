package game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class MonsterLv1 extends Character{
	public MonsterLv1(int attack, int hp, float movementSpeed, int luck, boolean alive, String name) {
		super(attack, hp, movementSpeed, luck, alive, name);
	}

	Random rand = new Random();
	
	private void Wonder () {
		int move = rand.nextInt(3);
		switch(move) {
			case 0: moveUp();
			case 1: moveRight();
			case 2: moveDown();
			case 3: moveLeft();
		}
	}
	
	private void aStar (Point goal) {
		PriorityQueue<Pri> frontier = new PriorityQueue<>();
		frontier.add(new Pri(this.point, 0));
		this.point.cameFrom = null;
		this.point.cost = 0;
		
		while(!frontier.isEmpty()) {
			Point curr = frontier.remove().a;
			
			if (curr == goal) break;
			
			curr.addadj();
			for (Point next : curr.adjacent) {
				int newCost = curr.cost + 1;
				if(next.cameFrom == null || newCost < next.cost) {
					next.cost = newCost;
					int priority = newCost + goal.heuristic(next);
					frontier.add(new Pri(next, priority));
					next.cameFrom = curr;
					curr.next = next;
				}
			}
		}
	}
	
	//Ham main se them while(hero dang di) act(hero)
	private void act (Hero hero) {
		if (this.point.distance(hero.point) > 5) Wonder();
		
		aStar(hero.point);
		this.setPoint(this.point.next);
		
		if (this.point.distance(hero.point) <= 1) inFight(hero);
	}

	private void dmgHero(Hero hero) {
		if (onHit()) {
			int HPnow = hero.getHp() - attack;
			System.out.println("You have been damaged by " + this.getName());
			System.out.println(" Your HP now is " + HPnow);
			hero.setHp(HPnow);
		}
	}
	
	private void takeDmg(Hero hero) {
		if (hero.onHit())
			hp -= hero.attack;
	}

	public void inFight(Hero hero) {
		while (this.isAlive()) {
			dmgHero (hero);
			takeDmg (hero);
		}
	}
}
