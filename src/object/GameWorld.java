package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GamePanel;
import ui.InputManager;

/**
 * The GameWorld is the class that draw everything in playing process
 *
 */
/**
 * @author Admin
 *
 */
public class GameWorld extends JPanel implements ActionListener {	
	private GamePanel gamePanel;
//	private InputManager inputManager;
	public ArrayList<Map> map = new ArrayList<Map>();
	private int round = 1;
	public Battle battle;
	public Hero hero;
	public ObjectManager objectManager;
	
	private JButton buttonHomepage;// buttonNext;
	private Graphics2D g2d;

	
	public GameWorld(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
//		this.setBackground(Color.WHITE);
//		this.setLocation(0, 0);
		this.setFocusable(true);
		this.setLayout(null);
//		map = new Map();
		hero = new Hero("Hero", this);
		hero.setMapX(32*8);
		hero.setMapY(32*9);
		hero.setMaxHp(500);
		hero.updateCurrentHp(500);
		hero.setAttack(30);
		hero.setLuck(50);
		hero.setMovementSpeed(0);
		
		objectManager = new ObjectManager(this);
		initMonsterAndItem();
		initMap();
		initComps();
		
		this.gamePanel.startGame();
	}
	
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	

	private void initMonsterAndItem() {
		Monster slime = new Monster("Slime", 32, 352, 60, 15, 25, 0, this, 1);
		objectManager.addMonster(slime);
		
		Monster bat = new Monster("Bat", 352, 0, 80, 20, 30, 0, this, 1);
		objectManager.addMonster(bat);
		
		Monster plant = new Monster("Plant", 512, 416, 100, 25, 35, 0, this, 1);
		objectManager.addMonster(plant);
		
		Monster gayzer = new Monster("Gayzer", 544, 64, 175, 50, 50, 0, this, 2);
		objectManager.addMonster(gayzer);
		
		Monster skeleton = new Monster("Skeleton", 32, 352, 150, 55, 52, 0, this, 2);
		objectManager.addMonster(skeleton);
		
		Monster ghost = new Monster("Ghost", 288, 224, 200, 60, 55, 0, this, 2);
		objectManager.addMonster(ghost);
		
		Monster scorpion = new Monster("Scorpion", 256, 0, 400, 85, 67, 0, this, 3);
		objectManager.addMonster(scorpion);
		
		Monster ifrit = new Monster("Ifrit", 544, 64, 450, 90, 70, 0, this, 3);
		objectManager.addMonster(ifrit);
		
		Monster gayzer1 = new Monster("Gayzer", 64, 352, 350, 80, 60, 0, this, 3);
		objectManager.addMonster(gayzer1);
		
		Monster skeleton1 = new Monster("Skeleton", 320, 320, 300, 75, 63, 0, this, 3);
		objectManager.addMonster(skeleton1);
		
		Item potion = new Item("Potion", slime, Item.POTION, 0, 100, 0);
		objectManager.items.add(potion);
		
		Item potion1 = new Item("Potion", bat, Item.POTION, 0, 100, 0);
		objectManager.addItem(potion1);
		
		Item sword = new Item("Sword", plant, Item.EQUIPMENT, 40, 0, 0);
		objectManager.addItem(sword);
		
		Item potion2 = new Item("Potion", gayzer, Item.POTION, 0, 100, 0);
		objectManager.addItem(potion2);
		
		Item armor = new Item("Armor", skeleton, Item.EQUIPMENT, 0, 200, 0);
		objectManager.addItem(armor);
		
		Item necklace = new Item("Necklace", ghost, Item.EQUIPMENT, 0, 0, 15);
		objectManager.addItem(necklace);
		
		Item potion3 = new Item("Potion", skeleton1, Item.POTION, 0, 100, 0);
		objectManager.addItem(potion3);
		
		Item swordPro = new Item("SwordPro", gayzer1, Item.EQUIPMENT, 60, 0, 0);
		objectManager.addItem(swordPro);
		
		Item superArmor = new Item("SuperArmor", scorpion, Item.EQUIPMENT, 0, 400, 0);
		objectManager.addItem(superArmor);
		
		Item scarf = new Item("Scarf", ifrit, Item.EQUIPMENT, 0, 0, 20);
		objectManager.addItem(scarf);
		
	}
	
	private void initMap() {
		Map map0 = new Map(this, 0);
		int[][] arr0 = {{6,14,14,14,14,14,12,8,0,0,0,0,0,0},
				{5,15,15,15,15,11,0,0,0,0,0,0,0,0},
				{0,5,15,15,15,15,14,14,14,14,14,14,10,0},
				{0,0,7,15,15,15,15,15,15,15,15,15,11,0},
				{0,4,15,15,15,15,15,15,15,15,15,15,15,10},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{4,12,15,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{6,14,15,15,15,15,15,15,15,15,15,15,15,9},
				{7,15,15,15,15,15,15,15,15,15,15,15,9,0},
				{7,15,15,15,15,15,15,15,15,15,15,11,0,0},
				{7,15,15,15,15,15,15,15,15,15,15,11,0,0},
				{7,15,15,15,13,13,15,15,15,15,15,15,10,0},
				{7,15,15,11,0,0,7,15,15,15,15,15,11,0},
				{5,13,13,13,12,12,13,13,13,13,13,13,13,8}};
		map0.setArr(arr0);
		map.add(map0);
		
		Map map1 = new Map(this, 1);
		int[][] arr1 = {{6,14,10,0,0,0,0,0,0,0,0,0,0,0},
				{7,15,11,0,6,14,14,14,14,14,14,10,0,0},
				{5,15,11,0,7,15,15,15,15,15,15,11,0,0},
				{0,5,15,14,15,15,15,15,15,15,15,11,0,0},
				{0,0,7,15,15,15,15,15,15,15,15,11,0,0},
				{4,12,13,13,15,15,15,15,15,15,15,11,0,0},
				{0,0,0,0,7,15,15,15,15,15,15,11,0,0},
				{0,6,14,14,15,15,15,13,13,15,15,15,14,10},
				{0,7,15,15,15,15,11,0,0,7,15,15,15,11},
				{0,7,15,15,15,15,11,0,0,7,15,15,15,9},
				{0,7,15,15,15,15,11,0,0,7,15,15,11,0},
				{6,15,15,15,15,15,15,10,0,7,13,13,9,0},
				{5,13,15,15,15,15,15,15,14,11,0,0,0,0},
				{1,0,7,15,15,15,15,15,15,15,14,10,0,0},
				{2,0,7,15,15,15,15,15,15,15,15,15,10,0},
				{6,14,15,15,15,15,15,15,15,15,15,15,15,10},
				{7,13,13,15,15,15,15,15,15,15,15,15,15,11},
				{1,0,0,5,13,13,13,13,13,13,13,13,13,9}};
		map1.setArr(arr1);
		map.add(map1);
		
		Map map2 = new Map(this, 2);
		int[][] arr2 = {{6,14,14,14,14,14,14,14,14,14,14,14,14,10},
				{7,15,15,15,13,13,15,15,15,15,15,15,15,9},
				{7,15,15,11,0,0,7,15,15,15,15,15,11,0},
				{7,15,15,15,14,14,15,15,15,15,15,15,11,0},
				{7,15,15,15,15,15,15,15,15,15,15,15,11,0},
				{7,15,15,15,15,15,15,15,15,15,15,15,9,0},
				{7,15,15,13,15,15,15,15,15,15,15,9,0,0},
				{5,15,11,0,5,13,15,15,15,15,11,0,0,0},
				{0,7,11,0,0,0,5,15,15,15,11,0,0,0},
				{0,7,11,0,0,0,0,5,15,15,15,10,0,0},
				{0,7,11,0,0,0,0,0,7,15,15,15,10,0},
				{0,7,11,0,0,0,0,0,7,15,15,15,11,0},
				{0,7,11,0,0,0,6,14,15,15,15,15,11,0},
				{0,7,11,0,0,6,15,15,15,15,15,15,9,0},
				{0,5,15,14,14,15,15,15,15,15,15,11,0,0},
				{0,0,7,15,15,15,15,15,15,15,15,11,0,0},
				{0,0,7,13,13,13,13,13,13,13,13,9,0,0},
				{0,0,1,0,0,0,0,0,0,0,0,0,0,0}};
		map2.setArr(arr2);
		map.add(map2);
		
		Map map3 = new Map(this, 3);
		int[][] arr3 = {{6,14,14,14,14,14,12,8,0,0,0,0,0,0},
				{5,15,15,15,15,11,0,0,0,0,0,0,0,0},
				{0,5,15,15,15,15,14,14,14,14,14,14,10,0},
				{0,0,7,15,15,15,15,15,15,15,15,15,11,0},
				{0,4,15,15,15,15,15,15,15,15,15,15,15,10},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
     			{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{4,12,15,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{0,0,7,15,15,15,15,15,15,15,15,15,15,11},
				{6,14,15,15,15,15,15,15,15,15,15,15,15,9},
	    		{7,15,15,15,15,15,15,15,15,15,15,15,9,0},
				{7,15,15,15,15,15,15,15,15,15,15,11,0,0},
				{7,15,15,13,13,15,15,15,15,15,15,11,0,0},
				{7,15,11,0,0,5,15,15,15,15,15,11,0,0},
				{7,15,11,0,0,0,7,15,15,15,15,11,0,0},
				{5,13,13,12,12,12,13,13,13,13,13,13,12,8}};
		map3.setArr(arr3);
		map.add(map3);
		
		Map map4 = new Map(this, 4);
		int arr4[][]= {{6,14,14,14,14,14,14,14,14,14,14,14,14,10},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{7,15,15,15,15,15,15,15,15,15,15,15,15,11},
				{5,13,13,13,13,13,13,13,13,13,13,13,13,9}};
		map4.setArr(arr4);
		map.add(map4);
	}
	
	/**
	 * This function add 2 button to window
	 */
	private void initComps(){
		buttonHomepage = new JButton();
		buttonHomepage.setText("Home");
		buttonHomepage.setBounds(608, 408, 80, 30);
		buttonHomepage.addActionListener(this);
		add(buttonHomepage);
		
//		buttonNext = new JButton();
//		buttonNext.setText("Next");
//		buttonNext.setBounds(600, 357, 80, 30);
//		buttonNext.addActionListener(this);
//		add(buttonNext);	
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
//		g2d.setStroke(new java.awt.BasicStroke(2));
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Items", 620, 30);
		
		g2d.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Equipped", 610, 200);
		
		g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g2d.setColor(Color.BLACK);
		g2d.drawString("Map "+ this.round, 620, 390);
		
		map.get(this.round).drawMap(g2d);
		hero.draw(g2d);
		objectManager.draw(g2d);
	}
	
	public Graphics2D getG2d() {
		return g2d;
	}

	public void setG2d(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public void update() {
		objectManager.update();
		hero.update();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonHomepage){
			gamePanel.getControl().showHomepage();
		
		}
//		if(e.getSource() == buttonNext){
//			this.round++;
//			if(this.round >= map.size()) {
//				this.round = 0;
//				gamePanel.getControl().showHomepage();
//			}
//			else this.paintComponent(this.g2d);
		else {
			gamePanel.getControl().showHomepage();
			gamePanel.getControl().showGamePanel();
		}
				
	}
	
	public void nextMap() {
		if(this.getRound() < 4) {
			this.setRound(this.getRound() + 1);
		}
	}
	
	public void backMap() {
		if(this.getRound() > 0) {
			this.setRound(getRound()-1);
		}
	}
	
}
