package chap13.exam05;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	
	private Socket socket = null;
	private ObjectOutputStream oos = null;

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
			
		Scanner scan = new Scanner(System.in);
		
		try {
			// 1. 소켓에서 스트림 추출
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			while (true) {
				// 2. 보낼 메시지를 작성해서
				String msg = scan.nextLine();
				System.out.println("당신>"+msg);
				// 3. 보내고				
				oos.writeUTF(msg);
				oos.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			// 4. 자원반납(예외시에만)
			try {
				oos.close();
				socket.close();
				scan.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		

		
		

	}

}
