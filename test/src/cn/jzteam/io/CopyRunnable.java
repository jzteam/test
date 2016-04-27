package cn.jzteam.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyRunnable implements Runnable {

	public static final int BYTE_SIZE = 1024;
	public static final int THREAD_SIZE = 4;
	private long begin;
	private long end;
	private String src;
	private String desc;

	public CopyRunnable(long begin, long end, String src, String desc) {
		super();
		this.begin = begin;
		this.end = end;
		this.src = src;
		this.desc = desc;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start task!!");
		BufferedInputStream bis = null;
		RandomAccessFile raf = null;
		byte[] buf = new byte[BYTE_SIZE];
		long total = end - begin;
		long left = total;
		int len = 0;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			raf = new RandomAccessFile(desc, "rw");
			bis.skip(begin);
			raf.seek(begin);
			while (left > 0) {
				len = bis.read(buf);
				left -= len;
				if (len == -1){
					System.out.println(Thread.currentThread().getName()+" finish!!");
					return;
				}
				raf.write(buf, 0, len);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (raf != null)
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.out.println(Thread.currentThread().getName()+" finish!!");
	}

}
