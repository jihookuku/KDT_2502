package chap13.exam02;

import java.net.Socket;

public class ClientMain {

	// 컴파일된 파일에서 직접 실행
	// C:\STUDY\JAVA\Chapter13\bin 에서 cmd
	// java chap13.exam02.ClientMain
	public static void main(String[] args) throws Exception {
		
		// 1. 방문하고 싶은 서버 주소 입력
		Socket socket = new Socket("192.168.0.135", 7777);
		
		// 2. 예외가 발생하지 않으면 접속
		System.out.println("connect 완료!!");
		
		// 3. 할일이 끝나면 접속 종료
		socket.close();
		
	}

}
