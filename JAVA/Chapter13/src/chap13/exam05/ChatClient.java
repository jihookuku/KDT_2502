package chap13.exam05;

import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) throws Exception {
		
		// 소켓생성(서버에 접속 요청)
		Socket socket = new Socket("localhost", 7777);
		System.out.println("접속성공");
		
		// 서버에 요청(스레드 들에게 준다.)
		SendThread sender = new SendThread(socket);
		sender.start();
		ReceiveThread receiver = new ReceiveThread(socket);
		receiver.start();
		
		
		// 자원반납


	}

}
