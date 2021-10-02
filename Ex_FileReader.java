package a.b.c.ch7;

import java.io.File;
import java.io.FileReader;

import a.b.c.common.FilePath;

public class Ex_FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���� �н� ���� Ŭ�������� �ҷ�����
		String filePath = FilePath.FILE_PATH;
		// ���� �н� �� ����� ���ϸ���� �ʱ�ȭ;
		String inFile = filePath + "/" + "Ex_FileReader.java";
		
		//��������, ��������
		//��ü�̴� null�ʱ�ȭ�ߴ�. : ��ü�� default ���� null
		FileReader fr =null;
		
		//�������� : �����ڷ����� �Լ� ���ο��� �����ϸ� �Ϲ������� ����������� �θ���.
		// �������� ����Ʈ ������ �ʱ�ȭ �ߴ�.
		int data = 0;
		
		try {
			File f = new File(inFile);
			boolean bFile = f.exists();
			
			if(bFile) {
				// FileInputStream I/O ��ü�� �����Ѵ�.
				fr = new FileReader(f);
				System.out.println("fr >>>> : " + fr);
				
				data = fr.read();
				System.out.println("data >>> : " + data);
				System.out.println("(byte)data >>> : " + (byte)data);
				System.out.println("(char)data >>> : " + (char)data);
				
				// char ������ �Ӥ��� �� �� ���� -1�� ǥ���Ѵ�.
				while((data=fr.read()) !=-1) {
					System.out.print((char)data);
				}
				// ���������� ����Ǿ��� �� ����Ǵ� ��ƾ
				// FileInputStream I/O ��ü�� �ܵ��
				fr.close();
				
				//FileInputStream I/O ��ü�� null ó�� �ߴ�.
				//������ �÷��Ͱ� �٤��� �ش� ��ü�� �޸𸮿��� �������� �ʾ��� ���� ����ؼ�
				//�ش� ��������(fr)�� �����Ͱ� ���ٶ�� ǥ���Ѵ�.
				fr = null;
			}else {
				System.out.println("������ �����ϴ�.");
			}
		}catch(Exception i){
			System.out.println("������ i.getMessage() >>> : " + i.getMessage());
			
		}finally {
			// �� ���� ���Ḧ ����ؼ� ���� ��ƾ�̴�.
			if(fr !=null) {
				try {
					fr.close(); fr=null;
				}catch(Exception e) {}
			}
		}
	}
}
