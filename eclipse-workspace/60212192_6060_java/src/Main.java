import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		while (sc.hasNext()) {
			x = sc.nextInt();
			y = sc.nextInt();
			Point N1 = new Point(x, y);
			x = sc.nextInt();
			y = sc.nextInt();
			Point N2 = new Point(x, y);
			Point.distance(N1,N2);
			Point.show();
		}
		
	}

}
