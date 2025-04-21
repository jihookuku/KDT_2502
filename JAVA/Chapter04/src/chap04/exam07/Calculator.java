package chap04.exam07;

public class Calculator {
	
	//public : 패키지가 달라도 공유된다.	
	public void plus(int a, int b) {
	     System.out.println(a + b);
	}

	//default : 패키지가 다르면 공유하지 않는다.
	void plus(int a, String b) {
		System.out.println(a + b);
	}

	// private : 클래스 안에서만 사용 가능 하다.
	private void plus(int a, double b) {
		System.out.println(a + b);
	}

   void plus(int a, char b) {
      System.out.println(a + b);
   }

   void plus(int a, long b) {
      System.out.println(a + b);
   }

   void plus(int a, float b) {
      System.out.println(a + b);
   }

   void plus(String a, int b) {
      System.out.println(a + b);
   }

   void plus(String a, String b) {
      System.out.println(a + b);
   }

   void plus(String a, double b) {
      System.out.println(a + b);
   }

   void plus(String a, char b) {
      System.out.println(a + b);
   }

   void plus(String a, long b) {
      System.out.println(a + b);
   }

   void plus(String a, float b) {
      System.out.println(a + b);
   }

   void plus(double a, int b) {
      System.out.println(a + b);
   }

   void plus(double a, String b) {
      System.out.println(a + b);
   }

   void plus(double a, double b) {
      System.out.println(a + b);
   }

   void plus(double a, char b) {
      System.out.println(a + b);
   }

   void plus(double a, long b) {
      System.out.println(a + b);
   }

   void plus(double a, float b) {
      System.out.println(a + b);
   }

   void plus(char a, int b) {
      System.out.println(a + b);
   }

   void plus(char a, String b) {
      System.out.println(a + b);
   }

   void plus(char a, double b) {
      System.out.println(a + b);
   }

   void plus(char a, char b) {
      System.out.println(a + b);
   }

   void plus(char a, long b) {
      System.out.println(a + b);
   }

   void plus(char a, float b) {
      System.out.println(a + b);
   }

   
   void plus(long a, int b) {
      System.out.println(a + b);
   }

   void plus(long a, String b) {
      System.out.println(a + b);
   }

   void plus(long a, double b) {
      System.out.println(a + b);
   }

   void plus(long a, char b) {
      System.out.println(a + b);
   }

   void plus(long a, long b) {
      System.out.println(a + b);
   }

   void plus(long a, float b) {
      System.out.println(a + b);
   }

   void plus(float a, int b) {
      System.out.println(a + b);
   }

   void plus(float a, String b) {
      System.out.println(a + b);
   }

   void plus(float a, double b) {
      System.out.println(a + b);
   }

   void plus(float a, char b) {
      System.out.println(a + b);
   }

   void plus(float a, long b) {
      System.out.println(a + b);
   }

   void plus(float a, float b) {
      System.out.println(a + b);

   }

}
