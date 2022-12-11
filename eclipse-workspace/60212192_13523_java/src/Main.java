import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
		JTabbedPane jtp = new JTabbedPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(new JTextArea(10, 20));
		jp2.add(new JTextArea(10, 20));
		jtp.addTab("file1", jp1);
		jtp.addTab("file2", jp2);
		add(jtp);
		jtp.setBounds(0,0,400,300);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main f = new Main();
	}

}
