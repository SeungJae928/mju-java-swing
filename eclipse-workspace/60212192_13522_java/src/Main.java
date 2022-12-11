import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Main extends JFrame{
	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}
	public void makeGui() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(new JTextArea(10, 20));
		jp2.add(new JTextArea(10, 20));
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jp1, jp2);
		setContentPane(jsp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
	}

}
