package ui;

import object.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayGame extends JPanel implements Runnable,ActionListener{
	public static boolean IS_RUNNING=true;
	int round=0,change=1,key=1,key1=1,key2=1;;
	Image img;
	int x=0,y=0;
	private ControlPanel control;
	private BitSet traceKey = new BitSet();
	private JButton btn_Menu, btn_Next,kiem1;
	private Map map = new Map();
	
	public PlayGame(ControlPanel control) {
		this.control = control;
		setBackground(Color.WHITE);
		setLayout(null);
		setFocusable(true);
		addKeyListener(keyAdapter);
		Thread mytheard = new Thread(this);
		mytheard.start();
		innitCompts();
	}
	private void innitCompts(){
		btn_Menu = new JButton();
		btn_Menu.setText("Menu");
		btn_Menu.setBounds(600, 417, 80, 30);
		btn_Menu.addActionListener(this);
		add(btn_Menu);
		
		btn_Next = new JButton();
		btn_Next.setText("Next");
		btn_Next.setBounds(600, 357, 80, 30);
		btn_Next.addActionListener(this);
		add(btn_Next);	
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new java.awt.BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		g2d.setColor(Color.RED);
		g2d.drawString("Map "+round, 610, 25);
		map.drawMap(g2d, round);
		if(round==1) {			
			if(x>=32*16+25&&y>32*12) {
				x=32;y=32*13;
				round++;
			}
		}
		if(round == 2) {
			
			if(x>=32*16+25&&y>32&&y<70) {
				round++;
				x=32;y=32*2;
			}
			if(x<32&&y>32*12) {
				round--;
				x=32*16;y=32*13;
			}	
		}
		if(round == 3) {

			if(x<32&&y>30&&y<70) {
				round--;
				x=32*16;y=64;
			}
			if(x>32*16+25&&y>32*5&&y<32*6+10) {
				round++;
				x=32;y=32*5;
			}
		}
		if(round == 4) {	
			if(x<32&&y>32*4&&y<32*6) {
				round--;
				x=32*16;y=32*6;
			}
		}
	}
	
	private KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			traceKey.set(e.getKeyCode());
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			traceKey.clear(e.getKeyCode());
		}
	};
	
	@Override
	public void run() {
		while(IS_RUNNING){
			repaint();
			int arr1[][]= {{0,0,0,1,1,1,1,1,1,1,1,1,1,1},//1
					{0,0,0,1,0,0,0,0,0,0,0,0,0,1},//2
					{0,0,0,1,0,0,0,0,0,0,0,0,1,1},//3
					{1,0,0,0,0,0,0,0,0,0,0,0,1,1},//4
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1},//5
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},//6
					{1,1,1,1,0,0,0,0,0,0,0,0,1,1},//7
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0},//8
					{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//9
					{1,0,0,0,0,0,0,1,1,0,0,0,0,0},//10
					{1,0,0,0,0,0,0,1,1,0,0,0,0,1},//11
					{0,0,0,0,0,0,0,0,1,0,0,0,0,1},//12
					{0,0,0,0,0,0,0,0,0,0,1,1,1,1},//13
					{0,1,0,0,0,0,0,0,0,0,0,0,1,1},//14
					{0,1,0,0,0,0,0,0,0,0,0,0,0,1},//15
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//16
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},//17
				   	{0,1,1,0,0,0,0,0,0,0,0,0,0,0}};//17
			int arr2[][]= {{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{0,0,0,1,0,0,0,0,0,0,0,1,1,1},
					{1,0,0,1,1,1,0,0,0,0,0,0,1,1},
					{1,0,0,1,1,1,1,0,0,0,0,0,0,1},
					{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
					{1,0,0,1,1,1,1,1,0,0,0,0,0,1},
					{1,0,0,1,1,1,0,0,0,0,0,0,0,1},
					{1,0,0,1,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,1,1},
				   	{1,1,0,1,1,1,1,1,1,1,1,1,1,1}};
			int arr[][]= {{0,0,0,0,0,0,0,0,1,1,1,1,1,1},
					{0,0,0,0,0,0,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
				   	{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
			try {
				Thread.sleep(20);				
				if(traceKey.get(KeyEvent.VK_LEFT)){
					x-=2;
					change=3;				
				}
				if(traceKey.get(KeyEvent.VK_RIGHT)){
					x+=2;
					change=4;
				}
				if(traceKey.get(KeyEvent.VK_UP)){
					y-=2;
					change=2;
				}
				if(traceKey.get(KeyEvent.VK_DOWN)){
					y+=2;
					change=1;
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			control.setShowMenu();
		
		}
		if(e.getSource()==btn_Next){
			round++;
			if(round>4) round = 1;
		}
	}
}
