package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KMenuBar extends KContainer{
	private ArrayList<KMenu> kms = new ArrayList<>();
	private int barWidth = 0;
	private int mx = 7;
	private Point p;
	public KMenuBar() {
		super();
		this.height = 40;
		this.width = 50;
		this.x = 7;
		this.y = 31;
	}
	public void add(KMenu km) {
		km.setWidth(width);
		km.setX(mx);
		kms.add(km);
		mx += km.getWidth();
		barWidth += width;
	}
	public void addKActionListener(KActionListener kal) {
		this.kal = kal;
		for(KMenu km : kms) {
			km.addKActionListener(kal);
		}
	}
	@Override public boolean contains(Point p) {
		this.p = p;
		return true;
	}
	@Override public void processMouseEvent(MouseEvent e) {
		for(KMenu km :kms) {
			if(km.contains(p)) {
				km.getPoint(p);
				km.height = 20;
				km.click();
				km.processMouseEvent(e);
			} else {
				km.nclick();
			}
		}
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, barWidth, height);
		g.drawString("MenuBar", x + (width - text.length())/5, 44);
		for(KMenu km: kms) {
			km.draw(g);
		}
	}
	public int getBarWidth() {
		return barWidth;
	}
}
