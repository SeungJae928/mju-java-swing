import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Main extends JFrame{
	public Main() {
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		makeGui();
		setVisible(true);
	}
	public void makeGui() {
		JCheckBox jb1 = new JCheckBox("Apple");
		JCheckBox jb2 = new JCheckBox("Banana");
		JCheckBox jb3 = new JCheckBox("Kiwi");
		add(jb1);
		add(jb2);
		add(jb3);
		jb1.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand() + ((JCheckBox)(e.getSource())).isSelected());
			}
		});
		jb2.addActionListener(jb1.getActionListeners()[0]);
		jb3.addActionListener(jb1.getActionListeners()[0]);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}
