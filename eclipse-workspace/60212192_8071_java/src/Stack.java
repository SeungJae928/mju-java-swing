class Link{
	public int data;  
	public Link next;
	public Link(int data, Link link){
		this.data = data;
		this.next = link;
		// 생성자를 이용하자.
	}
}

public class Stack{
	private Link firstLink;
	
	public Stack() {
		firstLink = null;
	}
	void add(int i) {
		Link link = new Link(i, firstLink);
		firstLink = link;
	}
	int top() throws Exception {
		if (isEmpty()) {
			throw (new Exception("스택이 비어있음"));
		}
		return firstLink.data;
	}
	boolean isEmpty() {
		return firstLink == null;
	}
	void pop() {
		firstLink = firstLink.next;
		}
}
