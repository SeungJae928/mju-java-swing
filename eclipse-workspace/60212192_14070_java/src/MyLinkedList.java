interface ListIterator {
	public boolean hasNext();
	public String next();
	public boolean hasPrevious();
	public String previous();
}

public class MyLinkedList<E> {
	public class Link {
		E data;
		Link next;
		Link prev;
		Link(E a){
			this.data = a;
			this.next = null;
			this.prev = null;
		}
	}
	public Link first;
	public Link last;
	public int size = 0;
	public boolean isEmpty() {
		return first == null || last == null;
	}
	public void add(E e) {
		size++;
		Link link = new Link(e);
		if(isEmpty()) {
			this.first = link;
		} else {
			link.next = first;
			first.prev = link;
			first = link;
		}
		if(first.next == null) {
			last = first;
		}
	}
	public int size() {
		return size;
	}
	public ListIterator listIterator() {
		return new MyListIterator();
	}
	public ListIterator listIterator(int i) {
		return new MyListIterator(i);
	}
	public class MyListIterator implements ListIterator{
		Link link = last;
		Link tmp;
        MyListIterator() {}
		MyListIterator(int i) {
			for(int j = 0; j < i - 1; j++) {
				if(last.prev == null) {
					break;
				}
				last = last.prev;
			}
			link = last;
		}
		@Override public boolean hasNext() {
			return link != null;
		}
		@Override public String next() {
			Link l = link;
			link = link.prev;
			return (String) l.data;
		}
		@Override public boolean hasPrevious() {
			return link != null;
		}
		@Override public String previous() {
			Link l = link;
			link = link.next;
			return (String) l.data;
		}
	}
}


