package chap13.exam04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {//server

	public static void main(String[] args) throws IOException {
		
		// 1. 서버소켓 생성
		ServerSocket server = new ServerSocket(9999);
		
		// 2. 고객 접속 대기
		while (true) {
			System.out.println("접속 요청 대기중...");
			Socket socket = server.accept();
			InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
			String client = addr.getAddress().getHostAddress()+":"+addr.getPort();
			System.out.println(client+" 가 파일 전송 요청");
			
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						// 3. 고객의 요청 처리			
						// 3-1. 소켓으로 부터 스트림 준비
						BufferedInputStream bis =new BufferedInputStream(socket.getInputStream());
						ObjectInputStream ois = new ObjectInputStream(bis);
						
						// 3-2. 정보 받기(int, String, byte[])
						int size = ois.readInt();
						String name = ois.readUTF();
						// 3-3. 파일로 내보내기
						System.out.println(name+" 수신중...");
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/hi/Downloads/"+name));
						
						int data;
						while((data=ois.read()) != -1) {
							bos.write(data);
						}
						
						bos.flush();
						System.out.println(name+" 저장 완료");
						// 4. 자원반납
						ois.close();
						bos.close();
						socket.close();						
					} catch (Exception e) {
						e.printStackTrace();
					}
					

				}				
			};
			thread.start();
			
			
			
		}
		
		
		
	}

}



