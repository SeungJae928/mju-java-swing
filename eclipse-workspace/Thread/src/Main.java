public class Main extends Thread{
	String name;
	int i;
	@Override public void run() {
		try {
			for(int j = 0; j < 5; j++) {
				System.out.println(name);
				sleep(i);
			}
		}catch(Exception e) {
			
		}
	}
	Main(String name, int i) {
		this.name = name;
		this.i = i;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Main("apple", 1000);
		Thread t2 = new Main("banana", 2000);
		t1.start();
		t2.start();
	}

}
