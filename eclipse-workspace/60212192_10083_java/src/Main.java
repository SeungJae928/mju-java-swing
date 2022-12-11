import java.io.FileInputStream;
import java.io.IOException;


public class Main {
	
	public static void main	(String [] args) throws IOException {
		int count = 0;
		int c, d;
		FileInputStream myStream1 = new FileInputStream("one_mega.txt");
		
		long Time1 = System.currentTimeMillis();
		try {
			while ((c = myStream1.read()) != -1) {
				if(c == 'a') {
					count++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long Time2 = System.currentTimeMillis();
		
		System.out.println("count : " + count);
		System.out.println("소요시간 : " + (Time2 - Time1)/1000.0);
		myStream1.close();
		count = 0;
		Time1 = Time2 = 0;
		
		MyBufferedFileInputStream myStream2 = new MyBufferedFileInputStream(new FileInputStream("one_mega.txt"));
		Time1 = System.currentTimeMillis();
		try {
			while ((d = myStream2.read()) != -1) {
			    if (d == 'a') {
			    	count++;
			    }
			}
		} catch (Exception e) {
			
		}
		Time2 = System.currentTimeMillis();
		
		System.out.println("count : " + count);
		System.out.println("소요시간 : " + (Time2 - Time1)/1000.0);
	}

}
