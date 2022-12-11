
public class Main {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		myStack.add(11);
		myStack.add(22);
		myStack.add(33);
		
		try {
			myStack.addLast(44);  // Override 하고 예외를 던지게 한다.
		} catch (Exception e) {
			System.out.println(e);
		}

		while (!myStack.isEmpty()) {
			System.out.println(myStack.peek());
			myStack.pop();
		}

	}

}
