package chap11.exam08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Map;

public class ObjectInput {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// 1. 가져올위치+파일객체화+주스트림준비
		FileInputStream fis = new FileInputStream("C:/img/temp/object.dat");
		
		// 2. 보조스트림 준비
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 3. 읽기작업
		String str = ois.readUTF();// 문자열
		int num = ois.readInt();// 숫자
		int[] arr = (int[]) ois.readObject();// 배열
		Map<String, String> map = (Map<String, String>) ois.readObject();// 맵
		Sample sample = (Sample) ois.readObject();// 클래스
		
		
		System.out.println("string : "+str);
		System.out.println("int : "+num);
		System.out.println("array : "+Arrays.toString(arr));
		System.out.println("map : "+map);
		sample.method(); // 객체 내(멤버) 메서드 실행
		
		
		
		
		// 4. 자원 반납
		ois.close();

	}

}
