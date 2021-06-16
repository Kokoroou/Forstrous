package object;

import ui.GameWorld;

public class Villager extends Character {

	public Villager(String name, GameWorld gameWorld) {
		super(name, gameWorld);
	}

	public Villager(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed,
			GameWorld gameWorld) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
	}

	public Villager() {
	}

	@Override
	public void update() {
	}

}
