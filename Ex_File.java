package a.b.c.ch7;

import java.io.File;
import java.io.IOException;

import a.b.c.common.FilePath;

public class Ex_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = FilePath.FILE_PATH;

		try {
			// File 클래스는  자바에서 파일 및 폴더 객체를 다루는 클래스이다. 
			File f = new File("aaaaaa");
			System.out.println("f >>> :  " + f);
			System.out.println("f.getName() >>> :  " + f.getName());
			boolean bf = f.createNewFile();
			System.out.println("bf >>> : " + bf);
			
			boolean bdir = f.isDirectory();
			System.out.println("bdir >>> : " + bdir);
			boolean bfile = f.isFile();
			System.out.println("bfile >>> : " + bfile);
			
			String getPath = f.getAbsolutePath();
			System.out.println("getPath >>> : " + getPath);
			String getAbsolutePath = f.getCanonicalPath();
			System.out.println("getAbsolutePath >>> : " + getAbsolutePath);
			String getCanonicalPath = f.getCanonicalPath();
			System.out.println("getCanonicalPath >>> : " + getCanonicalPath);
			
			
			File f1 = new File (filePath + "/" + "aaaaaa.txt");
			System.out.println("f1 >>> : " + f1);
			System.out.println("f1.getName() >>> :  " + f1.getName());
			boolean bf1 = f1.createNewFile();
			System.out.println("bf1 >>> : " + bf1);
			
			boolean bdir1 = f1.isDirectory();
			System.out.println("bdir1 >>> : " + bdir1);
			boolean bfile1 = f1.isFile();
			System.out.println("bfile1 >>> : " + bfile1);
			
		}catch(Exception io) {
			
		}		
	}
}
