//package ui;
//
//import java.awt.Graphics;
//import java.awt.Image;
//
//import javax.swing.JFrame;
//
//public class Display extends JFrame {
//	
//	Image img;
//	
//	public Display(Image img) {
//		//Set JFrame title
//		super("Display an image");
//		
//		//Set default close operation for JFrame
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//Set JFrame size
//		setSize(300, 300);
//		
//		//Set visible
//		setVisible(true);
//		
//		//Set this image
//		this.img = img;
//	}
//	
//	public void paint(Graphics g) {
//		super.paint(g);
//		
//		g.drawImage(this.img, 0, 0, 397, 281, 500, 500, 100, 100,  this);
//	}
//}
