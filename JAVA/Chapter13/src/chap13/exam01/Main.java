package chap13.exam01;

import java.net.InetAddress;

public class Main {

	public static void main(String[] args) throws Exception {
		// 내 컴퓨터의 IP
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("내 주소 : "+addr.getHostAddress());//192.168.0.135
		
		// 118.131.22.86 <- 공인 IP(public IP) <- 외부에서 바라보는 IP <- 외부에서도 알수 있는 위치
		// 192.168.0.135 <- 사설 IP(private IP) <- 내부에서 바라보는 IP <- 내부끼리만 알수있는 위치
		
		// 도메인 주소로 IP 찾기
		String domain = "jongro.himedia.co.kr";
		addr = InetAddress.getByName(domain);
		System.out.println(domain+" 연결된 IP : "+addr.getHostAddress());// 175.123.253.74
		
		// 대형 사이트의 경우에는 여러대의 서버가 하나의 도메인으로 엮이는 경우가 있다.
		domain = "www.youtube.com";
		InetAddress[] list = InetAddress.getAllByName(domain);
		System.out.println(domain+" 연결된 IP 들...");
		for (InetAddress inet : list) {
			System.out.println(inet.getHostAddress());
		}
		

	}

}
