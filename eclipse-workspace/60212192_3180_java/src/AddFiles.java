import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddFiles {

	public static void main(String [] Filename) throws FileNotFoundException {
		int sum = 0;
		int i;
		
		for (i = 0; i < Filename.length; i++) {
			Scanner myScanner = new Scanner(new File(Filename[i]));
			while (myScanner.hasNextInt()) {
				int num = myScanner.nextInt();
				sum = sum + num;
			}
		}
		System.out.println(sum);
	}

}
