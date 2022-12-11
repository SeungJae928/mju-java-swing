
public class Main {

	public static void main(String[] args) {
		MyInt a, b;
		a = new MyInt(111);
		b = new MyInt(222);
		MyInt c = MyInt.add(a, b);
		c.println();
		c.addTo(a);
		c.println();
	}

}
