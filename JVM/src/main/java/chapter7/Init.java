package chapter7;

public class Init {
	
	static class Parent {
		
		
		
		static {
			A = 2;
		}
		
		public static int A = 1;
	}
	
	static class Sub extends Parent {
		
		public static int B = A;
	}
	
	public static void main(String[] args) {
		System.out.println(Parent.A);
		System.out.println(Sub.B);
	}
}
