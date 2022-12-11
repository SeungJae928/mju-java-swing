import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int N1, N2, N3, N4, N5, N6;
		Scanner sc = new Scanner(System.in);
		N1 = sc.nextInt();
		N2 = sc.nextInt();
		N3 = sc.nextInt();
		N4 = sc.nextInt();
		Rectangle Rec = new Rectangle(N1, N2, N3, N4);
		
		while(sc.hasNext()) {
			N5 = sc.nextInt();
			N6 = sc.nextInt();
			Point Point = new Point(N5, N6);
			Rectangle Rec2 = new Rectangle(Point);
		}
		System.out.println("END");
	}

}
