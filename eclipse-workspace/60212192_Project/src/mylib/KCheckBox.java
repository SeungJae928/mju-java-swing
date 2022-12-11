package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KCheckBox extends KAbstractButton{
	private boolean isChecked = false;
	public KCheckBox(String text) {
		super(text);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override public boolean contains(Point p) {
		return x <= p.x && x + width >= p.x && y <= p.y && p.y <= y + height;
	}
	@Override public void draw(Graphics g) {
		if(isChecked) {
			g.setColor(Color.red);
			g.fillOval(x + 3, y + height / 3, 10, 10);
		}
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		g.drawString(text, x + (width - text.length())/5 + 4, y + 22);
		g.drawOval(x + 3, y + height / 3, 10, 10);
	}
	@Override public void processMouseEvent(MouseEvent e) {
		changeState();
		if(isChecked) {
			kal.actionPerformed(new ActionEvent(this.text + isChecked, e.getID(), ""));
		} else if(!isChecked) {
			kal.actionPerformed(new ActionEvent(this.text + isChecked, e.getID(), ""));
		}
	}
	@Override public void addKActionListener (KActionListener al){
		this.kal = al;
	}
	public void changeState() {
		if(isChecked) {
			isChecked = false;
		} else if(!isChecked) {
			isChecked = true;
		}
	}
	public void unClicked() {
		isChecked = false;
	}
}
