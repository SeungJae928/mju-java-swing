
public class MyString {
	private char[] content;   // 실제 내용을 담을 배열 변수
	private int length;
	private static MyString str = new MyString();
	// immutable은 생성자 이외에는 내용물을 설정하는 방법이 없다.
	public MyString() {
		// 길이가 0 인 배열을 할당.
		int[] arr = new int [0];
	}
	public MyString(char[] carray) {
		length = carray.length;
		content = carray;
	}
	public MyString(String s) {
		length = s.length();
		content = s.toCharArray();
	}
	public int length() {
		return length;
	}
	
	public String toString() {
		return new String(content);
		// String 클래스의 생성자 중 적당한 것을 찾아서 활용
		// 이 함수가 있어야 println을 사용할 수 있다.
	}
	
	public boolean equals(String s) {
		String str = new String(content);
		if(s.equals(str)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean equals(MyString s) {
		if(s.equals("" + str)) {
			return true;
		}
		else {
			return false;
		}
	}
	public char charAt(int n) throws IndexOutOfBoundsException{
		// 특정 위치의 char 를 둘려주는 함수
		return content[n];
	}
	public static MyString add(MyString a, MyString b) {
		str = new MyString("" + a + b);
		return str;
	}
	public int indexOf(char c) {
		// 문자열에서 문자 c의 위치를 알려준다. 없으면 -1
		for (int i = 0; i < length; i ++) {
			if(content[i] == c) {
				return i;
			}
		}
		return -1;
	}
	public int indexOf(String s) {
		// s 가 포함되어 있는 경우 위치를 돌려준다.
		// 없으면 -1
		// 아래의 보조 함수 isSubstr을 사용하면 편리하다.
		// 그러면 여기서는 반복문만 돌리면 된다.
		for(int i = 0; i < length; i++) {
			if(isSubstr(i, s)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isSubstr(int index, String s) {
		// content의 특정 위치부터가 s와 같은지 판별하는 함수
		char[] c = s.toCharArray();
		if(content[index] == c[0]) {
			if(content[index+1] == c[1]) {
				if(content[index+2] == c[2]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public MyString substring(int begin, int end) {
		// 스트링의 일부를 추출해서 MyString으로 만들어 주는 함수.
		String s = "";
		if (begin > 0) {
			for (int i = begin; i < end; i++) {
				s += content[i];
			}
		}
		else if(begin < 0 || end > length) {
			for (int i = 0; i < length;i++) {
				s += content[i];
			}
		}
		str = new MyString("" + s);
		return str;
	}
}
