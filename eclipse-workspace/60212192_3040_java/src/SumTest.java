import java.util.Scanner;

public class SumTest {

	public static void main(String[] args) {
		int sum = 0;
		Scanner MyScanner = new Scanner(System.in);
		while (MyScanner.hasNextInt()) {
			int num = MyScanner.nextInt();
			sum = num + sum;
		}
		System.out.println(sum);
	}

}
