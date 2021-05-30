

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Option extends JPanel implements ActionListener{
	private MyContainer mContainer;
	private JLabel lbbackground;
	private ImageIcon backgroundIcon;
	private JButton btn_Menu;
	
	public Option(MyContainer mContainer) {
		this.mContainer = mContainer;
		setBackground(Color.YELLOW);
		setLayout(null);
		initCompts();
	}
	
	public void initCompts(){
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -18, GUI.WIDTHJF, GUI.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/Forstrous2.png"));
		lbbackground.setIcon(backgroundIcon);
		add(lbbackground);
		
		btn_Menu = new JButton();
		btn_Menu.setText("Menu");
		btn_Menu.setBounds(0, 0, 80, 30);
		btn_Menu.addActionListener(this);
		add(btn_Menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			mContainer.setShowMenu();
		}	
		
	}
	
}
