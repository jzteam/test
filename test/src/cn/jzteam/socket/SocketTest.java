package cn.jzteam.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class SocketTest {

	@Test
	public void test1() throws Exception {
		// Inet4Address
		InetAddress inetAddress = Inet4Address.getByName("www.61yzt.com");
		// 测试是否可到达
		boolean reachable = inetAddress.isReachable(10000);
		System.out.println("是否达到：" + reachable);
		// 获取ip
		String ip = inetAddress.getHostAddress();
		// 获取主机名
		String name = inetAddress.getHostName();
		// 获取权限定域名
		String canonicalName = inetAddress.getCanonicalHostName();
		System.out.println("ip:" + ip);
		System.out.println("主机名:" + name);
		System.out.println("权限定域名：" + canonicalName);
		// 本地主机
		System.out.println(InetAddress.getLocalHost());
	}

	/**
	 * openStream不能读到所有的字节，why????????
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		URL url = new URL("http://www.61yzt.com/yztapp/dataCenter/html/list?type=0");
		System.out.println("userinfo:"+url.getUserInfo());
		String file = url.getFile();
		System.out.println("拼接："+url.getProtocol()+"://"+url.getHost()+(url.getPort()==-1?"":":"+url.getPort())+url.getPath()+"?"+url.getQuery());
		System.out.println("file:"+file);
		InputStream is = url.openStream();
		
		byte[] buf = new byte[1024];
		int i = 0;
		int count = 0;
		int len = 0;
		while((len = is.read(buf)) != -1){
			count += len;
			System.out.println(new String(buf,"utf-8"));
			System.out.println("循环第"+ ++i+"次："+len+"字节");
		}
		System.out.println("结束，共"+count+"字节");
	}
	
	@Test
	public void test3() throws Exception{
		URL url = new URL("http://www.61yzt.com/yztapp/dataCenter/html/list?type=0");
		URLConnection conn = url.openConnection();
		System.out.println("长度："+conn.getContentLength());
		System.out.println("类型："+conn.getContentType());
	}
	
	@Test
	public void test4() throws Exception{
		URL url = new URL("http://www.61yzt.com/yztapp/dataCenter/html/list");
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Accept-Encoding", "text/plain");
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		os.write("type=0&title=bed".getBytes("utf-8"));
		InputStream is = conn.getInputStream();
		byte[] buf = new byte[1024];
		int i = 0;
		int count = 0;
		int len = 0;
		while((len = is.read(buf)) != -1){
			count += len;
			System.out.println(new String(buf,"utf-8"));
			System.out.println("循环第"+ ++i+"次："+len+"字节");
		}
		System.out.println("结束，共"+count+"字节");
	}
}
