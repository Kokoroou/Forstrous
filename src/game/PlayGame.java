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
import javax.swing.JPanel;
public class PlayGame extends JPanel implements Runnable,ActionListener{
	public static boolean IS_RUNNING=true;
	int sleep=30;
	int round=1,a=0,b,change=1,key=2,key1=2,key2=2,key3=2;
	int point=0;
	Image img;
	int hehe=0;
	int alive=0;
	int x1=400,y1=50;
	int x2=200,y2=200;
	int x3=50,y3=300;
	int x4=400,y4=300;
	private MyContainer mContainer;
	private BitSet traceKey = new BitSet();
	private JButton btn_Menu, btn_Next;
	private Manager mMagager = new Manager();
	ImageIcon Kiem1;	
	public PlayGame(MyContainer mContainer) {
		this.mContainer = mContainer;
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
		
		switch (round) {
		case 1:
			mMagager.drawMap1(g2d);
			break;
		case 2:
			mMagager.drawMap2(g2d);
			break;
		case 3:
			mMagager.drawMap3(g2d);
			break;
		case 4:
			mMagager.drawMap4(g2d);
			break;	
		default:		
			break;
		}	
		switch (change) {
		case 1:
			if(b%3==0) {
				img= new ImageIcon(getClass().getResource("/Images/down1.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(b%3==1) {
				img= new ImageIcon(getClass().getResource("/Images/down2.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(b%3==2) {
				img= new ImageIcon(getClass().getResource("/Images/down3.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			break;
		case 2:
			if(b%3==0) {
				img= new ImageIcon(getClass().getResource("/Images/up1.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(b%3==1) {
				img= new ImageIcon(getClass().getResource("/Images/up2.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(b%3==2) {
				img= new ImageIcon(getClass().getResource("/Images/up3.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
		    break;
		case 3:
			if(a%3==0) {
				img= new ImageIcon(getClass().getResource("/Images/left1.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(a%3==1) {
				img= new ImageIcon(getClass().getResource("/Images/left2.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
			if(a%3==2) {
				img= new ImageIcon(getClass().getResource("/Images/left3.png")).getImage();	
				g2d.drawImage(img, a, b, null);
				break;
			}
		    break;
		case 4:
			if(a%3==0) {
				img= new ImageIcon(getClass().getResource("/Images/right1.png")).getImage();	
				g2d.drawImage(img, a, b, null);
			}
			if(a%3==1) {
				img= new ImageIcon(getClass().getResource("/Images/right2.png")).getImage();	
				g2d.drawImage(img, a, b, null);
			}
			if(a%3==2) {
				img= new ImageIcon(getClass().getResource("/Images/right3.png")).getImage();	
				g2d.drawImage(img, a, b, null);
			}
			break;
		default:
			break;
		}
		if(round==1) {
			if(a>=32*16+25&&b>32*12) {
				a=32;
				b=32*13;
				round++;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
			}
		}
		if(round == 2) {
			if(a>=32*16+25&&b>32&&b<70) {
				round++;
				a=32;
				b=32*2;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
			}
			if(a<32&&b>32*12) {
				round--;
				a=32*16;
				b=32*13;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
			}	
		}
		if(round == 3) {
			if(a<32&&b>30&&b<70) {
		
				round--;
				a=32*16;
				b=64;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
			}
			if(a>32*16+25&&b>32*5&&b<32*6+10) {
				round++;
				a=32;
				b=32*5;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
			}
		}
		if(round == 4) {
			
			if(a<32&&b>32*4&&b<32*6) {
				
				round--;
				a=32*16;
				b=32*6;
				x1=300;
				y1=200;
				x2=70;
				y2=300;
				x3=400;
				y3=70;
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
					{0,0,0,1,0,0,0,0,0,0,0,0,0,1},//3
					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},//4
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
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,1,0,0,0,0,0,0,0,0,1,1},
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
			int arr3[][]= {{0,0,0,0,0,0,0,0,1,1,1,1,1,1},
					{0,0,0,0,0,0,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,1,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{0,0,0,0,1,1,0,0,0,0,0,0,0,1},
				   	{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};	
			switch (round) {
			case 1:
				if(traceKey.get(KeyEvent.VK_SPACE)){
					if(a>0) {
						int p=arr1[((a-3))/32][b/32];
						if(p==0)a-=2;
						}
					change=3;
				}
				if(traceKey.get(KeyEvent.VK_RIGHT)){
					if(a<32*17) {
						int p=arr1[(a+20)/32][b/32];
						if(p==0)a+=2;
						}
					change=4;
				}
				if(traceKey.get(KeyEvent.VK_UP)){
					if(b>0) {
						int p=arr1[a/32][(b-3)/32];
						if(p==0) b-=2;
					}
					change=2;
				}
				if(traceKey.get(KeyEvent.VK_DOWN)){
					if(b<32*13) {
						int p=arr1[a/32][(b+20)/32];
						if(p==0) b+=2;
						}
					change=1;
				}	
				break;
			case 2:
				if(traceKey.get(KeyEvent.VK_LEFT)){
					if(a>0) {
						int p=arr2[((a-3))/32][b/32];
						if(p==0)a-=2;
						}
					change=3;
				}
				if(traceKey.get(KeyEvent.VK_RIGHT)){
					if(a<32*17) {
						int p=arr2[(a+20)/32][b/32];
						if(p==0)a+=2;
						}
					change=4;
				}
				if(traceKey.get(KeyEvent.VK_UP)){
					if(b>0) {
						int p=arr2[a/32][(b-3)/32];
						if(p==0) b-=2;
					}
					change=2;
				}
				if(traceKey.get(KeyEvent.VK_DOWN)){
					if(b<32*13) {
						int p=arr2[a/32][(b+20)/32];
						if(p==0) b+=2;
						}	
					change=1;
				}	
				break;
			case 3:
				if(traceKey.get(KeyEvent.VK_LEFT)){
					if(a>0) {
						int p=arr3[((a-3))/32][b/32];
						if(p==0)a-=2;
						}
					change=3;
				}
				if(traceKey.get(KeyEvent.VK_RIGHT)){
					if(a<32*17) {
						int p=arr3[(a+20)/32][b/32];
						if(p==0)a+=2;
						}
					change=4;
				}
				if(traceKey.get(KeyEvent.VK_UP)){
					if(b>0) {
						int p=arr3[a/32][(b-3)/32];
						if(p==0) b-=2;
					}
					change=2;
				}
				if(traceKey.get(KeyEvent.VK_DOWN)){
					if(b<32*13) {
						int p=arr3[a/32][(b+20)/32];
						if(p==0) b+=2;
						}
					change=1;
				}	
				break;
			case 4:
				if(traceKey.get(KeyEvent.VK_LEFT)){
					a-=2;
					change=3;
					
				}
				if(traceKey.get(KeyEvent.VK_RIGHT)){
					a+=2;
					change=4;
				}
				if(traceKey.get(KeyEvent.VK_UP)){
					b-=2;
					change=2;
				}
				if(traceKey.get(KeyEvent.VK_DOWN)){
					b+=2;
					change=1;
				}			
				break;
			default:
				break;
			}	
			try {	
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};		
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			mContainer.setShowMenu();
			point=0;
			a=32;
			b=0;	
		}
		if(e.getSource()==btn_Next){
			round++;
			if(round>4) round = 1;
			//if(round)
		}
	}
}
