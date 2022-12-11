
public class Finally {
	
	public static int divide (int a, int b) throws Exception{
		if (b == 0) {
			throw (new Exception("divide"));
		}
		return a / b;
	}

	public static void main(String[] args) {
		try {
			int res;
			res = divide(3, 1);
			System.out.println(res);
			res = divide(3, 0);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("Error");
			return;
		} finally {
			System.out.println("Hi-finally");
		}
		System.out.println("Hi");
	}
}