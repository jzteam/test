package cn.jzteam.test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collect implements Serializable{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private List<?> list;

	private Set<?> set;

	private Map<String, Object> map;

	public Collect() {
		map = new HashMap<>(1);
		map.put(null, null);
		map.put("key", "test2");
		System.out.println("result:" + map.isEmpty() + "  " + map.get(null));
	}

	public static void main(String[] args) {
		new Collect().test();
	}
	@JzteamWarning
	public void test(){
		System.out.println("jzteam test annotion");
	}



}
