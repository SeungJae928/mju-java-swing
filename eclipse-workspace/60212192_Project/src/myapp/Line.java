package myapp;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Figure{
	private int X, Y, X1, Y1;

	public Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color_in;
	}
	public Line(Point sp, Point ep) {
		this.x = sp.x;
		this.y = sp.y;
		this.x2 = ep.x;
		this.y2 = ep.y;
		this.color = color_in;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x2, y2);
	}

	@Override
	public boolean contains(Point p1, Point p2) {
		return this.x >= p1.x && this.x2 <= p2.x && this.y >= p1.y && this.y2 <= p2.y;
	}

	@Override
	public void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
		this.x2 = this.x2 + (x2 - x);
		this.y2 = this.y2 + (y2 - y);
	}

	@Override
	public int getX() {
		if (this.x > this.x2) {
			return this.x2;
		} else {
			return this.x;
		}
	}

	@Override
	public int getY() {
		if (this.y > this.y2) {
			return this.y2;
		} else {
			return this.y;
		}
	}

	@Override
	public int getX2() {
		if (this.x > this.x2) {
			return this.x;
		} else {
			return this.x2;
		}
	}

	@Override
	public int getY2() {
		if (this.y > this.y2) {
			return this.y;
		} else {
			return this.y2;
		}
	}
	
	public int getLX() {
		return x;
	}
	
	public int getLX2() {
		return x2;
	}
	
	public int getLY() {
		return y;
	}
	
	public int getLY2() {
		return y2;
	}

	@Override
	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
		this.x2 = this.x2 + x;
		this.y2 = this.y2 + y;
	}

	@Override
	public boolean isClicked(int x, int y) {
		if (this.x > this.x2) {
			X1 = this.x;
			X = this.x2;
		} else {
			X = this.x;
			X1 = this.x2;
		}
		if (this.y > y2) {
			Y1 = this.y;
			Y = this.y2;
		} else {
			Y = this.y;
			Y1 = this.y2;
		}
		return X < x && x < X1 && y < Y1 && y > Y;
	}
	@Override public String getType() {
		return "Line";
	}
}
