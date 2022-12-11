import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Figure {
	protected int width;
	protected int height;
	protected int x, y, x2, y2;
	public static Color color_in = Color.red;
	protected Color color;
	void draw(Graphics g) {}
	void setLocation(int x, int y, int x2, int y2) {}
	boolean contains(int x, int y, int x2, int y2) {return false;}
	int getX() {return this.x;}
	int getY() {return this.y;}
	int getX2() {return this.width + this.x;}
	int getY2() {return this.height + this.y;}
}

class Rect extends Figure {
	Rect(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color_in; 
	}
	@Override void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}
	@Override boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}
	@Override void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}
}

class Oval extends Figure {
	Oval(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color_in; 
	}
	@Override void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}
	@Override boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}
	@Override void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}
}

class Line extends Figure {
	Line(int x, int y, int x2, int y2){
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color_in; 
	}
	@Override void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x2, y2);
	}
	@Override boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x2 <= x2 && this.y >= y && this.y2 <= y2;
	}
	@Override void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
		this.x2 = this.x2 + (x2 - x);
		this.y2 = this.y2 + (y2 - y);
	}
	@Override int getX() {
		if(this.x > this.x2) {
			return this.x2;
		} else {
			return this.x;
		}
	}
	@Override int getY() {
		if(this.y > this.y2) {
			return this.y2;
		} else {
			return this.y;
		}
	}
	@Override int getX2() {
		if(this.x > this.x2) {
			return this.x;
		} else {
			return this.x2;
		}
	}
	@Override int getY2() {
		if(this.y > this.y2) {
			return this.y;
		} else {
			return this.y2;
		}
	}
}

class Group extends Figure {
	ArrayList group;
	public Group(int x, int y, int x2, int y2) {
		group = new ArrayList();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.width = x2 - x;
		this.height = y2 - y;
	}
	public void add(Figure f) {
		group.add(f);
	}
	@Override void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, width, height);
	}
	public boolean contain(int x, int y) {
		return this.x < x && x < this.x2 && y < this.y2 && y > this.y;
	}
	@Override boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}
	@Override void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}
}