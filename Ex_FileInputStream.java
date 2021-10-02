package a.b.c.ch7;

import java.io.File;
import java.io.FileInputStream;
import a.b.c.common.FilePath;
/*
 	�ڹ����α׷������� �޸𸮸�
 	�ҽ����� �����ڰ� �޸𸮸� ����� ������ ���� �ʴ´�.
 	�ڹٿ��� �޸𸮸� ����� ��Ȱ�� ����ϴ� ���� ������ �÷����̴�.
 	�ڹٿ��� �޸𸮸� ����ٴ� ����
 	�ڹٿ����� ������ �÷��Ϳ��� ��û�ϴ� ���̴�.
 	���α׷����� �޸𸮿��� �������� ���� ���� �������� �𸥴�.
 */
/*
 	�ڹٿ��� 
 	null Ű���尡 �ǹ��ϴ� ���� �����͸� ����Ű�� �ʴ´�.
 	���� ���� �� ���������� �����Ͱ� ����.
 */
public class Ex_FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			���������� ����ϴ� ���
			1. ���������� �Լ����� �¾�� �Լ����� �״´�.
				�� : ���̴� ���� GC(������ �÷���)�Ѵ�.
			2. ���������� ���̶�� ����� �� ���� ����.
			3. ���������� ������ �÷��Ͱ� �� ���α׷��� �޸� ��Ȳ�� ����
			4. ���α׷��� �켱������ ���� �����ٸ��� ���ؼ� �޸𸮿��� ���ŵȴ�.
		*/
		/*
			���� ������ ����ϴ� ��Ģ
			1. �������� ����� ���ÿ� ����Ʈ ������ �ʱ�ȭ �Ѵ�.
				��ü �������� = null;
				�����ڷ��� ���� ���� = ����Ʈ��; 0, 0.0 , false
			2. ��Ű���, I/O �� �߻��ϴ� ��ü�� ��� ��
				close(), flush(), null ó���� �ؾ��Ѵ�.
			3.rt.jar : java.io.*, java.sql.* , java.lang.*
			��)  FileInputStream fis = null; : null�� �ʱ�ȭ
			
				��ü ����
				fis = new FileInputStream(path + "/" + "Ex_IOTest_1.java");
				
				��ü�ݱ�
				fis.close();
				
				������ �������� null�� �ʱ�ȭ
				fis = null;
			
		*/
		
		// ��������, ��������
		// ��ü�̴� null �ʱ�ȭ �ߴ� : ��ü�� ����Ʈ ���� null
		FileInputStream fis = null;
		
		// �������� : �����ڷ����� �Լ� ���ο��� ���� �ϸ� �Ϲ������� ����������� �Ѵ�.
		// �������� ����Ʈ������ �ʱ�ȭ �ߴ�.
		int data = 0;
		
		try {
			// Common Ŭ������ ����ϴ� ��Ģ
			String path = FilePath.FILE_PATH; // common�� FILE_PATH ����� �����;�.
			System.out.println("path >>> : " + path);
			path = path + "/" + "Ex_FileInputStream.java";
			System.out.println("path >>> : " + path);
			
			File f = new File(path);
			boolean bFile = f.exists();
			
			if (bFile){
				
				//FileInputStream I/O ��ü�� �����Ѵ�.
				fis = new FileInputStream(f);
				System.out.println("fis >>> : " + fis);
				data = fis.read();
				System.out.println("data >> : " + data);
				System.out.println("(byte)data >>> : " + (byte)data);
				System.out.println("(char)data >>> : " + (char)data);
				
				// ����Ʈ ������ ���� �� �ǳ��� -1 ǥ���Ѵ�.
				while((data=fis.read()) !=-1) {
					System.out.print((char)data);
				}
				// ���������� ���� �Ǿ��� �� ����Ǵ� ��ƾ
				// FileInputStream I/O ��ü�� �ݴ´�.
				fis.close();
				
				//FileInputStream I/O ��ü�� null ó���ߴ�.
				//������ �÷��Ͱ� �ٺ��� �ش� ��ü�� �޸𸮿��� �������� �ʾ��� ���� ����ؼ�
				// �ش� �������� (���⼭�� fis) �� �����Ͱ� ���ٶ�� ǥ���Ѱ�
				fis = null;
				
			}else{
				System.out.println("������ �����ϴ�.");
			}
			
		}catch(Exception i ){
			System.out.println("������ i.getMessage() >>> : " + i.getMessage());
		}finally {
			
			// ������ ���Ḧ ����ؼ� ���� ��ƾ�̴�.
			if(fis !=null) {
				try {
					fis.close(); fis = null; //IO�ÿ��� �� close������Ѵ�.
				}catch (Exception e) {
					
				}
			}
			
		}

	}

}
