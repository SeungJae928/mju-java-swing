class Link{
	public String data;
	public Link next;
	public Link(String data, Link link){
		this.data = data;
		this.next = null;
	}
}

public class Queue{
	private Link front, rear;
	
	public Queue() {
		front = null;
		rear = null;
	}
	void add(String i) {
		Link link = new Link(i, rear);
		if(front == null) {
			front = link;
			rear = link;
		} else {
			rear.next = link;
			rear = link;
		}
	}
	String front() throws Exception {
		if(isEmpty()) {
			throw (new Exception("큐가 비어있음"));
		}
		return front.data;
	}
	boolean isEmpty() {
		return front == null;
	}
	void remove() throws Exception {
		if(isEmpty()) {
			throw (new Exception("큐가 비어있음"));
		}
		front = front.next;
		if(front == null) {
			rear = null;
		}
	}
	
}