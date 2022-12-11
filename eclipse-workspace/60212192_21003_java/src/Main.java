import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	public MyFrame() {
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame f = new MyFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700,400);
		
		f.setContentPane(new MyPanel());
		f.setVisible(true);
	}

}
