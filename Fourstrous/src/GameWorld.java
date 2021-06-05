package GameObject;

import java.awt.Graphics2D;

public class GameWorld {
	
	public Map map;
	
	public Hero he;
	
	public GameWorld() {
		map = new Map();
		he = new Hero(0, 0, 100, 50, 25, 20, this);
	}
	
	public void drawGameWorld(Graphics2D g2){
		
		map.drawMap(g2, map.getRound());
		he.draw(g2, he.getDir());
		
	}
	
	public void update(int dir) {
		
		switch(dir) {
		case 0:
			he.move(dir);
			break;
		case 1:
			he.move(dir);
			break;
		case 2:
			if(map.isBeginTile(he.getMapX()/32, he.getMapY()/32)) {
				map.backMap();
				he.setDir(2);
				he.setMapX(17*32);
			}
			else he.move(dir);
			break;
		case 3:
			if(map.isEndTile((he.getMapX()/32), he.getMapY()/32)) {
				map.nextMap();
				he.setDir(3);
				he.setMapX(0);
			}
			else he.move(dir);
			break;
		default:
			break;
		}
		
	}
	
}
