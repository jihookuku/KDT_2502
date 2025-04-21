package chap13.exam05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws IOException {
		
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7777);
		
		// 요청 대기(오직 한명에게 받는 요청)
		System.out.println("채팅 대기...");
		
		// 접속 요청 응답
		Socket socket = server.accept();
		System.out.println("접속 수락");
				
		// 요청에 대한 처리(스레드 들에게 준다.)
		SendThread sender = new SendThread(socket);
		sender.start();
		ReceiveThread receiver = new ReceiveThread(socket);
		receiver.start();
				
		// 자원반납
		server.close();
	}

}





