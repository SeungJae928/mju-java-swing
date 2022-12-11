import java.util.Scanner;

public class Student {
	private static int[] num = new int[100];
	private static String[] name = new String[100];
	private static double[] grade = new double[100];
	static String data;
	static int index = 0;

	public Student() {
		getData();
		toString();
	}
	
	public static void getStudent(Scanner sc) {
		try {
			if(sc.hasNextInt()) {
				num[index] = sc.nextInt();
			}
			else if (sc.hasNextDouble()) {
				grade[index] = sc.nextDouble();
			}
			else {
				name[index] = sc.next();
			}
			data = "학번 : " + String.valueOf(num[index]) + " " +  "이름 : " + name[index] + " " + "성적 : " + String.valueOf(grade[index]);
			if (((num[index] != 0) && (name[index] != null)) && grade[index] != 0) {
				show();
				StuApp s = new StuApp();
				index++;
			}
		}catch (NullPointerException e) {
			
		}
		
	}

	
	public int[] getNum() {
		return num;
	}
	public String[] getName() {
		return name;
	}
	public double[] getGrade() {
		return grade;
	}
	public String getData() {
		return data;
	}
	
	public static void show() {
		System.out.println(data);
	}
	
	public String toString() {
		return data;
	}
}