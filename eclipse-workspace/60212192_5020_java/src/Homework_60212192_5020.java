class Counter {
	int a;
	public void Bump() {
		a++;
	}
	public void reset() {
		a = 0;
	}
	public void Show() {
		System.out.println(a);
	}
}

public class Homework_60212192_5020 {

	public static void main(String[] args) {
		Counter a;
		a = new Counter();
		a.reset();
		for(int i = 0; i < 5; i++) {
			a.Bump();
		}
		a.Show();
	}

}
