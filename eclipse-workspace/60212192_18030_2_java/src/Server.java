import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) throws IOException, SocketException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1000);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		while(true) {
			System.out.print((char) is.read());
		}
	}

}
