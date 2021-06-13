package ui;

import java.awt.CardLayout;
import java.awt.Dimension;

//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * The GUI is the class that create a window of game
 *
 */
public class GUI extends JFrame {
	public static final int WIDTH = 720;
	public static final int HEIGHT = 448;
	private ControlPanel control;

	public GUI() {
		this.setTitle("Forstrous");	
		this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.pack();
		this.setLayout(new CardLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.control = new ControlPanel(this);
		add(this.control);
	}
}