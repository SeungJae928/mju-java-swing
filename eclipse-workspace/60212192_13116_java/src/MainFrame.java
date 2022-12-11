import java.awt.AWTEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	protected int x1, y1, x2, y2;
	public MainFrame() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
		
		mf.setVisible(true);
		// 리스너를 추가한다.
	}

}