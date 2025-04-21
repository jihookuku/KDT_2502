package chap13.exam05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReceiveThread extends Thread {
	
	private Socket socket = null;
	private ObjectInputStream ois = null;

	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 1. socket 에서 Stream 추출 후 ObjectInputStream 에 탑승
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			while (true) {
				// 2. 메시지를 받아와서
				String msg = ois.readUTF();
				// 3. 출력하고		
				System.out.println("상대>"+msg);
			}
		} catch (IOException e) {			
			e.printStackTrace();
			// 4. 자원 반납(exception 발생시...)
			try {
				ois.close();
				socket.close();
				System.out.println("스레드 종료");
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
		}		
	}	

}
