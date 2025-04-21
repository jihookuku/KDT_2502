package chap11.exam06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		//1. 위치 지정 + 파일 객체화 + 스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/img.gif");
		FileOutputStream fos = new FileOutputStream("C:/img/temp/move.gif");
		
		// 1-2. 보조 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
				
		
		TimeChcker chk = new TimeChcker();	// 시간측정 시작
		chk.start();
		
		int data;
		while((data = bis.read()) != -1) {// 2. 읽어오기
			bos.write(data);// 3. 쓰기
		}		
		
		System.out.println(chk.end());	//시간측정 종료
		
		// 4. 자원 정리
		bos.flush();
		bos.close();
		bis.close();

	}

}
