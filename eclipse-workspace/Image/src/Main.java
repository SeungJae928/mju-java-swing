import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


//class MyPanel extends JPanel {
	//public MyPanel() {
		//setBackground(new Color(200, 255, 255));
//	}
//	@Override public void paint(Graphics g) {
//		super.paint(g);
//	}
//}

class MyFrame extends JFrame {
	BufferedImage img = null;
	public MyFrame() {
		try {
			img = ImageIO.read(new File("DUKE.png"));
		} catch (IOException e) {
			System.out.println("Cannot open image file");
		}
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, 450, 450, null);
	}
}

public class Main {
	public static void main(String [] args) {
		JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		
		//f.setContentPane(new MyPanel());
		f.setVisible(true);
	}
}
