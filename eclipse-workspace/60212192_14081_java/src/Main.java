import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		long start, end;
		Vector<Integer> Vector = new Vector<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		start = System.currentTimeMillis();
		for(Integer i = 0; i < 10000; i++) {
			Vector.add(i);
		}
		for(Integer i = Vector.size(); i >= 0; i--) {
			Vector.remove(i);
		}
		end = System.currentTimeMillis();
		System.out.println("Vector add,remove 소요시간 " + (end - start));
		
		for(Integer i = 0; i < 10000; i++) {
			Vector.add(i);
		}
		start = System.currentTimeMillis();
		for(Integer i = 0; i < 10000; i++) {
			Vector.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("Vector 검색 소요시간 " + (end - start));
		
		start = System.currentTimeMillis();
		for(Integer i = 0; i < 10000; i++) {
			list.add(0, i);
		}
		for(Integer i = list.size(); i >= 0; i--) {
			list.remove(i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList add, remove 소요시간 " + (end - start));
		
		for(Integer i = 0; i < 10000; i++) {
			list.add(0, i);
		}
		start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list.indexOf(i);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList 검색 소요시간 " + (end - start));
	}

}
