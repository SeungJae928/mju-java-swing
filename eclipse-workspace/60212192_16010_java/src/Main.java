import java.util.*;   // Vector나 ArrayList를 위해 import한다.

class Thing {
	String name;
	public Thing(String name) {
		this.name = name;
	}
	public void show(){
		System.out.println("이름은: " + name);
	}
}

class Fruit extends Thing{
	//String name;
	Fruit(String name){
		super(name);
	}
}

class Apple extends Fruit{
	Apple(String name){
		super(name);
	}
	public void show(){
		System.out.println("사과입니다. ");
		super.show();
		// 이름 출력은 상위 클래스 이용
	}
}

class Banana extends Fruit{
	Banana(String name){
		super(name);
	}
	public void show(){
		System.out.println("바나나입니다. ");
		super.show();
		// 이름 출력은 상위 클래스 이용
	}
}
class FruitBox extends Thing{
	ArrayList myList;
	// myList 는 Vector나 ArrayList를 이용한다. 적당한 크기의 배열도 OK
	//String name;
	FruitBox(String name){
		super(name);
		myList = new ArrayList();
		// myList를 초기화 한다.
	}
	public void add(Thing f){
		myList.add(f);
		// myList를 이용하여 내용물을 보관한다.
	}
	public void show(){

		System.out.println("[상자입니다. 이름은: " + name);
		System.out.println("내용물은:");
		for (int i=0; i<myList.size(); i++){
			((Thing) myList.get(i)).show();
		}
		System.out.println("]");
	}
}

class Main{
	// 새로운 Main 으로 대체한다.
	public static void main(String[] args){
		FruitBox fb = new FruitBox("과일상자1");
		FruitBox fb2 = new FruitBox("과일상자2");
		fb.add(new Apple("김사과"));
		fb.add(new Apple("이사과"));
		fb.add(new Banana("홍바나나"));
		fb2.add(new Apple("박사과"));
		fb.add(fb2);
		fb.add(new Banana("김바나나"));
		fb.show();
	}
}