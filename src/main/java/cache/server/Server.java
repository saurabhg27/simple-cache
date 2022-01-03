package cache.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

	public static void main(String[] args) {
		try {
			Server sr = new Server();
			sr.initData();
			sr.doo();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	Map<String,String> map;
	public Server() throws IOException {
		this.server = new ServerSocket(5120);
		System.out.println("Server started,Waiting for a client ...");

		this.socket = server.accept();
		this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		this.out = new DataOutputStream(socket.getOutputStream());
		System.out.println("Client Connected!!");
	}


	public void doo() throws IOException {

		String line = "";

		while (!line.equals("CLOSECONN")) {
			try {
				line = in.readUTF();
				System.out.println(line);
				out.writeUTF("hogaya");

			} catch (IOException i) {
				System.out.println(i);
			}
		}
		System.out.println("Closing connection");

		// close connection
		socket.close();
		in.close();
		server.close();
	}

	private void initData() {
		map = new HashMap<>();
		map.put("hello", "world");
		map.put("hello1", "heuheuhe");
	}
	
	private void getData() {
		
	}
}
