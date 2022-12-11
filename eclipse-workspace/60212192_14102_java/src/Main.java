import java.util.ArrayList;

class Dog extends Pet{
	public Dog(String name) {
		super(name);
	}
	public String toString() {
		return "멍멍이 "  + super.toString();
	}
}

class Cat extends Pet{
	public Cat(String name) {
		super(name);
	}
	public String toString() {
		return "고양이 "  + super.toString();
	}
}

class Pet {
	protected String name;
	public Pet(String name) {
		this.name = name;
	}
	@Override public String toString() {
		return name;
	}
}

class School<E extends Pet>{
	ArrayList<E> petList = new ArrayList<>();
	public void add(E d) {
		petList.add(d);
	}
	public void show() {
		for (E d: petList) {
			System.out.println(d);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//School<String> stringschool = new School<>();
		School<Dog> dogschool = new School<>();
		School<Cat> catschool = new School<>();
		dogschool.add(new Dog("aaa"));
		dogschool.add(new Dog("bbb"));
		//dogschool.add(new Cat("xxx"))
		
		catschool.add(new Cat("ccc"));
		catschool.add(new Cat("ddd"));
		
		dogschool.show();
		catschool.show();
	}

}