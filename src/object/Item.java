package object;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;


public class Item{
    public int mapX;
    public int mapY;
    Image img;
    Graphics g;
    boolean pickUp = false;
    int itemType;
    String name;
    Player player;
    int atk = 0;
    int hpMax = 0;
    int speed = 0;
    int luck = 0;
    int hp = 0;
    
    public Item(int mapX, int mapY){
        this.mapX = mapX;
        this.mapY = mapY;
        randomItem();
        draw(g);
    }
    
    public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}

	public int getAtk() {
		return atk;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getLuck() {
		return luck;
	}


	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public void randomItem() {
		Random rand = new Random();
        int itemNum = rand.nextInt(6);
        switch(itemNum){
            case 0:
                setName("Armor");
                setHpMax(100);
                setItemType(1);
                img = new ImageIcon("Armor.jpg").getImage();
                break;
            case 1:
                setName("Axe");
                setHpMax(50);
                setAtk(20);
                setItemType(1);
                img = new ImageIcon("Axe.jpg").getImage();
                break;
            case 2:
            	setName("Boots");
            	setSpeed(30);
            	setItemType(1);
            	img = new ImageIcon("Boots.jpg").getImage();
                break;
            case 3:
            	setName("Cloak");
            	setHpMax(50);
            	setSpeed(15);
            	setItemType(1);
            	img = new ImageIcon("Cloak.jpg").getImage();
                break;
            case 4:
            	setName("Helmet");
            	setHpMax(50);
            	setLuck(10);
            	setItemType(1);
            	img = new ImageIcon("Helmet.jpg").getImage();
                break;
            case 5:
            	setName("Necklace");
            	setLuck(20);
            	setItemType(1);
            	img = new ImageIcon("Necklace.jpg").getImage();
                break;
            case 6:
            	setName("Sword");
            	setAtk(40);
            	setItemType(1);
            	img = new ImageIcon("Sword.jpg").getImage();
                break;
            case 7:
            	setName("Cherry");
            	setHp(50);
            	setItemType(0);
            	img = new ImageIcon("Cherry.jpg").getImage();
            	break;
        }
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, 0, 0, null);
	}
	
	public void pickUpCheck(Character character) {
		if(character.getMapX() == mapX && character.getMapY() == mapY) pickUp = true;
	}
	
	public void typeItem(int itemType) {
		if (itemType == 1) chiso(player);
		else potions();
	}
	public void potions() {
		potions++;
	}
}