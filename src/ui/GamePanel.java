package ui;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * The GamePanel is the class that builds 2 layouts of playing process: GameWorld, Battle.
 *
 */
public class GamePanel extends JPanel implements KeyListener, Runnable{
	private static final String TAG_GAMEWORLD = "tag_gameworld";
	private static final String TAG_BATTLE = "tag_battle";	
	private Thread thread;
	public static boolean running;
	private ControlPanel control;
	private GameWorld gameWorld;
	private Battle battle;
	private CardLayout cardLayout;
	private InputManager inputManager;
	
	public GamePanel(ControlPanel control) {
		this.control = control;
		this.cardLayout = new CardLayout();
		
		setLayout(this.cardLayout);
		setFocusable(true);
		
		inputManager = new InputManager(this);
		gameWorld = new GameWorld(this);
		battle = new Battle(this, gameWorld.hero);
		
		this.add(this.gameWorld, TAG_GAMEWORLD);
		this.add(this.battle, TAG_BATTLE);
		this.addKeyListener(this);
		
		this.showGameWorld();
	}
	
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

	public void startGame() {
		if(thread == null) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void updateGame() {
		if(!gameWorld.hero.inBattle)
			gameWorld.update();
		else battle.update();
	}
	
	@Override
	public void run() {
        long previousTime = System.nanoTime();
        long currentTime;
        long sleepTime;

        long period = 1000000000/30;

        while(running){
            updateGame();
        	
            repaint();

            currentTime = System.nanoTime();
            sleepTime = period - (currentTime - previousTime);
            try {
                if(sleepTime > 0)
                        Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);

            } catch(Exception e) {}

            previousTime = System.nanoTime();
        }
    }
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		inputManager.processKeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputManager.processKeyReleased(e.getKeyCode());
	}
	
}
