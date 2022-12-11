import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	public MyPanel() {
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyListener());
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1, 1, 50, 50);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
//		getContentPane().setBackground(Color.yellow);
	}
	
}

public class Main {
	public static void main(String [] args) {
		JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200,100);
		
		f.setContentPane(new MyPanel());
		f.setVisible(true);
	}
}
