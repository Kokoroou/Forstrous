package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import effect.*;
import object.*;

public class GamePanel extends JPanel implements KeyListener, Runnable{
	private static final String TAG_GAMEWORLD = "tag_gameworld";
	private static final String TAG_BATTLE = "tag_battle";	
	private Thread thread;
	public static boolean running;
	private BufferedImage bufImage;
	private Graphics2D bufG2D;
	private ControlPanel control;
	private GameWorld gameWorld;
	private Battle battle;
	private CardLayout cardLayout;
	private BitSet traceKey = new BitSet();
	private InputManager inputManager;
	
	public GamePanel(ControlPanel control) {
		
		this.control = control;
		this.cardLayout = new CardLayout();
		
		setLayout(this.cardLayout);
		setFocusable(true);
//		addKeyListener(keyAdapter);
		inputManager = new InputManager(this);
		gameWorld = new GameWorld(this);
		battle = new Battle(this, gameWorld.hero);
		bufImage = new BufferedImage(GUI.WIDTH, GUI.HEIGHT, BufferedImage.TYPE_INT_ARGB);
//		System.out.println(gameWorld.hero);

		
		this.add(this.gameWorld, TAG_GAMEWORLD);
		this.add(this.battle, TAG_BATTLE);
		this.addKeyListener(this);
		this.showGameWorld();
	}
	
//	@Override
//	public void paint (Graphics g) {
//		g.drawImage(bufImage, 0, 0, this);
//		
//	}
	
	public void showGameWorld() {
		cardLayout.show(this, TAG_GAMEWORLD);
		gameWorld.requestFocus();
	}
	
	public void showBattle() {
		cardLayout.show(this, TAG_BATTLE);
		battle.requestFocus();
	}
	
	public ControlPanel getControl() {
		return control;
	}

	public void setControl(ControlPanel control) {
		this.control = control;
	}
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public void updateGame() {
		if(!gameWorld.hero.inBattle) {
//			System.out.println("Update GameWorld");
			gameWorld.update();
		}
		else {
//			System.out.println("Update Battle");
			battle.update();
			
		}
	}
	
//	public void RenderGame() {
//		if(bufImage == null)
//			bufImage = new BufferedImage(GUI.WIDTH, GUI.HEIGHT, BufferedImage.TYPE_INT_ARGB);
//		
//		if(bufImage != null) {
//			bufG2D = (Graphics2D) bufImage.getGraphics();
//		}
//		
//		if(bufG2D != null) {
//			bufG2D.setColor(Color.white);
//			bufG2D.fillRect(0, 0, GUI.WIDTH, GUI.HEIGHT);
//		}
		
//	}
	
	public void startGame() {
		if(thread == null) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {

        long previousTime = System.nanoTime();
        long currentTime;
        long sleepTime;

        long period = 1000000000/30;

        while(running){
//        	System.out.println("Update Game");
            updateGame();
//            System.out.println(gameWorld.hero.inBattle);
//            RenderGame();
        	
            repaint();

            currentTime = System.nanoTime();
            sleepTime = period - (currentTime - previousTime);
            try{

                    if(sleepTime > 0)
                            Thread.sleep(sleepTime/1000000);
                    else Thread.sleep(period/2000000);

            }catch(Exception e){}

            previousTime = System.nanoTime();
        }
        
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputManager.processKeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputManager.processKeyReleased(e.getKeyCode());
	}
	
//	private KeyAdapter keyAdapter = new KeyAdapter() {
//		@Override
//		public void keyPressed(KeyEvent e) {
//			traceKey.set(e.getKeyCode());
//		}
//		
//		@Override
//		public void keyReleased(KeyEvent e) {
//			traceKey.clear(e.getKeyCode());
//		}
//	};
}
