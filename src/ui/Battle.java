package ui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import effect.FrameImage;
import object.*;

public class Battle extends JPanel implements KeyListener, ActionListener {
	private GamePanel gamePanel;
	private Graphics2D g2d;
	private JButton buttonHomepage;
	private String[] battleLog;
	private int battleLogX = 30, battleLogY = 15, battleLogWidth = 516, battleLogHeight = 100;
	private int heroLogX = 30, heroLogY = 330, heroLogWidth = 516, heroLogHeight = 100;	
	private long beginTime;
	private FrameImage back = new FrameImage();
	
	private Monster monster;
	private Hero hero;
	private static int heroChoice = -1;
	public ObjectManager objectManager;
	public boolean battling = false;	
	
	private InputManager inputManager;
	
	public Battle(GamePanel gamePanel, Hero hero) {
		this.gamePanel = gamePanel;
		this.objectManager = gamePanel.getGameWorld().objectManager;
		this.hero = hero;
		
		this.setFocusable(true);
		this.setLayout(null);
		beginTime = System.nanoTime();
		inputManager = new InputManager(this.gamePanel);
		this.addKeyListener(this);
		
		initComps();
	}
	
	public Battle(GamePanel gamePanel, Monster monster) {
		this.gamePanel = gamePanel;
		this.objectManager = gamePanel.getGameWorld().objectManager;
		this.monster = monster;
		
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
//		System.out.println("Draw Battle.");
		super.paintComponent(g);
		this.g2d = (Graphics2D) g;
		
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Items", 620, 30);
		
		BufferedImage img;
		
		try {		
			//Draw Battleback_Floor
			img = ImageIO.read(new File("image/Meadow.png"));
			g2d.drawImage(img, 0, 4, null);
			
			//Draw Battleback_Wall
			img = ImageIO.read(new File("image/Forest1.png"));
			g2d.drawImage(img, 0, 0, null);
		}
		catch (IOException e) {}
		
		//Draw Monster
		img = this.monster.getFullBody().getImage();
		g2d.drawImage(img, (576 - img.getWidth())/2, (448 - img.getHeight())/2, null);
		
		//Draw Items
		objectManager.drawItems(g2d);
		
		//Draw Battle_log board
		g2d.setColor(Color.BLUE);
		g2d.drawRect(battleLogX, battleLogY, battleLogWidth, battleLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d.fillRect(battleLogX, battleLogY, battleLogWidth, battleLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		//Draw Hero_info board
		g2d.setColor(Color.BLUE);
		g2d.drawRect(heroLogX, heroLogY, heroLogWidth, heroLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d.fillRect(heroLogX, heroLogY, heroLogWidth, heroLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		//Draw Monster HP
		g2d.setColor(Color.WHITE);
		g2d.drawString(this.monster.getName() + " HP:" , 110, 50);
		g2d.setColor(Color.RED);
		int monsterHPBar = 200; //Length of HP Bar
		g2d.drawRect(188, 35, monsterHPBar, 18);
		monsterHPBar = (int) (monsterHPBar * ((float) monster.getCurrentHp() / (float) monster.getMaxHp()));
		g2d.fillRect(188, 35, monsterHPBar, 18);
		
		try {
			//Draw Hero Face
			img = this.hero.getFace().getImage();
			int padding = (heroLogHeight - img.getHeight()) / 2;
			g2d.drawImage(img, heroLogX + padding, heroLogY + padding, null);
			
		}
		catch (Exception e) {}
		
		//Draw Hero HP
		int padding = 15;
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.WHITE);
		g2d.drawString("HP:", heroLogX + img.getWidth() + padding, heroLogY + padding + 18);
		g2d.setColor(Color.GREEN);
		int heroHPBar = heroLogWidth - 2 * padding - img.getWidth() - 30; //Length of HP Bar
		g2d.drawRect(heroLogX + img.getWidth() + padding + 30, heroLogY + padding, heroHPBar, 18);
		heroHPBar = (int) (heroHPBar * ((float) hero.getCurrentHp() / (float) hero.getMaxHp()));
		g2d.fillRect(heroLogX + img.getWidth() + padding + 30, heroLogY + padding, heroHPBar, 18);
		
		//Change default format for text
//		g2d.setColor(co)
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
	
	public void onBattle() {
		beginTime = System.nanoTime();
		boolean heroDefending = false, monsterDefending = false;
		Random rand = new Random();
		if (rand.nextInt(1) == 1) monsterDefending = true;
		
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		g2d.setColor(Color.BLACK);
		switch(heroChoice) {
			case 1: //Attack
				
				g2d.drawString("Hero attacked!", 160, 384);
				
				try {
					BufferedImage img;

					//Draw Battleback_Floor
					img = ImageIO.read(new File("image/Slime.png"));
					back.setImage(img);
					back.draw(g2d, 0, 4);

				}
				catch (IOException e) {}
				
				if(hero.onHit()) {
					if(monsterDefending == false) {
						g2d.drawString(monster.getName() + " took " + Integer.toString(hero.getAttack()) + " damage.", 160, 384 );
						
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack());
					}
						
					else {
						g2d.drawString(monster.getName() + " is defending!", 160, 352);
						g2d.drawString(monster.getName() + " took " + Integer.toString(hero.getAttack()/2) + " damage.", 160, 384);
						g2d.drawString("Hero took " + Integer.toString(monster.getAttack()/2) + " damage.", 160, 416);
						
						hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2);
						monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
					}
				}
				else {
					g2d.drawString("Miss!", 160, 384);
				}
				break;
			case 2: //Defend
				heroDefending = true;
				
				g2d.drawString("Hero took a protective stance!", 160, 384);
				break;
			case 3://Run				
				g2d.drawString("Hero run away safely", 160, 384);
				
				hero.setMovementSpeed(0);
				
				monster.setMapX(monster.getBeginX());
				monster.setMapY(monster.getBeginY());
				
				battling = false;
				hero.inBattle = false;

				gamePanel.showGameWorld();
				break;
			case 4: //Use Item
				g2d.drawString("Hero used potion", 160, 384);
				hero.usePotion();
				break;
			default: break;
		}
		while(System.nanoTime() - beginTime <= 2000000000) {};
		beginTime = System.nanoTime();
		
		//Monster's turn
		if (heroChoice != 3) {
			g2d.drawString(monster.getName() + " attacked!", 160, 384);
			
			if (monster.onHit()) {				
				if (heroDefending) {
					g2d.drawString("Hero defended!", 160, 384);
					g2d.drawString("Hero took " + Integer.toString(monster.getAttack()/2) + " damage.", 160, 384);
					g2d.drawString(monster.getName() + " took " + Integer.toString(hero.getAttack()/2) + " damage.", 160, 384);
					
					hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack()/2);
					monster.updateCurrentHp(monster.getCurrentHp() - hero.getAttack()/2);
				}
				else {
					g2d.drawString("Hero took " + Integer.toString(monster.getAttack()) + " damage.", 160, 384);
					
					hero.updateCurrentHp(hero.getCurrentHp() - monster.getAttack());
				}
			}
			else {
				g2d.drawString("Miss!", 160, 384);
			}
			g2d.drawString("Hero has " + Integer.toString(hero.getCurrentHp()) + " health points left.", 160, 384);
			g2d.drawString(monster.getName() +" has " + Integer.toString(monster.getCurrentHp()) + " health points left.", 160, 384);
		}
		heroChoice = -1;
		
	}
	
	public void update() {
//		System.out.println("Battle Update!");

		if (battling) {
			if (heroChoice != -1) {
				onBattle();
				hero.inBattle = true;
				
				if (hero.getCurrentHp() == 0) {
					battling = false;
					hero.inBattle = false;
					gamePanel.getControl().showGameOver();
					gamePanel.running = false;
				}
				
				else if (monster.getCurrentHp() == 0) {
					if(monster.getName()!="Demon") {						
						battling = false;
						hero.inBattle = false;
						
						monster.setAlive(false);
						hero.setMovementSpeed(0);
						gamePanel.showGameWorld();
					}
					else {
						gamePanel.getControl().showVictory();
						gamePanel.running = false;
					}
				}					
			}			
		}
		else {
			hero.inBattle = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputManager.processKeyPressed(e.getKeyCode());
		this.update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputManager.processKeyReleased(e.getKeyCode());
		this.update();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonHomepage){
			gamePanel.getControl().showHomepage();
		}
	}
}
