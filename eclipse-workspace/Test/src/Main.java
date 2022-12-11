import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

class MyFrame extends JFrame {
	Color color = new Color(0,0,0);
	ArrayList<JButton> buttons = new ArrayList<>();
	ArrayList<Figure> figures = new ArrayList<>();
	JToolBar tool = new JToolBar();
	private int x1, y1, x2, y2, type = 0;
	int minX, minY, maxX, maxY;
	Group g;
	public MyFrame() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		tool.setBackground(Color.gray);
		buttons.add(new JButton("사각형"));
		buttons.add(new JButton("타원"));
		buttons.add(new JButton("선분"));
		buttons.add(new JButton("복합도형"));
		buttons.add(new JButton("빨강"));
		buttons.add(new JButton("파랑"));
		buttons.add(new JButton("초록"));
		
		ActionListener lis = new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				Object p = e.getSource();
				if(((AbstractButton) p).getText().equals("사각형")) {
					type = 0;
				} else if(((AbstractButton) p).getText().equals("타원")) {
					type = 1;
				} else if(((AbstractButton) p).getText().equals("선분")) {
					type = 2;
				} else if(((AbstractButton) p).getText().equals("복합도형")) {
					type = 3;
				} else if(((AbstractButton) p).getText().equals("빨강")) {
					Figure.color_in = new Color(255,0,0);
				} else if(((AbstractButton) p).getText().equals("파랑")) {
					Figure.color_in = new Color(0,0,255);
				} else if(((AbstractButton) p).getText().equals("초록")) {
					Figure.color_in = new Color(0,255,0);
				}
			}
		};
		
		for(JButton button : buttons) {
			tool.add(button);
			button.addActionListener(lis);
		}
		
		this.add(tool, BorderLayout.NORTH);
		
		
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		
		for(Figure figure : figures) {
			figure.draw(g);
		}
	}
	
	@Override public void processMouseEvent(MouseEvent e) {
		switch(e.getID()){
		case MouseEvent.MOUSE_CLICKED:
			if(type == 4 && !g.contain(e.getX(), e.getY())) {
				System.out.println("Clicked");
				type = 3;
			}
			break;
		case MouseEvent.MOUSE_PRESSED:
			x1 = e.getX();
			y1 = e.getY();
			if(type == 3 && g != null) {
				if(g.contain(x1, y1)) {
					type = 4;
				}
			}
			break;
		case MouseEvent.MOUSE_RELEASED:
			x2 = e.getX();
			y2 = e.getY();
			if(type == 2) {
				figures.add(new Line(x1, y1, x2, y2));
				repaint();
			} 
			else if(type == 4) {
				g.setLocation(x1, y1, x2, y2);
				for(int i = 0; i < g.group.size(); i++) {
					((Figure) g.group.get(i)).setLocation(x1, y1, x2, y2);
				}
				repaint();
			}
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
			if(type == 0) {
				figures.add(new Rect(x1, y1, x2-x1, y2-y1));
				repaint();
			} else if(type == 1) {
				figures.add(new Oval(x1, y1, x2-x1, y2-y1));
				repaint();
			} else if(type == 3) {
				int minX = minY = maxX = maxY = -1;
				for(Figure figure : figures) {
					if(figure.contains(x1, y1, x2, y2)) {
						if(figure.getX() < minX || minX == -1) {
							minX = figure.getX();
						}
						if(figure.getY() < minY || minY == -1) {
							minY = figure.getY();
						}
						if(figure.getX2() > maxX || maxX == -1) {
							maxX = figure.getX2();
						}
						if(figure.getY2() > maxY || maxY == -1) {
							maxY = figure.getY2();
						}
					}
				}
				g = new Group(minX, minY, maxX, maxY);
				
				for(Figure figure : figures) {
					if(figure.contains(x1, y1, x2, y2)) {
						g.add(figure);
					}
				}
				figures.add(g);
				System.out.println(g.group);
				repaint();
			} 
			break;
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700,400);
		
		f.setVisible(true);
	}

}
