package object;

import ui.GameWorld;

public class Hero extends Character{

	public static final int beginY[] = {0, 0, 416, 64, 192};
	public static final int endY[] = {0, 416, 64, 192, 416};
	public boolean inBattle = false;
	
	
	public Hero() {}
	
	public Hero(String name, GameWorld gameWorld) {
		super(name, gameWorld);
	}

	public Hero(String name, int mapX, int mapY, int maxHp, int attack, int luck, int movementSpeed, GameWorld gameWorld) {
		super(name, mapX, mapY, maxHp, attack, luck, movementSpeed, gameWorld);
	}
	public void equip(Item item) {
		
	}
	
	public void usePotion() {
		if(getGameWorld().objectManager.numOfPotions>=1) {
			getGameWorld().objectManager.numOfPotions--;
			updateCurrentHp(getCurrentHp()+150);
		}
	}
	
	@Override
	public void update() {
		boolean canMove[] = {true, true, true, true};
		
		int tileX = (int) getMapX() / 32;
		int tileY = (int) getMapY() / 32;
		
		if (getMapX() % 32 == 0 || getMapY() % 32 == 0)
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX, tileY)])
				canMove[i] = false;
		
		if (getMapX() % 32 == 0 && getMapY() % 32 != 0) {
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX, tileY+1)])
				
				canMove[i] = false;
			canMove[UP_DIR] = true;
			canMove[DOWN_DIR] = true;
		}
		
		if (getMapX() % 32 != 0 && getMapY() % 32 == 0) {
			for (int i : canDir[15 - getGameWorld().map.get(gameWorld.getRound()).getTile(tileX+1, tileY)])
				canMove[i] = false;
			canMove[LEFT_DIR] = true;
			canMove[RIGHT_DIR] = true;
		}
		if(getMapX()==0 && getMapY()==beginY[getGameWorld().getRound()]) {
			canMove[LEFT_DIR] = true;
		}
		if(getMapX()==544 && getMapY()==endY[getGameWorld().getRound()]) {
			canMove[RIGHT_DIR] = true;
		}
		if(canMove[getDirection()])
			switch(getDirection()) {
			case LEFT_DIR:
				if(getMapX()==0 && getMapY()==beginY[getGameWorld().getRound()]) {
					getGameWorld().backMap();
					setMapX(544);
				}
				else setMapX(getMapX() + getMovementSpeed());
				break;
			case RIGHT_DIR:
				if(getMapX()==544 && getMapY()==endY[getGameWorld().getRound()]) {
					if(getGameWorld().getRound()==3) {
						gameWorld.getGamePanel().getBattle().setMonster(getGameWorld().boss);
						gameWorld.getGamePanel().getBattle().setBattling(true);
						gameWorld.hero.inBattle = true;
						gameWorld.getGamePanel().getControl().showGamePanel();
						gameWorld.getGamePanel().showBattle();
					}
					else {
					getGameWorld().nextMap();
					setMapX(0);
					}
				}
				else setMapX(getMapX() + getMovementSpeed());
				break;
			case UP_DIR:
			case DOWN_DIR:
				setMapY(getMapY() + getMovementSpeed());
				break;
			}
		else {
			setMapX(getMapX());
			setMapY(getMapY());
			setMovementSpeed(0);
		}
	}
}

