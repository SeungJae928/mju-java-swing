package mylib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KButton extends KAbstractButton {
	public KButton(String text) {
		super(text);
	}
	@Override public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override public void addKActionListener (KActionListener al){
		this.kal = al;
	}
	@Override public void processMouseEvent(MouseEvent e) {
		kal.actionPerformed(new ActionEvent(this.text, e.getID(), ""));
	}
}
