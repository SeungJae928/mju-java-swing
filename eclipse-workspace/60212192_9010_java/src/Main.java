class Dog {
	public void bark(){
		System.out.println("멍멍!");
	}
}

class FlyingDog extends Dog {
	public void Fly() {
		System.out.println("I'm flying!");
	}
}

public class Main {

	public static void main(String[] args) {
		FlyingDog fido = new FlyingDog();
		fido.bark();
		fido.Fly();
	}

}
