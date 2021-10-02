package a.b.c.ch7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

import a.b.c.common.FilePath;

public class Ex_BufferedStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = FilePath.FILE_PATH; // 상수값을 가져옴.
		
		String inFile = filePath + "/" + "Ex_BufferedStream.java";
		String outFile = filePath + "/" + "Ex_BufferedStream.bak";
		
		BufferedInputStream inbuf = null; // 지역변수 디폴트갓으로 초기화시킴
		BufferedOutputStream outbuf = null; // 지역변수 디폴트갓으로 초기화시킴
		FileInputStream fis =null; // 지역변수 디폴트갓으로 초기화시킴
		FileOutputStream fos = null; // 지역변수 디폴트갓으로 초기화시킴
		int data =0; // 지역변수 디폴트갓으로 초기화시킴
		File f =null; // 지역변수 디폴트갓으로 초기화시킴
		
		
		
		try {
			
			f = new File(inFile); //참조변수 f에 inFile 초기화
			// f.exists() 논리값임 >> f에 데이터가 있으면 있으면 true
			if(f.exists()) {
				
				fis = new FileInputStream(inFile); //데이터를 fis에넣음 >> inputStream
				inbuf = new BufferedInputStream(fis); // 데이터를 inbuf에 넣음 >> bufferedInputStream
				
				fos = new FileOutputStream(outFile, true);
				outbuf = new BufferedOutputStream(fos);
				
				data = inbuf.read(); // 데이터를 읽은거를 data에 초기화
				System.out.println("data >>> : " + data); // p >>> 112 
				
				//데이터값이 -1이 아니면 = true , -1이되면  false
				//-1이 나오면 반복문 종료
				while((data = inbuf.read()) != -1) {
					System.out.print((char)data);
					
					outbuf.write((char)data); // Ex_BufferedStream.bak 파일 만듬
					
				}
				outbuf.flush(); //buffered out쪽에만 flush할 수 있음.
				outbuf.close(); // 스트림을 종료 합니다.
				outbuf = null; // 디폴트값으로 초기화합니다.
				fos.close(); // 스트림을 종료합니다.
				fos = null; // 디폴트값으로 초기화합니다.
				inbuf.close(); // 스트림을 종료합니다.
				inbuf=null; // 디폴트값으로 초기화 합니다.
				fis.close(); // 스트리을 종료합니다.
				fis = null; // 디폴트값으로 초기화 합니다.
			}
			
		} catch(Exception e) {
			System.out.println("error e >> : " +e);
		} finally {
			if (outbuf != null) {
				try { outbuf.close();outbuf = null; }catch(Exception i) {}
			}
			if (fos != null) { 
				try { fos.close(); fos = null; }catch(Exception i) {}
			}
			if (inbuf != null) { 
				try { inbuf.close(); inbuf = null; }catch(Exception i) {}
			}
			if (fos != null) {
				try {fis.close();fis = null;}catch(Exception i) {}
			}
		}
	}
}
