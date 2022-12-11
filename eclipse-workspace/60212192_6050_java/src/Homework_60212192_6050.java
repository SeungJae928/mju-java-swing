import java.util.Scanner;

public class Homework_60212192_6050 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		while(myScanner.hasNext()) {
			Student.getStudent(myScanner);
		}
		System.out.println("");
		System.out.println("학생 정보 출력\n");
		StuApp.StuShow();
		System.out.println("END");
	}
}
