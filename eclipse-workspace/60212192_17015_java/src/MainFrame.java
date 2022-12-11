import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	class AppleThread extends Thread{
		@Override public void run() {
			for (int i=0; i<10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("apple");
			}
		}
	}
	public MainFrame() {
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton b1 = new JButton("apple");
		JButton b2 = new JButton("banana");
		b1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new AppleThread().start();
			}
		});
		b2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		
		add(b1); add(b2);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
	}

}
