package exam05;

public class Main {

	public static void main(String[] args) {
		
		MemberJoin join = new MemberJoin();
		
		try {
			join.reservedCheck("admin");
		} catch (Exception e) {
			//System.out.println(e.toString());
			System.out.println("이미 등록된 아이디 입니다.");
		}
		
		try {
			join.ageCheck(19);
		} catch (AdultException e) {
			e.printStackTrace();//개발후 지워야함
			System.out.println("미성년자는 가입 할 수 없습니다.");
		}
		

	}

}
