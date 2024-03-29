package com.zyh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class FileCopy {
	public static void main(String[] args) {
		try {
			copyFile(new File("C:\\Users\\E G\\Desktop\\123.txt"), new File("C:\\Users\\E G\\Desktop\\321.txt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static long copyFile(File f1,File f2) throws Exception{
		long time = new Date().getTime();
		int length=2097152;
		FileInputStream in=new FileInputStream(f1);
		FileOutputStream out=new FileOutputStream(f2);
		FileChannel inC=in.getChannel();
		FileChannel outC=out.getChannel();
		ByteBuffer b=null;
		while(true){
			if(inC.position()==inC.size()){
				inC.close();
				outC.close();
				return new Date().getTime()-time;
			}
			if((inC.size()-inC.position())<length){
				length=(int)(inC.size()-inC.position());
			}else{
				length=2097152;
			}
			b=ByteBuffer.allocateDirect(length);
			inC.read(b);
			b.flip();
			outC.write(b);
			outC.force(false);
		}
	}
	
//	public long forChannel(File f1,File f2) throws Exception{
//        long time=new Date().getTime();
//        int length=2097152;
//        FileInputStream in=new FileInputStream(f1);
//        FileOutputStream out=new FileOutputStream(f2);
//        FileChannel inC=in.getChannel();
//        FileChannel outC=out.getChannel();
//        ByteBuffer b=null;
//        while(true){
//            if(inC.position()==inC.size()){
//                inC.close();
//                outC.close();
//                return new Date().getTime()-time;
//            }
//            if((inC.size()-inC.position())<length){
//                length=(int)(inC.size()-inC.position());
//            }else{
//                length=2097152;
//			}
//            b=ByteBuffer.allocateDirect(length);
//            inC.read(b);
//            b.flip();
//            outC.write(b);
//            outC.force(false);
//        }
//    }
}
