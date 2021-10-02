package a.b.c.ch7;

import java.io.File;
import java.io.FileInputStream;
import a.b.c.common.FilePath;
/*
 	자바프로그램에서는 메모리를
 	소스에서 개발자가 메모리를 지우는 행위를 하지 않는다.
 	자바에서 메모리를 지우는 역활을 담당하는 놈은 가비지 컬렉터이다.
 	자바에서 메모리를 지운다는 것은
 	자바에서는 가비지 컬렉터에게 요청하는 것이다.
 	프로그램에서 메모리에서 지워지는 것은 언제 지워질지 모른다.
 */
/*
 	자바에서 
 	null 키워드가 의미하는 것은 데이터를 가르키지 않는다.
 	나는 현재 이 참조변수에 데이터가 없다.
 */
public class Ex_FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			지역변수를 사용하는 방법
			1. 지역변수는 함수에서 태어나서 함수에서 죽는다.
				단 : 죽이는 것은 GC(가비지 컬렉터)한다.
			2. 지역변수는 죽이라고 명령을 할 수가 없다.
			3. 지역변수는 가비지 컬렉터가 그 프로그램의 메모리 상황을 보고
			4. 프로그램의 우선순위도 보고 스케줄링에 의해서 메모리에서 제거된다.
		*/
		/*
			지역 변수를 사용하는 규칙
			1. 지역변수 선언과 동시에 디폴트 값으로 초기화 한다.
				객체 참조변수 = null;
				기초자료형 지역 변수 = 디폴트값; 0, 0.0 , false
			2. 통신관련, I/O 가 발생하는 객체는 사용 후
				close(), flush(), null 처리를 해야한다.
			3.rt.jar : java.io.*, java.sql.* , java.lang.*
			예)  FileInputStream fis = null; : null로 초기화
			
				객체 오픈
				fis = new FileInputStream(path + "/" + "Ex_IOTest_1.java");
				
				객체닫기
				fis.close();
				
				사용다한 지역변수 null로 초기화
				fis = null;
			
		*/
		
		// 지역변수, 참조변수
		// 객체이니 null 초기화 했다 : 객체의 디폴트 값은 null
		FileInputStream fis = null;
		
		// 지역변수 : 기초자료형을 함수 내부에서 선언 하면 일반적으로 지역변수라고 한다.
		// 지역변수 디폴트값으로 초기화 했다.
		int data = 0;
		
		try {
			// Common 클래스를 사용하는 규칙
			String path = FilePath.FILE_PATH; // common에 FILE_PATH 상수를 가져와씀.
			System.out.println("path >>> : " + path);
			path = path + "/" + "Ex_FileInputStream.java";
			System.out.println("path >>> : " + path);
			
			File f = new File(path);
			boolean bFile = f.exists();
			
			if (bFile){
				
				//FileInputStream I/O 객체를 오픈한다.
				fis = new FileInputStream(f);
				System.out.println("fis >>> : " + fis);
				data = fis.read();
				System.out.println("data >> : " + data);
				System.out.println("(byte)data >>> : " + (byte)data);
				System.out.println("(char)data >>> : " + (char)data);
				
				// 바이트 단위로 읽을 때 맨끝을 -1 표현한다.
				while((data=fis.read()) !=-1) {
					System.out.print((char)data);
				}
				// 정상적으로 수행 되었을 때 수행되는 루틴
				// FileInputStream I/O 객체를 닫는다.
				fis.close();
				
				//FileInputStream I/O 객체를 null 처리했다.
				//가비지 컬렉터가 바빠서 해당 객체를 메모리에서 해제하지 않았을 때를 대비해서
				// 해당 참조변수 (여기서는 fis) 에 데이터가 없다라고 표현한것
				fis = null;
				
			}else{
				System.out.println("파일이 없습니다.");
			}
			
		}catch(Exception i ){
			System.out.println("에러가 i.getMessage() >>> : " + i.getMessage());
		}finally {
			
			// 비정상 종료를 대비해서 만든 루틴이다.
			if(fis !=null) {
				try {
					fis.close(); fis = null; //IO시에는 꼭 close해줘야한다.
				}catch (Exception e) {
					
				}
			}
			
		}

	}

}
