package com.zyh.util;

import java.io.File;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class test {
	public static void main(String[] args) {
		String path = "http:\\\\localhost:8081\\SMAvatar\\".replaceAll("\\\\", "/");
//		System.out.println(path);
		String aString = "E:\\2019.6实训\\eclipse-workplace\\StudentManager\\WebContent\\avatar\\";
		System.out.println(new File(aString));
//		String path1 = path.replaceAll("\\", "/");
		
		File file = new File(path+"123.txt");
//		System.out.println(file);
	}
}
