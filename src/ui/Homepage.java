package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The Homepage is the class that build the page where user interact firstly
 *
 */
public class Homepage extends JPanel {
	private int padding = 10; //Distant between 2 button
	private GUI gui;
	private ControlPanel control;
	private JLabel labelPlayGame;
	private JLabel labelOption;
	private JLabel labelExit;
	private JLabel background;
//	private ImageIcon Background;
	
	public Homepage(ControlPanel control) {
		this.control = control;
		this.gui = control.getGui();
		this.setBackground(Color.YELLOW);
		this.setLayout(null);
		
		//Initialize homepage
		this.initComps(this.gui);
		this.initBackground();
	}
	
	/**
	 * This function add 3 buttons to homepage
	 */
	public void initComps(GUI gui){
		labelPlayGame = setLabel((gui.getWidth()-150)/2-40, (gui.getHeight()-30)/2-30, "/image/newgame.png");
		labelOption = setLabel(labelPlayGame.getX(), labelPlayGame.getY() + labelPlayGame.getHeight() + this.padding, "/image/option.png");
		labelExit = setLabel(labelOption.getX(), labelOption.getY() + labelOption.getHeight() + padding, "/image/exit.png");
		
		labelPlayGame.addMouseListener(mouseAdapter);
		labelOption.addMouseListener(mouseAdapter);
		labelExit.addMouseListener(mouseAdapter);
		
		add(labelPlayGame);
		add(labelOption);
		add(labelExit);	
	}
	
	/**
	 * This function draw background of the homepage
	 */
	public void initBackground(){
		background = new JLabel();
		
		background.setBounds(0, -18, gui.getWidth(), gui.getHeight());
		background.setBackground(Color.BLACK);
		background.setIcon(new ImageIcon(getClass().getResource("/image/Forstrous2.png")));
		
		add(background);
	}
	
	public JLabel setLabel(int x, int y, String ImageIcon){
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		
		return label;
	}
	
	private MouseAdapter mouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == labelPlayGame){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/image/newgame1.png"));
				labelPlayGame.setIcon(playIcon);
			}
			if(e.getSource() == labelOption){
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/image/option1.png"));
				labelOption.setIcon(optionIcon);
			}
			if(e.getSource() == labelExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/image/exit1.png"));
				labelExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == labelPlayGame){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/image/newgame.png"));
				labelPlayGame.setIcon(playIcon);
			}
			if(e.getSource() == labelOption){
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/image/option.png"));
				labelOption.setIcon(optionIcon);
			}
			if(e.getSource() == labelExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/image/exit.png"));
				labelExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == labelExit){
				gui.dispose();
				System.exit(0);
			}
			if(e.getSource() == labelPlayGame){
				control.showPlay();
			}
			if(e.getSource() == labelOption){
				control.showOption();
			}
		}
	};
	
	
}	
