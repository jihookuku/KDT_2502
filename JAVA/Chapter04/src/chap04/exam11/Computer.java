package chap04.exam11;

public class Computer {
	
	private boolean power = false;
	private int panSpeed;
	private int temp;
	
	//setter, getter 메서드
	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
		
		if(this.power == true) {
			this.panSpeed = 60;
			this.temp = 50;
		}
		
	}
	
	public int getPanSpeed() {		
		return panSpeed;
	}
	
	public void setPanSpeed(int panSpeed) {
		this.panSpeed = panSpeed;
		// 110 - 팬 속도 = 온도
		this.temp = 110 - this.panSpeed;		
	}
	
	public int getTemp() {
		return temp;
	}
	
	
	

	
}
