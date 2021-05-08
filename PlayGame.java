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
	private MyContainer mContainer;
	private BitSet traceKey = new BitSet();
	private JButton btn_Menu;
	private Manager mMagager = new Manager();
	
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
		btn_Menu.setBounds(495, 417, 80, 30);
		btn_Menu.addActionListener(this);
		add(btn_Menu);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new java.awt.BasicStroke(2));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		mMagager.draWBackground(g2d);
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_Menu){
			mContainer.setShowMenu();
		}	
		
	}
}
