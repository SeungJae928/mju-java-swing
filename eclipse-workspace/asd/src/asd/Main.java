package asd;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

class MyFrame extends JFrame {
	public MyFrame() {
		getContentPane().setBackground(Color.yellow);
	}
	@Override public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(1, 1, 50, 50);
		getContentPane().getGraphics().drawRect(1, 1, 50, 50);
	}
}

public class Main {
	public static void main(String [] args) {
		JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setVisible(true);
	}
}
