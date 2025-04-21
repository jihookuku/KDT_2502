package exam12;

public class Main {

	public static void main(String[] args) {
		// "abcdef"	"f"	"abcde"
		//"BCBdbe"	"B"	"Cdbe"
		Solution sol = new Solution();
		System.out.println("abcde=="+sol.solution("abcdef", "f"));
		System.out.println("Cdbe=="+sol.solution("BCBdbe", "B"));

	}

}
