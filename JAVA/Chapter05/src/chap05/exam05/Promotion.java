package chap05.exam05;

public class Promotion {

	public static void main(String[] args) {
		
		Vertebrate ver = null; // 고양이, 강아지, 닭, 오리 는 모두 척추동물 안에 들어갈 수 있다.
		ver = new Cat();
		ver = new Dog();
		ver = new Chicken();
		ver = new Duck();
		
		//Birds birds = new Cat(); // 조류에 고양이는 포함될수 없다.
		//Mammal mal = new Duck(); // 포유류에 오리가 포함 될 수 없다.

	}

}


class Vertebrate{}

class Birds extends Vertebrate{}
class Mammal extends Vertebrate{}

class Duck extends Birds{}
class Chicken extends Birds{}

class Cat extends Mammal{}
class Dog extends Mammal{}
