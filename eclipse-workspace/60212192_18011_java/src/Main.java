
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss;
		ss = new ServerSocket(1000);
		Socket client = ss.accept();
		InputStream istream = client.getInputStream();
		int i;
		while(true) {
			i = istream.read();
			System.out.print((char) i);
		}
	}
}