package chap05.exam07;

public class ArrSpell {

	public static void main(String[] args) {

		//배열을 활용해서 Ice, Fire, Light 순서대로 나가게 하기
		Spell[] arr = new Spell[3];
		arr[0] = new Ice();
		arr[1] = new Light();
		arr[2] = new Fire();
		/*
		System.out.println(arr[0].casting());
		System.out.println(arr[1].casting());
		System.out.println(arr[2].casting());
		*/
		
		for (Spell spell : arr) {
			System.out.println(spell.casting());
		}
		
	}

}
