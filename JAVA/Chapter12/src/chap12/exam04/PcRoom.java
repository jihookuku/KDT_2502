package chap12.exam04;

public class PcRoom {

	public static void main(String[] args) {
		
		Computer com = new Computer(); // 공용 컴퓨터 하나 생성
		
		// 2명의 유저에게 각각 사용하라고 한다.
		User1 user1 = new User1(com);
		
		// com = new Computer(); <- 컴퓨터를 2대 제공하면 문제가 발생하지 않을것
		User2 user2 = new User2(com);
		// 시작!
		user1.start();
		user2.start();

	}

}
