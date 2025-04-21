package chap09.exam02;

public class Box<T> {// 이 박스에 뭐가 담길지 모름... 그래서 T 라고 지정해둔 형태
	
	private T value; // T 의 타입이 정해지는 순간 데이터 타입이 변한다.

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}	

}
