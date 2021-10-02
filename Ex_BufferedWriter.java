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
		BufferedReader inbuf = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		BufferedWriter outbuf = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		FileReader fr =null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		FileWriter fw = null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		int data =0; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		File f =null; // �������� ����Ʈ������ �ʱ�ȭ��Ŵ
		
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
					
					outbuf.write(data); //Ex_BufferedWriter.bak ���� ����.
				}
				outbuf.flush(); // 
				outbuf.close(); outbuf = null; // ��Ʈ�� ���� , ����Ʈ�������ʱ�ȭ
				fw.close(); fw = null; // ��Ʈ�� ���� , ����Ʈ�������ʱ�ȭ
				inbuf.close(); inbuf =null; // ��Ʈ�� ���� , ����Ʈ�������ʱ�ȭ
				fr.close(); fr = null; // ��Ʈ�� ���� , ����Ʈ�������ʱ�ȭ
			}else {
				System.out.println("������ ���׿�.");
			}
			//����ó�� IOException
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
