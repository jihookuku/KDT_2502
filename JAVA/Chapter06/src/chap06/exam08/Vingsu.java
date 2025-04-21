package chap06.exam08;

public interface Vingsu {
	
	public default void iceFlake() {
		System.out.println("얼음을 갈아 넣는다.");
	}
	
	public default void milk() {
		System.out.println("우유를 넣는다.");
	}
	
	public default void redBean() {
		System.out.println("팥을 넣는다.");
	}
	
	public default void jelly() {
		System.out.println("젤리를 넣는다.");
	}
	
	public void etc();	

}
