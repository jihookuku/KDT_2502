package chap02.exam01;

public class One {

	public static void main(String[] args) {
		
		//부호 연산자
		int x = 1;
		int y = -1;
		
		//증감 연산자
		x++;
		y++;
		System.out.println("X : "+x);
		System.out.println("Y : "+y);
		x--;
		y--;
		System.out.println("X : "+x);
		System.out.println("Y : "+y);
		
		x = 1;
		y = 1;
		x++;	// 증가가 나중에 된다.
		++y;	// 증가가 먼저 된다.
		System.out.println("X : "+x); //2
		System.out.println("Y : "+y);
		
		int result = (x++) + 10; // 운동할때 무언가를 하고 나서 횟수를 증가할 경우...
		int result2 = (++y) + 10;
		System.out.println("result="+result); 		//12	: x 와 10이 먼저 더해지고(12가 나옴), 이후 x 가 증가 된다.	
		System.out.println("result2="+result2);		//13	: y가 먼저 증가되고(3이됨) 이 값을 10과 더해 13이 나온다.
		
		// 논리 부정 연산자(true | false)
		boolean yn = true;
		System.out.println("YN : "+yn);
		yn = !yn;
		System.out.println("YN : "+yn);
		yn = !yn;
		System.out.println("YN : "+yn);
		
		

	}

}













