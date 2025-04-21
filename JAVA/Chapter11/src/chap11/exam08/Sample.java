package chap11.exam08;

import java.io.Serializable;


// class 객체를 스트림 안으로 넣으려면 잘게 쪼개야 하므로... 직렬화가 필요하다.
// 직렬화 - 커다란 오브젝트 형태를 얇은 관 안에 들어갈 수 있도록 잘게 쪼개 일렬로 세워서 보내는 개념으로 이해하자
// 잘게 쪼개거나, 이것을 조립할때 어떤 규격이 필요하다.(퍼즐 가이드 처럼)
// 이것을 Serializable 인터페이스가 해준다.
public class Sample implements Serializable{
	
	int num = 11;
	String team = "edu";
	String job = "manager";
	
	void method() {
		System.out.println("num : "+num+" / team : "+team+" / job : "+job);
	}

}
