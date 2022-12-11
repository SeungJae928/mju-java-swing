package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KFrame extends KContainer{
	protected KMenuBar kmb;
	protected KToolBar ktb;
	protected KContainer contentPane;
	private KAdapterFrame kaf;
	public void setKMenuBar(KMenuBar mb) {
		// 원래 메뉴바는 frame에 있는게 정상이지만...
		add(mb);
	}
	public KFrame() {}
	@Override public void processMouseEvent(MouseEvent e) {
		super.processMouseEvent(e);
		switch(e.getID()) {
		case MouseEvent.MOUSE_CLICKED:
			for(KComponent comp : compoList) {
				if(comp.contains(e.getPoint())) {
					comp.processMouseEvent(e);
				}
			}
			break;
		}
	}
	public void paint(Graphics g) {
		for(KComponent comp : compoList) {
			comp.draw(g);
		}
	}
	public void setKAF(KAdapterFrame kaf) {
		this.kaf = kaf;
	}
	public void repaint() {
		kaf.repaint();
	}
}
