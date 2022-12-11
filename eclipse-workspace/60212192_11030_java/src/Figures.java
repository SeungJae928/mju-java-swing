import java.util.Scanner;

class Figure{
	int width, height;
	public Figure(int w, int h){
		width = w; height = h;
	}
	public double area(){
		// 면적을 구하는 함수. 이건 쓰지 않는 함수이다. Override하게 될 것이다.
		return 0.0;
	}
}

class Rectangle extends Figure{
	public Rectangle(int w, int h) {
		super(w, h);
	}

	public double area() {
		return width * height;
	}
	// 생성자는 기존 생성자를 최대한 활용한다.
}

class Triangle extends Figure{
	public Triangle(int w, int h) {
		super(w, h);
	}

	public double area() {
		return (width * height) / 2.0;
	}
	// 생성자는 기존 생성자를 최대한 활용한다.
}

public class Figures{
	public static void main(String[] args){
		Figure[] p = new Figure[4];
		Scanner sc = new Scanner(System.in);
		// 4개의 instance를 만들되 둘은 사각형, 둘은 3각형으로 한다.
		for (int i=0; i<4; i++){
			int type, w, h;
			type = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			if(type == 0) {
				p[i] = new Triangle(w, h);
			}
			else if (type == 1) {
				p[i] = new Rectangle(w, h);
			}
			// 타입(1 사각형 0 삼각형), 밑변, 높이를 입력받는다.
			// 각 p[i]에 적절한 객체를 new 해서 assign한다.
		}

		for (int i = 0; i < p.length; i++){
			System.out.println(p[i].area());
			// 각 객체의 면적을 출력하라.
		}
	}
}