package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

import effect.CacheDataLoader;
import effect.FrameImage;
import ui.*;

public class Battle extends JPanel {
	private PlayGame playgame;
	private FrameImage background;
	private Monster monster;
	private Hero hero;
	private int heroChoice;
	private boolean battling = false;
	
	public Battle() {
		this.battling = true;
	}
	
	public Battle(PlayGame playgame) {
		this.battling = true;
		this.playgame = playgame;
		this.hero = playgame.getHero();
	}
	
	public Battle(PlayGame playgame, Monster monster) {
		this.battling = true;
		this.playgame = playgame;
		this.hero = playgame.getHero();
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
	
	private void drawString(Graphics2D g2, String text, int x, int y){
        for(String str : text.split("\n"))
            g2.drawString(str, x, y+=g2.getFontMetrics().getHeight());
    }
	
	public void draw(Graphics2D g2) {
		if (battling) {
			background.draw(g2, 0, 0);
			monster.getFullBody().draw(g2, (background.getImageWidth() - monster.getFullBody().getImageWidth())/2, (background.getImageHeight() - monster.getFullBody().getImageHeight())/2);
			hero.getFace().draw(g2, 0, background.getImageHeight() - hero.getFace().getImageHeight());
		}
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
				//thong bao ra man hinh
				
				break;
			case 4: //binh mau hoac mana
				
				break;
			default: break;
		}
		//luot cua monster
		if(isMonsterDefense == 0 && monster.onHit()) {
			if(!isHeroDefense)
				hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack());
			else {
				hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2
						);
				monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
			}
		}
		
	}
	
	public void update() {
		
		if (battling) {
			onBattle();
			hero.battle = true;
		}
		else if(hero.isAlive()) {
			
		}
		else {
			//
			System.out.println("Game over");
		}
	}
}
