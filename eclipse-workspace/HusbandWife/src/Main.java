class Husband {
	Wife myWife;
	String name;
	public Husband(String name) {
		this.name = name;
	}
	void setWife(Wife w) {
		myWife = w;
	}
	void speak() {
		System.out.println("나는 " + name + ", 내 아내는 " + myWife.getName());
	}
	public String getName() {
		return name;
	}
}

class Wife {
	Husband myHusband;
	String name;
	public Wife(String name) {
		this.name = name;
	}
	void setHusband(Husband h) {
		myHusband = h;
	}
	public String getName() {
		return name;
	}
	void speak() {
		System.out.println("나는 " + name + ", 내 남편는 " + myHusband.getName());
	}
}

public class Main {

	public static void main(String[] args) {
		Husband h1 = new Husband("홍길동");
		Wife w1 = new Wife("홍길순");
		h1.setWife(w1);
		w1.setHusband(h1);
		h1.speak();  // 자기와 자기 부인 소개  예시: 나는 홍길동 내 아내는 홍길순
		w1.speak();

	}

}
