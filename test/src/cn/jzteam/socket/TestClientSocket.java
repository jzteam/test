package cn.jzteam.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClientSocket {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("115.35.81.36", 80);
		System.out.println("连接成功！请输入：");
		new Thread(new InputRunnable(socket)).start();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		String line = null;
		while ((line = br.readLine()) != null)
			System.out.println(line);
	}
}
