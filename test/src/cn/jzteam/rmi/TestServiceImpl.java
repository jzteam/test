package cn.jzteam.rmi;

import java.io.Serializable;

public class TestServiceImpl implements TestService, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void call() {
		System.out.println("¸´ÔÓÂß¼­£¬²Ù×÷Êý¾Ý¿â");
	}

}
