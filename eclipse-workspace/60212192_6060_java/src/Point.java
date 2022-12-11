
public class Point {
	private static String A;
	private int[] arr = new int[2];
	public Point(int x, int y) {
		arr[0] = x;
		arr[1] = y;
	}
	
	public Point (String s) {
		
	}
	
	public static Point distance(Point N1, Point N2) {
		double distance = 0;
		distance = Math.sqrt((N1.arr[0]-N2.arr[0])*(N1.arr[0]-N2.arr[0])+(N1.arr[1]-N2.arr[1])*(N1.arr[1]-N2.arr[1]));
		A = String.valueOf(distance);
		return new Point(A);
	}
	public String toString() {
		return A;
	}
	public static void show() {
		System.out.println(A);
	}
}
