package chap05.exam07;

public class Ice extends Spell {

	@Override
	public String casting() {
		return "냉기 "+super.casting();
	}	

}
