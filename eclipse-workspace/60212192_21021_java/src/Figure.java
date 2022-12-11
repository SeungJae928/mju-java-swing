import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Thing {
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
	void move(int x, int y) {}
	boolean contain(int x, int y) {return false;}
	public void add(Thing figure) {}
}

public class Figure extends Thing {}

class Rect extends Figure {
	Rect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color_in;
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

	@Override
	boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}

	@Override
	void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}

	@Override
	void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	@Override
	public boolean contain(int x, int y) {
		return this.x < x && x < this.x + this.width && y < this.y + this.height && y > this.y;
	}
}

class Oval extends Figure {
	Oval(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color_in;
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(x, y, width, height);
	}

	@Override
	boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}

	@Override
	void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}

	@Override
	void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	@Override
	public boolean contain(int x, int y) {
		return this.x < x && x < this.x + this.width && y < this.y + this.height && y > this.y;
	}
}

class Line extends Figure {
	private int X, Y, X1, Y1;

	Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color_in;
	}

	void setBounds(int x, int y, int x2, int y2) {

	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x2, y2);
	}

	@Override
	boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x2 <= x2 && this.y >= y && this.y2 <= y2;
	}

	@Override
	void setLocation(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
		this.x2 = this.x2 + (x2 - x);
		this.y2 = this.y2 + (y2 - y);
	}

	@Override
	int getX() {
		if (this.x > this.x2) {
			return this.x2;
		} else {
			return this.x;
		}
	}

	@Override
	int getY() {
		if (this.y > this.y2) {
			return this.y2;
		} else {
			return this.y;
		}
	}

	@Override
	int getX2() {
		if (this.x > this.x2) {
			return this.x;
		} else {
			return this.x2;
		}
	}

	@Override
	int getY2() {
		if (this.y > this.y2) {
			return this.y;
		} else {
			return this.y2;
		}
	}

	@Override
	void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
		this.x2 = this.x2 + x;
		this.y2 = this.y2 + y;
	}

	@Override
	public boolean contain(int x, int y) {
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
}

class Group extends Thing {
	ArrayList<Thing> group;

	public Group(int x, int y, int x2, int y2) {
		group = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.width = x2 - x;
		this.height = y2 - y;
	}

	public void add(Thing f) {
		group.add(f);
	}

	@Override
	void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, width, height);
		for (Thing figure : group) {
			figure.draw(g);
		}
	}

	@Override
	public boolean contain(int x, int y) {
		return this.x < x && x < this.x2 && y < this.y2 && y > this.y;
	}

	@Override
	boolean contains(int x, int y, int x2, int y2) {
		return this.x >= x && this.x + this.width <= x2 && this.y >= y && this.y + this.height <= y2;
	}

	@Override
	void setLocation(int x, int y, int x2, int y2) {
		this.x += x2 - x;
		this.y += y2 - y;
		for (int i = 0; i < this.group.size(); i++) {
			this.group.get(i).move(x2 - x, y2 - y);
		}
	}

	@Override
	void move(int x, int y) {
		this.x += x;
		this.y += y;
		for (int i = 0; i < this.group.size(); i++) {
			this.group.get(i).move(x, y);
		}
	}

	void setLocation_(int x, int y, int x2, int y2) {
		this.x = this.x + (x2 - x);
		this.y = this.y + (y2 - y);
	}
}