import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		Scanner myScanner = new Scanner(System.in);

		while (myScanner.hasNext()){
			myList.addFront(myScanner.next());	
		}

		try {
			myList.addBack("xxx");
			myList.addBack("yyy");
			myList.addBack("zzz");

			myList.printForward();
			System.out.println("Front: " + myList.peekFront());
			System.out.println("Back: " + myList.peekBack());
			
			myList.removeFront();
			myList.removeBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		myList.remove("xxx");

		myList.printBackward();
	}

}
