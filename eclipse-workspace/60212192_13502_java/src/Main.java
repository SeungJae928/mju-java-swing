import java.awt.Graphics;

import javax.swing.JFrame;

class MyFrame extends JFrame {
	public MyFrame(String str) {
		super(str);
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void draw() {
		Graphics g = this.getGraphics();
		g.drawRect(100, 100, 50, 50);
		System.out.println("실행됨");
	}
	@Override public void paint(Graphics g) {
		//super.paint(g);
		System.out.println("paint 실행");
	}
}
public class Main {
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame("엉터리 프레임");
		f.setVisible(true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.draw();
	}

}
