package cn.jzteam.test;

class Fulei {
	protected int i = 2;

	public Fulei() {
		System.out.println(this.i);
		this.display();
	}

	public void display() {
		System.out.println("Fulei中 i：" + this.i);
	}
}

public class FuFangZi extends Fulei {
	protected int i = 22;

	public FuFangZi() {
		i = 222;
	}

	public void display() {
		System.out.println("子类中的 i:" + i);
	}

	private static final String s3 = "test";

	public static void main(String[] args) {
		// new FuFangZi();
		final String s1 = "java";
		final String s2 = "SE";
		System.out.println(s1 + s2 == "javaSE"); // false
		System.out.println(s1 + s3 == "javatest");
		System.out.println("结果是：" + test());
	}

	public static String test() {
		int i = 0;
		try {
			System.out.println("游戏开始");
			//i = 10 / i;
			return "try" + i++;
		} catch (Exception e) {
			System.out.println("处理异常");
			//return "catch" + i++;
		} finally {
			System.out.println("finally中了");
			return "finally" + i++;
		}
	}
}
