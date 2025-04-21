package chap05.exam07;

public class Mage {

	public static void main(String[] args) {
		
		Spell spell = null;
		spell = new Ice();
		System.out.println(spell.casting());
		
		spell = new Light();
		System.out.println(spell.casting());
		
		spell = new Fire();
		System.out.println(spell.casting());

	}

}
