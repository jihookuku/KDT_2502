package chap11.exam08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectOutput {

	public static void main(String[] args) throws IOException {
		
		// 1. 저장 위치 + 파일 객체화 + 주스트림 준비
		FileOutputStream fos = new FileOutputStream("C:/img/temp/object.dat");
		
		// 2. 보조스트림 준비
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. 쓰기작업
		oos.writeUTF("기본형 문자");// 3-1. 문자열
		oos.writeInt(100);// 3-2. 숫자
		oos.writeObject(new int[] {90,100,110,120});// 3-3. 배열
		// 3-4. 맵
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "김지훈");
		map.put("phone", "010-1234-1234");
		oos.writeObject(map);
		// 3-5. 클래스
		oos.writeObject(new Sample());
		
		// 4. 자원반납
		oos.flush();
		oos.close();
		System.out.println("저장 완료!");
		

	}

}
