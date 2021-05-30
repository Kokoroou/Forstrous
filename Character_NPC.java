package game;

import java.util.Random;
// import game.Character;

class Test {
	public static void main (String[] args) {
		NPC a = new NPC(10, 10, "I have a gift for you.");
	}
}

class NPC extends Character {
	private String autoLines;

	NPC(int x, int y, String lines){
		this.positionX = x;
		this.positionY = y;
		this.autoLines = lines;
	}
	
	public String say(String autoLines) {}

	public void move() {
		Random num = new Random();
		int direction = num.nextInt(4); //0:Up - 1:Down - 2:Left - 3:Right
		int step = num.nextInt(5);

		switch (direction) {
			case (0): {
				for (int i=0; i<step; i++) moveUp();
				System.out.println("Moved up. Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
			case (1): {
				for (int i=0; i<step; i++) moveDown();
				System.out.println("Moved down. Position now is (" + this.positionX + ", " + this.positionY + ").");
				break;
			}
			case (2): {
				for (int i=0; i<step; i++) moveLeft();
				System.out.println("Moved left. Position now is (" + this.positionX + ", " + this.positionY + ").");
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

