package cn.jzteam.test;

/**
 * 
 * @author jzteam
 *
 *         2016Äê3ÔÂ29ÈÕ
 */
public class HelloWorld {
	static {
		i = 10;
		System.out.println(HelloWorld.i);
	}
	static int i;
	static {
		i = i + 1;
	}

	public static void main(String[] args) {
		System.out.println("HelloWorld");
		System.out.println("i:" + new HelloWorld().i);
	}
}



