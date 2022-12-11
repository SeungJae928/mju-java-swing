import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel extends JPanel {
	public ArrayList figures = new ArrayList();
	protected int x1, y1, x2, y2;
	protected int x = 2;
	protected int y = 2;
	public MyPanel() {
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyListener());
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1, 1, 100, 50);
		g.drawRect(101, 1, 100, 50);
		g.drawRect(201, 1, 100, 50);
		g.drawRect(1, 51, 40, 20);
		
		g.drawString("사각형", 30, 30);
		g.drawString("타원형", 130, 30);
		g.drawString("선분", 240, 30);
		g.drawString("지우기", 4, 66);
		
		for(Object figure : figures) {
			((Figure) figure).draw(g);
		}
	}
	class MyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(x > 1 && x < 40 && y > 51 && y < 70) {
				figures.clear();
				repaint();
				x = 2; y = 2;
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			if(x > 1 && x < 101 && y > 1 && y < 50) {
				if(x2 > x1 && y2 > y1) {
					figures.add(new Rect(x1, y1, x2-x1, y2-y1));
					repaint();
				}
				else if (x2 < x1 && y2 > y1) {
					figures.add(new Rect(x2, y1, x1-x2, y2-y1));
					repaint();
				}
				else if (x2 < x1 && y2 < y1) {
					figures.add(new Rect(x2, y2, x1-x2, y1-y2));
					repaint();
				}
				else if (x2 > x1 && y2 < y1) {
					figures.add(new Rect(x1, y2, x2-x1, y1-y2));
					repaint();
				}
			}
			else if (x > 101 && x < 200 && y > 1 && y < 50) {
				if(x2 > x1 && y2 > y1) {
					figures.add(new Oval(x1, y1, x2-x1, y2-y1));
					repaint();
				}
				else if (x2 < x1 && y2 > y1) {
					figures.add(new Oval(x2, y1, x1-x2, y2-y1));
					repaint();
				}
				else if (x2 < x1 && y2 < y1) {
					figures.add(new Oval(x2, y2, x1-x2, y1-y2));
					repaint();
				}
				else if (x2 > x1 && y2 < y1) {
					figures.add(new Oval(x1, y2, x2-x1, y1-y2));
					repaint();
				}
			}
			else if (x > 201 && x <300 && y > 1 && y < 50) {
				figures.add(new Line(x1, y1, x2, y2));
				repaint();
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
}

class Figure {
	protected int width;
	protected int height;
	protected int x, y, x2, y2;
	protected String str;
	void draw(Graphics g) {};
}

class Rect extends Figure {
	Rect(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}

class Oval extends Figure {
	Oval(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override void draw(Graphics g) {
		g.drawOval(x, y, width, height);
	}
}

class Line extends Figure {
	Line(int x, int y, int x2, int y2){
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	@Override void draw(Graphics g) {
		g.drawLine(x, y, x2, y2);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
	}
	
}

public class Main {
	public static void main(String [] args) {
		JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700,400);
		
		f.setContentPane(new MyPanel());
		f.setVisible(true);
	}
}
