package chap11.exam07;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInput {

	public static void main(String[] args) throws IOException {
		
		// 1. 위치지정 + 파일객체생성 + 스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/temp/data.dat");
		
		// 2. 보조스트림 생성
		DataInputStream dis = new DataInputStream(fis);
				
		// 3. 읽기 작업(입력 순서대로 읽어야 한다.)
		String name = dis.readUTF();
		int salary = dis.readInt();
		boolean promotion = dis.readBoolean();
		
		System.out.println("이름 : "+name+" / 급여 : "+salary+" / 승진여부 : "+promotion);
		
		// 4. 자원반납(close)
		dis.close();

	}

}






