package enemy;

import java.awt.Image;

public class MonsterLv2 extends MonsterLv1{

	public MonsterLv2(int attack, int hp, float movementSpeed, int luck, boolean alive, String name) {
		super(3/2*attack, 2*hp, movementSpeed,(int) 1.1 * luck, alive, name);
	}
	
	
}
