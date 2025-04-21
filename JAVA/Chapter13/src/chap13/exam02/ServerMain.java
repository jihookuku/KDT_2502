package chap13.exam02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerMain {

	public static void main(String[] args) throws IOException {		
		
		ServerSocket server = null;
		
		try {
			// 1. 서버 생성(어느 문을 사용할지 지정)
			server = new ServerSocket(7777);
			
			// 2. 고객을 기다리며 대기
			while (true) {
				System.out.println("고객 기다리는 중...");
				
				// 3. 고객이 들어오면 요청 수락(고객 정보 얻음)
				Socket socket = server.accept(); //blocking
				
				// 4. 누군지 확인
				InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("접속 완료 : "+addr.getAddress()+":"+addr.getPort());
				
				// 5. 기타 등등...				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			// 6. 예외 발생시 서버 종료
			server.close();
		}
		

		
		

	}

}
