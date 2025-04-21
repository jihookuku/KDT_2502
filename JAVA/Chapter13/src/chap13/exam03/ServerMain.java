package chap13.exam03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		
		// 1. 서버소켓 생성
		ServerSocket server = new ServerSocket(5300);
		
		// 2. 고객 대기
		while (true) {
			System.out.println("고객 대기 중...");
			
			// 3. 고객요청 수락
			Socket socket = server.accept();
			InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
			String client = addr.getAddress().getHostAddress()+":"+addr.getPort();
			System.out.println(client+" 접속!!");
			
			// 4. 고객의 요청을 처리
			// 4-1. 주스트림 + 보조스트림 준비
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			// 4-2. 데이터 받기
			String msg = ois.readUTF();
			System.out.println(client+" 가 보낸 메시지 >> "+msg);
			// 4-3. 받은 데이터 돌려주기
			oos.writeUTF("당신이 보낸 메시지 : "+msg);
			oos.flush();
			// 4-4. 자원 반납 
			ois.close();
			oos.close();
			// 5. 자원반납(서버소켓은 반납 하지 않을 예정)
		}
		
		



	}

}
