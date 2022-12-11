import java.util.LinkedList;

public class Stack extends LinkedList<Object> {
	void addLast(int i) throws Exception {
		throw (new Exception("예외 출력"));
	}
	public Object getLast() {
		return modCount;
	}
	@Override public Object getFirst() {
		return modCount;
	}
	void addFirst(int i) throws Exception {
		throw (new Exception("예외 출력"));
	}
	@Override public boolean add(Object o) {
		super.addFirst(o);
		return true;
	}
}
