
public class Homework_60212192_5035 {
	static int seq=1;
	static void debugprint(MyStrBuffer s) {
		System.out.println(seq++ + ". " + s + " len= " + s.length() + " / size = " + s.capacity());
	}
	public static void main (String[] args) {
		MyStrBuffer s = new MyStrBuffer("Hello");
		MyStrBuffer t = new MyStrBuffer("world");
		    debugprint(s);
		s.append(t);
		s.append(123);
		    debugprint(s);
		s.delete(0,3);
			debugprint(s);
		s.insert(0, "Hel");
			debugprint(s);
		t.reverse();
			debugprint(t);
		s.delete(8, s.length());
			debugprint(s);
		s.trimToSize();
			debugprint(s);
	}
}
