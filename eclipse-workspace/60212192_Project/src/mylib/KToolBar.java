package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KToolBar extends KContainer{
	private ArrayList<KAbstractButton> btnList = new ArrayList<>();
	private int by = 200, bheight = 40;
	private Point p;
	public KToolBar() {
		this.x = 7;
		this.y = 200;
		this.width = 60;
		this.height = 0;
	}
	public void add(KAbstractButton btn) {
		btnList.add(btn);
		btn.setBounds(x, by, width, bheight);
		by += btn.getHeight();
		this.height += btn.getHeight();
	}
	public void addKActionListener(KActionListener kal) {
		this.kal = kal;
		for(KAbstractButton btn: btnList) {
			btn.addKActionListener(kal);
		}
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString("Tools", x + (width - text.length())/5, y -3);
		for(KAbstractButton btn: btnList) {
			btn.draw(g);
		}
	}
	public boolean contains(Point p) {
		this.p = p;
		return true;
	}
	public boolean isClicked(Point p) {
		return p.x <= x + width && p.x >= x && p.y <= y + height && p.y >= y;
	}
	@Override public void processMouseEvent(MouseEvent e) {
		if(this.isClicked(p)) {
			for(KAbstractButton btn: btnList) {
				if(btn.contains(p)) {
					btn.processMouseEvent(e);
				} else {
					btn.unClicked();
				}
			}
		}
	}
}
