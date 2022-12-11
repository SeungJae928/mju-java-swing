
public class Unhandled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			foo(1);
		} catch (Exception e) {

		}

	}

	public static void bar(int x) throws Exception {
		if (x > 0) {
			System.out.println("okay");
		} else {
			throw (new Exception("Negative"));
		}
	}

	public static void foo(int x) throws Exception {
		bar(x);
	}

}
