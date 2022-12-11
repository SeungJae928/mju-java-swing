public class List{
    // Member data
    private Link first;

    // nested class Link
    public static class Link{
        int data;
        Link next;
        public Link(int n, Link nxt){
            data = n; next = nxt;
        }
    }

    public List(){
        first = null;
    }
    
    public void add(int n){
          Link t = new Link(n, first);
          first = t;
    }
    
    public boolean includes(int n){
        for (Link t = first; t != null ; t=t.next){
            if (n == t.data) return true;
        }
        return false;
    }
    
    public void show(){
        for (Link t = first; t != null ; t=t.next){
            System.out.println("item: " + t.data);
        }
    }
}