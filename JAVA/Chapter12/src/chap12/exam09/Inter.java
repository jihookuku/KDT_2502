package chap12.exam09;

public class Inter extends Thread {

	@Override
	public void run() {
		/* 인터럽트를 활용한 정지 1
		try {
			while(true){
				System.out.println("자소서 작성중...");
				Thread.sleep(1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("자소서 저장");
			System.out.println("PC 종료");
		}
		*/
		
		// 인터럽트를 활용한 정지 2
		while(!Thread.interrupted()){
			System.out.println("자소서 작성중...");
		}
		System.out.println("자소서 저장");
		System.out.println("PC 종료");
		
	}	

}
