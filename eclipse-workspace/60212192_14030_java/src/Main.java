import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjVector ov = new ObjVector(10);
		Scanner sc = new Scanner(System.in);
		
		ov.add(sc.nextDouble());
		ov.add(sc.nextDouble());
		ov.add(sc.nextInt());
		ov.add(sc.nextInt());
		
		System.out.println((Double)ov.get(0));
		System.out.println((Double)ov.get(1));
		System.out.println((Integer)ov.get(2));
		System.out.println((Integer)ov.get(3));
	}

}
