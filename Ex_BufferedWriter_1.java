package a.b.c.ch7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;

//Ex_BufferedWriter.java ȭ���� �о 
//Ex_BufferedWriter.bak ���� ����� 
public class Ex_BufferedWriter_1 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      // ����� �������� �ʱ�ȭ �ϱ�
      // ����  in, out Ŭ����
      BufferedReader inBuffer = null;
      BufferedWriter outBuffer = null;   
      // ���� in, out Ŭ����
      FileReader fr = null;
      FileWriter fw = null;
      // ���� üũ�� File Ŭ����
      File f = null;
      // ���⿡ ����� ������
      int data = 0;
      
      // ���� �н� ���ϸ� �ҷ����� , ���� Ŭ���� ����ϱ�  a.b.c.common.FilePath
      String filePath = FilePath.FILE_PATH;
      String inFile = filePath + "/" + "Ex_BufferedWriter.java";
      String outFile = filePath + "/" + "Ex_BufferedWriter.bak";
      
      // try-catch �� ����� 
      try {
         // ������ �ִ��� üũ�ϱ� 
         f = new File(inFile);
         boolean b = f.exists();
         
         if (b) {
            
            // ���� �о����
            fr = new FileReader(f);
            inBuffer = new BufferedReader(fr);
            
            // ���� ���� 
            fw = new FileWriter(outFile);
            outBuffer = new BufferedWriter(fw);
            
            while ((data=inBuffer.read()) != -1) {
                System.out.print((char)data);
            	outBuffer.write(data);

            }
            outBuffer.flush();
            
            inBuffer.close(); inBuffer=null;
            outBuffer.close(); outBuffer=null;
            fr.close(); fr=null;
            fw.close(); fw=null;
         }else {
            System.out.println("������ ���׿� >>> : ");
         }
         // ���� �о����
         // ���� ���� 
         
      }catch(Exception e) {
         System.out.println("������ e.getMessage() >>> : " + e.getMessage());
      }finally{
         if (inBuffer !=null){
            try{inBuffer.close(); inBuffer=null;}catch(Exception e){}
         }
         if (outBuffer !=null){
            try{outBuffer.close(); outBuffer=null;}catch(Exception e){}
         }   
         if (fr !=null){
            try{fr.close(); fr=null;}catch(Exception e){}
         }
         if (outFile !=null){
            try{fw.close(); fw=null;}catch(Exception e){}
         }   
      }      
      
      
   }
}