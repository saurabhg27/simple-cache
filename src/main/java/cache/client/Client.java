package cache.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Client cl = new Client();
			cl.sendMSg("HUEHUEHU");
//			Thread.sleep(4000);
			cl.sendCloseCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Socket socket;
	DataOutputStream out;
	DataInputStream in;

	public Client() throws UnknownHostException, IOException {
		this.socket = new Socket("127.0.0.1", 5120);
		this.out = new DataOutputStream(socket.getOutputStream());
		this.in = new DataInputStream(socket.getInputStream());
	}

	public void sendMSg(String msg) throws UnknownHostException, IOException {
		String fr = in.readUTF();
		System.out.println("fr: "+fr);
		out.writeUTF(msg);
		out.flush();
	}

	private void sendCloseCon() throws IOException {
		out.writeUTF("CLOSECONN");
		out.close();
		socket.close();
	}
}
