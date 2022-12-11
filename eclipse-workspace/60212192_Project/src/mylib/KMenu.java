package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KMenu extends KContainer{
	private ArrayList<KMenuItem> kmi = new ArrayList<>();
	private Point p;
	public KMenu(String text) {
		super(text);
		this.height = 20;
		this.y = 51;
	}
	public void add(KMenuItem km) {
		kmi.add(km);
		km.setBounds(x, y + (height * kmi.size()), width, height);
	}
	public void addKActionListener(KActionListener kal) {
		this.kal = kal;
		for(KMenuItem kmi: kmi) {
			kmi.kal = kal;
		}
	}
	@Override public void processMouseEvent(MouseEvent e) {
		for(KMenuItem mi : kmi) {
			if(mi.contains(p)) {
				mi.processMouseEvent(e);
			}
		}
	}
	@Override public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(text, x + (width - text.length())/5, 66);
		for(KMenuItem mi : kmi) {
			if(mi.visible == true) {
				mi.draw(g);
			}
		}
	}
	public void click() {
		for(KMenuItem mi: kmi) {
			mi.visible = true;
			this.height += mi.getHeight();
		}
	}
	public void nclick() {
		for(KMenuItem mi: kmi) {
			mi.visible = false;
		}
		this.height = 20;
	}
	@Override public boolean contains(Point p) {
		return x <= p.x && x + width >= p.x && y <= p.y && p.y <= y + height;
	}
	public void getPoint(Point p) {
		this.p = p;
	}
}