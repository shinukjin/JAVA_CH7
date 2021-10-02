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
		
		String filePath = FilePath.FILE_PATH; // ������� ������.
		
		String inFile = filePath + "/" + "Ex_BufferedStream.java";
		String outFile = filePath + "/" + "Ex_BufferedStream.bak";
		
		BufferedInputStream inbuf = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		BufferedOutputStream outbuf = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		FileInputStream fis =null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		FileOutputStream fos = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		int data =0; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		File f =null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		
		
		
		try {
			
			f = new File(inFile); //�������� f�� inFile �ʱ�ȭ
			// f.exists() ������ >> f�� �����Ͱ� ������ ������ true
			if(f.exists()) {
				
				fis = new FileInputStream(inFile); //�����͸� fis������ >> inputStream
				inbuf = new BufferedInputStream(fis); // �����͸� inbuf�� ���� >> bufferedInputStream
				
				fos = new FileOutputStream(outFile, true);
				outbuf = new BufferedOutputStream(fos);
				
				data = inbuf.read(); // �����͸� �����Ÿ� data�� �ʱ�ȭ
				System.out.println("data >>> : " + data); // p >>> 112 
				
				//�����Ͱ��� -1�� �ƴϸ� = true , -1�̵Ǹ�  false
				//-1�� ������ �ݺ��� ����
				while((data = inbuf.read()) != -1) {
					System.out.print((char)data);
					
					outbuf.write((char)data); // Ex_BufferedStream.bak ���� ����
					
				}
				outbuf.flush(); //buffered out�ʿ��� flush�� �� ����.
				outbuf.close(); // ��Ʈ���� ���� �մϴ�.
				outbuf = null; // ����Ʈ������ �ʱ�ȭ�մϴ�.
				fos.close(); // ��Ʈ���� �����մϴ�.
				fos = null; // ����Ʈ������ �ʱ�ȭ�մϴ�.
				inbuf.close(); // ��Ʈ���� �����մϴ�.
				inbuf=null; // ����Ʈ������ �ʱ�ȭ �մϴ�.
				fis.close(); // ��Ʈ���� �����մϴ�.
				fis = null; // ����Ʈ������ �ʱ�ȭ �մϴ�.
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
