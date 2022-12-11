import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

interface MyActionListener {
	public void actionPerformed(ActionEvent e);
}


public class MyPanel extends JPanel {
	public ArrayList figures = new ArrayList();
	public ArrayList buttons = new ArrayList();
	public MyButton btnRect = new MyButton("사각형");
	public MyButton btnOval = new MyButton("타원");
	public MyButton btnLine = new MyButton("선분");
	protected int x1, y1, x2, y2, type = 0;
	protected Point p;
	public MyPanel() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		setBackground(new Color(200, 255, 255));
		btnRect.setBounds(10, 10, 70, 25);
		btnOval.setBounds(90, 10, 70, 25);
		btnLine.setBounds(170, 10, 70, 25);
		
		btnRect.addMyActionListener(new MyListener());
		btnOval.addMyActionListener(new MyListener());
		btnLine.addMyActionListener(new MyListener());
		
		this.add(btnRect);
		this.add(btnOval);
		this.add(btnLine);
	}
	class MyListener implements MyActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getSource());
			if(e.getSource() == "사각형") {
				type = 0;
			} else if(e.getSource() == "타원") {
				type = 1;
			} else if(e.getSource() == "선분") {
				type = 2;
			}
		}
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
	@Override public void processMouseEvent(MouseEvent e) {
		switch(e.getID()){
		case MouseEvent.MOUSE_CLICKED:
			if(btnRect.contains(e.getPoint())) {
				btnRect.Clicked();
			} else if(btnOval.contains(e.getPoint())) {
				btnOval.Clicked();
			} else if(btnLine.contains(e.getPoint())) {
				btnLine.Clicked();
			}
		case MouseEvent.MOUSE_PRESSED:
			x1 = e.getX();
			y1 = e.getY();
			break;
		case MouseEvent.MOUSE_RELEASED:
			x2 = e.getX();
			y2 = e.getY();
			if(type == 2) {
				figures.add(new Line(x1, y1, x2, y2));
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
			}
			break;
		}	
	}
}