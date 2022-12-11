import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Buttons extends JFrame {
	JButton btnApple, btnBanana, btnOrange;
	Buttons(){
		Container mainPane = getContentPane();
		mainPane.setBackground(Color.yellow);
		mainPane.setLayout(null);
		btnApple = new JButton("Apple");
		btnBanana = new JButton("Banana");
		btnOrange = new JButton("Orange");
		btnApple.setBounds(10, 10, 100, 30);
		btnBanana.setBounds(10, 50, 100, 30);
		btnOrange.setBounds(10, 90, 100, 30);
		this.add(btnApple);
		this.add(btnBanana);
		this.add(btnOrange);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnApple.addActionListener(new MyListener());
		btnBanana.addActionListener(new MyListener());
		btnOrange.addActionListener(new MyListener());
	}
	class MyListener implements ActionListener{
		  @Override public void actionPerformed(ActionEvent e) {
		     if(e.getSource()==btnApple){
		        System.out.println("Apple");
		     } else if (e.getSource()==btnBanana){
		        System.out.println("Banana");
		     }
		     else if (e.getSource() == btnOrange) {
		    	 System.out.println("Orange");
		     }
		 }
	}
}
	
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buttons b = new Buttons();
		
	}

}
