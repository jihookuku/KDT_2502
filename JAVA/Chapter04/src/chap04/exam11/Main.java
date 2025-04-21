package chap04.exam11;

public class Main {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		// 여기서 power 의 값을 true 로 변경 하려면?
		com.setPower(true);
		System.out.println("전원 : "+com.isPower());
		
		System.out.println("PC 온도 : "+com.getTemp());
		com.setPanSpeed(100);
		System.out.println("PC 온도 : "+com.getTemp());

	}

}
