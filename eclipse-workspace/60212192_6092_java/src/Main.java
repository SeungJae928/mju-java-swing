import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MyIntArray arr = new MyIntArray(4);
		Scanner sc = new Scanner (System.in);
		while (sc.hasNext()) {
			arr = new MyIntArray(sc);
		}
	}

}
