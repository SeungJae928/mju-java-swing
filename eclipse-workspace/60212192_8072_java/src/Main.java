import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue q = new Queue();
		String data;
		while(sc.hasNext()) {
			data = sc.next();
			q.add(data);
		}
		try {
			while(!q.isEmpty()) {
				System.out.println(q.front());
				q.remove();
			}
			System.out.println(q.front());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
