
public class MyQueue extends MyLinkedList {
	
	void insert(String s) {
		super.addFront(s);
	}
	String peek() {
		try {
			return super.peekBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	void remove() {
		super.back = super.back.prev;
	}
	boolean isEmpty() {
		return super.isEmpty();
	}
	@Override
	protected void addBack(String s) {
		
	}
	@Override
	protected void addFront(String s){
		
	}
}
