class Animal{
	Dog dg = new Dog();
	public void Speak(){
		System.out.println("I am an animal.");
	}
}

class Dog extends Animal{
	Animal an = new Animal();
	public void Speak(){
		System.out.println("I am a dog.");
	}
}

class Main{
	// Animal과 Dog의 변수를 선언하고 서로의 클래스 인스턴스를 assign해본다.	
}