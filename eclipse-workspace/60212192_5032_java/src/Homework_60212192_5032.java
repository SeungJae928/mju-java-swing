
public class Homework_60212192_5032 {
	public static void main(String[] args) {
		char charArray[] = { '가', '나', '다' };
		MyString s = new MyString("Hello");
		MyString t = new MyString(" world");
		MyString u = new MyString(charArray);
		System.out.println("1. " + u);
		System.out.println("2. " + s);    // println 이 되려면 MyString에 toString 메소드가 구현되어 있어야 한다.
		s = MyString.add(s, t);  // add 는 static 함수
		System.out.println("3. " + s);
		System.out.println("4. " + s.equals("Hello"));  // false
		System.out.println("5. " + s.equals("Hello world"));  // true
		System.out.println("6. " + s.equals(new MyString("Hello world")));  // true
		System.out.println("7. " + s.length());    // 11
		System.out.println("8. " + s.charAt(6));  // 'w' 가 출력되어야함.
		try {
			System.out.println("9. " + s.charAt(99));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("9. " + "인덱스 오류");
		}
		System.out.println("10. " + s.indexOf('w'));   // 6
		System.out.println("11. " + s.indexOf('x'));   // 없으므로 -1
		System.out.println("12. " + s.indexOf("rld"));   // 8
		System.out.println("13. " + s.indexOf("wol"));   // 없으므로 -1
		System.out.println("14. " + s.substring(2,5));  // llo
		System.out.println("15. " + s.substring(-1, 100));   // Hello world
	}
}
