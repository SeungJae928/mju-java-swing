
public class StuApp {
	private static String str;
	private static String[] arr = new String[100];
	private static String[] arr2;
	public StuApp () {
		str = Student.data;
		arr[Student.index] = str;
	}
	public static void StuShow() {
		try {
			arr2 = new String[Student.index];
			arr2 = arr;
			for (int i = 0; i < Student.index + 1; i++) {
				
				System.out.println(arr2[Student.index - 1 - i]);
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
	}
}
