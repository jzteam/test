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
	public static void main(String[] args) {
		//new FuFangZi();
		final String s1 = "java";
		final String s2;
		{
		    s2 = "SE";
		}
		System.out.println(s1+s2 == "javaSE");    //false
	}
}
