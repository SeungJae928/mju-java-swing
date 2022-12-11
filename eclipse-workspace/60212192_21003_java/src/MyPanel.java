import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public ArrayList figures = new ArrayList();
	public ArrayList buttons = new ArrayList();
	public MyButton btnRect = new MyButton("사각형");
	public MyButton btnOval = new MyButton("타원");
	public MyButton btnLine = new MyButton("선분");
	protected int x1, y1, x2, y2, type = 0;
	protected Point p;
	public MyPanel() {
		setBackground(new Color(200, 255, 255));
		addMouseListener(new MyListener());
		btnRect.setBounds(10, 10, 70, 25);
		btnOval.setBounds(90, 10, 70, 25);
		btnLine.setBounds(170, 10, 70, 25);
		
		this.add(btnRect);
		this.add(btnOval);
		this.add(btnLine);
	}
	private void add(MyButton btn) {
		buttons.add(btn);
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		for(Object button : buttons) {
			((MyButton) button).draw(g);
		}
		for(Object figure : figures) {
			((Figure) figure).draw(g);
		}
	}
	class MyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			p = e.getPoint();
			if(btnRect.contains(p)) {
				System.out.println("사각형");
				type = 0;
			}
			else if(btnOval.contains(p)) {
				System.out.println("타원");
				type = 1;
			}
			else if(btnLine.contains(p)) {
				System.out.println("선분");
				type = 2;
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
			if(type == 0) {
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
			else if (type == 1) {
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
			else if (type == 2) {
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