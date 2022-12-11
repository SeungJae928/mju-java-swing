import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<String> list = new MyLinkedList<>();
		Scanner myscanner = new Scanner(System.in);
		while (myscanner.hasNext()) {
			list.add(myscanner.next());
		}
		
		ListIterator iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("");
		
		ListIterator iter2 = list.listIterator(list.size()); // 끝 항목부터 시작
		while (iter2.hasPrevious()) {
			System.out.println(iter2.previous());
		}
		
	}
}