import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable{
	public String name;
	public Student(String name){
		this.name = name;
	}
	public void talk() {
		System.out.println(this.name);
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student std = null;
		while(true) {
			int menu = sc.nextInt();
			if(menu == 0) {
				String name;
				name = sc.next();
				std = new Student(name);
			} else if (menu == 1) {
				try {
					ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("C:\\Users\\USER\\Desktop\\test\\data.txt"));
					oss.writeObject(std);
					oss.close();
				} catch (Exception e) {
					System.out.println("Fail");
				}
			} else if (menu == 2) {
				try {
					ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\Desktop\\test\\data.txt"));
					std = (Student)is.readObject();
				} catch (Exception e) {
					System.out.println("Fail");
				}
			} else if (menu == 3) {
				std.talk();
			} else {
				break;
			}
		}
	}

}
