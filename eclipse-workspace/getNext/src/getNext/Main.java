package getNext;

import java.io.IOException;

public class Main {
	
	public static String getNext() {
		int c;
		try {
			c = System.in.read();
			while (Character.isWhitespace(c)) {
				c = System.in.read();
			}
			if (c == -1) {
				return "";
			}
			String res = "";
			while ( c!=-1 && !Character.isWhitespace(c)) {
				res += (char)c;
				c = System.in.read();
			}
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	public static void main (String []args) {
		String s;
		s = getNext();
		while (!s.equals("")) {
			System.out.println(s);
			s = getNext();
		}
	}
}
