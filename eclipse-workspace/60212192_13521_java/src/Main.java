import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main extends JFrame{
	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}
	public void makeGui() {
		JScrollPane jsp = new JScrollPane(new TextArea());
		jsp.setBounds(0,0,400,300);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jsp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
	}

}
