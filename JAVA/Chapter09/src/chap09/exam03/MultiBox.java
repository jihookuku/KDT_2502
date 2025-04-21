package chap09.exam03;

public class MultiBox <K,V>{//제너릭의 타입은 여러개가 될 수 있다.
	
	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}	

}
