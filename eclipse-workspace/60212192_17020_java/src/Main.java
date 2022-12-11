
class MyRunnable implements Runnable {
	String name;
	int i;
	MyRunnable(String name, int i){
		this.name = name;
		this.i = i;
	}
	@Override public void run() {
		for(int j = 0; j < 5; j++) {
			try {
				System.out.println(name);
				Thread.sleep(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyRunnable("apple", 1000));
		Thread t2 = new Thread(new MyRunnable("banana", 2000));
		t1.start();
		t2.start();
	}

}
