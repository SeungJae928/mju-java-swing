package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KComponent{
	protected KActionListener kal;
	public int x, y, width, height;
	public String text = null;
	public KComponent() {this("");}
	public KComponent(String text) {
		this.text = text;
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(text, x + (width - text.length()) / 5, y + 20);
	}
	public boolean contains(Point p) {
		return x <= p.x && x + width >= p.x && y <= p.y && p.y <= y + height;
	}
	
	public void processMouseEvent(MouseEvent e) {}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getText() {
		return text;
	}
	public KActionListener getKActonListener() {
		return kal;
	}
}
