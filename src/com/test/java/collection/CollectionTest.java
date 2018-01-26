package com.test.java.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.bytebuddy.asm.Advice.This;

public class CollectionTest {
/**
 *1.定义一个 ArrayList 里面有三个字符串元素，在第二个元素与第三个元素之间增加一个字符串元素，再把这个ArrayList 转换成一个数组并返回
 *
 *2.写出一个方法，给定义个路径，判断路径是否是一个文件，如果是文件怎把该文件的绝对路径输入到该文件中，
 *	如果是文件夹，则在该文件夹内创建一个与文件夹名相同的txt文件，
 *	比如如果文件夹名为a，怎么在a文件夹下创建一个a.txt文件，并在a.txt中输入a.txt的绝对路径
 */
	
	public static void main(String[] args) {
		
		HomeWork1();
		CollectionTest ct=new CollectionTest();
		//ct.testFile("D://demo/curry1");
		String workspace=System.getProperty("user.dir");
		ct.testFile(workspace+File.separator+"demo");
		
		
	}

	public  void testFile(String path) {
		//c:/file/file.txt
		System.out.println(path);
		File file=new File(path);
		String name= file.getName();
		System.out.println("file name is "+name);
		boolean isDir=false;
		if(name.indexOf(".")==-1) {
			isDir=true;
			if(!file.exists()) {
				file.mkdirs();
			}
		}
		if(isDir){
			File dir=new File(path+File.separator+name+".txt");
			System.out.println(dir.getAbsolutePath());
			this.testWrite(dir.getAbsolutePath(),dir.getAbsolutePath());
		}
		else {
			testWrite(file.getAbsolutePath(),file.getAbsolutePath());
		}
	}
	
	public void testWrite(String path,String content) {
		
		File file= new File(path);

			try {
				FileOutputStream os=new FileOutputStream(file);
				byte[] byteBuffer = content.getBytes();
				os.write(byteBuffer, 0, byteBuffer.length);
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void HomeWork1() {
		List<String> list=new ArrayList<String>();
		
		list.add("curry");
		list.add("green");
		list.add("durant");
		
		list.add(2, "thomphson");
		
		String[] s=new String[list.size()];
		list.toArray(s);
		//Object[] l=list.toArray();
		
		
		for(String S:s) {
			System.out.println(S);
		}
		/*for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}*/
		
/*		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
	}
}
