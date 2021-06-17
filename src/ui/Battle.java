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

/**
 * The Battle is the class that draw everything in a battle.
 *
 */
public class Battle extends JPanel implements KeyListener, ActionListener {
	private GamePanel gamePanel;
	public boolean battling = false;
	private Graphics2D g2d;
	private InputManager inputManager;
	private long beginTime;
	private String[] battleLog;
	
	int battleLogX = 30, battleLogY = 15, battleLogWidth = 516, battleLogHeight = 100;
	int heroLogX = 30, heroLogY = 330, heroLogWidth = 516, heroLogHeight = 100;
	
	private JButton buttonHomepage;
	private JButton buttonAttack;
	private JButton buttonDefense;
	private JButton buttonRun;
	private JButton buttonItem;
	
	private Monster monster;
	private Hero hero;
	private static int heroChoice = -1;
	public ObjectManager objectManager;	
	
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
		
		int padding = 11; //Distant between buttons
		
		buttonAttack = new JButton();
		buttonAttack.setBorder(null);
		buttonAttack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonAttack.setText("(1) Attack");
		buttonAttack.setBounds(145, 380, 88, 30);
		buttonAttack.addActionListener(this);
		add(buttonAttack);
		
		buttonDefense = new JButton();
		buttonDefense.setBorder(null);
		buttonDefense.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonDefense.setText("(2) Defense");
		buttonDefense.setBounds(buttonAttack.getX() + buttonAttack.getWidth() + padding, buttonAttack.getY(), buttonAttack.getWidth(), buttonAttack.getHeight());
		buttonDefense.addActionListener(this);
		add(buttonDefense);
		
		buttonRun = new JButton();
		buttonRun.setBorder(null);
		buttonRun.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonRun.setText("(3) Run");
		buttonRun.setBounds(buttonDefense.getX() + buttonDefense.getWidth() + padding, buttonDefense.getY(), buttonDefense.getWidth(), buttonDefense.getHeight());
		buttonRun.addActionListener(this);
		add(buttonRun);
		
		buttonItem = new JButton();
		buttonItem.setBorder(null);
		buttonItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonItem.setText("(4) Item");
		buttonItem.setBounds(buttonRun.getX() + buttonRun.getWidth() + padding, buttonRun.getY(), buttonRun.getWidth(), buttonRun.getHeight());
		buttonItem.addActionListener(this);
		add(buttonItem);
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
		
		//Draw Hero_log board
		g2d.setColor(Color.BLUE);
		g2d.drawRect(heroLogX, heroLogY, heroLogWidth, heroLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		g2d.fillRect(heroLogX, heroLogY, heroLogWidth, heroLogHeight);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		try {
			//Draw Hero Face
			img = this.hero.getFace().getImage();
			int padding = (heroLogHeight - img.getHeight()) / 2; //Padding from Hero_log board to Hero_Face 
			g2d.drawImage(img, heroLogX + padding, heroLogY + padding, null);
			
		}
		catch (Exception e) {}
		
		int padding = 15; //Padding from Log board to HP bar
		int HPWidth = heroLogWidth - 2 * padding - img.getWidth() - 30;
		int HPHeight = 18;
		int HPPosX = heroLogX + img.getWidth() + padding + 30;
		
		//Write HP of hero and Monster HP
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, HPHeight));
		g2d.setColor(Color.WHITE);
		g2d.drawString("HP", HPPosX - 30, heroLogY + padding + HPHeight);
		g2d.drawString(this.monster.getName() + " HP" , HPPosX - 100, battleLogY + padding + HPHeight);
		
		//Draw Hero HP		
		g2d.setColor(Color.GREEN);
		int heroHPWidth = HPWidth; //Width of HP Bar
		g2d.drawRect(HPPosX, heroLogY + padding, heroHPWidth, HPHeight);
		heroHPWidth = (int) (heroHPWidth * ((float) hero.getCurrentHp() / (float) hero.getMaxHp()));
		g2d.fillRect(HPPosX, heroLogY + padding, heroHPWidth, HPHeight);
		
		//Draw Monster HP		
		g2d.setColor(Color.RED);
		int monsterHPWidth = HPWidth; //Width of HP Bar
		g2d.drawRect(HPPosX, battleLogY + padding, monsterHPWidth, HPHeight);
		monsterHPWidth = (int) (monsterHPWidth * ((float) monster.getCurrentHp() / (float) monster.getMaxHp()));
		g2d.fillRect(HPPosX, battleLogY + padding, monsterHPWidth, HPHeight);
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
		if(e.getSource() == buttonAttack) {
			heroChoice = 1;
			this.update();
		}
		if(e.getSource() == buttonDefense) {
			heroChoice = 2;
			this.update();
		}
		if(e.getSource() == buttonRun) {
			heroChoice = 3;
			this.update();
		}
		if(e.getSource() == buttonItem) {
			heroChoice = 4;
			this.update();
		}
	}
}
