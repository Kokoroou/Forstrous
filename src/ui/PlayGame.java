package ui;

import object.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The PlayGame is the class that control user's playing process
 * PlayGame has 2 layouts: GameWorld, Battle
 *
 */
//public class PlayGame extends JPanel implements Runnable, ActionListener {
public class PlayGame extends JPanel {
	private static final String TAG_GAMEWORLD = "tag_gameworld";
	private static final String TAG_BATTLE = "tag_battle";	
	public static boolean running = true;
	private CardLayout cardLayout;
	private ControlPanel control;
	private GameWorld gameWorld;
	private Battle battle;
	private JButton buttonHomepage, buttonNext;

	private int round = 0;
	private BitSet traceKey = new BitSet();
//	private Map map = new Map();
//	private Hero hero = new Hero();
//	int round=0,change=1,key=1,key1=1,key2=1;;
//	Image img;
//		
//	public Hero getHero() {
//		return this.hero;
//	}
//	public void setHero() {
//		this.hero = hero;
//	}
	
	public PlayGame(ControlPanel control) {
		this.control = control;
		this.cardLayout = new CardLayout();
		
		setBackground(Color.WHITE);
		setLayout(this.cardLayout);
		setFocusable(true);
		addKeyListener(keyAdapter);
		
		//Add layouts to PlayGame
		this.gameWorld = new GameWorld(this);
		this.battle = new Battle(this);
		
		this.add(this.gameWorld, TAG_GAMEWORLD);
		this.add(this.battle, TAG_BATTLE);
		
		this.showGameWorld();
		
//		Thread thread = new Thread(this);
//		Thread thread = new Thread();
		
//		thread.start();
//		initCompts();
	}
	
	public void showGameWorld() {
		cardLayout.show(this, TAG_GAMEWORLD);
		gameWorld.requestFocus();
	}
	
	public void showBattle() {
		cardLayout.show(this, TAG_BATTLE);
		battle.requestFocus();
	}
	
//	/**
//	 * This function add 2 button to window
//	 */
//	private void initCompts(){
//		buttonHomepage = new JButton();
//		buttonHomepage.setText("Home");
//		buttonHomepage.setBounds(600, 417, 80, 30);
//		buttonHomepage.addActionListener(this);
//		add(buttonHomepage);
//		
//		buttonNext = new JButton();
//		buttonNext.setText("Next");
//		buttonNext.setBounds(600, 357, 80, 30);
//		buttonNext.addActionListener(this);
//		add(buttonNext);	
//	}
	
	public ControlPanel getControl() {
		return control;
	}

	public void setControl(ControlPanel control) {
		this.control = control;
	}

//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setStroke(new java.awt.BasicStroke(2));
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setFont(new Font("Arial", Font.BOLD, 20));
//		g2d.setColor(Color.RED);
//		g2d.drawString("Map "+ this.round, 610, 25);
//		map.drawMap(g2d, this.round);
		
//		if(this.round==1) {			
//			if(hero.mapX >= 32*16+25 && hero.mapY > 32*12) {
//				this.round++;
//				hero.mapX = 32;
//				hero.mapY = 32*13;
//			}
//		}
//		if(this.round == 2) {
//			
//			if(hero.mapX >= 32*16+25 && hero.mapY > 32 && hero.mapY < 70) {
//				this.round++;
//				hero.mapX = 32;
//				hero.mapY = 32*2;
//			}
//			if(hero.mapX < 32 && hero.mapY > 32*12) {
//				this.round--;
//				hero.mapX = 32*16;
//				hero.mapY = 32*13;
//			}	
//		}
//		if(this.round == 3) {
//
//			if(hero.mapX < 32 && hero.mapY > 30 && hero.mapY < 70) {
//				this.round--;
//				hero.mapX = 32*16;
//				hero.mapY = 64;
//			}
//			if(hero.mapX > 32*16+25 && hero.mapY > 32*5 && hero.mapY < 32*6+10) {
//				this.round++;
//				hero.mapX = 32;
//				hero.mapY = 32*5;
//			}
//		}
//		if(this.round == 4) {	
//			if(hero.mapX < 32 && hero.mapY > 32*4 && hero.mapY < 32*6) {
//				this.round--;
//				hero.mapX = 32*16;
//				hero.mapY = 32*6;
//			}
//		}
//	}
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	private KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			traceKey.set(e.getKeyCode());
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			traceKey.clear(e.getKeyCode());
		}
	};
	
//	@Override
//	public void run() {
//		while(running){
//			repaint();
//			int arr1[][]= {{0,0,0,1,1,1,1,1,1,1,1,1,1,1},//1
//					{0,0,0,1,0,0,0,0,0,0,0,0,0,1},//2
//					{0,0,0,1,0,0,0,0,0,0,0,0,1,1},//3
//					{1,0,0,0,0,0,0,0,0,0,0,0,1,1},//4
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,1},//5
//					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},//6
//					{1,1,1,1,0,0,0,0,0,0,0,0,1,1},//7
//					{1,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
//					{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//9
//					{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//10
//					{1,0,0,0,0,0,0,1,1,0,0,0,0,1},//11
//					{0,0,0,0,0,0,0,0,1,0,0,0,0,1},//12
//					{0,0,0,0,0,0,0,0,0,0,1,1,1,1},//13
//					{0,1,0,0,0,0,0,0,0,0,0,0,1,1},//14
//					{0,1,0,0,0,0,0,0,0,0,0,0,0,1},//15
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//17
//				   	{0,1,1,0,0,0,0,0,0,0,0,0,0,0}};//17
//			int arr2[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//					{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
//					{0,0,0,1,0,0,0,0,0,0,0,1,1,1},
//					{1,0,0,1,1,1,0,0,0,0,0,0,1,1},
//					{1,0,0,1,1,1,1,0,0,0,0,0,0,1},
//					{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
//					{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
//					{1,0,0,1,1,1,0,0,0,0,0,0,0,1},
//					{1,0,0,1,1,0,0,0,0,0,0,0,0,1},
//					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{1,1,0,0,0,0,0,0,0,0,0,0,1,1},
//				   	{1,1,0,1,1,1,1,1,1,1,1,1,1,1}};
//			int arr[][]= {{0,0,0,0,0,0,0,0,1,1,1,1,1,1},
//					{0,0,0,0,0,0,1,1,1,1,1,1,1,1},
//					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,1},
//					{1,0,0,0,0,0,0,0,0,0,0,0,0,0},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
//					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//					{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
//				   	{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
//			try {
//				Thread.sleep(20);				
//				if(traceKey.get(KeyEvent.VK_LEFT)){
//					hero.mapX-=2;
//					change=3;				
//				}
//				if(traceKey.get(KeyEvent.VK_RIGHT)){
//					hero.mapX+=2;
//					change=4;
//				}
//				if(traceKey.get(KeyEvent.VK_UP)){
//					hero.mapY-=2;
//					change=2;
//				}
//				if(traceKey.get(KeyEvent.VK_DOWN)){
//					hero.mapY+=2;
//					change=1;
//				}
//				
//				
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			};
//		}	
//		
//	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == buttonHomepage){
//			control.showHomepage();
//		
//		}
//		if(e.getSource() == buttonNext){
//			this.round++;
//			if(this.round > 4) {
//				
//			}
//		}
//	}
}
