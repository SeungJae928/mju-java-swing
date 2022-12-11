
public class Rectangle {
	private static int x1, x2, y1, y2, x, y;
	private int[] arr;
	public Rectangle (int N1, int N2,int N3,int N4) {
		x1 = N1;
		x2 = N3;
		y1 = N3;
		y2 = N4;
		if(x2 > x1) {
			x1 = N3;
			x2 = N1;
		}
		if(y2 > y1) {
			y1 = N4;
			y2 = N2;
		}
	}
	public Rectangle(Point a) {
		arr = a.arr();
		x = arr[0];
		y = arr[1];
		if ((x > x1 || x < x2)||(y > y1 || y < y2)) {
			System.out.println("no");
		}
		else if ((x <= x1 && x >= x2) && (y <= y1 && y >= y2)) {
			System.out.println("yes");
		}
	}
}
