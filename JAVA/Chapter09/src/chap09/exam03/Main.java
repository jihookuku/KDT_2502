package chap09.exam03;

public class Main {

	public static void main(String[] args) {
	
		MultiBox<String, Integer> box = new MultiBox<String, Integer>();
		
		box.setKey("홍길동");
		box.setValue(90);
		
		String name = box.getKey();
		int score = box.getValue();
		System.out.println(name+" : "+score);

	}

}
