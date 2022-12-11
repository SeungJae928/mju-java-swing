import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		File dir = new File(str);
		File files[] = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
		    System.out.println("file: " + files[i]);
		}
	}

}
