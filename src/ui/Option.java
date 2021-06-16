package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Option extends JPanel implements ActionListener{
	private ControlPanel control;
	private JLabel background;
	private ImageIcon Background;
	private JButton buttonHomepage;
	
	public Option(ControlPanel control) {
		this.control = control;
		setBackground(Color.WHITE);
		setLayout(null);
		initComps();
	}
	
	public void initComps(){

		buttonHomepage = new JButton();
		buttonHomepage.setText("Home");
		buttonHomepage.setBounds(608, 408, 80, 30);
		buttonHomepage.addActionListener(this);
		add(buttonHomepage);
		
		background = new JLabel();
		background.setBounds(0, 0, GUI.WIDTH, GUI.HEIGHT);
		background.setBackground(Color.BLACK);
		Background = new ImageIcon(getClass().getResource("/image/Forstrous.png"));
		background.setIcon(Background);
		add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonHomepage){
			control.showHomepage();
		
		}
		else {
			control.showHomepage();
			control.showGamePanel();
		}
				
	}
		
}
