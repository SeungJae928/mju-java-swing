package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		ServerSocket ss;
		ss = new ServerSocket(1000);
		Socket client = ss.accept();
		System.out.println(client.getInetAddress());
	}

}
