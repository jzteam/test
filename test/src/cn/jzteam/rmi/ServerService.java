package cn.jzteam.rmi;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService {
	
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(41000);
		System.out.println("�ȴ�����...");
		Socket socket = ss.accept();
		OutputStream out = socket.getOutputStream();
		TestService ts = new TestServiceImpl();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(ts);
		oos.flush();
		oos.close();
		System.out.println("�����Ѵ���");
	}

}
