package cn.jzteam.io;

public class Test {

	public static void main(String[] args) {
		/*String path = "E:/test";
		File file = new File(path);
		System.out.println(file.getParent());
		boolean b = file.mkdirs();
		System.out.println("����" + path + "  " + b);*/
		
		String src = "E:/mydata/�����ֽ";
		String desc = "E:/test";
		FileUtils.multiThreadCopy(src, desc);
		
	}

}
