import java.util.Scanner;

public class Echo {

	public static void main(String[] args) {
		int c;
		Scanner myScanner = new Scanner(System.in);
		while (myScanner.hasNext()) {
			int num = myScanner.nextInt();
			System.out.print(num);
		}
		System.out.println("END");
	}

}
