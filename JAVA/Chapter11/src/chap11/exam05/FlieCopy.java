package chap11.exam05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FlieCopy {

	public static void main(String[] args) throws Exception {
		// 1. 읽고 내보낼 위치 지정
		String src = "C:/img/img.png";
		String dst = "C:/img/temp/copy.png";
		
		// 파일객체 생성은? -> File... 으로 시작하는 스트림에서는 생략이 가능 하다.		
		
		// 2. 읽고 내보낼 스트림 준비
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		
		// 3. 읽어오고...
		int i = 0;
		
		int data; // 이 방식은 티스푼으로 10L 물을 옮기는 것과 같다.
		while ((data = fis.read()) != -1 ) {
			fos.write(data); // 4. 내보낸다.
			i++;
			System.out.println("File 복사중... "+i);
		}
		
		
		/* 컵으로 이동시키는 방법
		byte[] arr = new byte[1024];
		while(fis.read(arr) != -1) {
			fos.write(arr);
			i++;
			System.out.println("File 복사중... "+i);
		}	
		*/		
		// 5. 자원 정리(flush, close)
		fos.flush();
		fis.close();
		fos.close();

	}

}
