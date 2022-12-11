
public class MyStrBuffer {
	private char[] content;
	private int length;
	private int capacity;

	public MyStrBuffer() {
		int[] arr = new int[0];
	}

	public MyStrBuffer(char[] c) {
		content = c;
		length = c.length;
	}

	public MyStrBuffer(String s) {
		length = s.length();
		content = s.toCharArray();
		capacity = 16 + s.length();
	}

	public MyStrBuffer append(MyStrBuffer t) {
		char[] arr;
		arr = new char[length + t.length];
		try {
			for (int i = 0; i < length + t.length; i++) {
				arr[i] = content[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			for (int i = 0; i < length; i++) {
				arr[i + length] = t.charAt(i);
			}
		}
		content = arr;
		length = arr.length;
		return new MyStrBuffer(content);
	}

	public MyStrBuffer append(int x) {
		char[] arr = new char[length + (int) (Math.log10(x) + 1)];
		try {
			for (int i = 0; i < length + (int) (Math.log10(x) + 1); i++) {
				arr[i] = content[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			for (int i = 0; i < (int) (Math.log10(x) + 1); i++) {
				arr[length + i] = (char) (i + 1 + '0');
			}
		}
		content = arr;
		length = arr.length;
		return new MyStrBuffer(arr);
	}

	public MyStrBuffer delete(int begin, int end) {
		char[] arr;
		arr = new char[length];
		try {
			int index = 0;
			for (int i = begin; i < end; i++) {
				content[i] = 0;
			}
			for (int i = 0; i < length; i++) {
				if (content[i] == 0) {
					content[i] = content[i + 1];
				} else if (content[i] != 0) {
					arr[index] = content[i];
					index++;
				}
			}
			content = arr;
			arr = new char[index];
			for (int i = 0; i < index; i++) {
				if (content[i] != 0) {
					arr[i] = content[i];
				} else if (content[i] == 0) {
					length = index;
				}
			}
		} catch (NullPointerException e) {

		} catch (ArrayIndexOutOfBoundsException e) {
			int index = 0;
			for (int i = 0; i < length; i++) {
				if (content[i] != 0) {
					index++;
				}
			}
			arr = new char[index];
			for (int i = 0; i < index; i++) {
				arr[i] = content[i];
			}
			content = arr;
		}
		content = arr;
		length = arr.length;
		return new MyStrBuffer(content);
	}

	public MyStrBuffer insert(int index, String s) {
		char[] arr;
		arr = new char[length + s.length()];
		int count = 0;
		try {
			for (int i = 0; i < length + s.length(); i++) {
				if (index == i) {
					for (int j = 0; j < s.length(); j++) {
						arr[j] = s.charAt(j);
						count++;
					}
				}
				for (int t = 0; t < length; t++) {
					arr[t + count] = content[t];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		content = arr;
		length = arr.length;
		return new MyStrBuffer(arr);
	}

	public MyStrBuffer reverse() {
		char[] arr;
		arr = new char[length];
		for (int i = 0; i < length; i++) {
			arr[i] = content[length - 1 - i];
		}
		content = arr;
		length = arr.length;
		return new MyStrBuffer(content);
	}

	public MyStrBuffer trimToSize() {
		capacity = length;
		return new MyStrBuffer(content);
	}

	public String toString() {
		return new String(content);
	}

	public int capacity() {
		return capacity;
	}

	public int length() {
		return length;
	}

	public char charAt(int n) throws IndexOutOfBoundsException {
		return content[n];
	}
}
