package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KMenuItem extends KAbstractButton{
	protected boolean visible = false;
	public KMenuItem(String text) {
		super(text);
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(text, x + (width - text.length())/5, y + 15);
	}
	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	@Override public void processMouseEvent(MouseEvent e) {
		kal.actionPerformed(new ActionEvent(this.text, MouseEvent.MOUSE_CLICKED, ""));
	}
}