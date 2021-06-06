package com.kdat.object;

import java.awt.Graphics2D;
import java.util.Random;

import com.kdat.effect.*;

public class Monster extends Character {
	private float currX, currY;
	
	public Monster() {}

	public Monster(String name, float mapX, float mapY, int maxHp, int attack, int luck, float movementSpeed, GameWorld gameWorld) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
		this.setDirection(Character.DOWN_DIR);
		currX = getMapX();
		currY = getMapY();
		Wonder();
	}

	private int Random(int a[]) {
		Random rand = new Random();
		int dir = rand.nextInt(a.length);
		return a[dir];
	}
	
	private void Wonder() {
		this.setMovementSpeed(0);
		int tileX = (int) this.getMapX() / 32;
		int tileY = (int) this.getMapY() / 32;
		int dir = Random(canDir[Map.arr1[tileX][tileY]]);
		//System.out.println("...: " + Map.arr1[tileX][tileY]);
		switch(dir) {
			case DOWN_DIR:
				setDirection(DOWN_DIR);
				this.setMovementSpeed(1);
				this.setMapX(this.getMapX());
				this.setMapY(this.getMapY() + this.getMovementSpeed());
				//System.out.println("Downing");
				break;
			case LEFT_DIR:
				setDirection(LEFT_DIR);
				this.setMovementSpeed(-1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				//System.out.println("Lefting");
				break;
			case RIGHT_DIR:
				setDirection(RIGHT_DIR);
				this.setMovementSpeed(1);
				this.setMapY(this.getMapY());
				this.setMapX(this.getMapX() + this.getMovementSpeed());
				//System.out.println("Righting");
				break;
			case UP_DIR:
				setDirection(UP_DIR);
				this.setMovementSpeed(-1);
				this.setMapX(this.getMapX());
				this.setMapY(this.getMapY() + this.getMovementSpeed());
				//System.out.println("Uping");
				break;
			default: break;
		}
	}
	
	@Override
	public void update() {
		if (Math.abs(getMapX() - currX) >= 32 || Math.abs(getMapY() - currY) >= 32){
			//System.out.println(getMapX() + "   " + getMapY());
			switch(getDirection()) {
				case LEFT_DIR:
					setMapX(currX - 32);
					break;
				case RIGHT_DIR:
					setMapX(currX + 32);
					break;
				case UP_DIR:
					setMapY(currY - 32);
					break;
				case DOWN_DIR:
					setMapY(currY + 32);
					break;
			}
			currX = getMapX();
			currY = getMapY();
			Wonder();
		}
		else {
			switch(getDirection()) {
				case LEFT_DIR:
				case RIGHT_DIR:
					setMapX(getMapX() + getMovementSpeed());
					break;
				case UP_DIR:
				case DOWN_DIR:
					setMapY(getMapY() + getMovementSpeed());
					break;
			}
		}
	}

}
