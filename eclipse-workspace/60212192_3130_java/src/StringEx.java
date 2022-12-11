import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) {
		String a = " ";
		Scanner myScanner = new Scanner(System.in);
		while (myScanner.hasNext()) {
			String A = myScanner.next();
			a = A + " " + a;
		}
		System.out.print(a);
	}
}
