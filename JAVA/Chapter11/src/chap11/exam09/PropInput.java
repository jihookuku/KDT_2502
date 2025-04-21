package chap11.exam09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropInput {

	public static void main(String[] args) throws IOException {
		// 1. 불러올 파일 위치 지정
		String path = "C:\\STUDY\\JAVA\\Chapter11\\src\\chap11\\exam09\\profile.properties";

		// 2. 주스트림 + 보조스트림 준비
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 3. Properties 객체화
		Properties prop = new Properties();
		
		// 4. 파일 읽어오기
		prop.load(bis);
		
		// 5. 속성 가져오기 - properties 파일은 한글이 깨져 보이지만 읽어올 때는 정상적으로 읽어와 진다.
		for (Object key : prop.keySet()) {
			System.out.println(prop.get(key));
		}
				
		// 6. 자원 반납
		bis.close();
	}

}












