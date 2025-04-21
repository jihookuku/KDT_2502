package chap11.exam09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOut {

	public static void main(String[] args) throws IOException {
		
		// 1. 파일을 쓸 위치 지정
		String path = "C:\\STUDY\\JAVA\\Chapter11\\src\\chap11\\exam09\\profile.properties";
		// 2. 주스트림 준비
		FileOutputStream fos = new FileOutputStream(path);		
		
		// 3. 보조스트림 준비(Buffer)
		BufferedOutputStream bos = new BufferedOutputStream(fos);
				
		// 4. Properties 객체 생성
		Properties prop = new Properties();
		
		// 5. 데이터 담기
		prop.put("id", "admin");
		prop.put("pass", "1234");
		prop.put("name","김지훈");
		prop.put("email", "admin@email");
		
		// 6. 내보내기
		prop.store(bos, "simple comment");
		System.out.println("저장 완료!");
		
		// 7. 자원반납
		bos.close();


	}

}



