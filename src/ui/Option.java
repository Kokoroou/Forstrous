package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Option extends JPanel implements ActionListener{
	private ControlPanel control;
	private JLabel background;
	private ImageIcon Background;
	private JButton btn_Menu;
	
	public Option(ControlPanel mContainer) {
		this.control = control;
		setBackground(Color.WHITE);
		setLayout(null);
		initCompts();
	}
	
	public void initCompts(){
		background = new JLabel();
		background.setBounds(0, -18, GUI.WIDTH, GUI.HEIGHT);
		background.setBackground(Color.BLACK);
		Background = new ImageIcon(getClass().getResource("/image/Forstrous.png"));
		background.setIcon(Background);
		add(background);
		
		btn_Menu = new JButton();
		btn_Menu.setText("Menu");
		btn_Menu.setBounds(600, 417, 80, 30);
		btn_Menu.addActionListener(this);
		add(btn_Menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			control.setShowMenu();
		}	
		
	}
	
}
