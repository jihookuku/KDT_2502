package chap05.exam07;

public class Fire extends Spell {

	@Override
	public String casting() {
		return "화염 "+super.casting();
	}
	
	

}
