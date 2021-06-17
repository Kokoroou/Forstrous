package ui;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * The ControlPanel is the class that builds main layouts of game: Homepage, PlayGame, Option, GameOver, Victory.
 *
 */
public class ControlPanel extends JPanel {
	private static final String TAG_HOMEPAGE = "tag_homepage";
	private static final String TAG_GAMEPANEL = "tag_gamepanel";
	private static final String TAG_OPTION = "tag_option";
	private static final String TAG_GAMEOVER = "tag_gameover";
	private static final String TAG_VICTORY = "tag_victory";
	
	private GUI gui;
	private CardLayout cardLayout;
	private Homepage homepage;
	private GamePanel gamePanel;
	private Option option;
	private GameOver gameOver;
	private Victory victory;
	
	public ControlPanel(GUI gui){
		this.gui = gui;
		this.setBackground(Color.WHITE);
		
		this.cardLayout = new CardLayout();
		this.setLayout(this.cardLayout);
		
		this.homepage = new Homepage(this);
		this.gamePanel = new GamePanel(this);
		this.option = new Option(this);
		this.gameOver = new GameOver(this);
		this.victory = new Victory(this);
		
		this.add(this.homepage, TAG_HOMEPAGE);
		this.add(this.gamePanel, TAG_GAMEPANEL);
		this.add(this.option, TAG_OPTION);
		this.add(this.gameOver, TAG_GAMEOVER);
		this.add(this.victory, TAG_VICTORY);
		this.showHomepage();

	}

	public GUI getGui() {
		return this.gui;
	}
	public void showHomepage(){

		cardLayout.show(this, TAG_HOMEPAGE);
		homepage.requestFocus();
	}

	public void showGamePanel(){

		cardLayout.show(this, TAG_GAMEPANEL);
		gamePanel.requestFocus();
	}
	
	public void showGameOver(){

		cardLayout.show(this, TAG_GAMEOVER);
		gameOver.requestFocus();
	}
	
	public void showOption(){
		cardLayout.show(this, TAG_OPTION);
		option.requestFocus();
	}
	
	public void showVictory() {
		cardLayout.show(this, TAG_VICTORY);
		victory.requestFocus();
	}
}
