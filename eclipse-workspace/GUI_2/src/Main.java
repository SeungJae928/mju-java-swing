import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	MyFrame myFrame;
	Point start;
	Point end;
	
	public MyPanel() {
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyListener());
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		if(start != null) {
			g.drawRect(start.x, start.y, end.x - start.x, end.y - start.y);
		}
	}
	class MyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			start = e.getPoint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			end = e.getPoint();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
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
		f.setSize(500,300);
		
		f.setContentPane(new MyPanel());
		f.setVisible(true);
	}
}
