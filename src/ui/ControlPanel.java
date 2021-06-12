package ui;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	private static final String TAG_HOMEPAGE = "tag_homepage";
	private static final String TAG_PLAYGAME = "tag_playgame";
	private static final String TAG_OPTION = "tag_option";
	private CardLayout cardLayout;
	private GUI gui;
	private Homepage homepage;
	private PlayGame playGame;
	private Option option;
	public ControlPanel(GUI gui){
		this.gui = gui;
		setBackground(Color.WHITE);
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		homepage = new Homepage(this);
		add(homepage,TAG_HOMEPAGE);
		option = new Option(this);
		add(option, TAG_OPTION);
		playGame = new PlayGame(this);
		add(playGame, TAG_PLAYGAME);
		
		setShowHomepage();

	}

	public GUI getGui() {
		return gui;
	}
	public void setShowHomepage(){
		cardLayout.show(ControlPanel.this, TAG_HOMEPAGE);
		homepage.requestFocus();
	}

	public void setShowPlay(){
		cardLayout.show(ControlPanel.this, TAG_PLAYGAME);
		playGame.requestFocus();
	}
	public void setShowOption(){
		cardLayout.show(ControlPanel.this, TAG_OPTION);
		option.requestFocus();
	}
	
}
