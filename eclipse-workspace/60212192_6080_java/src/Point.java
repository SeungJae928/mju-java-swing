
public class Point {
	private int x;
	private int y;
	private String str;
	private static int[] arr = new int[2];
	public Point (int N1, int N2) {
		x = N1;
		y = N2;
		arr[0] = N1;
		arr[1] = N2;
		arr();
	}
	public int[] arr() {
		return arr;
	}
}
