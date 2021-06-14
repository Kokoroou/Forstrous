package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import effect.CacheDataLoader;
import effect.FrameImage;
import ui.*;

public class Battle extends JPanel implements ActionListener {
	private GamePanel gamePanel;
	private Graphics2D g2d;
	private JButton buttonHomepage;
	private JPanel noticeBoard;
	
//	private FrameImage background;	
	private Monster monster;
	private Hero hero;
	private int heroChoice = -1;
	public ObjectManager objectManager;
	private boolean battling = false;	
	
//	private InputManager inputManager;
	
	public Battle(GamePanel gamePanel, Hero hero) {
		this.gamePanel = gamePanel;
		this.hero = hero;
		this.objectManager = gamePanel.getGameWorld().objectManager;
		
		this.setFocusable(true);
		this.setLayout(null);
				
		initComps();
	}
	
	public Battle(GamePanel gamePanel, Monster monster) {
		this.gamePanel = gamePanel;
		this.monster = monster;
		this.objectManager = gamePanel.getGameWorld().objectManager;
		
		this.setFocusable(true);
		this.setLayout(null);
		
		initComps();
	}
	
	private void initComps(){
		buttonHomepage = new JButton();
		buttonHomepage.setText("Home");
		buttonHomepage.setBounds(608, 408, 80, 30);
		buttonHomepage.addActionListener(this);
		add(buttonHomepage);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g2d = (Graphics2D) g;
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Items", 620, 30);
		
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Equipped", 610, 200);
		
		BufferedImage img;
		
		//Draw Battleback_Floor
		try {
			img = ImageIO.read(new File("image/Meadow.png"));
			this.g2d.drawImage(img, 0, 4, null);
		} catch (IOException e) {	}
		
		//Draw Battleback_Wall
		try {
			img = ImageIO.read(new File("image/Forest1.png"));
			this.g2d.drawImage(img, 0, 0, null);
		} catch (IOException e) {	}
		
		//Draw Monster
		img = this.monster.getFullBody().getImage();
		this.g2d.drawImage(img, (576 - img.getWidth())/2, (448 - img.getHeight())/2, null);
		
		//Draw Items
		objectManager.drawItems(g2d);
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
	
	public void onBattle() {
		boolean heroDefending = false, monsterDefending = false;
		Random rand = new Random();
		if (rand.nextInt(1) == 1) monsterDefending = true;
		
		//Hero's turn
		switch(heroChoice) {
			case 1: //Attack
				if(hero.onHit()) {
					if(monsterDefending == true)
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack());
					else {
						hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2);
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
					}
				}
				heroChoice = -1;
				break;
			case 2: //Defend
				heroDefending = true;
				
				heroChoice = -1;
				break;
			case 3://Run
				battling = false;
				hero.setMapX(0);
				hero.setMapY(0);
				monster.setMapX(monster.getBeginX());
				monster.setMapY(monster.getBeginY());
				monster.setCurrX(monster.getBeginX());
				monster.setCurrY(monster.getBeginY());
				monster.setFirstWonder(false);

				gamePanel.showGameWorld();
				heroChoice = -1;
				break;
			case 4: //Use Item
				heroChoice = -1;
				break;
			default: break;
		}
		
		//Monster's turn
		if (heroChoice == 0) { 
		if(monsterDefending == false && monster.onHit()) {
			if(!heroDefending)
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
			if (heroChoice != -1) {
				onBattle();
				hero.inBattle = true;
				if (monster.getCurrentHp()==0 || hero.getCurrentHp()==0)
					battling = false;
			}			
		}
		else {
			if (monster.getCurrentHp() == 0) {
				hero.inBattle = false;
				System.out.println("Battle finish");
				
				monster.setAlive(false);
				hero.setMovementSpeed(0);
				
				gamePanel.showGameWorld();
				System.out.println("Back to GameWorld");
			}
			
			else if (hero.getCurrentHp()==0) {
				System.out.println("Game Over!");
			}
			
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonHomepage){
			gamePanel.getControl().showHomepage();
		}
	}
}
