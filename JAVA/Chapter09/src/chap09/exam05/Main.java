package chap09.exam05;

public class Main {

	public static void main(String[] args) {
		
		Info info = new Info();//box
		
		// 박스에 값을 담아서...
		info.setEmp_no(112);
		info.setName("kim");
		info.setAge(44);
		info.setSalary(7000000);
		info.setAssets(1500000000L);
		info.setCommission(0.2f);
		info.setMarried(true);
		info.setHobby("독서");
		
		// employee 에게 준다.
		Employee<Info> emp = new Employee<Info>();
		emp.setInfo(info);

	}

}
