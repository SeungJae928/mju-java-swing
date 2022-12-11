
public class MyStringArray {
	private String[] str;
	private int index = 0;
	public MyStringArray (int i) {
		str = new String[i];
	}
	
	public void add(String s) throws Exception {
		if(index >= str.length) {
			System.out.println("크기초과");
		}
		str[index] = s;
		index++;
	}
	public int size() {
		return index;
	}
	
	public String elementAt(int i) throws Exception {
		if (i < 0 || i >= index) {
			System.out.println("인덱스범위초과");
		}
		return str[i];
	}
}
