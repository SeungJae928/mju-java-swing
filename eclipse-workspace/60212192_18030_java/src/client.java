
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class client {

	public static void main(String[] args) throws IOException {
		String  str = "Hello from java15";
		Socket client = new Socket("127.0.0.1", 1000);
		InputStream istream = client.getInputStream();
		OutputStream ostream = client.getOutputStream();
		ostream.write(str.getBytes());
		ostream.flush();
		ostream.close();
	}
}