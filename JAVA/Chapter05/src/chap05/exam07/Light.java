package chap05.exam07;

public class Light extends Spell {

	@Override
	public String casting() {
		return "번개 "+super.casting();
	}
	
	

}
