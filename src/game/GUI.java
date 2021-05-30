package game;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
public class GUI extends JFrame{
	public static final int WIDTHJF = 590;
	public static final int HEIGHTJF = 482;
	private MyContainer mContainer;

	public GUI() {
		setTitle("Forstrous");
		setSize(WIDTHJF, HEIGHTJF);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mContainer = new MyContainer(this);
		add(mContainer);
	}
}