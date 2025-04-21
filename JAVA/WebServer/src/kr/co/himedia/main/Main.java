package kr.co.himedia.main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 0. 스레드풀 준비
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
				
		// 1. 서버소켓 생성
		ServerSocket server = new ServerSocket(7777);
		
		// 2. 손님 대기(접속 요청 대기)
		while (true) {
			System.out.println("요청 대기중...");
			// 3. 접속 수락
			Socket socket = server.accept();
			
			Runnable runn = new Runnable() {				
				@Override
				public void run() {
					
					try {
						// 4. 손님이 하는 이야기 듣기(클라이언트 요청 수신)
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						// http protocol 에서는 최대 65,536byte 까지 받을수 있도록 되어있다.
						byte[] arr = new byte[65536];
						dis.read(arr);
						
						String request = new String(arr);
						System.out.println(request);
												
						// 5. 요청에 대한 응답
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						// 응답 - 헤더
						ps.print("HTTP/1.1 200 \r\n");
						ps.print("Content-type: text/html; charset=utf-8 \r\n");
						ps.print("\r\n"); // 헤더와 바디 사이의 공백(이게 있어야 헤더와 바디를 구분 할 수 있다.)
						// 응답 - 바디
						ps.print("<h3>반가워요!</h3>");

						
						//자원반납
						ps.flush();
						dis.close();
						ps.close();						
						socket.close();					
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					
				}
			};
			pool.execute(runn);
			

			
		}
		
		
		



	}

}
