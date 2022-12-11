import java.io.FileInputStream;

public class Main{
	public static void main(String[] args){
		// System.in 이나 FileInputStream이나 둘다 InputStream 이므로 
		// 둘다 사용가능하다.
		MyScanner myScanner = new MyScanner(System.in);
		int sum = 0;
		while (myScanner.hasNextInt()){
			sum += myScanner.nextInt();
		}
		System.out.println("Sum is " + sum);
		while (myScanner.hasNext()){
			System.out.println("String " + myScanner.next());
		}
		System.out.println("END");
		try {
			MyScanner myFileScanner = new MyScanner(new FileInputStream("data.txt"));
			sum = 0; // int sum = 0; 에서 수정
			while (myFileScanner.hasNextInt()){
				sum += myFileScanner.nextInt();
			}
			System.out.println("Sum is " + sum);
			while (myFileScanner.hasNext()){
				System.out.println("String " + myFileScanner.next());
			}
			System.out.println("END");
		} catch (Exception e){
			System.out.println(e);
		}
	}
}