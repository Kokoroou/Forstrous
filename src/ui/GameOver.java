package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 * The GameOver is the class that displays when player loses this game.
 *
 */
public class GameOver extends JPanel {
	private GUI gui;
	private ControlPanel control;
	private JLabel background;
	
	public GameOver(ControlPanel control) {
		this.control = control;
		this.gui = control.getGui();
		this.setBackground(Color.YELLOW);
		this.setLayout(null);

		this.initBackground();
	}
	
	//Draw Background
	private void initBackground() {
		background = new JLabel();
		
		background.setBounds(0, -18, gui.getWidth(), gui.getHeight());
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(getClass().getResource("/image/GameOver.png")));
		
		add(background);
	}
	
	
	
	
}
