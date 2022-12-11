import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyBufferedFileInputStream extends FileInputStream {
	byte[] bf = new byte[8192];
	int i = 0;
	int c;
	MyBufferedFileInputStream (String str) throws IOException{
		super(str);
		super.read(bf);
	}
	@Override public int read() throws IOException {
		i++;
		if(bf[i - 1] == 0) {
			return -1;
		}
		if(i >= bf.length) {
			bf = new byte[8192];
			read(bf);
			i = 0;
			return (int) bf[i];
		}
		return (int) bf[i - 1];
	}
}
