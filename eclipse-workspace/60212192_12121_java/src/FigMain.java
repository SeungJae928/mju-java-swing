import java.util.Scanner;

// 도형은 삼각형 사각형 두종류만 있다고 하자.
// 삼각형은 이등변 삼각형으로 가정한다.
// 입력시 0 은 삼각형  1은 사각형이다.
// 0 이나 1이 아닌 것은 더이상 입력이 없는 것으로 한다.
interface Comparer {
	public boolean compare (Figures f1, Figures f2);
	public void say();
}

class WidthComparer implements Comparer {
	@Override public boolean compare (Figures f1, Figures f2) {
		return f1.Width < f2.Width;
	}
	@Override public void say() {
		System.out.println("너비 정렬");
	}
}

class AreaComparer implements Comparer {
	@Override public boolean compare (Figures f1, Figures f2) {
		return f1.Area < f2.Area;
	}
	@Override public void say() {
		System.out.println("면적 정렬");
	}
}

class Figures {
	Figures[] FigureList;
	int Figure, Width, Height, index;
	double Area;
	Figures(){}
	Figures (int num){FigureList = new Figures[num];}
	public void add(int Figure, int Width, int Height) {
		if(Figure == 0) {
			FigureList[index++] = new Triangle(Width, Height);
		}
		else if (Figure == 1) {
			FigureList[index++] = new Rectangle(Width, Height);
		}
	}
	public void listAll() {
		for(int i = 0; i < FigureList.length; i++) {
			if (FigureList[i].Figure == 0) {
				FigureList[i].print();
			}
			else if (FigureList[i].Figure == 1) {
				FigureList[i].print();
			}
			if (FigureList[i+1] == null) {
				break;
			}
		}
	}
	public void print() {}
	public void sort(Comparer cp) {
		Figures figure = FigureList[0];
		Figures tmp;
		try {
			for(int i = 0; i < FigureList.length; i++) {
				for(int j = 0; j < FigureList.length; j++) {
					if(cp.compare(FigureList[j], FigureList[j+1])) {
						tmp = FigureList[j];
						FigureList[j] = FigureList[j+1];
						FigureList[j+1] = tmp;
					}
					if (FigureList[j+2] == null) {
						break;
					}
				}
			}
			cp.say();
		} catch (Exception e) {
			
		}
	}
}

class Triangle extends Figures {
	public Triangle (int Width, int Height) {
		this.Height = Height;
		this.Width = Width;
		this.Area = (Height * Width)/2.0 ;
	}
	@Override public void print() {
		System.out.println("삼각형 너비:" + Width + " 높이:" + Height + " 면적:" + Area);
	}
}

class Rectangle extends Figures {
	public Rectangle (int Width, int Height) {
		this.Height = Height;
		this.Width = Width;
		this.Area = Height * Width;
	}
	@Override public void print() {
		System.out.println("사각형 너비:" + Width + " 높이:" + Height + " 면적:" + Area);
	}
}


public class FigMain{
	public static void main(String[] args){
		Figures myFigures = new Figures(100);  //주어진 개수대로 최대 크기를 결정
		//Scanner 를 이용하여 도형을 입력한다.
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			int Figure = sc.nextInt();// 도형 종류,  너비, 높이 (모두 정수) 순서로 입력한다.
			int Width = sc.nextInt();// 입력 예시: 0 10 8
			int Height = sc.nextInt();//            1 5 4
			myFigures.add(Figure, Width, Height);  // add 함수를 이용하여 추가.  
		}
		myFigures.listAll(); // 순서대로 출력
		// 예시:   사각형  10  8 80     너비 높이 면적 순으로 출력
		//         삼각형  10  8 40
		// 편의상 면적도 정수로 한다.
		
		// 아래는 버전 2 부분이다.
		// 인터페이스를 이용하여 정렬
		myFigures.sort(new WidthComparer());  // 너비 기준으로 정렬
		myFigures.listAll();
		myFigures.sort(new AreaComparer()); // 면적 기준으로 정렬
		myFigures.listAll();
	}
}
