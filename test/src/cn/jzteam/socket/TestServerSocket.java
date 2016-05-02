package cn.jzteam.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TestServerSocket {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Map<String,Socket> map = new HashMap<>();
		try {
			ss = new ServerSocket(40000);
			System.out.println("等待连接");
			while(true){
				Socket socket = ss.accept();
				map.put(socket.getInetAddress().getHostName(), socket);
				Thread thread = new Thread(new ChatRunnable(socket,map));
				thread.start();
				System.out.println("连接一个");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
