package chap11.exam02;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//File 객체는 파일을 다루는 모든 메서드를 가지고 있는 객체이다.
		
		/*1. 폴더(디렉토리) 만들기*/
		File dir = new File("C:/img/temp");//객체화 시 다룰 폴더 또는 파일의 경로를 넣어준다.(생성자 초기화) 
		boolean exist = dir.exists();
		System.out.println("해당 폴더가 있는가? "+exist);
		
		if (!exist) {
			System.out.println("폴더 없음, 생성 시작!");
			dir.mkdirs();
		}
		
		/* 2. 파일 만들기 */
		File file = new File("C:/img/temp/test.txt");		
		if (!file.exists()) {
			System.out.println("파일 없음, 생성 시작!");
			file.createNewFile();
		}	
		
		/* 3. 파일 정보 알아보기*/
		File folder = new File("C:/");
		
		String[] names = folder.list();//해당 경로의 폴더나 디렉토리 이름 반환
		for (String name : names) {
			System.out.println(name);
		}
		
		File[] files = folder.listFiles();// 해당 경로의 파일객체들을 반환
		
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.print("[폴더] ");
			}else {
				System.out.print("[파일] ");
			}
			System.out.println(f.getName()+" / "+f.length()+" byte");
		}
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
