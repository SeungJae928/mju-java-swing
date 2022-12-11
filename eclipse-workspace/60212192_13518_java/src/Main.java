import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Main extends JFrame{
	public Main() {
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}
	class MyItemListener implements ItemListener{
		@Override public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
				System.out.println(((JRadioButton)e.getSource()).getText());
		}
	}
	public void makeGui() {
		JRadioButton btnA = new JRadioButton("Apple");
		JRadioButton btnB = new JRadioButton("Banana");
		JRadioButton btnK = new JRadioButton("Kiwi");
		add(btnA);
		add(btnB);
		add(btnK);
		btnA.setBounds(0,0,100,25);
		btnB.setBounds(110,0,100,25);
		btnK.setBounds(230,0,100,25);
		ButtonGroup bg = new ButtonGroup();
		bg.add(btnA);
		bg.add(btnB);
		bg.add(btnK);	
		
		btnA.addItemListener(new MyItemListener());
		btnB.addItemListener(new MyItemListener());
		btnK.addItemListener(new MyItemListener());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}
