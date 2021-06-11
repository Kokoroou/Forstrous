package ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class GUI extends JFrame{
	public static final int WIDTH = 720;
	public static final int HEIGHT = 485;
	private ControlPanel control;

	public GUI() {
		setTitle("Forstrous");
		setSize(WIDTH, HEIGHT);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		control = new ControlPanel(this);
		add(control);
	}
}