package a.b.c.ch7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import a.b.c.common.FilePath;

public class Ex_FileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���� �н� ����Ŭ�������� �ҷ�����
		String filePath = FilePath.FILE_PATH;
		
		// ���� �н� �� ����� ���ϸ���� �ʱ�ȭ.
		String inFile = filePath + "/" + "Ex_FileOutputStream.java";
		String outFile = filePath + "/" + "Ex_FileOutputStream.bak";

		// �������� ����Ʈ ������ �ʱ�ȭ
		FileInputStream fis = null;
		FileOutputStream fos = null;
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
				fis = new FileInputStream(f);
				System.out.println("fis >>> : " + fis);
				
				// ������ ���� ���ؼ� 
				fos = new FileOutputStream(outFile, true);
				System.out.println("fos >>> : " + fos);
				
				// ������ �о ���Ͽ� ���� 
				while ((data=fis.read()) != -1) {
					System.out.print((char)data);
					fos.write(data);
				}
			}else {
				System.out.println("����Ϸ��� �ش� ������(������)�� �����ϴ�. ");
			}
			
			// io �� ���� ���� ���� ������ �ݴ�� �ݴ´�. 
			fos.close(); fos=null;
			fis.close(); fis=null;
			
		}catch (Exception e) {
			System.out.println("������ e.getMessage() >>> : " + e.getMessage());
		}finally {
			// try ������ ���� �߻��� ����� io ��ü �ݱ� 
			// io �� ������ ��ü�� null �� ��쿡�� ���� �ȴ�. 
			if (fos !=null){
				try{fos.close(); fos=null;}catch (Exception e){}
			}
			if (fis !=null){
				try{fis.close(); fis=null;}catch (Exception e){}
			}
		}		
	}
}