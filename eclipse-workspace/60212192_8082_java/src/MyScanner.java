import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
	public int[] c = new int[100];
	public static String[] str = new String[100];
	public static int[] int1 = new int[100];
	public static int index = 0;
	public static int a = 0, x = 0, b, y = 0, z = 0, end_index;

	public MyScanner(InputStream in) {
		try {
			String s = "";
			int1 = new int[100];
			index = 0;
			a = 0;
			x = 0;
			y = 0;
			z = 0;
			str = new String[100];
			c = new int[100];
			int i = 0;
			while (true) {
				b = in.read();
				if(b == -1) {
					break;
				}
				c[i] = b;
				i++;
			}
			end_index = i;
			for (i = 0; i < c.length; i++) {
				if(c[i] == 13) {
					if(s == "") {
						s = "";
						i++;
						continue;
					}
					s.trim();
					str[index] = s;
					index++;
					s = "";
					i++;
					continue;
				} else if (c[i] == 32) {
					if(s == "") {
						s = "";
						continue;
					}
					str[index] = s;
					index++;
					s = "";
					continue;
				} else if (c[i] == c[end_index]) {
					str[index] = s;
					index++;
					s = "";
					break;
				}
				s += (char) c[i];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean hasNextInt() {
		try {
			Integer.parseInt(str[a]);
			int1[a] = Integer.parseInt(str[a]);
			a++;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int nextInt() {
		int i = 0;
		i += int1[x];
		x++;
		return i;
	}

	public boolean hasNext() {
		
		if(str[y] == null || str[y] == "") {
			return false;
		}
		y++;
		return true;
	}

	public String next() {
		String s = "";
		s = str[z];
		z++;
		return s;
	}

}
