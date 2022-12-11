import java.io.IOException;

public class Homework_60212192_4036 {
	
	public static String getNext() throws IOException {
		String str = "";
		while (true) {
			int c = System.in.read();
			if(c==-1) {
				while(!Character.isWhitespace(c)) {
					c = System.in.read();
				}
			}
			else if (!Character.isWhitespace(c)){
				str += (char)c;
				while(true) {
					c = System.in.read();
					if(Character.isWhitespace(c)) {
						return str;
					}
					else if (c == -1) {
						System.out.print(str);
						return "";
					}
					str += (char)c;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String s;
		s = getNext();
		while (!s.equals("")) {
			System.out.println(s);
			s = getNext();
		}
	}

}
