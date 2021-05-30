import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class GUI extends JFrame{
	public static final int WIDTHJF = 720;
	public static final int HEIGHTJF = 485;
	private MyContainer mContainer;

	public GUI() {
		setTitle("Forstrous");
		setSize(WIDTHJF, HEIGHTJF);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mContainer = new MyContainer(this);
		add(mContainer);
		//addWindowListener(mwindow);
	}
	/*
	private WindowAdapter mwindow = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			PlayGame.IS_RUNNING = false;
		}
	};
	*/
}