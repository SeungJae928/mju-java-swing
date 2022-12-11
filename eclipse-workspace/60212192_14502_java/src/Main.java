@FunctionalInterface
interface LoggerInterfae{
   void writeLog(float degree);
}

public class Main {

	public static void main(String[] args) {
		// 여기에 무명 클래스 선언이 필요한다.
		LoggerInterfae f = (float degree) -> System.out.println("현재 온도는 " + degree + " 도 입니다.");
		f.writeLog(99.5f);  // f 가 변수명이라하고 이렇게 호출.
	}
}