import java.awt.Graphics;
import java.awt.Point;

public class MyButton {
	int x, y, width, height;
	String str;
    public MyButton(String s) {
		this.str = s;
	}
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public boolean contains(Point p) {
		return p.x > x && p.x < x + width && p.y > y && p.y < y + height;
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(str, x + 15, y + 15);
	}
}
