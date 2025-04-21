package chap05.exam08;

public class DriveController {

	public static void main(String[] args) {
		
		Racer racer = new Racer();
		
		Audi audi = new Audi();
		System.out.println(racer.run(audi));
		
		Benz benz = new Benz();
		System.out.println(racer.run(benz));
		
		Bmw bmw = new Bmw();
		System.out.println(racer.run(bmw));

	}

}
