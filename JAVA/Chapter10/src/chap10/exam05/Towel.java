package chap10.exam05;

public class Towel {

	private String color;
	
	public Towel(String color) {
		this.color = color;
	}

	// 색상을 보여주기만 하고 변경은 못하게 하겠다.(캡슐화 사용)
	public String getColor() {
		return color;
	}	

}
