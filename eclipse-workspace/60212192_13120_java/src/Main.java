import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;


class Rect{
	int x, y, width, height;
	Rect(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}

class MyFrame extends JFrame { 
	protected int x1, y1, x2, y2;
	private ArrayList<Rect> rects = new ArrayList<>();
	public MyFrame() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override public void processMouseEvent(MouseEvent e) {
		switch(e.getID()){
		case MouseEvent.MOUSE_PRESSED:
			x1 = e.getX();
			y1 = e.getY();
			break;
		case MouseEvent.MOUSE_RELEASED:
			x2 = e.getX();
			y2 = e.getY();
			if(x1 > x2) {
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			if(y1 > y2) {
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			rects.add(new Rect(x1, y1, x2 - x1, y2 - y1));
			repaint();
			break;
		}	
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		for(Rect rect: rects) {
			rect.draw(g);
		}
	}
}

public class Main {
	public static void main(String [] args) {
		MyFrame f = new MyFrame();
		
		f.setVisible(true);
	}
}
