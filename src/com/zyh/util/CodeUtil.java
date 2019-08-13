package com.zyh.util;

import java.util.Random;

public class CodeUtil {
	public static String str(){
		String str = "ABCDEFGHJKMNOPQRSTUVWXYZabcdefghgkmnopkrstuvwxyz23456789";
		Random random = new Random();
		char c = str.charAt(random.nextInt(str.length()));
		return c+"";
	}
//	public static void main(String[] args) {
//		System.out.println(str());
//	}
}
