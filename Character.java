package game;

import java.util.Random;

class Test {
	public static void main(String[] args) {
		NPC a = new NPC(10, 10, "I have a gift for you.");
		a.say();
		for (int i=0; i<10; i++) {
			a.move();
		}
	}
}


interface Movable {
	void moveUp();
	void moveDown();
	void moveLeft();
	void moveRight();
}

public class Character implements Movable {
	protected int positionX;
	protected int positionY;
	
	public void moveUp()    {this.positionY += 1;}
	public void moveDown()  {this.positionY -= 1;}
	public void moveLeft()  {this.positionX -= 1;}
	public void moveRight() {this.positionX += 1;}
	
	public String say(String lines){
		System.out.println(lines);
		return lines;
	}
}

class NPC extends Character {
	private String autoLines;

	NPC(int x, int y, String lines){
		this.positionX = x;
		this.positionY = y;
		this.autoLines = lines;
	}
	
	public String say() {
		System.out.println(this.autoLines);
		return this.autoLines;
	}

	public void move() {
		Random num = new Random();
		int direction = num.nextInt(4); //0:Up - 1:Down - 2:Left - 3:Right
		int step = num.nextInt(5)+1;

		switch (direction) {
			case (0): {
				for (int i=0; i<step; i++) moveUp();
				System.out.println("Moved up.    Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
			case (1): {
				for (int i=0; i<step; i++) moveDown();
				System.out.println("Moved down.  Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
			case (2): {
				for (int i=0; i<step; i++) moveLeft();
				System.out.println("Moved left.  Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
			case (3): {
				for (int i=0; i<step; i++) moveRight();
				System.out.println("Moved right. Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
		}
	}
}