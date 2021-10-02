package a.b.c.ch7;

import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import a.b.c.common.FilePath;

public class Ex_InOutStrReadTest  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = FilePath.FILE_PATH;

		// 파일 패스 및 사용할 파일 명까지 초기화 
		String inFile = filePath + "/" + "Ex_InOutStrReadTest.java";
		String outFile = filePath + "/" + "Ex_InOutStrReadTest.bak";
		
		File ff = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null; // byte -> char 변환한는 io 보조스트림 클래스 
		OutputStreamWriter osw = null; // char -> byte 변환한는 io 보조스트림 클래스
		BufferedReader bfr = null;
		BufferedWriter bfw = null;
		int data = 0;
		boolean bFile = false;
		
		try {
			ff = new File(inFile);
			bFile = ff.exists();
			
			if(bFile) {
				
				//파일패스 읽기위해
				bfr = new BufferedReader(new InputStreamReader(new FileInputStream(ff)));
				
				//파일패스 쓰기위해

				bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
				
				//파일패쓰 읽은거 쓰기
				while((data = bfr.read()) !=-1 ) {
					System.out.print((char)data);
					bfw.write(data);
				}
				bfw.flush();
			
			}else{
				System.out.println("데이터가 없습니다.");
			}
			
			bfw.close(); bfw = null;
			bfr.close(); bfr = null;
			osw.close(); osw = null;
			isr.close(); isr = null;
			fos.close(); fos = null;
			fis.close(); fis = null;
			
		}catch(Exception i) {
			System.out.println("error i.getMessage >>> : " + i.getMessage());
		}
		finally {
			if(bfw !=null) {try {bfw.close(); bfw = null; }catch(Exception e) {}}
			if(osw !=null) {try {osw.close(); osw = null; }catch(Exception e) {}}
			if(fos !=null) {try {fos.close(); fos = null; }catch(Exception e) {}}
			if(bfr !=null) {try {bfr.close(); bfr = null; }catch(Exception e) {}}
			if(isr !=null) {try {isr.close(); isr = null; }catch(Exception e) {}}
			if(fis !=null) {try {fis.close(); fis = null; }catch(Exception e) {}}	
		}
	}
}
