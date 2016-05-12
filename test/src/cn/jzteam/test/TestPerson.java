package cn.jzteam.test;

public class TestPerson {
	
	private String name;

	public void test1() {
		System.out.println("Annotation:"+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
