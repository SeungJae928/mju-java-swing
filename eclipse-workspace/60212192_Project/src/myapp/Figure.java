package myapp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Figure implements Serializable{
	protected int width;
	protected int height;
	protected int x, y, x2, y2;
	protected boolean isFill = false;
	public static Color color_in = Color.BLACK;
	protected Color color, figureColor;

	public void draw(Graphics g) {}
	public void setLocation(int x, int y, int x2, int y2) {}
	public boolean contains(Point p1, Point p2) {return false;}
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public int getX2() {return this.width + this.x;}
	public int getY2() {return this.height + this.y;}
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	public void move(int x, int y) {}
	public boolean isClicked(int x, int y) {return false;}
	public void add(Figure figure) {}
	public void fill() {
		figureColor = color_in;
		isFill = true;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getType() {
		return "Figure";
	}
}
