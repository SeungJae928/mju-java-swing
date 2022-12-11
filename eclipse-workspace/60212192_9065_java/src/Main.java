import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		MyQueue queue = new MyQueue();
		Scanner myscanner = new Scanner(System.in);
		
		while (myscanner.hasNext()){
			queue.insert(myscanner.next());
		}

		while ( !queue.isEmpty() ){
			System.out.print(queue.peek() + " ");
			queue.remove();
		}
		System.out.println();

		queue.insert("aaa");
		queue.insert("bbb");
		queue.addBack("ccc");
		queue.addFront("ddd");

		while ( !queue.isEmpty() ){
			System.out.print(queue.peek() + " ");
			queue.remove();
		}
	}
}
