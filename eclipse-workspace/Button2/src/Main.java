import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame{
	JTextField faren = new JTextField();
	JLabel label = new JLabel("화씨 온도");
	ActionListener lis = new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) { 
			System.out.println(faren.getText());
		}
	};
	public Main() {
		setLayout(null);
		setSize(500, 300);
		label.setBounds(10, 10, 100, 30);
		faren.setBounds(140, 10, 100, 30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(label);
		add(faren);
		faren.addActionListener(lis);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
	}

}
