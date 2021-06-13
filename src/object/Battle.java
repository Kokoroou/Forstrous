package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import effect.CacheDataLoader;
import effect.FrameImage;
import ui.*;

public class Battle extends JPanel {
	private ControlPanel control;
	private GUI gui;
	private GamePanel gamePanel;
	private FrameImage background;
	private Monster monster;
	private Hero hero;
	private int heroChoice;
	private boolean battling = false;
	private Graphics2D g2d;
	
	public Battle() {}
	
//	public Battle(ControlPanel control) {
//		this.control = control;
//		this.gui = control.getGui();
//		this.setBackground(Color.WHITE);
//		this.setLayout(getLayout());
//	}
	
	public Battle(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public Battle(GamePanel gamePanel, Monster monster) {
		this.gamePanel = gamePanel;
		this.monster = monster;
	}
	
	public boolean isBattling() {
		return battling;
	}
	public void setBattling(boolean battling) {
		this.battling = battling;
	}
	public int getHeroChoice() {
		return heroChoice;
	}
	public void setHeroChoice(int heroChoice) {
		this.heroChoice = heroChoice;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
//	private void drawString(Graphics2D g2, String text, int x, int y){
//        for(String str : text.split("\n"))
//            g2.drawString(str, x, y+=g2.getFontMetrics().getHeight());
//    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.g2d = (Graphics2D) g;
		
		BufferedImage img;
		
		try {
			img = ImageIO.read(new File("image/RockCave1.png"));
			this.g2d.drawImage(img, 0, 4, null);
		}
		catch (IOException e) {	}
		
		try {
			img = ImageIO.read(new File("image/RockCave.png"));
			this.g2d.drawImage(img, 0, 0, null);
		}
		catch (IOException e) {	}
		
		img = this.monster.getFullBody().getImage();
		this.g2d.drawImage(img, (580 - img.getWidth())/2, (448 - img.getHeight())/2, null);
		
		
	}
	
	public void onBattle() {
		boolean isHeroDefense = false;
		Random rand = new Random();
		int isMonsterDefense = rand.nextInt(1);
		// danh, phong thu, chay, hoi mau, mana
		//luot cua hero
		switch(heroChoice) {
			case 1://attack
				if(hero.onHit()) {
					if(isMonsterDefense == 1)
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack());
					else {
						hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2);
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
					}
				}
				//thong bao ra man hinh
				
				break;
			case 2:// phong thu
				isHeroDefense = true;
				//thong bao ra man hinh
				
				break;
			case 3://chay
				battling = false;
				hero.setMapX(0);
				hero.setMapY(0);
				monster.setMapX(monster.getBeginX());
				monster.setMapY(monster.getBeginY());
				monster.setCurrX(monster.getBeginX());
				monster.setCurrY(monster.getBeginY());
				monster.setFirstWonder(false);
				//thong bao ra man hinh
				gamePanel.showGameWorld();
				break;
			case 4: //binh mau hoac mana
				
				break;
			default: break;
		}
		//luot cua monster
		if (heroChoice == 0) { 
		if(isMonsterDefense == 0 && monster.onHit()) {
			if(!isHeroDefense)
				hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack());
			else {
				hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2
						);
				monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
			}
		}
			heroChoice = -1;
		}
		
		System.out.println("Hero: " + hero.getCurrentHp());
		System.out.println("Monster: " + monster.getCurrentHp());
	}
	
	public void update() {
		
		if (battling) {
			onBattle();
			hero.battle = true;
			if (monster.getCurrentHp()==0 || hero.getCurrentHp()==0)
				battling = false;
		}
		else hero.battle = false;
	}
}
