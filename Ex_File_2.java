package a.b.c.ch7;

import java.io.File;
import java.io.IOException;

import a.b.c.common.DateUtil;

public class Ex_File_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//mkdir(함수)
		File f1= new File("abc");
		f1.mkdir();
		System.out.println("f1 >>> : " +f1);
		
		//File f2 = new File(f1, "20210727"+f1.getName()+".txt");
		File f2 = new File(f1, DateUtil.yyyymmdd() + "_" + f1.getName() + ".txt");
		f2.createNewFile();
		String getPath = f2.getPath(); // 파일에 입력된 경로
		System.out.println("getPath >>> : " + getPath); 
		
		if(f2.exists()) {
			java.io.FileWriter fw = null;
			fw = new java.io.FileWriter(f2);
			fw.write("mkdir :: 파일 내용을 써보세요");
			fw.close();
		}
		File files[] = f1.listFiles();
		System.out.println("files.length >>> : " + files.length);
		for (int i =0; i <files.length ; i++) {
			String fileName = files[i].getName();
			System.out.println("fileName >>> : " + fileName);
		}
		
		//mkdirs()함수
		File f3 = new File("aa/bb/cc"); //cc만 생김ㅁ
		f3.mkdirs();
		System.out.println("f3 >>> : " + f3);
		
		//f3.getName() >>> : cc만 생김
		File f4 = new File(f3, DateUtil.yyyymmdd() +"_"+f3.getName()+".txt");
		f4.createNewFile();
		String getPath1= f4.getPath();
		System.out.println("getPath1 >> : " + getPath1);
		
		if(f4.exists()){
			java.io.FileWriter fw = null;
			fw = new java.io.FileWriter(f4);
			fw.write("mkdirs :: 파일내용을 써보세요");
			fw.close();
		}
	}

}
