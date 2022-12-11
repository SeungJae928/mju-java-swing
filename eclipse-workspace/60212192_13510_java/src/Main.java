import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

class MyFrame extends JFrame {
	public ArrayList figures = new ArrayList();
	MyFrame(String str){
		super(str);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		for(Object figure : figures) {
			((Figure) figure).draw(g);
		}
	}
}

class Figure {
	protected int width;
	protected int height;
	protected int x, y, x2, y2;
	protected String str;
	void draw(Graphics g) {};
}

class Rect extends Figure {
	Rect(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}

class Oval extends Figure {
	Oval(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override void draw(Graphics g) {
		g.drawOval(x, y, width, height);
	}
}

class Line extends Figure {
	Line(int x, int y, int x2, int y2){
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	@Override void draw(Graphics g) {
		g.drawLine(x, y, x2, y2);
	}
}

class Text extends Figure {
	Text(String str, int x, int y){
		this.x = x;
		this.y = y;
		this.str = str;
	}
	@Override void draw(Graphics g) {
		g.drawString(str, x, y);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width, height, x, y, x2, y2;
		String str;
		Scanner sc = new Scanner(System.in);
		MyFrame f = new MyFrame("도형 그리기");
		f.setVisible(true);
		
		while(true) {
			int type = sc.nextInt();
			if(type == 0) {
				System.out.println("rect");
				x = sc.nextInt();
				y = sc.nextInt();
				width = sc.nextInt();
				height = sc.nextInt();
				f.figures.add(new Rect(x, y, width, height));
				f.repaint();
			}
			else if(type == 1) {
				System.out.println("oval");
				x = sc.nextInt();
				y = sc.nextInt();
				width = sc.nextInt();
				height = sc.nextInt();
				f.figures.add(new Oval(x, y, width, height));
				f.repaint();
			}
			else if (type == 2) {
				System.out.println("line");
				x = sc.nextInt();
				y = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				f.figures.add(new Line(x, y, x2, y2));
				f.repaint();
			}
			else if (type == 3) {
				System.out.println("text");
				str = sc.next();
				x = sc.nextInt();
				y = sc.nextInt();
				f.figures.add(new Text(str, x, y));
				f.repaint();
			}
		}
	}

}
