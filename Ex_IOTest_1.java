package a.b.c.ch7;

// ������ �д� ��ü, byte ������ �д� ��ü 
// ������ �������� 
// 1. ������ �ִ� ��ġ�� �˾ƾ� �Ѵ�. 
// 2. ���� �̸��� �˾ƾ� �Ѵ�. 
// 3. 1��, 2���� �����Ǹ� ���Ͽ� �ִ� ������ �޸𸮿� �÷��� �Ѵ�. 
// 4. ������ ���� �� byte ������ �о �޸��� �÷� ���´�. 
// 5. ������ �� ã�Ƽ� �޸� �÷� ������ 
// 6. FileInputStream.read() �Լ��� ����Ʈ ������ �о�´�. 
// 7. byte ������ ���� �� ������ �� -1 �� ǥ���Ѵ�. 
import java.io.FileInputStream;
// IOException ���� Ŭ������ 
// io ��Ű���� �ֻ��� ���� Ŭ���� �̴�. 
// checked Exception �̴� : ������ �� üũ�ϴ� �����̴�. 
// �ҽ������� ������ �� : ������ �� �� : �� ���� ó���� ���־�� �Ѵ�. 
import java.io.IOException;


// ���� 
// ���丮 + �����̸� + ���� ��� 
public class Ex_IOTest_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// ���丮 ������, ���ϱ����� : file seperator 
		// ������ : \, ������, ���н� : /
		// ��Ŭ���� ������� �ٸ���. / , \\ 
		// String path = "C:\\00.KOSMO93\\10.JExam\\el_java_work\\javaTest\\src\\a\\b\\c\\ch7";
		
		// FileInputStream fis = new FileInputStream(path + "\\" + "Ex_IOTest_1.java");
		FileInputStream fis = new FileInputStream("Ex_IOTest_1.java");
		System.out.println("fis >>> : " + fis);

		int data = fis.read();
		
		System.out.println("data >>> : " + data);
		System.out.println("(byte)data >>> : " + (byte)data);
		System.out.println("(char)data >>> : " + (char)data);

		// ����Ʈ ������ �ش� ������ ������ ������ ������ �дµ� ������ �� ���� -1�� ǥ���Ѵ�.
		while ((data=fis.read()) != -1){
			System.out.print((char)data);
		}
		/*
		while ((data=fis.read()) != -1){
			System.out.println(  " : " + data
				               + " : " + (char)data
							   + " : " + Integer.toBinaryString(data));
		}
		*/
	}
}

/*
batch ��ɾ� 
echo 
>> 
---------------------

C:\00.KOSMO93\10.JExam\ch7>echo Hello World11 >> hello.txt

C:\00.KOSMO93\10.JExam\ch7>echo Hello World2222
Hello World2222

C:\00.KOSMO93\10.JExam\ch7>echo Hello World2222 >> hello_2.txt

C:\00.KOSMO93\10.JExam\ch7>

C:\00.KOSMO93\10.JExam\ch7>java a.b.c.ch7.Ex_IOTest_1 >> Ex_IOTest_1.txt

C:\00.KOSMO93\10.JExam\ch7>

*/
