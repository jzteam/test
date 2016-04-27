package cn.jzteam.io;

import java.io.File;

public class FileUtils {

	public static void multiThreadCopy(String src, String desc) {
		File file = new File(src);
		if (!file.exists()) {
			System.out.println(src + " not found");
			return;
		}

		if (file.isFile()) {
			long total = file.length();
			long left = total % CopyRunnable.THREAD_SIZE;
			long temp = 0;
			if (left == 0) {
				temp = total / CopyRunnable.THREAD_SIZE;
			} else {
				temp = total / (CopyRunnable.THREAD_SIZE - 1);
				left = total % (CopyRunnable.THREAD_SIZE - 1);
			}
			for (int i = 0; i < CopyRunnable.THREAD_SIZE; i++) {
				new Thread(new CopyRunnable(i * temp, (i + 1) * temp, src, desc), "thread " + i).start();
			}
		} else {
			File descFile = new File(desc);
			if (!descFile.exists())
				descFile.mkdirs();
			String[] list = file.list();
			for (String path : list) {
				String desc1 = desc + "/" + path;
				System.out.println("desc1: " + desc1);
				multiThreadCopy(src+"/"+path, desc1);
			}
		}
	}

}
