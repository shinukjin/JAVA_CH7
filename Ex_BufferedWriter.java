package a.b.c.ch7;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


import a.b.c.common.*;

public class Ex_BufferedWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = FilePath.FILE_PATH;
		
		String inFile = filePath + "/" + "Ex_BufferedWriter.java";
		String outFile = filePath + "/" + "Ex_BufferedWriter.bak";
		BufferedReader inbuf = null; // 지역변수 디폴트갓으로 초기화시킴
		BufferedWriter outbuf = null; // 지역변수 디폴트갓으로 초기화시킴
		FileReader fr =null; // 지역변수 디폴트갓으로 초기화시킴
		FileWriter fw = null; // 지역변수 디폴트갓으로 초기화시킴
		int data =0; // 지역변수 디폴트갓으로 초기화시킴
		File f =null; // 지역변수 디폴트갓으로 초기화시킴
		
		try{
			f = new File(inFile);

			System.out.println(f.exists());
			
			if(f.exists()) {
				
				fr = new FileReader(f); 
				fw = new  FileWriter(outFile, true);
				inbuf = new BufferedReader(fr);
				outbuf = new BufferedWriter(fw);
				
				while((data=inbuf.read()) !=-1) {
					System.out.print((char)data);
					
					outbuf.write(data); //Ex_BufferedWriter.bak 파일 만듬.
				}
				outbuf.flush(); // 
				outbuf.close(); outbuf = null; // 스트림 종료 , 디폴트값으로초기화
				fw.close(); fw = null; // 스트림 종료 , 디폴트값으로초기화
				inbuf.close(); inbuf =null; // 스트림 종료 , 디폴트값으로초기화
				fr.close(); fr = null; // 스트림 종료 , 디폴트값으로초기화
			}else {
				System.out.println("파일이 없네요.");
			}
			//예외처리 IOException
		}catch(IOException i) {
			System.out.println("error i >> : " + i.getMessage());
		} finally {
			if(outbuf != null){ 
				try {outbuf.close(); outbuf = null;}catch(Exception e){}
			}
			if(fw != null){ 
				try {fw.close(); fw = null;}catch(Exception e){}
			}
			if(inbuf != null){ 
				try {inbuf.close(); inbuf = null;}catch(Exception e){}
			}
			if(fr != null){ 
				try {fr.close(); fr = null;}catch(Exception e){}
			}
		}
	}
}
