package chap05.exam04;

// public 은 자바 파일과 동일한 이름을 갖는 클래스만 사용할 수 있다.
public class Child extends ParentHouse{
	@Override
	public void useRoom() {
		System.out.println("첫째가 방을 사용 한다.");
	}	
}

class ChildTwo extends ParentHouse{
	@Override
	public void useRoom() {
		System.out.println("둘째가 방을 사용 한다.");
	}	
}

class ChildThree extends ParentHouse{
	@Override
	public void useRoom() {
		System.out.println("셋째가 방을 사용 한다.");
	}	
}

class ChildFour extends ParentHouse{
	@Override
	public void useRoom() {
		System.out.println("넷째가 방을 사용 한다.");
	}	
}
