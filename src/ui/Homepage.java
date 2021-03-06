package ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Homepage is the class that builds the page where player interacts firstly
 *
 */
public class Homepage extends JPanel {
	private GUI gui;
	private ControlPanel control;
	private JLabel labelGamePanel;
	private JLabel labelOption;
	private JLabel labelExit;
	private JLabel background;
	
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
		labelGamePanel = setLabel((gui.getWidth()-150)/2-40, (gui.getHeight()-30)/2-30, "/image/Play.png");
		labelOption = setLabel(labelGamePanel.getX(), labelGamePanel.getY() + labelGamePanel.getHeight(), "/image/Option.png");
		labelExit = setLabel(labelOption.getX(), labelOption.getY() + labelOption.getHeight(), "/image/Exit.png");
		
		labelGamePanel.addMouseListener(mouseAdapter);
		labelOption.addMouseListener(mouseAdapter);
		labelExit.addMouseListener(mouseAdapter);
		
		add(labelGamePanel);
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
		background.setIcon(new ImageIcon(getClass().getResource("/image/Forstrous.png")));
		
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
			if(e.getSource() == labelGamePanel){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/image/Play1.png"));
				labelGamePanel.setIcon(playIcon);
			}
			if(e.getSource() == labelOption){
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/image/Option1.png"));
				labelOption.setIcon(optionIcon);
			}
			if(e.getSource() == labelExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/image/Exit1.png"));
				labelExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == labelGamePanel){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/image/Play.png"));
				labelGamePanel.setIcon(playIcon);
			}
			if(e.getSource() == labelOption){
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/image/Option.png"));
				labelOption.setIcon(optionIcon);
			}
			if(e.getSource() == labelExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/image/Exit.png"));
				labelExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == labelExit){
				gui.dispose();
				System.exit(0);
			}
			if(e.getSource() == labelGamePanel){
				control.showGamePanel();
			}
			if(e.getSource() == labelOption){
				control.showOption();
			}
		}
	};	
}	
