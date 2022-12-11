import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;


interface Comparator<E>{
	public int compare(E str1, E str2);
}

class MyComparator implements Comparator<String>{
	@Override public int compare(String str1, String str2) {
		return str1.charAt(0) - str2.charAt(0);
	}
}

class LengthComparator implements Comparator<String>{
	@Override public int compare(String str1, String str2) {
		return str1.length() - str2.length();
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		Scanner myScanner = new Scanner(System.in);
		while (myScanner.hasNext()) {
			myList.add(myScanner.next());
		}
		myList.sort(new MyComparator());
		for (String s: myList) {
			System.out.println(s);
		}
		
		myList.sort(new LengthComparator());
		for (String s: myList) {
			System.out.println(s);
		}
	}

}