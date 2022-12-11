import java.io.FileInputStream;
import java.io.IOException;

public class MyBufferedFileInputStream {
	FileInputStream myStream;
	byte[] bf = new byte[8192];
	int c;
	int i = 0;
	public MyBufferedFileInputStream(FileInputStream fis) throws IOException {
		this.myStream = fis;
		myStream.read(bf);
	}
	public int read() throws IOException {
		i++;
		if(bf[i - 1] == 0) {
			return -1;
		}
		if(i >= bf.length) {
			bf = new byte[8192];
			myStream.read(bf);
			i = 0;
			return (int) bf[i];
		}
		return (int) bf[i - 1];
	}
}
