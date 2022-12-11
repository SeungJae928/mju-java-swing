class Link{
    int data;
    Link next;
	public Link(int n, Link nxt){
		data = n; next = nxt;
	}
}
public class Stack{
    private Link first;
    public Stack(){ first = null; }
    public void push(int n){
          Link t = new Link(n, first);
          first = t;
    }
	public boolean isEmpty(){ 
		return first==null; 
		
	}
    public void pop(){ 
    	if (first != null) 
    		first = first.next; 
    	
    }
    public int top(){ 
    	return first.data; 
    }
}