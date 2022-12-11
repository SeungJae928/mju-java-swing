interface MyIterable{
	public boolean hasNext();
	public Integer next();
}

class IntVector{
	Integer[] ilist;
	int max;
	IntVector(){
		ilist = new Integer[100];
		max = 0;
	}
	void insert(Integer o){
		ilist[max++] = o;
	}
	Integer get(int i){
		return ilist[i];
	}
	public MyIterable getIterator() {
		return new IntIterator();
	}
	class IntIterator implements MyIterable{
		private int index = 0;
		@Override public boolean hasNext() {
			return ilist[index] != null;
		}
		@Override public Integer next() {
			return ilist[index++];
		}
	}
	// IntVector의 inner클래스로서 IntIterator를 정의해보라.

}
public class Main{
	public static void main(String[] args){
		IntVector v = new IntVector();
		v.insert(new Integer(11));
		v.insert(new Integer(22));
		v.insert(new Integer(33));
		MyIterable t = v.getIterator();
		while (t.hasNext()){
			System.out.println(t.next());
		}
	}
}
