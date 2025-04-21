package chap11.exam07;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutput {

	public static void main(String[] args) throws IOException {
		
		// 1. 위치지정 + 파일객체생성 + 스트림 준비
		FileOutputStream fos = new FileOutputStream("C:/img/temp/data.dat");
				
		// 2. 보조스트림 생성
		DataOutputStream dos = new DataOutputStream(fos);
				
		// 3. 쓰기작업
		dos.writeUTF("김지훈");
		dos.writeInt(1000);
		dos.writeBoolean(true);
				
		// 4. 자원반납(flush, close)
		dos.flush();
		dos.close();
		System.out.println("저장 완료");
	}

}





