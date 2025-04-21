package exam05;

public class MemberJoin {
	
	public void reservedCheck(String id) {
		
		String[] idList = {"admin","manager","tester"};
		for (String str : idList) {
			if (id.equals(str)) {
				throw new ReservedException(id+" 는 등록된 ID 입니다.");
			}
		}
		
		
	}
	
	public void ageCheck(int age) throws AdultException {		
		if (age<20) {
			//예외 발생
			throw new AdultException("미성년자 가입 금지");
		}		
	}

}
