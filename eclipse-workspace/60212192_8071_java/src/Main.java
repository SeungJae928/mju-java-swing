import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack a = new Stack();
		int data;
		while(sc.hasNext()) {
			data = sc.nextInt();
			a.add(data);
		}
		try {
			while(!a.isEmpty()) {
				System.out.println(a.top());
				a.pop();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
