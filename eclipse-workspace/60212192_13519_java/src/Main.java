import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame{
	public Main() {
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		makeGui();
		setVisible(true);
	}
	public void makeGui() {
		String fruits[] = {"apple", "banana", "mango", "kiwi"};
		JList myList = new JList(fruits);
		myList.setBounds(0, 0, 200, 200);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(myList);
		myList.addListSelectionListener(new ListSelectionListener() {
			@Override public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
					System.out.println(myList.getSelectedIndex() + " " + myList.getSelectedValue());
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main();
	}

}
