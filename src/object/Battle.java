package object;

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
import ui.*;

public class Battle extends JPanel implements KeyListener, ActionListener {
	private GamePanel gamePanel;
	private Graphics2D g2d;
	private JButton buttonHomepage;
	private JPanel noticeBoard;
	private long beginTime;
	private FrameImage background = new FrameImage();	
	private Monster monster;
	private Hero hero;
	private static int heroChoice = -1;
	public ObjectManager objectManager;
	public boolean battling = false;	
	
	private InputManager inputManager;
	
	public Battle(GamePanel gamePanel, Hero hero) {
		this.gamePanel = gamePanel;
		this.hero = hero;
		this.objectManager = gamePanel.getGameWorld().objectManager;
		this.noticeBoard = new JPanel();
		this.setFocusable(true);
		this.setLayout(null);
		beginTime = System.nanoTime();
		inputManager = new InputManager(this.gamePanel);
		this.addKeyListener(this);
		
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
		g2d.drawString("HP:" , 580, 250);
		g2d.setColor(Color.BLUE);
		g2d.drawRect(610, 235, hero.getMaxHp()/20, 18);
		g2d.fillRect(610, 235, hero.getCurrentHp()/20, 18);
		
		try {
			BufferedImage img;

			//Draw Battleback_Floor
			img = ImageIO.read(new File("image/Meadow.png"));
			background.setImage(img);
			background.draw(g2d, 0, 4);

			//Draw Battleback_Wall
			img = ImageIO.read(new File("image/Forest1.png"));
			this.g2d.drawImage(img, 0, 0, null);

			background.setImage(img);
			background.draw(g2d, 0, 0);

			//Draw Monster
			img = this.monster.getFullBody().getImage();
			this.monster.getFullBody().draw(g2d, (576 - img.getWidth())/2, (448 - img.getHeight())/2);

		}
		catch (IOException e) {}

		//Draw Items
		objectManager.drawItems(g2d);
		
		g2d.setColor(Color.WHITE);
		g2d.drawString("Monster HP:" , 110, 50);
		g2d.setColor(Color.RED);
		g2d.drawRect(188, 35, 200, 18);
		g2d.fillRect(188, 35, 200 * this.monster.getCurrentHp()/this.monster.getMaxHp(), 18);
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
	}
}
