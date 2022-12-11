import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

class MyFrame extends JFrame {
	public MyFrame(String str) {
		super(str);
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font myfont = new Font("굴림체", Font.PLAIN, 20);
		this.setFont(myfont);
	}
	//void draw() {
	//	Graphics g = this.getGraphics();
	//	g.drawRect(100, 100, 50, 50);
	//	System.out.println("실행됨");
	//}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(100, 100, 100, 50);
		g.drawOval(100, 100, 100, 50);
		g.drawLine(100, 100, 200, 150);
		g.drawString("hello", 100, 100);
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
	}

}
