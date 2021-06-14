package ui;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

import object.Battle;

/**
 * The ControlPanel is the class that make a base to build main layouts of game: Homepage, PlayGame, Option
 *
 */
public class ControlPanel extends JPanel {
	private static final String TAG_HOMEPAGE = "tag_homepage";
	private static final String TAG_GAMEPANEL = "tag_gamepanel";
	private static final String TAG_GAMEOVER = "tag_gameover";
	private static final String TAG_OPTION = "tag_option";

	private CardLayout cardLayout;
	private GUI gui;
	private Homepage homepage;
	private GamePanel gamePanel;
	private GameOver gameOver;
	private Option option;

	
	public ControlPanel(GUI gui){
		this.gui = gui;
		this.setBackground(Color.WHITE);
		
		this.cardLayout = new CardLayout();
		this.setLayout(this.cardLayout);
		
		//Add layouts to ControlPanel
		this.homepage = new Homepage(this);
		this.gamePanel = new GamePanel(this);
		this.gameOver = new GameOver(this);
		this.option = new Option(this);

		
		this.add(this.homepage, TAG_HOMEPAGE);
		this.add(this.gamePanel, TAG_GAMEPANEL);
		this.add(this.gameOver, TAG_GAMEOVER);
		this.add(this.option, TAG_OPTION);
		
		this.showHomepage();

	}

	public GUI getGui() {
		return this.gui;
	}
	public void showHomepage(){
//		cardLayout.show(ControlPanel.this, TAG_HOMEPAGE);
		cardLayout.show(this, TAG_HOMEPAGE);
		homepage.requestFocus();
	}

	public void showGamePanel(){
//		cardLayout.show(ControlPanel.this, TAG_PLAYGAME);
		cardLayout.show(this, TAG_GAMEPANEL);
		gamePanel.requestFocus();
	}
	public void showGameOver(){
//		cardLayout.show(ControlPanel.this, TAG_PLAYGAME);
		cardLayout.show(this, TAG_GAMEOVER);
		gameOver.requestFocus();
	}	
	public void showOption(){
//		cardLayout.show(ControlPanel.this, TAG_OPTION);
		cardLayout.show(this, TAG_OPTION);
		option.requestFocus();
	}
	
}
