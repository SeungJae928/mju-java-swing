import java.util.Scanner;

public class Homework_60212192_3200 {

	public static void main(String[] args) {
		int sum = 0;
		Scanner Line = new Scanner(System.in);
		String str = Line.nextLine();		
		Scanner num = new Scanner(str);
		while (num.hasNextInt()) {
			int b = num.nextInt();
			sum = b + sum;
		}	
		System.out.println(sum);
	}

}
