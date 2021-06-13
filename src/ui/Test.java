package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

	Image img;
	public Test()
	{
//		img = new ImageIcon(getClass().getResource("newgame.png")).getImage();
	}
	
	public void paint(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
	
	public static void main(String[] args)
	{
//		new Test().setVisible(true);
//		JLabel label = new JLabel();
//		ImageIcon Icon = new ImageIcon(getClass().getResource("/image/newgame.png"));
//		label.setBounds(0, 0, Icon.getIconWidth(), Icon.getIconHeight());
//		label.setIcon(Icon);
//		
//		JFrame x = new JFrame();
//		x.add(label);
//		x.setVisible(true);
		
	}

}
