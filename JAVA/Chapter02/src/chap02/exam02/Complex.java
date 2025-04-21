package chap02.exam02;

public class Complex {

	public static void main(String[] args) {
		
		// 대입 연산자
		int result = 0;
		
		// 복합대입 연산자
		//result = result + 10;
		result += 10;
		System.out.println(result);
		
		//result = result - 5;
		result -= 5;
		System.out.println(result);
		
		//result = result * 2;
		result *= 2;
		System.out.println(result);
		
		//result = result / 2;
		result /= 2;
		System.out.println(result);
		
		//result = result % 2;
		result %= 2;
		System.out.println(result);
		
		// 응용
		// 대입연산자는, 합한 값을, 누적하는데, 아주 유용하다.
		String str = "";
		str = "대입연산자는 ";
		str += "합한 값을"; // str = str+ "합한 값을";
		str += "누적하는데";
		str += "아주 유용하다.";
		System.out.println(str);
		
		int num = 1; // 1부터 5 까지 더한 값은?
		num += 2;
		num += 3;
		num += 4;
		num += 5;
		
		System.out.println(num);

	}

}





















