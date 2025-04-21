package chap10.exam05;

import java.util.Stack;

public class Box {

	public static void main(String[] args) {
		
		// 다이아몬드 연산자 : 뒤의 제너릭에 타입을 생략
		// 효율성이 좋지 않아 권장하지 않는다.
		Stack<Towel> box = new Stack<>();
		
		// push() - 데이터를 넣는다.
		box.push(new Towel("red"));
		box.push(new Towel("orange"));
		box.push(new Towel("yellow"));
		box.push(new Towel("green"));
		box.push(new Towel("blue"));
		box.push(new Towel("navy"));
		box.push(new Towel("purple"));
				
		// peek() - 데이터 확인후 다시 넣는다.(확인시 사용)
		// pop() - 데이터 확인 후 버린다.(가져올때 사용)
		
		while (!box.isEmpty()) {
			//메서드 체이닝
			//System.out.println("색상 : "+box.pop().getColor()+" / 남은 수 : "+box.size());
			System.out.println("색상 : "+box.peek().getColor()+" / 남은 수 : "+box.size());
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
