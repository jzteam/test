package cn.jzteam.test;

import cn.jzteam.annotation.Evaluate;
import cn.jzteam.annotation.ParseAnnotation;

public class TestAnnotation {
	
	@Evaluate(name="jzteam")
	private TestPerson p;
	
	public TestAnnotation(){
		ParseAnnotation.parseFieldAnnotation(this);
	}
	
	public static void main(String[] args) {
		new TestAnnotation().test();
	}

	public void test(){
		p.test1();
	}
	
}
