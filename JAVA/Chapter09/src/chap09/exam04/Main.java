package chap09.exam04;

public class Main {

	public static void main(String[] args) {
		
		Employee<Integer, String, Integer, Integer, Long, Float, Boolean, String> emp  
			= new Employee<Integer, String, Integer, Integer, Long, Float, Boolean, String>();
		

		emp.setNo(1111);
		emp.setName("김지훈");
		emp.setAge(30);
		emp.setSalary(5000000);
		emp.setAssets(1000000000L);
		emp.setCommission(0.33f);
		emp.setMarried(false);
		emp.setHobby("영화");


	}

}
