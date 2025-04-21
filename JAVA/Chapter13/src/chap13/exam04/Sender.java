package chap13.exam04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender { // client

	public static void main(String[] args) throws Exception {
		
		// 1. 소켓생성(서버에 접속 요청)
		Socket socket = new Socket("localhost", 9999);
		
		// 2. 할일 하고...
		// 2-1. 내 PC 의 파일 위치 지정
		File file = new File("C:/img/img.png");
		
		// 2-2. 주스트림 + 보조스트림 준비
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				
		// 2-3. 파일 읽어오기 - 파일 크기만한 배열을 준비 하면 한방에 끝난다.
		byte[] arr = new byte[(int) file.length()];
		int data = bis.read(arr);
		System.out.println(data);	
		// 2-4. 소켓에서 부터 받아온 스트림 준비
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		// 2-5. 보내기
		System.out.println("보낼 파일 명 : "+file.getName());
		oos.writeInt((int)file.length());
		oos.writeUTF(file.getName());
		oos.write(arr);
		oos.flush();
								
		// 3. 접속 종료
		bis.close();
		oos.close();
		socket.close();

	}

}





