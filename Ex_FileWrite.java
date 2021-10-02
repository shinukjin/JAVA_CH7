package a.b.c.ch7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import a.b.c.common.FilePath;

public class Ex_FileWrite {
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      // ���� �н� ����Ŭ�������� �ҷ����� 
      String filePath = FilePath.FILE_PATH;

      // ���� �н� �� ����� ���� ����� �ʱ�ȭ 
      String inFile = filePath + "/" + "Ex_FileWrite.java";
      String outFile = filePath + "/" + "Ex_FileWrite.bak";
      
      // �������� ����Ʈ ������ �ʱ�ȭ 
      FileReader fr = null;
      FileWriter fw = null;
      File f = null;      
      int data = 0;
            
      try {
         
         f = new File(inFile);
         
         // ������ �ִ��� ���� üũ �ϴ� boolean 
         boolean bFile = f.exists();
         System.out.println("bFile >>> : " + bFile);
         
         // ������ ���� ���� ���� �Ѵ�. 
         if (bFile) {
            
            // ������ �б� ���ؼ� 
            fr = new FileReader(f);
            System.out.println("fr >>> : " + fr);
            
            // ������ ���� ���ؼ� 
            fw = new FileWriter(outFile, true);
            System.out.println("fw >>> : " + fw);
            
            // ������ �о ���Ͽ� ���� 
            while ((data=fr.read()) != -1) {
               System.out.print((char)data);
               fw.write(data);
            }
         }else {
            System.out.println("����Ϸ��� �ش� ������(������)�� �����ϴ�. ");
         }
         
         // io �� ���� ���� ���� ������ �ݴ�� �ݴ´�. 
         fw.close(); fw=null;
         fr.close(); fr=null;
         
      }catch (Exception e) {
         System.out.println("������ e.getMessage() >>> : " + e.getMessage());
      }finally {
         // try ������ ���� �߻��� ����� io ��ü �ݱ� 
         // io �� ������ ��ü�� null �� ��쿡�� ���� �ȴ�. 
         if (fw !=null){
            try{fw.close(); fw=null;}catch (Exception e){}
         }
         if (fr !=null){
            try{fr.close(); fr=null;}catch (Exception e){}
         }
      }      
   }
}