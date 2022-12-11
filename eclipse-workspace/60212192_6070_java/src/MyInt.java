
public class MyInt {
	private static int sum;
	private int a;
	public MyInt(int x) {
		a = x;
	}
	
	public static MyInt add(MyInt N1, MyInt N2) {
		sum = 0;
		sum = N1.a + N2.a;
		return new MyInt(sum);
	}
	
	public void println() {
		System.out.println(sum);
	}
	
	public MyInt addTo(MyInt N3) {
		sum = sum + N3.a;
		return new MyInt(sum);
	}

}
