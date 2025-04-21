package chap13.exam03;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		
		// 1. 소켓생성(서버에 접속 요청)
		Socket socket = new Socket("localhost", 5300);
		
		// 2. 할일 하고...(데이터를 보내고, 데이터를 받고)
		// 2-1. 스트림 준비(주+보조)	
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		ObjectInputStream ois = new ObjectInputStream(is);
				
		// 2-2. 데이터 내보내기
		oos.writeUTF("안녕하세요!!");
		oos.flush();
		
		// 2-3. 들어온 데이터 받기
		String msg = ois.readUTF();
		System.out.println(msg);
		
		// 2-4. 자원반납
		oos.close();
		ois.close();
		
		// 3. 종료
		socket.close();
		
	}

}



