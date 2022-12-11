import java.util.Scanner;

public class MyIntArray {
	private static String[] str;
	private static String[] str2;
	private int a;
	private char b;
	private static int index = 0;
	private static String s = null;
	private static String str1 = "";
	private static int[] arr = new int[2];
	private static int c = 0;

	public MyIntArray(int a) {
		str = new String[a];
	}

	public MyIntArray(Scanner sc) {
		manage();
		if (sc.hasNextInt()) {
			if (c >= 2) {
				c = 0;
			}
			arr[c] = sc.nextInt();
			b = 't';
			c++;
		} else {
			s = sc.next();
			c = 0;
		}
		if (s != null && b == 't') {
			if (s.equals("a")) {
				a(arr[0]);
			} else if (s.equals("x")) {
				x(arr[0]);
			} else if (arr[1] != 0 && s.equals("i")) {
				i(arr[0], arr[1]);
			}
		}
        if (s.equals("p")) {
        	show();
        } else if (s.equals("s")) {
        	s();
		}
	}

	public void a(int i) {
		for(int x = 0; x < str.length; x++) {
			if (str[x] == null) {
				str[x] = String.valueOf(i);
				break;
			}
		}
		index++;
	}

	public void i(int a, int b) {
		index++;
		for (int i = index -2; i >= 0; i--) {
			if (str[a] == null) {
				break;
			}
			str[a+i+1] = str[a+i];
		}
		str[a] = String.valueOf(b);
	}
	
	public void s() {
		String s;
		for(int j = 0; j < index -1; j++) {
			for(int i = 0; i < index -1; i++) {
				if(Integer.parseInt(str[i + 1]) > Integer.parseInt(str[i])) {
					s = str[i];
					str[i] = str[i +1];
					str[i + 1] = s;
				}
			}
		}
	}
	
	public void x(int a) {
		str[a] = null;
		for(int i = 0; i < index-1; i++) {
			str[a + i] = str[a + i + 1];
		}
		str[index-1] = null;
		index--;
	}

	public void show() {
		System.out.println("크기 " + str.length + " 사용 " + index + " 내용" + content() + " 끝");
	}

	public String content() {
		str1 = "";
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null) {
				return str1;
			}
			str1 += " " + str[i];
		}
		return str1;
	}
	
	public void manage() {
		MyIntArray a;
		if(index >= str.length) {
			str2 = str;
			a = new MyIntArray(str.length*2);
			for (int i = 0; i < str2.length; i++) {
				str[i] = str2[i];
			}
		}
		else if(str.length > 4 && str.length/4 >= index) {
			str2 = str;
			a = new MyIntArray(str.length/2);
			for(int i = 0; i < str.length; i++) {
				str[i] = str2[i];
			}
		}
	}
}
