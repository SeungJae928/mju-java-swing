class Link {
	public String data;  
	public Link next;
	public Link prev;
	public Link(String data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class MyLinkedList {
	Link front;
	Link back;
	
	boolean isEmpty() {
		return front == null || back ==null;
	}
	
	void addFront(String s){
		Link link = new Link(s);
		if(isEmpty()) {
			this.front = link;
		} else {
			link.next = front;
			front.prev = link;
			front = link;
		}
		if(front.next == null) {
			back = front;
		}
	}
	
	void addBack(String s) {
		Link link = new Link(s);
		if(isEmpty()) {
			addFront(s);
		} else {
			back.next = link;
			link.prev = back;
			back = link;
		}
	}
	
	String peekFront() throws Exception {
		if(isEmpty()) {
			throw (new Exception("List가 비어있음"));
		}
		return front.data;
	}
	
	String peekBack() throws Exception {
		if(isEmpty()) {
			throw (new Exception("List가 비어있음"));
		}
		return back.data;
	}
	
	String removeFront() throws Exception {
		if(isEmpty()) {
			throw (new Exception("List가 비어있음"));
		}
		Link link = front;
		front = null;
		front = link.next;
		front.prev = null;
		return front.data;
	}
	
	void remove(String s) {
		if (front.data.equals(s)) {
			try {
				removeFront();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(back.data.equals(s)) {
			try {
				removeBack();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			while(true) {
				if(front.data.equals(s)) {
					Link remove = front;
					Link next_ = remove.next;
					Link prev_ = remove.prev;
					
					prev_.next = next_;
					next_.prev = prev_;
					
					break;
				}
				front = front.next;
			}
		}
	}
	
	String removeBack() throws Exception {
		if(isEmpty()) {
			throw (new Exception("List가 비어있음"));
		}
		Link link = back;
		back = null;
		back = link.prev;
		back.next = null;
		
		return back.data;
	}
	
	void printForward() {
		Link[] lk = new Link[100];
		int i = 0;
		while(!isEmpty()) {
			try {
				System.out.print(peekFront() + " ");
			} catch (Exception e) {
			}
			lk[i] = front;
			front = front.next;
			i++;
		}
		System.out.println();
		for(;i > 0; i--) {
			if(lk[i-1] == null) {
				break;
			}
			addFront(lk[i-1].data);
		}
	}
	
	void printBackward() {
		Link[] lk = new Link[100];
		int i = 0;
		while(!isEmpty()) {
			try {
				System.out.print(peekBack() + " ");
			} catch (Exception e) {
			}
			lk[i] = back;
			back = back.prev;
			i++;
		}
		System.out.println();
		for(;i > 0; i--) {
			if(lk[i-1] == null) {
				break;
			}
			addBack(lk[i-1].data);
		}
	}
}