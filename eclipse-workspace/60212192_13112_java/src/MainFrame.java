import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

class ExternalListener implements MouseListener{
	// 생성자 필요함.
	MainFrame f;
	public ExternalListener(MainFrame f) {
		this.f = f;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// 아래 줄을 수정한다.
		System.out.println(((MainFrame) f).getCount());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class MainFrame extends JFrame{
	private int count=0;
	public int getCount() {
		return ++count;
	}
	public MainFrame() {
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
		mf.addMouseListener(new ExternalListener(mf));
		mf.setVisible(true);
		// 리스너를 추가한다.
	}

}