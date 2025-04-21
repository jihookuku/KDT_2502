package chap06.exam08;

public class Client {

	public static void main(String[] args) {
		
		VingsuConcrete maker = new VingsuConcrete();
		
		Vingsu ving = new RedBeanVimgsu();
		maker.makeVingsu(ving);
		
		System.out.println();
		maker.makeVingsu(new ChocoVingsu());
		
		System.out.println();
		maker.makeVingsu(new CookieVingsu());


	}

}
