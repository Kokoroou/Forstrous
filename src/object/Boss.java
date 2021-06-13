package object;

public class Boss extends Monster {

	public Boss() {
	}

	public Boss(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed,
			GameWorld gameWorld, int round) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld, round);
		
	}

}
