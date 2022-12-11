package myapp;

import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Figure{
	public Oval(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color_in;
	}
	public Oval(Point p1, Point p2) {
		Point sp = p1, ep = p2;
		if (sp.x > ep.x) {
			int tmp = sp.x;
			sp.x = ep.x;
			ep.x = tmp;
		}
		if (sp.y > ep.y) {
			int tmp = sp.y;
			sp.y = ep.y;
			ep.y = tmp;
		}
		this.x = sp.x;
		this.y = sp.y;
		this.width = ep.x - sp.x;
		this.height = ep.y - sp.y;
		this.color = color_in;
	}
	@Override
	public void draw(Graphics g) {
		if(isFill) {
			g.setColor(figureColor);
			g.fillOval(x,y,width,height);
		}
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}

	@Override
	public boolean contains(Point p1, Point p2) {
		return this.x >= p1.x && this.x + this.width <= p2.x && this.y >= p1.y && this.y + this.height <= p2.y;
	}

	@Override
	public void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}

	@Override
	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	@Override
	public boolean isClicked(int x, int y) {
		return this.x < x && x < this.x + this.width && y < this.y + this.height && y > this.y;
	}
	@Override public String getType() {
		return "Oval";
	}
}
